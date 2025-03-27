package com.example.photoz_clone.repository;

import com.example.photoz_clone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository  extends CrudRepository<Photo, Integer> {


}
