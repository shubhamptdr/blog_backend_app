package com.blog.services.impl;

import com.blog.entities.Blog;
import com.blog.entities.Image;
import com.blog.repositories.BlogRepository;
import com.blog.repositories.ImageRepository;
import com.blog.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;
    @Override
    public String addImage(int blogId, String description, String dimensions) {
        // fetch blog entity
        Blog blog = blogRepository2.findById(blogId).get();
        // create image entity
        Image image = new Image();
        image.setDimensions(dimensions);
        image.setDescription(description);
        image.setBlog(blog);

        //save parent
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return "Added image successfully";
    }

    @Override
    public int countImagesInScreen(int id, String screenDimensions) {
        String [] scrarray = screenDimensions.split("X");

        // fetch image entity
        Image image = imageRepository2.findById(id).get();

        String imageDimensions = image.getDimensions();
        String [] imgarray = imageDimensions.split("X");

        int scrl = Integer.parseInt(scrarray[0]);
        int scrb = Integer.parseInt(scrarray[1]);

        int imgl = Integer.parseInt(imgarray[0]);
        int imgb = Integer.parseInt(imgarray[1]);


        return noImages(scrl,scrb,imgl,imgb);
    }

    private int noImages(int scrl, int scrb, int imgl, int imgb) {
        int lenC = scrl/imgl;
        int lenB = scrb/imgb;
        return lenC*lenB;
    }

    @Override
    public void deleteImage(int id) {
        imageRepository2.deleteById(id);

    }
}
