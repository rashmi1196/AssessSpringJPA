package com.assess.spring.jpa.service;

import com.assess.spring.jpa.entity.Courses;
import com.assess.spring.jpa.entity.Learner;
import com.assess.spring.jpa.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class LearnerService {

    @Autowired
    LearnerRepository learnerRepository;

    public List<Learner> getAllLearner(){
        return learnerRepository.findAll();
    }

    public Learner getLearnerByID(@PathVariable("learner_id") int id){
        return learnerRepository.findById(id).get();
    }

    public Learner addLearner(Learner learner){
        return learnerRepository.save(learner);
    }

    public void deleteLearner(@PathVariable("learner_id") int id){
        Optional<Learner> tempLearner = learnerRepository.findById(id);
        if(tempLearner.isEmpty())
            throw new RuntimeException("Learner with "+id+" not found");
        learnerRepository.deleteById(id);
    }

    public int getAllRecords(){
        return learnerRepository.findAll().size();
    }

    public boolean learnerPresentOrNot(@PathVariable("learner_id") int id) {
        return learnerRepository.findById(id).isEmpty();
    }

        public Learner assignProfile(int id, Courses courses){
        Learner learner = learnerRepository.findById(id).get();
        learner.setCourses(courses);
        return learnerRepository.save(learner);
    }

    @Transactional
    public List<Learner> findByEmailAddressAndLastname(String email, String last_name){
        return learnerRepository.findByEmailAddressAndLastname(email,last_name);
    }

    @Transactional
    public List<Learner> findDistinctLearnerByLastnameOrFirstname(String first_name, String last_name){
        return learnerRepository.findDistinctLearnerByLastnameOrFirstname(first_name, last_name);
    }

    @Transactional
    public List<Learner> findByLastnameIgnoreCase(String last_name){
        return learnerRepository.findByLastnameIgnoreCase( last_name);
    }

    @Transactional
    public List<Learner> findByLastnameOrderByFirstnameAsc(String last_name){
        return learnerRepository.findByLastnameOrderByFirstnameAsc( last_name);
    }


}
