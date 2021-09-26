package com.mycompany.service;

import com.mycompany.model.User;

import java.util.List;

public interface UserService {

    public List<User> listAll();

    public void save(User user);

}
