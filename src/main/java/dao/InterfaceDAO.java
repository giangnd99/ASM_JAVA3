package dao;


import java.util.List;

public interface InterfaceDAO <T>{
    T create(T t);

    T update(T t);

    T get(Integer id);

    boolean remove(Integer id);

    List<T> listAll();
}
