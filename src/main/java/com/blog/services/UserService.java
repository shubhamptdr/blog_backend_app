package com.blog.services;


public interface UserService {

    String createUser(String username, String password);

    String deleteUser(int userId) throws Exception;

    String updateUser(Integer id, String password) throws Exception;
}