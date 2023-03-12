package com.blog.services;


public interface UserService {

    String createUser(String username, String password);

    void deleteUser(int userId);

    String updateUser(Integer id, String password);
}