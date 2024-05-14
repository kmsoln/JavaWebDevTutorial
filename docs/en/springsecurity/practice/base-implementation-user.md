# Create Base Implementation for User

In this task, we will focus on creating a base implementation for managing users in your application. This includes defining the UserDetails entity, creating a repository to manage user data, and implementing a UserDetailsService to load user details during authentication.

## Goal

The goal of this task is to establish a solid foundation for managing users within your application. By implementing UserDetails, UsersRepository, and UserDetailsService, you will be able to authenticate users, manage their details, and perform user-related operations efficiently.

## Steps

1. **Define UserDetails Entity**

   Start by defining a UserDetails entity that represents the user details in your application. This entity should implement the UserDetails interface provided by Spring Security.

   ```java
   package edu.labs.yourproject.model;

   import org.springframework.security.core.GrantedAuthority;
   import org.springframework.security.core.userdetails.UserDetails;

   import java.util.Collection;

   public class CustomUserDetails implements UserDetails {
   
       // Implement UserDetails methods here
   
   }
   ```

   Implement the methods required by the UserDetails interface to provide user details such as username, password, authorities, etc.

2. **Create UsersRepository Class**

   Since we are using in-memory storage for now, we'll create a simple UsersRepository class to manage user data.

   a. **Create UsersRepository Class**

   Create a new Java class named `UsersRepository` inside the `edu.labs.yourproject.repository` package.

      ```java
      package edu.labs.yourproject.repository;

      import org.springframework.stereotype.Repository;
      import edu.labs.yourproject.model.CustomUserDetails;

      @Repository
      public class UsersRepository {
   
          private List<CustomUserDetails> users = new ArrayList<>();
   
          // Add methods for managing users as needed
      }
      ```

   This class will serve as the repository for managing user data. We'll add methods to retrieve, add, update, and delete users in subsequent steps.

   b. **Add findByUsername Method**

   Add a method named `findByUsername` to the `UsersRepository` class. This method will retrieve user details by username from the repository.

      ```java
        public CustomUserDetails findByUsername(String username) {
            for (CustomUserDetails user : users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null; // User not found
        }
      ```

   The `findByUsername` method is used to retrieve user details by username from the repository. In this placeholder implementation, it returns `null`, but you'll replace it with the actual logic to fetch user details from the database or any other data source.

3. **Implement UserDetailsService**

   In this step, we will implement a UserDetailsService to load user details during authentication. This service will retrieve user information from the UsersRepository.

   a. **Create CustomUserDetailsService Class**

   Start by creating a new class named `CustomUserDetailsService` within your project's service package. This class will implement the UserDetailsService interface provided by Spring Security.

      ```java
      package edu.labs.yourproject.service;

      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.security.core.userdetails.UserDetails;
      import org.springframework.security.core.userdetails.UserDetailsService;
      import org.springframework.security.core.userdetails.UsernameNotFoundException;
      import org.springframework.stereotype.Service;
      import com.yourcompany.yourproject.model.CustomUserDetails;
      import com.yourcompany.yourproject.repository.UsersRepository;

      @Service
      public class CustomUserDetailsService implements UserDetailsService {
      
          private final UsersRepository usersRepository;

          @Autowired
          public CustomUserDetailsService(UsersRepository usersRepository) {
              this.usersRepository = usersRepository;
          }

          // Implement methods here
      }
      ```

   We create the `CustomUserDetailsService` class and autowire the `UsersRepository` dependency using constructor injection.

   b. **Override loadUserByUsername Method**

   Override the `loadUserByUsername` method defined in the UserDetailsService interface. This method will retrieve user details from the UsersRepository based on the provided username.

      ```java
      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          // Retrieve user details from the in-memory repository
          CustomUserDetails userDetails = usersRepository.findByUsername(username);
          if (userDetails == null) {
              throw new UsernameNotFoundException("User not found with username: " + username);
          }
          return userDetails;
      }
      ```

   Inside the `loadUserByUsername` method, we call the `findByUsername` method of the UsersRepository to retrieve user details by username. If the user is not found, we throw a UsernameNotFoundException.

4. **Configure Beans in WebSecurityConfig**

   Open the WebSecurityConfig class located in your project's configuration package (`edu.labs.yourproject.config`). Inside this class, define beans for CustomUserDetails and UserDetailsRepository.

   ```java
   package edu.labs.yourproject.config;

   import edu.labs.yourproject.model.CustomUserDetails;
   import edu.labs.yourproject.repository.UserDetailsRepository;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;

   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig {

       // The rest of code is here...
    
       @Bean
       public CustomUserDetailsService customUserDetailsService() {
           // Instantiate and configure CustomUserDetails bean
           return new CustomUserDetailsService();
       }

       @Bean
       public UserDetailsRepository userDetailsRepository() {
           // Instantiate and configure UserDetailsRepository bean
           return new UserDetailsRepository();
       }
   }
   ```

   Define two bean methods: `CustomUserDetailsService()` and `userDetailsRepository()`. These methods instantiate and configure CustomUserDetailsService and UserDetailsRepository beans, respectively.

## Folder Structure

Your project's folder structure should resemble the following:

```
src
└── main
    └── java
        └── edu
            └── labs
                └── yourproject
                    ├── model
                    │   └── CustomUserDetails.java
                    ├── repository
                    │   └── UsersRepository.java
                    └── service
                        └── CustomUserDetailsService.java
```

This folder structure indicates where to create the `CustomUserDetailsService` class and the `UsersRepository` interface within your project. Organizing your classes in this manner helps maintain a clear and structured codebase.

---

# [NEXT TASK: Password Encryption](password-encryption.md)