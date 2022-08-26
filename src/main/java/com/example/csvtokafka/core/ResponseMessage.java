package com.example.csvtokafka.core;

/**
 * @author Hasan DOĞAN
 * IntelliJ IDEA
 * 27.08.2022
 */
public class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}