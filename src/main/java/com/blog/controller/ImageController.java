package com.blog.controller;


import com.blog.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/{blogId}/add-image")
    public ResponseEntity<String> addImage(@PathVariable int blogId, @RequestParam String description, @RequestParam String dimensions) {

        try{
            String response = imageService.addImage(blogId,description,dimensions);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable int id) {
        try{
            String response = imageService.deleteImage(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<>(e.getMessage() ,HttpStatus.OK);
        }
    }
}