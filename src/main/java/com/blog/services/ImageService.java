package com.blog.services;



public interface ImageService {


    String addImage(int blogId, String description, String dimensions) throws Exception;

    int countImagesInScreen(int id, String screenDimensions);

    String deleteImage(int id) throws Exception;
}