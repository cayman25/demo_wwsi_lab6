package com.wwsi.lab6.service;

import com.wwsi.lab6.model.db.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ApiService {

//    @Autowired
//    AzureBlobService azureBlobService;

    @Autowired
    MongoService mongoService;

//    String containerUrl=System.getenv("BLOB_CONTAINER_URL");

//    public Set<BlobModel> getPhotos(){
//        return azureBlobService.getBlobs()
//                .stream()
//                .map(blobItem -> BlobModel.builder().id(blobItem.getName()).url(containerUrl+blobItem.getName()).build())
//                .collect(Collectors.toSet());
//    }
//
//    public Optional<BlobModel> getPhotosById(String id){
//        return getPhotos().stream().filter(blobModel -> blobModel.getId().equals(id)).findFirst();
//    }
//
//    public void deletePhoto(String id){
//        azureBlobService.deleteBlob(id);
//    }
//
//    public void uploadPhotoToBlob(String id, MultipartFile file){
//        try {
//            azureBlobService.uploadBlob(id, BinaryData.fromBytes(file.getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Iterable<Photo> getAll(){
//        return mongoService.getAll();
//    }

//    public void insertPhotoDetails(){
//        Photo photo = Photo.builder()
//                .creationDate(LocalDateTime.now())
//                .description("aaaaa")
//                .name("test.jpg")
//                .tags(List.of("xxx","yyyy"))
//                .build();
//
//        mongoService.photoRepository.save(photo);
//    }

    public List<Photo> getPhotosFromMongo() {
        return mongoService.getAll();
    }

//    public Photo saveInfoPhotoToMongo(String id, String url, String description, String tags) {
//        return mongoService.savePhoto(id,url,description,tags);
//    }
//
//    public void deletePhotoFromMongo(String id) {
//        String name = mongoService.findOne(id).get().getName();
//        mongoService.deleteByName(name);
//        azureBlobService.deleteBlob(name);
//    }
//
//    public void getPhotosByMongoId(String id) {
//    }
}
