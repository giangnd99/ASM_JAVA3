package dao;

import util.XJdbc;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T> {

    private final Class<T> type;

    public GenericDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void insert(T entity) throws IllegalAccessException {
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(type.getSimpleName().toLowerCase());
        sql.append(" (");

        Field[] fields = type.getDeclaredFields();
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (Field field : fields) {
            if (!field.getName().equalsIgnoreCase("id")) {
                field.setAccessible(true); // Bỏ qua id
                columns.append(field.getName()).append(",");
                values.append("?,");

            }
        }

        sql.append(columns.substring(0, columns.length() - 1)).append(") VALUES ( ");
        sql.append(values.substring(0, values.length() - 1)).append(" ) ");

        List<Object> params = new ArrayList<>();
        for (Field field : fields) {
            if (!field.getName().equalsIgnoreCase("id")) {  // Bỏ qua id
                params.add(field.get(entity));
            }
        }
        XJdbc.update(sql.toString(), params.toArray());
    }

    public T insertAndReturn(T entity) throws IllegalAccessException, SQLException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        insert(entity);  // Thực hiện chèn trước
        Field emailField = null;
        Field idField = null;

        for (Field field : type.getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase("email")) {
                emailField = field;
                emailField.setAccessible(true);
                break;
            }
        }

        if (emailField != null) {
            String email = (String) emailField.get(entity);
            return findByEmail(email);  // Trả về đối tượng đã chèn bằng email
        }
        return null;
    }

    public List<T> findAll() throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String sql = "SELECT * FROM " + type.getSimpleName().toLowerCase();
        ResultSet resultSet = XJdbc.query(sql);
        List<T> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(mapResultSetToEntity(resultSet));
        }
        return list.isEmpty() ? null : list;
    }

    public T findById(int id) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String sql = "SELECT * FROM " + type.getSimpleName().toLowerCase() + " WHERE id = ?";
        ResultSet resultSet = XJdbc.query(sql, id);
        if (resultSet.next()) {
            return mapResultSetToEntity(resultSet);
        }
        return null;
    }

    public T update(T entity, int id) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(type.getSimpleName().toLowerCase());
        sql.append(" SET ");

        Field[] fields = type.getDeclaredFields();
        StringBuilder setClause = new StringBuilder();
        List<Object> params = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            if (!field.getName().equalsIgnoreCase("id")) {  // Không cập nhật id
                setClause.append(field.getName()).append("=?,");
                params.add(field.get(entity));
            }
        }

        sql.append(setClause.substring(0, setClause.length() - 1));
        sql.append(" WHERE id = ?");

        params.add(id);
        XJdbc.update(sql.toString(), params.toArray());

        try {
            return findById(id);  // Trả về đối tượng sau khi cập nhật
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        T entity = findById(id);
        if (entity != null) {
            String sql = "DELETE FROM " + type.getSimpleName().toLowerCase() + " WHERE id = ?";
            XJdbc.update(sql, id);
            return true;
        }
        return false;
    }

    protected T mapResultSetToEntity(ResultSet resultSet) throws
            SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        T entity = type.getDeclaredConstructor().newInstance();  // Sử dụng constructor thay vì newInstance
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);  // Cho phép truy cập vào các field private
            // Tên của cột trong ResultSet
            String columnName = field.getName();
            // Ánh xạ giá trị từ ResultSet vào đối tượng entity
            Object value = getResultSetValue(resultSet, field, columnName);
            if (value != null) {
                field.set(entity, value);  // Đặt giá trị cho field tương ứng
            }
        }
        return entity;
    }

    protected List<T> mapResultSetToEntityList(ResultSet rs) throws
            SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        List<T> list = new ArrayList<>();
        while (rs.next()) {
            list.add(mapResultSetToEntity(rs));
        }
        return list;
    }

    public T findByEmail(String email) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String sql = "SELECT * FROM " + type.getSimpleName().toLowerCase() + " WHERE email = ?";
        ResultSet resultSet = XJdbc.query(sql, email);
        if (resultSet.next()) {
            return mapResultSetToEntity(resultSet);
        }
        return null;
    }

    private Object getResultSetValue(ResultSet resultSet, Field field, String columnName) throws SQLException {
        Class<?> fieldType = field.getType();

        if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
            return resultSet.getInt(columnName);
        } else if (fieldType.equals(String.class)) {
            return resultSet.getString(columnName);
        } else if (fieldType.equals(Boolean.class) || fieldType.equals(boolean.class)) {
            return resultSet.getBoolean(columnName);
        } else if (fieldType.equals(java.sql.Date.class)) {
            return resultSet.getDate(columnName);
        } else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {
            return resultSet.getLong(columnName);
        } else if (fieldType.equals(Double.class) || fieldType.equals(double.class)) {
            return resultSet.getDouble(columnName);
        } else {
            return resultSet.getObject(columnName);  // Phòng trường hợp cho các kiểu khác
        }
    }
}
