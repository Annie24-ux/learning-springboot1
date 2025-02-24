package com.example.learning_springboot.persistence;

import com.example.learning_springboot.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

    @Query("SELECT b FROM business_info b WHERE b.name = :name AND b.description = :description AND b.location = :location AND b.contact = :contact AND b.owner = :owner")
    Business findBusiness(
            @Param("name") String name,
            @Param("description") String description,
            @Param("location") String location,
            @Param("contact") String contact,
            @Param("owner") String owner
    );
    boolean
    existsByNameAndDescriptionAndLocationAndContactAndOwnerAndId(String name,
                                                                 String description, String location, String contact,
                                                                 String owner, Long id);

}
