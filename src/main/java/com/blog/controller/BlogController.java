package com.blog.controller;

import com.blog.entities.Blog;
import com.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping
    public ResponseEntity<String> createBlog(@RequestParam Integer userId, @RequestParam String title, @RequestParam String content){
        try {
            String response = blogService.createAndReturnBlog(userId, title, content);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<String> deleteBlog(@PathVariable int blogId) {
        try {
            String response = blogService.deleteBlog(blogId);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }
    }
}



