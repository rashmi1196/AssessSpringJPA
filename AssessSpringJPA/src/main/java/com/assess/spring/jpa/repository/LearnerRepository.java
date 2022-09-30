package com.assess.spring.jpa.repository;

import com.assess.spring.jpa.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LearnerRepository extends JpaRepository<Learner,Integer> {

    @Modifying
    @Query("SELECT l FROM Learner l Where l.learner_email = :learner_email AND l.learner_last_name = :learner_last_name" )
    List<Learner> findByEmailAddressAndLastname(@Param("learner_email") String email, @Param("learner_last_name") String last_name );

    @Modifying
    @Query("SELECT DISTINCT l FROM Learner l Where l.learner_first_name = :learner_first_name OR l.learner_last_name = :learner_last_name" )
    List<Learner> findDistinctLearnerByLastnameOrFirstname(@Param("learner_first_name") String first_name, @Param("learner_last_name") String last_name );

    @Modifying
    @Query("SELECT l FROM Learner l  WHERE UPPER(l.learner_last_name) = :learner_last_name OR LOWER(l.learner_last_name) = :learner_last_name" )
    List<Learner> findByLastnameIgnoreCase(@Param("learner_last_name") String last_name );

    @Modifying
    @Query("SELECT l  FROM Learner l  WHERE l.learner_last_name = :learner_last_name ORDER BY learner_first_name ASC" )
    List<Learner> findByLastnameOrderByFirstnameAsc(@Param("learner_last_name") String last_name );

}
