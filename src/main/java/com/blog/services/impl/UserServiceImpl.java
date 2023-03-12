package com.blog.services.impl;

import com.blog.entities.User;
import com.blog.repositories.UserRepository;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository3;
    @Override
    public String createUser(String username, String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        userRepository3.save(user);
        return "Added User successfully";
    }

    @Override
    public void deleteUser(int userId) {
        userRepository3.deleteById(userId);
    }

    @Override
    public String updateUser(Integer id, String password) {
        User user = userRepository3.findById(id).get();
        user.setPassword(password);
        userRepository3.save(user);
        return "Updated user successfully";
    }
}
