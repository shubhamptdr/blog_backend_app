package com.blog.controller;

import com.blog.dtos.request.BlogEntryDto;
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

    @PostMapping("/createBlog")
    public ResponseEntity<String> createBlog(@RequestBody BlogEntryDto blogEntryDto){
        try {
            String response = blogService.createAndReturnBlog(blogEntryDto);
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



