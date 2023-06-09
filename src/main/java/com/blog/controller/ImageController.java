package com.blog.controller;


import com.blog.dtos.request.ImageEntryDto;
import com.blog.dtos.response.ImageResponseDto;
import com.blog.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/")
    public ResponseEntity<String> addImage(@RequestBody ImageEntryDto imageEntryDto) {

        try{
            String response = imageService.addImage(imageEntryDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.OK);
        }

    }

    @GetMapping("/countImagesInScreen/{id}/{screenDimensions}")
    public ResponseEntity<Integer> countImagesInScreen(@PathVariable int id, @PathVariable String screenDimensions) {
        int count = imageService.countImagesInScreen(id,screenDimensions);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable int id) {
        try{
            String response = imageService.deleteImage(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<>(e.getMessage() ,HttpStatus.OK);
        }
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<List<ImageResponseDto>> getAllImage(@PathVariable int blogId) {
        List<ImageResponseDto> response = imageService.getAllImage(blogId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}