package com.blog.services;


public interface ImageService {


    void addImage(int blogId, String description, String dimensions);

    int countImagesInScreen(int id, String screenDimensions);

    void deleteImage(int id);
}