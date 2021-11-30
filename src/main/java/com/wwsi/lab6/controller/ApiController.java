package com.wwsi.lab6.controller;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.models.BlobItem;
import com.wwsi.lab6.model.UploadPhoto;
import com.wwsi.lab6.model.db.Photo;
import com.wwsi.lab6.service.BlobService;
import com.wwsi.lab6.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Optional;

@RestController
public class ApiController {

    private String BLOB_STRING = "https://gallerymdrobot.blob.core.windows.net/gallery/";

    final
    MongoService mongoService;

    final
    BlobService blobService;

    public ApiController(MongoService mongoService, BlobService blobService) {
        this.mongoService = mongoService;
        this.blobService = blobService;
    }

    @DeleteMapping("/api/v1/photo/{id}")
    public ModelAndView deletePhoto(@PathVariable("id") String id){
        try{
            Optional<Photo> photo = mongoService.findOne(id);
            if(photo.isPresent()){
                blobService.deleteBlob(photo.get().getName());
                mongoService.deleteById(id);
            }

        } catch (Exception ex){

        }
        return new ModelAndView("redirect:/gallery");
    }

    @PostMapping("/api/v1/photo")
    public ModelAndView uploadPhoto(@RequestParam("file") MultipartFile file, UploadPhoto uploadPhoto){
        try{
            blobService.uploadBlob(file.getOriginalFilename(), BinaryData.fromBytes(file.getBytes()));
            String url = BLOB_STRING+file.getOriginalFilename();
            mongoService.savePhoto(uploadPhoto, url, file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/gallery");
    }



}
