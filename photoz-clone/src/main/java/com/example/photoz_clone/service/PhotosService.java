package com.example.photoz_clone.service;


import com.example.photoz_clone.model.Photo;
import com.example.photoz_clone.repository.PhotosRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PhotosService {

    private final PhotosRepository photosRepository;

    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public Iterable<Photo> get() {
        return photosRepository.findAll();
    }

    public Optional<Photo> get(Integer id) {
        return photosRepository.findById(id);
    }

    public void remove(Integer id) {
        photosRepository.deleteById(id);
    }
    

    public Photo save(String fileName, String contentType, byte[] data){
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepository.save(photo);
        return photo;
    }
}
