package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {


    @Query(
            "SELECT " +
                    "distinct c " +
            "FROM " +
                    "Company c " +
            "JOIN " +
                    "Candidate candidate ON candidate.id.company = c " +
            "WHERE " +
                    "candidate.id.acceleration.id = :accelerationId "
    )
    List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);


    @Query(
            "SELECT " +
                    "c " +
            "FROM " +
                    "Company c " +
            "JOIN " +
                    "Candidate candidate ON candidate.id.company = c " +
            "WHERE " +
                    "candidate.id.user.id = :userId "
    )
    List<Company> findByUserId(@Param("userId") Long userId);
}
