# Authorize Authenticated User

This task outlines the process of authorizing authenticated users in your application. By requiring authentication for specific paths or endpoints, you can ensure that only logged-in users can access certain resources.

## Goal

Authorize access to the `/second` path only for authenticated users while allowing public access to other paths.

## Steps

1. **Update Security Configuration:**

   In the `WebSecurityConfig` class, modify the `configure(HttpSecurity http)` method to specify that access to the `/second` path should be restricted to authenticated users.

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // Other endpoints...
                   .requestMatchers("/second").authenticated()
                   // Other endpoints...
               );
       }
   }
   ```

   In this configuration:
    - We use `.authorizeHttpRequests()` to define authorization rules.
    - The `.requestMatchers("/second").authenticated()` statement specifies that access to the `/second` path should be restricted to authenticated users.

---

# [NEXT TASK: Authorize by Role](authorize-server-role.md)