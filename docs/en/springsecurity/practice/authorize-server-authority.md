# Authorize by Authority

This task outlines the process of authorizing users based on their authorities in your application. By assigning different authorities to users, you can control access to specific functionalities or actions.

## Goal

Authorize access to the `/addStudent` path for users with the `WRITE` authority and the `/removeStudent` path for users with the `DELETE` authority.

## Steps

1. **Update Security Configuration:**

   In the `WebSecurityConfig` class, modify the `configure(HttpSecurity http)` method to specify authority-based access control for the `/addStudent` and `/removeStudent` paths.

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // Other Endpoints...
                   .requestMatchers("/addStudent").hasAuthority("WRITE")
                   .requestMatchers("/removeStudent").hasAuthority("DELETE")
                   // Other Endpoints...
               );
       }
   }
   ```

   In this configuration:
    - The `.requestMatchers("/addStudent").hasAuthority("WRITE")` statement specifies that access to the `/addStudent` path should be restricted to users with the `WRITE` authority.
    - Similarly, `.requestMatchers("/removeStudent").hasAuthority("DELETE")` restricts access to the `/removeStudent` path to users with the `DELETE` authority.

---

# [NEXT TASK: Custom Login Form](custom-login-form.md)