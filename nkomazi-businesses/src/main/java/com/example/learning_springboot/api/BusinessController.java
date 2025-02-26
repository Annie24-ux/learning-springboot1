package com.example.learning_springboot.api;


import com.example.learning_springboot.model.Business;
import com.example.learning_springboot.persistence.BusinessRepository;
import com.example.learning_springboot.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/businesses")
@RestController
public class BusinessController{
    private final BusinessService businessService;
    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessController(BusinessService businessService, BusinessRepository businessRepository) {

        this.businessService = businessService;
        this.businessRepository = businessRepository;
    }

    @PostMapping
    public ResponseEntity<Business>  addBusiness(@RequestBody Business business) {

        try{
            Business addedBusiness = businessService.saveBusiness(business);
            return ResponseEntity.ok(addedBusiness);

        }  catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Business>> getBusinesses() {
        List<Business> businesses = businessService.getBusinesses();

        return ResponseEntity.ok(businesses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusinessbyId(@PathVariable Long id) {
        Business businessWithId = businessService.getBusinessById(id);

        return ResponseEntity.ok(businessWithId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Business> updateBusiness(@PathVariable Long id, @RequestBody Business updatedBusiness) {

        try {
            Business newBusiness = businessService.updateBusiness(id, updatedBusiness);
            return ResponseEntity.ok(newBusiness);
        } catch (RuntimeException e) {
            System.out.println("Duplicates are not allowed.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }



    @GetMapping("/{name}")
    public ResponseEntity<List<Business>> getBusinessesByName(@PathVariable String name) {


        List<Business> ownersBusiness = businessService.businessesByOwners(name);
        if (ownersBusiness.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ownersBusiness);
    }


}

