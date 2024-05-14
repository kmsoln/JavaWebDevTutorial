# Setup Server Authorization

This task you through setting up authorization in your application by configuring security rules using Spring Security. By defining authorization rules, you can control access to specific paths and endpoints within your application.

## Goal

Configure authorization rules to restrict or allow access to various paths and endpoints in the application.

## Steps

1. **Add Security Configuration:**

   In the `WebSecurityConfig` class, add the `configure(HttpSecurity http)` method to define security rules for the application. We'll use the paths and endpoints defined in the previous lab work.

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   .requestMatchers("/first").permitAll()
                   .requestMatchers("/second").permitAll()
                   .requestMatchers("/third").permitAll()
                   .requestMatchers("/fourth").permitAll()
                   .requestMatchers("/addStudent").permitAll()
                   .requestMatchers("/removeStudent").permitAll()
               );
       }
   }
   ```

   In this configuration:
    - We use `.authorizeHttpRequests()` to define authorization rules.
    - Inside the lambda expression, we specify which requests should be permitted.

---

# [NEXT TASK: Authorize Authenticated Users](authorize-server-authenticated.md)