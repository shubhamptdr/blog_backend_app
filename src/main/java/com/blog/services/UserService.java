package com.blog.services;


import com.blog.dtos.request.UserEntryDto;

public interface UserService {

    String createUser(UserEntryDto userEntryDto);

    String deleteUser(int userId) throws Exception;

    String updateUser(Integer id, String password) throws Exception;
}