package com.example.learning_springboot.service;

import com.example.learning_springboot.model.Business;
import com.example.learning_springboot.persistence.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {
    private final BusinessRepository businessRepository;
    public List<Business> ownersBusiness = new ArrayList<>();

    @Autowired
    public BusinessService(BusinessRepository businessRepository) {

        this.businessRepository = businessRepository;
    }

    public Business saveBusiness(Business business) {

        Business existingBusiness = businessRepository.findBusiness(business.getName(),
                business.getDescription(), business.getLocation(), business.getContact(), business.getOwner());

        if (existingBusiness != null) {
            throw new RuntimeException("Business with the same name and location " +
                    "already exists");
        }
        return businessRepository.save(business);

    }


    public List<Business> getBusinesses() {
        List<Business> allBusinesses = businessRepository.findAll();

        return allBusinesses;
    }

    public boolean isBusinessADuplicate(Business x) {
        List<Business> allBusinesses = getBusinesses();

        if(allBusinesses == null) return false;

        for(Business business: allBusinesses) {
            if(business.getName().equals(x.getName()) && business.getLocation().equals(x.getLocation())) {
                return true;
            }
    }
        return false;
    }

    public Business updateBusiness(Long id, Business updatedBusiness) {
            Optional<Business> existingBusiness = businessRepository.findById(id);

        if(existingBusiness.isPresent()) {
            Business newBusinessData = existingBusiness.get();
            newBusinessData.setName(updatedBusiness.getName());
            newBusinessData.setDescription(updatedBusiness.getDescription());
            newBusinessData.setLocation(updatedBusiness.getLocation());
            newBusinessData.setContact(updatedBusiness.getContact());
            newBusinessData.setOwner(updatedBusiness.getOwner());

            if(isBusinessADuplicate(newBusinessData)) {
                System.out.println("Choose another name or location");
                return businessRepository.save(null);
            } else {
                return businessRepository.save(newBusinessData);
        }
        }
        return businessRepository.save(null);
    }


    public Business getBusinessById(Long id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Business with ID " + id + " not found"));
    }



    public List<Business> businessesByOwners(String owner) {
//        String[] details = owner.split(" ");
        List<Business> totalBUsinesses = getBusinesses();
        List<Business> noBusinesses = new ArrayList<>();

        for(Business business1 : totalBUsinesses ){
            if(business1.getOwner().trim().equals(owner.trim())){
                ownersBusiness.add(getBusinessById(business1.getId()));
            }else{
                System.out.println("Owner has no business :)");
                return noBusinesses;
            }
        }
        return ownersBusiness;
    }
    }





//
//    public List<String> getBusinessByOwner(String name) {
//
//        String[] personDetails = name.split(" ");
//
//        if (personDetails.length < 2) {
//        throw new IllegalArgumentException("Full name required (First Last)");
//        }
//
//        String firstName = personDetails[0];
//        String lastName = personDetails[1];
//
////        @Query("SELECT p FROM Person p WHERE p.firstName = :firstName AND p.lastName = :lastName")
////        List<Person> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
//
////
////        List<Business> matchingPeople = businessRepository.
//
//
////                findByFirstNameAndLastName(firstName, lastName);
////
////    if (matchingPeople.isEmpty()) {
////        return Collections.emptyList(); // No matching person found
////    }
//        List<String> ownersBusiness = businessRepository.findAll();
////
//        return ownersBusiness;
//    }



