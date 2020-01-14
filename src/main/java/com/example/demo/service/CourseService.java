package com.example.demo.service;


import com.example.demo.modal.Course;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<CourseDto> findAllCourses(){

        List<Course> classes = courseRepository.findAllClasses();

        List<CourseDto> courses = new ArrayList<>();
        for (Course aClass : classes) {
            CourseDto course = CourseDto.builder()
                    .courseName(aClass.getClassName())
                    .build();
            courses.add(course);
        }

        return courses;
    }

    public List<Course> searchByCourseName(String input){

        return courseRepository.findCourseByName(input);
    }

}
