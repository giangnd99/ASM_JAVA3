package dao;


import exception.UserNotFoundException;

import java.util.List;

public interface InterfaceDAO <T>{
    T create(T t);

    T update(T t);

    T get(Integer id) throws UserNotFoundException;

    boolean remove(Integer id);

    List<T> listAll();
}
