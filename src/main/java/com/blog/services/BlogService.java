package com.blog.services;


import com.blog.entities.Blog;

public interface BlogService {

    Blog createAndReturnBlog(Integer userId, String title, String content);

    void deleteBlog(int blogId);
}