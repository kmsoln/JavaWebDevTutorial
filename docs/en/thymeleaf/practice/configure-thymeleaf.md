# Configure Thymeleaf in Spring

**Description:**

This task involves setting up Thymeleaf within a Spring application, enabling seamless integration of the template engine for web development.

## **Steps:**

1. **Create Thymeleaf Configuration Class:**
   - In your Spring project, create a new Java class annotated with `@Configuration`. We recommend placing this class in the `config` package.
   - Extend the class with `WebMvcConfigurer`.

    Example:

   ```java
   package edu.labs.thymeleaf.config;

   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

   @Configuration
   public class WebMvcConfig implements WebMvcConfigurer {
       // Configuration code goes here
   }
   ```

    Placing the configuration class in the `config` package enhances organization and ensures a clear structure in your project. Adjust the package name based on your project's structure.

2. **Configure Thymeleaf Template Resolver:**
   - Define a method annotated with `@Bean` to configure the Thymeleaf template resolver.
   - Use `ClassLoaderTemplateResolver` and set the prefix, suffix, template mode, and character encoding.

      ```java
      @Bean
      public ClassLoaderTemplateResolver templateResolver() {
          // Create a ClassLoaderTemplateResolver bean
          ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
       
          // Set the path where Thymeleaf will find templates
          templateResolver.setPrefix("/templates/");
       
          // Set the file extension for templates
          templateResolver.setSuffix(".html");
       
          // Set the template mode to HTML
          templateResolver.setTemplateMode(TemplateMode.HTML);
       
          // Set the character encoding for templates
          templateResolver.setCharacterEncoding("UTF-8");

          // Return the configured template resolver bean
          return templateResolver;
      }
      ```
  
3. **Configure Message Source:**
   - Add a method annotated with `@Bean` to configure the message source using `ReloadableResourceBundleMessageSource`.
   - Set the default encoding.

      ```java
      @Bean
      public MessageSource messageSource() {
          // Create a ReloadableResourceBundleMessageSource bean
          ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
       
          // Set the default encoding for messages
          messageSource.setDefaultEncoding("UTF-8");

          // Return the configured message source bean
          return messageSource;
      }
      ```

4. **Configure Thymeleaf View Resolver:**
   - Create a method annotated with `@Bean` to configure the Thymeleaf view resolver.
   - Set the template engine.

      ```java
      @Bean
      public ViewResolver thymeleafViewResolver() {
          // Create a ThymeleafViewResolver bean
          ThymeleafViewResolver resolver = new ThymeleafViewResolver();
       
          // Set the template engine for the view resolver
          resolver.setTemplateEngine(templateEngine());

          // Return the configured ThymeleafViewResolver bean
          return resolver;
      }
      ```

5. **Configure Thymeleaf Template Engine:**
   - Implement a method annotated with `@Bean` to configure the Thymeleaf template engine.
   - Set the template resolver and template engine message source.

      ```java
      @Bean
      public SpringTemplateEngine templateEngine() {
          // Create a SpringTemplateEngine bean
          SpringTemplateEngine templateEngine = new SpringTemplateEngine();
       
          // Set the template resolver for the template engine
          templateEngine.setTemplateResolver(templateResolver());
       
          // Set the template engine message source
          templateEngine.setTemplateEngineMessageSource(messageSource());

          // Return the configured SpringTemplateEngine bean
          return templateEngine;
      }
      ```

---

---

# [NEXT TASK: *Create First View*](create-first-view.md)