package hu.unideb.inf.repository;

import hu.unideb.inf.model.User;

import java.util.List;

public interface UserDAO extends AutoCloseable {
    void insertUser(User user);
    List<User> getUsers();

    @Override
    void close();
}
