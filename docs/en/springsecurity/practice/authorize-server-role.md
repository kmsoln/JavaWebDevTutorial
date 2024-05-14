# Authorize by Role

This task outlines the process of authorizing users based on their roles in your application. By assigning different roles to users, you can control access to specific resources or functionalities.

## Goal

Authorize access to the `/third` path for users with the `ROLE_MODERATOR` role and the `/fourth` path for users with the `ROLE_ADMIN` role.

## Steps

1. **Update Security Configuration:**

   In the `WebSecurityConfig` class, modify the `configure(HttpSecurity http)` method to specify role-based access control for the `/third` and `/fourth` paths.

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // Other Endpoints...
                   .requestMatchers("/third").hasAuthority("ROLE_MODERATOR")
                   .requestMatchers("/fourth").hasAuthority("ROLE_ADMIN")
                   // Other Endpoints...
               );
       }
   }
   ```

   In this configuration:
    - The `.requestMatchers("/third").hasAuthority("ROLE_MODERATOR")` statement specifies that access to the `/third` path should be restricted to users with the `ROLE_MODERATOR` authority.
    - Similarly, `.requestMatchers("/fourth").hasAuthority("ROLE_ADMIN")` restricts access to the `/fourth` path to users with the `ROLE_ADMIN` authority.

---

# [NEXT TASK: Authorize by Authority](authorize-server-authority.md)