package com.blog.services;




public interface BlogService {

    void createAndReturnBlog(Integer userId, String title, String content);

    void deleteBlog(int blogId);
}