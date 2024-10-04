package dao.impl;

import dao.GenericDAO;
import dao.InterfaceDAO;
import model.NewsLetter;
import util.XJdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class NewsletterDAO extends GenericDAO<NewsLetter> implements InterfaceDAO<NewsLetter> {

    @Override
    public NewsLetter create(NewsLetter newsLetter) {
        try {
            return super.insertAndReturn(newsLetter);
        } catch (Exception e) {
            throw new RuntimeException("Error when creating newsletter" + e.getMessage(), e);
        }
    }

    @Override
    public NewsLetter update(NewsLetter newsLetter) {
        String sql = "UPDATE newsletter SET enable = ? WHERE email = ?";
        XJdbc.update(sql, newsLetter.isEnabled(), newsLetter.getEmail());
        return newsLetter;
    }

    @Override
    public NewsLetter get(Integer id) {
        return null;
    }

    @Override
    public NewsLetter findByEmail(String email) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return super.findByEmail(email);
    }

    @Override
    public boolean remove(Integer id) {
        return false;
    }

    @Override
    public List<NewsLetter> listAll() {
        try {
            return super.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error when listing newsletters", e);
        }
    }
}

