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
    public ResponseEntity<Blog> createBlog(@RequestParam Integer userId, @RequestParam String title, @RequestParam String content){
        // Create a blog and add it under given user
        Blog response = blogService.createAndReturnBlog(userId, title, content);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable int blogId) {
        // Delete the blog using deleteById
        blogService.deleteBlog(blogId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



