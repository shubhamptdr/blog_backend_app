package com.blog.services;


import com.blog.dtos.request.BlogEntryDto;

public interface BlogService {

    String createAndReturnBlog(BlogEntryDto blogEntryDto) throws Exception;

    String deleteBlog(int blogId) throws Exception;
}