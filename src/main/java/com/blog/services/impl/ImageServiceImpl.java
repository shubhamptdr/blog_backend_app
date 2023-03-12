package com.blog.services.impl;

import com.blog.dtos.request.ImageEntryDto;
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
    public String addImage(ImageEntryDto imageEntryDto) throws Exception {
        // fetch blog entity
        Blog blog = blogRepository2.findById(imageEntryDto.getBlogId()).get();
        if (blog == null)
            throw new Exception("Blog not found");

        // create image entity
        Image image = Image.builder()
                .dimensions(imageEntryDto.getDimensions())
                .description(imageEntryDto.getDescription())
                .blog(blog)
                .build();

        //save parent------------------
        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return "Added image successfully";
    }

    @Override
    public int countImagesInScreen(int id, String screenDimensions) {
        String [] scrArray = screenDimensions.split("X");

        // fetch image entity
        Image image = imageRepository2.findById(id).get();

        String imageDimensions = image.getDimensions();
        String [] imgarray = imageDimensions.split("X");

        int scrL = Integer.parseInt(scrArray[0]);
        int scrB = Integer.parseInt(scrArray[1]);

        int imgL = Integer.parseInt(imgarray[0]);
        int imgB = Integer.parseInt(imgarray[1]);


        return noImages(scrL,scrB,imgL,imgB);
    }

    private int noImages(int scrl, int scrb, int imgl, int imgb) {
        int lenC = scrl/imgl;
        int lenB = scrb/imgb;
        return lenC*lenB;
    }

    @Override
    public String deleteImage(int id) throws Exception {

        Image image = imageRepository2.findById(id).get();
        if(image == null)
            throw new Exception("Image not found");

        imageRepository2.delete(image);

        return "Deleted image successfully";
    }
}
