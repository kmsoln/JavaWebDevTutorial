# Configure Spring Security

In this task, we will focus on configuring Spring Security in your project. Spring Security provides comprehensive security features for Java applications, including authentication, authorization, and protection against common security threats.

## Goal

The goal of this task is to integrate Spring Security into your existing project, ensuring that your application is secure and protected against unauthorized access.

## Steps

1. **Add Spring Security Dependency**

    - For Maven Projects:

      Add the following dependency to your project's `pom.xml` file:

      ```xml
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-security</artifactId>
      </dependency>
      ```

    - For Gradle Projects:

      Add the following dependency to your project's `build.gradle` file:

      ```groovy
      implementation 'org.springframework.boot:spring-boot-starter-security'
      ```

   Ensure that you include the appropriate version of Spring Security for your project.

2. **Create Security Configuration Class**

   Create a new Java class named `WebSecurityConfig` within your project's source folder structure. Typically, this class resides in the `config` package. The file should be named `WebSecurityConfig.java`.

   Your project's folder structure should resemble the following:

   ```
   src
   └── main
       └── java
           └── edu
               └── labs
                   └── yourproject
                       ├── config
                       │   └── WebMvcConfig.java
                       │   └── WebSecurityConfig.java
                       └── controller
                           └── PracticeController.java
   ```

3. **Configure Security Configuration Class**

   Inside the `WebSecurityConfig` class, annotate it with `@Configuration` and `@EnableWebSecurity` to indicate that it is a configuration class for Spring Security. also will annotate `configure` method with `@Bean`

   ```java
   package edu.labs.yourproject.config;

   import org.springframework.context.annotation.Configuration;
   import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
   import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig {
       
       @Bean
       public SecurityFilterChain configure(HttpSecurity http) throws Exception {
           http
           // Security configuration here
           return http.build();
       }
   }
   ```

## Conclusion

Congratulations! You have successfully configured Spring Security in your project. Your application is now equipped with robust security features to protect against unauthorized access and ensure the confidentiality and integrity of user data.

---

# [Next Task: Create a Base Implementation for User](base-implementation-user.md)
