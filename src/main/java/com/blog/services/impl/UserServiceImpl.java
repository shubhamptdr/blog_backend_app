package com.blog.services.impl;

import com.blog.dtos.request.UserEntryDto;
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
    public String createUser(UserEntryDto userEntryDto) {
        // create entity
        User user = User.builder()
                .username(userEntryDto.getUsername())
                .password(userEntryDto.getPassword())
                .firstName(userEntryDto.getFirstName())
                .lastName(userEntryDto.getLastName())
                .build();
        // save in DB
        userRepository3.save(user);

        return "Added User successfully";
    }

    @Override
    public String deleteUser(int userId) throws Exception {

        User user = userRepository3.findById(userId).get();

        if(user == null)
            throw new Exception("User not found");

        userRepository3.delete(user);
        return "User delete successfully";
    }

    @Override
    public String updateUser(Integer id, String password) throws Exception {
        User user = userRepository3.findById(id).get();
        if(user == null)
            throw new Exception("User not found");
        // update attr.
        user.setPassword(password);
        // save
        userRepository3.save(user);

        return "Updated user successfully";
    }
}
