package com.blog.services;


import com.blog.entities.Image;

public interface ImageService {


    String addImage(int blogId, String description, String dimensions);

    int countImagesInScreen(int id, String screenDimensions);

    void deleteImage(int id);
}