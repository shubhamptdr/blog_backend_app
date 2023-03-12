package com.blog.controller;

import com.blog.dtos.request.UserEntryDto;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody UserEntryDto userEntryDto) {
        String response = userService.createUser(userEntryDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        try{
            String response = userService.deleteUser(userId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.OK);
        }
    }

    @PutMapping("/")
    public ResponseEntity<String> updateUser(@RequestParam Integer id, @RequestParam String password) {
        try{
            String response = userService.updateUser(id,password);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.OK);
        }
    }
}