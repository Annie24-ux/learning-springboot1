package com.example.photoz_clone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTOS")
public class Photo {

    @Id
    private int id;

    @NotEmpty
    private String fileName;

    private String contentType;

    @JsonIgnore
    private byte[] data;



    public Photo(){
    }

    public Integer getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
