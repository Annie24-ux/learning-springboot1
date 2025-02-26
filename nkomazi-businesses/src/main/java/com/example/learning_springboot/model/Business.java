package com.example.learning_springboot.model;

import jakarta.persistence.*;


@Entity(name = "business_info")
@Table(name="business_info")
public class Business {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "contact")
    private String contact;

    @Column(name = "owner")
    private String owner;

    public Long getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void setBusinessId(Long businessId) {
        this.id = businessId;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
