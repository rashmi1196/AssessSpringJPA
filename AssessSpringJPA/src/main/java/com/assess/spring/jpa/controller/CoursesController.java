package com.assess.spring.jpa.controller;

import com.assess.spring.jpa.entity.Courses;
import com.assess.spring.jpa.entity.Learner;
import com.assess.spring.jpa.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    @GetMapping
    public List<Courses> getAllCourses(){
        return coursesService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Courses getCourseByID(@PathVariable int id){
        return coursesService.getCourseByID(id);
    }

    @PostMapping("/addCourse")
    public Courses addCourse(@RequestBody Courses courses){
        return coursesService.addCourse(courses);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public void deleteCourse(@PathVariable int id){
        coursesService.deleteCourse(id);
    }

    @GetMapping("/size")
    public int getAllRecords(){
        return coursesService.getAllRecords();
    }

    @GetMapping("/present")
    public boolean coursePresentOrNot(@PathVariable int id){
        return coursesService.coursePresentOrNot(id);
    }

}
