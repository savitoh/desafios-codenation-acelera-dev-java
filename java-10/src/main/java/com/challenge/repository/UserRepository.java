package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT " +
                "u " +
            "FROM " +
                "User u " +
            "JOIN " +
                "Candidate c ON c.id.user = u " +
            "WHERE " +
                "c.id.acceleration.name LIKE %:accelerationName%")
    List<User> findByAccelerationName(@Param("accelerationName") String accelerationName);

    @Query("SELECT " +
                "u " +
            "FROM " +
                "User u " +
            "JOIN " +
                "Candidate c ON c.id.user = u " +
            "WHERE " +
                "c.id.company.id = :companyId")
    List<User> findByCompanyId(@Param("companyId") Long companyId);
}
