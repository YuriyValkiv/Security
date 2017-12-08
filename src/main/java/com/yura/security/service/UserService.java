package com.yura.security.service;

import com.yura.security.DAO.UserDAO;
import com.yura.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }

    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Transactional
    public List<User> getUserByName(String name) {
        return userDAO.getByName(name);
    }

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public void editUser(User user) {
        userDAO.editUser(user);
    }
}
