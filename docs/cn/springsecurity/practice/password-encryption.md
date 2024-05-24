# Password Encryption

In this task, we will configure password encryption for user authentication in a Spring Security-enabled application. Encrypting passwords enhances security by storing them securely in the database.

## Goal

The goal of this setup is to configure password encryption using the BCryptPasswordEncoder provided by Spring Security. This ensures that passwords are securely hashed before being stored in the database.

## Steps

1. **Add BCryptPasswordEncoder Bean**

   Open the WebSecurityConfig class located in your project's configuration package (`edu.labs.yourproject.config`). Inside this class, define a bean for BCryptPasswordEncoder.

   ```java
   package edu.labs.yourproject.config;

   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

   @Configuration
   public class WebSecurityConfig {

       @Bean
       public BCryptPasswordEncoder passwordEncoder() {
           // Instantiate and configure BCryptPasswordEncoder bean
           return new BCryptPasswordEncoder();
       }
   }
   ```

   Define a bean method `passwordEncoder()` that instantiates and configures a BCryptPasswordEncoder bean. This bean will be used to encode passwords before storing them in the database.

2. **Encrypt Passwords**

   a. **Update CustomUserDetailsService Class**

   Open the CustomUserDetailsService class located in your project's service package (`edu.labs.yourproject.service`). Inject the BCryptPasswordEncoder bean into this class.

      ```java
      package edu.labs.yourproject.service;

      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
      import org.springframework.stereotype.Service;
      import edu.labs.yourproject.model.CustomUserDetails;
      import edu.labs.yourproject.repository.UsersRepository;

      @Service
      public class CustomUserDetailsService implements UserDetailsService {

          private final UsersRepository usersRepository;

          @Autowired
          private BCryptPasswordEncoder passwordEncoder;

          @Autowired
          public CustomUserDetailsService(UsersRepository usersRepository) {
              this.usersRepository = usersRepository;
          }
      }
      ```

   b. **Implement Registration Method**

   Define a method in the CustomUserDetailsService class to handle user registration. In this method, encrypt the user's password before saving it to the database.

      ```java
          public void registerUser(CustomUserDetails user) {
              // Encrypt password before saving user
              String encodedPassword = passwordEncoder.encode(user.getPassword());
              user.setPassword(encodedPassword);
              usersRepository.save(user);
          }
      ```

   This method takes a CustomUserDetails object representing the user to be registered. It encrypts the user's password using the BCryptPasswordEncoder bean and then saves the user to the database.

---
# [NEXT TASK: Add a Dummy Users](add-dummy-users.md)