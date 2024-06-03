# Custom Login Form

This task guides you through the process of enabling a custom login form for authentication using Spring Security. By implementing a custom login form, users can securely authenticate into your application.

## Goal

Activate the custom login form page that has already been created in specific path.

## Steps

1. **Update Security Configuration:**

   In the `WebSecurityConfig` class, modify the `configure(HttpSecurity http)` method to specify the custom login page.

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // Add other authorization configurations here
               )
               .formLogin((login) -> login
                   .loginPage("/custom-login-page") // Specify the custom login page URL
                   // Add other form login configurations here
               );
       }
   }
   ```

   In this configuration:
    - The `.loginPage("/custom-login-page")` statement specifies the URL of the custom login page.
    - You can add additional configurations to customize the form login behavior, such as setting login success or failure URLs, defining form field names, etc.

---

# [NEXT: TASKS](../lab-work.md)
