package com.example.photoz_clone.web;

import com.example.photoz_clone.model.Photo;
import com.example.photoz_clone.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class DownloadController {

    private String id;

    private final PhotosService photosService;

    public DownloadController(@Autowired PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id){
        Optional<Photo> photo = photosService.get(id);
        if (photo.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = photo.get().getData();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.get().getContentType()));
        ContentDisposition build = ContentDisposition.builder("attachment").filename(photo.get().getFileName()).build();
        headers.setContentDisposition(build);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}
