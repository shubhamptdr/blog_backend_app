package com.blog.services;


public interface UserService {

    void createUser(String username, String password);

    void deleteUser(int userId);

    void updateUser(Integer id, String password);
}