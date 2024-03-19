package com.lu2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

// new endpoint for "workout"

@GetMapping("/workout")
public String getDailyWorkout(){
        return "Run Hard!!!!";


        }
// new endpoint for "fortune"
        @GetMapping("/fortune")
        public String getDailyFortune(){
        return "Today is your lucky day.";
        }


}