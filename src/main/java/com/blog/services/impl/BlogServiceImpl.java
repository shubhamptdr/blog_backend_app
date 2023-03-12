package com.blog.services.impl;

import com.blog.entities.Blog;
import com.blog.entities.User;
import com.blog.repositories.BlogRepository;
import com.blog.repositories.UserRepository;
import com.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;
    @Override
    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        User user = userRepository1.findById(userId).get();
        // create blog and set attr.
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUser(user);
        blog.setPubDate(new Date());

        // save parent
        user.getBlogList().add(blog);
        userRepository1.save(user);
        return blog;
    }

    @Override
    public void deleteBlog(int blogId) {
        blogRepository1.deleteById(blogId);
    }
}
