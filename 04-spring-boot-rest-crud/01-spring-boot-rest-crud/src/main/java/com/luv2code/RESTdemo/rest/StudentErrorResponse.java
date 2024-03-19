package com.luv2code.RESTdemo.rest;

public class StudentErrorResponse {
    private int Status;
    private String Message;
    private Long timeStamp;

    public StudentErrorResponse(){

    }

    public StudentErrorResponse(int status, String message, Long timeStamp) {
        Status = status;
        Message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
