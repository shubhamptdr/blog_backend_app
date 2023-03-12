package com.blog.services;


import com.blog.entities.Blog;

public interface BlogService {

    String createAndReturnBlog(Integer userId, String title, String content) throws Exception;

    String deleteBlog(int blogId) throws Exception;
}