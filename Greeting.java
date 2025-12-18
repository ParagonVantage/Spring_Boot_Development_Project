package com.example.springdemo;

public class Greeting {
    private String message;
    private String author;

    public Greeting(String message, String author) {
        this.message = message;
        this.author = author;
    }

    // getters (Spring uses these to build JSON)
    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }
}
