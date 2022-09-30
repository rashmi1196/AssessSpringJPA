package com.assess.spring.jpa.service;

import com.assess.spring.jpa.entity.Courses;
import com.assess.spring.jpa.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository coursesRepository;

    public List<Courses> getAllCourses(){
        return coursesRepository.findAll();
    }

    public Courses getCourseByID(@PathVariable("learner_id") int id){
        Optional<Courses> tempCourses = coursesRepository.findById(id);
        if(tempCourses.isEmpty())
            throw new RuntimeException("Course with "+id+" not found");
        return coursesRepository.findById(id).get();
    }

    public Courses addCourse(Courses courses){
        return coursesRepository.save(courses);
    }

    public void deleteCourse(@PathVariable("course_id") int id){
        Optional<Courses> tempLearner = coursesRepository.findById(id);
        if(tempLearner.isEmpty())
            throw new RuntimeException("Learner with "+id+" not found");
        coursesRepository.deleteById(id);
    }

    public int getAllRecords(){
        return coursesRepository.findAll().size();
    }

    public boolean coursePresentOrNot(@PathVariable("course_id") int id) {
        return coursesRepository.findById(id).isEmpty();
    }
}
