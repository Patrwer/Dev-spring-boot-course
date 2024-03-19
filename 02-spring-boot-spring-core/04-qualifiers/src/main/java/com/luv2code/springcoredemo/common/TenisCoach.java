package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach{
    @Override
    public String getDailWorkout() {
        return "Train backhand more!";
    }
}
