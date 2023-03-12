package com.blog.services;


import com.blog.dtos.request.ImageEntryDto;

public interface ImageService {


    String addImage(ImageEntryDto imageEntryDto) throws Exception;

    int countImagesInScreen(int id, String screenDimensions);

    String deleteImage(int id) throws Exception;
}