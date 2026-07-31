package com.example.git_actions_aws_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController
public class GitActionsAwsProjectApplication {

    @GetMapping("/")
    public String home() {
        return "Hello from Spring Boot AWS CI/CD!";
    }

    public static void main(String[] args) {
        SpringApplication.run(GitActionsAwsProjectApplication.class, args);
    }
}
