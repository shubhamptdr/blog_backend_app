package com.blog.services;


import com.blog.dtos.request.BlogEntryDto;
import com.blog.dtos.response.BlogResponseDto;

import java.util.List;

public interface BlogService {

    String createAndReturnBlog(BlogEntryDto blogEntryDto) throws Exception;

    String deleteBlog(int blogId) throws Exception;

    List<BlogResponseDto> getAllBlog(int userId);
}