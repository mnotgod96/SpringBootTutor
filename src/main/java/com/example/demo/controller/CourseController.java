package com.example.demo.controller;

import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping(path = "/two-sum/{inputString}", produces = "application/json")
    public HttpEntity<Integer> findIndices(@PathVariable("inputString") String inputString){
       // List<CourseDto> allCourses = courseService.findAllCourses();

        List<Integer> indices = courseService.findIndices(inputString);

        return new ResponseEntity(indices,HttpStatus.OK);
    }
}
