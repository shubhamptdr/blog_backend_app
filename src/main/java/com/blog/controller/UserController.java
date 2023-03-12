package com.blog.controller;

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

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestParam String username, @RequestParam String password) {
        String response = userService.createUser(username,password);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        try{
            String response = userService.deleteUser(userId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.OK);
        }
    }

    @PutMapping("/update")
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