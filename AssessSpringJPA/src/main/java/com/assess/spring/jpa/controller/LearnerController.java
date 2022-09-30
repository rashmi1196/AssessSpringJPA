package com.assess.spring.jpa.controller;

import com.assess.spring.jpa.entity.Courses;
import com.assess.spring.jpa.entity.Learner;
import com.assess.spring.jpa.service.CoursesService;
import com.assess.spring.jpa.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/learners")
public class LearnerController {

    @Autowired
    LearnerService learnerService;

    @Autowired
    CoursesService coursesService;

    @GetMapping
    public List<Learner> getAllLearner(){
        return learnerService.getAllLearner();
    }

    @GetMapping("/{id}")
    public Learner getLearnerByID(@PathVariable int id){
        return learnerService.getLearnerByID(id);
    }

    @PostMapping("/addLearner")
    public Learner addLearner(@RequestBody Learner learner){
        return learnerService.addLearner(learner);
    }

    @DeleteMapping("/deleteLearner/{id}")
    public void deleteLearner(@PathVariable int id){
        learnerService.deleteLearner(id);
    }

    @GetMapping("/size")
    public int getAllRecords(){
        return learnerService.getAllRecords();
    }

    @GetMapping("/present/{id}")
    public boolean learnerPresentOrNot(@PathVariable int id){
        return learnerService.learnerPresentOrNot(id);
    }

    @PutMapping("/{id}/courses/{course_id}")
    public Learner assignDetails (@PathVariable int id, @PathVariable int course_id){
        Courses courses = coursesService.getCourseByID(course_id);
        System.out.println(courses);
        return learnerService.assignProfile(id,courses);
    }

    @PostMapping(value = "/findByEmailAndLastName")
    public List<Learner> findByEmailAndLastName(@RequestBody Map<String,String> response){
         return learnerService.findByEmailAddressAndLastname(response.get("learner_email").toString(),response.get("learner_last_name").toString());
    }

    @PostMapping("/findDistinctLearnerByLastnameOrFirstname")
    public List<Learner> findDistinctLearnerByLastnameOrFirstname(@RequestBody Map<String,String> response){
            return learnerService.findDistinctLearnerByLastnameOrFirstname(response.get("learner_first_name"),response.get("learner_last_name"));
    }

    @PostMapping("/findByLastnameIgnoreCase")
    public List<Learner> findByLastnameIgnoreCase(@RequestBody Map<String,String> response){
        return learnerService.findByLastnameIgnoreCase(response.get("learner_last_name"));
    }

    @PostMapping("/findByLastnameOrderByFirstnameAsc")
    public List<Learner> findByLastnameOrderByFirstnameAsc(@RequestBody Map<String,String> response){
        return learnerService.findByLastnameOrderByFirstnameAsc(response.get("learner_last_name"));
    }

}
