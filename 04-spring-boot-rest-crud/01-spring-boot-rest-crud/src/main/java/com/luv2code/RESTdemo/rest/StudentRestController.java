package com.luv2code.RESTdemo.rest;

import com.luv2code.RESTdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Andrew", "Biger"));
        theStudents.add(new Student("Nero", "Paelo"));
        theStudents.add(new Student("Jan", "Second"));

    }

    // define endpoint for "/students" - return lists of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint for /students/{studentId} - return student index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // index into the list ... keeping it simple

        // check the student id against list size

        if ( (studentId > theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found " + studentId);
        }

        return theStudents.get(studentId);

    }
    // adding exception user





}
