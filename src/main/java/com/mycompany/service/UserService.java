package com.mycompany.service;

import com.mycompany.model.User;
import com.mycompany.service.impl.UserNotFoundException;

import java.util.List;

public interface UserService {

    public List<User> listAll();

    public void save(User user);

    public User get(Integer id) throws UserNotFoundException;

    public void delete(Integer id) throws UserNotFoundException;
}
