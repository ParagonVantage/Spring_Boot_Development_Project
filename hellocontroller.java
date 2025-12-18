package com.example.springdemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Spring from VS Code!";
    }
    
    @GetMapping("/hello/{name}")
    public String sayHelloToName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/api/greeting")
    public Greeting getGreeting() {
    return new Greeting("Hello from a JSON API!", "Spring Boot");
    }
    @PostMapping("/api/greet")
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return new Greeting(
            "Your message: " + greeting.getMessage(),
            "Received from: " + greeting.getAuthor()
        );
    }

}
