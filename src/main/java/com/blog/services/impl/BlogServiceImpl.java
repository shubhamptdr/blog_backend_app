package com.blog.services.impl;

import com.blog.services.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {
    @Override
    public void createAndReturnBlog(Integer userId, String title, String content) {

    }

    @Override
    public void deleteBlog(int blogId) {

    }
}
