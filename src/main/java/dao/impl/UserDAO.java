package dao.impl;


import dao.GenericDAO;
import dao.InterfaceDAO;
import model.Users;

import java.util.List;

public class UserDAO extends GenericDAO<Users> implements InterfaceDAO<Users> {

    @Override
    public Users create(Users user) {
        try {
            return insertAndReturn(user);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating user: " + e.getMessage(), e);
        }
    }

    @Override
    public Users update(Users user) {
        try {
            if (user.getId() == null) {
                throw new IllegalArgumentException("User ID cannot be null for update.");
            }
            update(user, user.getId());
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Error while updating user with id " + user.getId() + ": " + e.getMessage(), e);
        }
    }

    @Override
    public Users get(Integer id)  {
        try {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null.");
            }
            return findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching user with id " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public boolean remove(Integer id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null.");
            }
            return delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting user with id " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<Users> listAll() {
        try {
            return findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while fetching list of users: " + e.getMessage(), e);
        }
    }
}