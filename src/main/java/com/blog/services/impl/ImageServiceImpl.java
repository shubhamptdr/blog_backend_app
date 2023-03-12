package com.blog.services.impl;

import com.blog.services.ImageService;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public void addImage(int blogId, String description, String dimensions) {

    }

    @Override
    public int countImagesInScreen(int id, String screenDimensions) {
        return 0;
    }

    @Override
    public void deleteImage(int id) {

    }
}
