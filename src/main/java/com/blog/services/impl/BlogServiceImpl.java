package com.blog.services.impl;

import com.blog.dtos.request.BlogEntryDto;
import com.blog.dtos.response.BlogResponseDto;
import com.blog.entities.Blog;
import com.blog.entities.User;
import com.blog.repositories.BlogRepository;
import com.blog.repositories.UserRepository;
import com.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;
    @Override
    public String createAndReturnBlog(BlogEntryDto blogEntryDto) throws Exception {

        User user = userRepository1.findById(blogEntryDto.getUserId()).get();
        if(user == null)
            throw new Exception("User not found");

        // create blog entity
        Blog blog = Blog.builder()
                .title(blogEntryDto.getTitle())
                .content(blogEntryDto.getContent())
                .user(user)
                .pubDate(new Date())
                .build();

        // save parent -------
        user.getBlogList().add(blog);
        userRepository1.save(user);
        return "Blog created successfully";
    }

    @Override
    public String deleteBlog(int blogId) throws Exception {

        Blog blog = blogRepository1.findById(blogId).get();

        if(blog == null)
            throw new Exception("Blog not found");

        blogRepository1.deleteById(blogId);
        return "Blog deleted successfully";
    }

    @Override
    public List<BlogResponseDto> getAllBlog(int userId) {

        User user = userRepository1.findById(userId).get();
        List<BlogResponseDto> blogResponseDtoList = new ArrayList<>();

        for (Blog blog : user.getBlogList()){
            BlogResponseDto blogResponseDto = BlogResponseDto.builder()
                    .id(blog.getId())
                    .title(blog.getTitle())
                    .content(blog.getContent())
                    .pubDate(blog.getPubDate())
                    .build();
            blogResponseDtoList.add(blogResponseDto);
        }

        return blogResponseDtoList;

    }
}
