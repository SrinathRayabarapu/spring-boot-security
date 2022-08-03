package com.practice.spring.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.practice.spring.security.SpringBootSecurityApplication.BLOCKING_QUEUE;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld(){
        return "<h2>Welcome page<h2>";
    }

    @GetMapping("/user")
    public String user() throws InterruptedException {
        // starting some task
        new Thread(new SomeTask()).start(); // statemachine
        Object take = BLOCKING_QUEUE.take();
        return "<h2>Welcome, User!<h2> This is your object : " + take;
//        return "<h2>Welcome home, Srinath";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h2>Welcome, Admin!<h2>";
    }

}
