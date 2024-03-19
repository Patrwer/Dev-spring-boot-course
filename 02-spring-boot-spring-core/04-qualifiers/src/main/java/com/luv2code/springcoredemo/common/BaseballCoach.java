package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{


    @Override
    public String getDailWorkout() {
        return "Spend 30minutes in batting practice";
    }
}
