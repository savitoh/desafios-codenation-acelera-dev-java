package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    @Query(
            " SELECT " +
                " c " +
            " FROM " +
                " Challenge c " +
            " WHERE " +
                " c = " +
                      "(SELECT " +
                        " a.challenge " +
                      "FROM " +
                        "Acceleration a " +
                      "JOIN " +
                        "a.challenge challenge " +
                      "WHERE " +
                        "a.id = :accelerationId )" +
                " AND c IN " +
                      "(SELECT " +
                         "s.id.challenge " +
                      "FROM " +
                         "Submission s " +
                      "WHERE " +
                         "s.id.user.id = :userId ) "
    )
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,
                                                  @Param("userId") Long userId);
}
