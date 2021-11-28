package com.wwsi.lab6.service;

import com.wwsi.lab6.model.db.Photo;
import com.wwsi.lab6.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MongoService {

    @Autowired(required = false)
    private PhotoRepository photoRepository;

    public List<Photo> getAll(){
        return photoRepository.findAll();
    }

    public Photo savePhoto(String id, String url, String description, List<String> tags) {
        return photoRepository.save(
                Photo.builder()
                        .name(id)
                        .creationDate(LocalDateTime.now())
                        .description(description)
                        .tags(tags)
                        .url(url)
                        .build());
    }

    //public void deleteByName(String id) {
    //    photoRepository.deleteByName(id);
    //}

    public void deleteById(String id){ photoRepository.deleteById(id);}
    public Optional<Photo> findOne(String id) {
        return photoRepository.findById(id);
    }
}
