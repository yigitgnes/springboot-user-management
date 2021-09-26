package com.mycompany.service.impl;

import com.mycompany.model.User;
import com.mycompany.repository.UserRepository;
import com.mycompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository repo;

    @Override
    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not find any ID " + id);
    }

    @Override
    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count==0){
            throw  new UserNotFoundException("Could not find any users with ID " + id);
        }
        repo.deleteById(id);
    }


}
