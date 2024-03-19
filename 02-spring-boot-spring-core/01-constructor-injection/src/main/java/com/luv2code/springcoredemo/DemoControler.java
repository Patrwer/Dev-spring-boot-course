package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoControler {

    //define private field for the dependency

    private Coach myCoach;

    // define constructor for dependency

    @Autowired
    public DemoControler(Coach theCoach){

        myCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
        public String getDailyWorkout(){
        return myCoach.getDailWorkout();

    }

}
