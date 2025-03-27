package com.example.photoz_clone.web;


import com.example.photoz_clone.model.Photo;
import com.example.photoz_clone.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/photos")
@CrossOrigin(origins = "http://localhost:63342")
public class PhotozController {

    private final PhotosService photosService;




    public PhotozController(@Autowired PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/")
    public String greet(){
        return "Hello world!";
    }

    @GetMapping
    public Iterable<Photo> get(){
        return photosService.get();
    }

    @GetMapping("/{id}")
    public Optional<Photo> getPhotoById(@PathVariable Integer id){
        Optional<Photo> photo = photosService.get(id);

        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/{id}")
    public void deletePhotoById(@PathVariable Integer id){
        photosService.remove(id);

    }

    @PostMapping
    public Photo createPhoto(@RequestPart("data")MultipartFile file) throws IOException {
        Photo photo = photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
        return photo;

    }

}
