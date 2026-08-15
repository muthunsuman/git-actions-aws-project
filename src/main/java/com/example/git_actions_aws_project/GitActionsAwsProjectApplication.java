package com.example.git_actions_aws_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GitActionsAwsProjectApplication extends SpringBootServletInitializer {

    @GetMapping("/HomeController")
    public String home() {
        return "Hello from Spring Boot AWS CI/CD!";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GitActionsAwsProjectApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(GitActionsAwsProjectApplication.class, args);
    }
}
