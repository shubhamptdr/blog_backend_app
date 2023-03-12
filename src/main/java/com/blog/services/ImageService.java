package com.blog.services;


import com.blog.dtos.request.ImageEntryDto;
import com.blog.dtos.response.BlogResponseDto;
import com.blog.dtos.response.ImageResponseDto;

import java.util.List;

public interface ImageService {


    String addImage(ImageEntryDto imageEntryDto) throws Exception;

    int countImagesInScreen(int id, String screenDimensions);

    String deleteImage(int id) throws Exception;

    List<ImageResponseDto> getAllImage(int blogId);

}