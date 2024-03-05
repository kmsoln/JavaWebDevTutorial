# Working with variables

**Description:**

In this task, you will explore and utilize different types of local variables in Thymeleaf within your Spring application's views. These include variables defined within the view itself, variables passed from the controller, variables defined in a properties file for localization, and static variables defined in the Thymeleaf configuration class.

## **Steps:**

1. **Define Local Variables in Thymeleaf View:**
    - Open your Thymeleaf view file (e.g., `first.html`).
    - Explore the usage of local variables defined directly within the view.
    - In the example code provided:

       ```html
       <head th:with="title='Home'">
           <meta charset="UTF-8">
           <title th:text="${title}">Title</title>
       </head>
       ```

      The local variable `title` is defined within the `<head>` section of the HTML.

2. **Localization Variables from Properties File:**
    - Review the configuration of the `MessageSource` bean in your Thymeleaf configuration class:

       ```java
       @Bean
       public MessageSource messageSource() {
           ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
           messageSource.addBasenames("classpath:local/practice");
           messageSource.setDefaultEncoding("UTF-8");
 
           return messageSource;
       }
       ```
   - Create a `practice.properties` file in the path `/src/main/resources/local/` and add the following content:

         ```properties
         student.name=MyName
         student.group=PRE-121
         message.welcome=Welcome, {0}
         message.info=Your Group is: {0}
         ```
   **Note on `{0}`:**
    - The notation `{0}` in localization messages represents a placeholder for a variable. When the message is rendered, the placeholder `{0}` is replaced with the actual value provided in the message. For example, in the message `Welcome, {0}`, `{0}` will be replaced with the value of the variable, such as a name.

    - Explore the usage of localized variables in the Thymeleaf view using the `#{}` syntax. 
   - In the example code provided:

      ```html
      <h3 th:utext="#{message.welcome(#{student.name})}"></h3>
      <h4 th:utext="#{message.info(#{student.group})}"></h4>
      ```

     The variables `student.name`, `student.group`, `message.welcome` and `message.info` are all implementing this idea.

3. **Static Variables in Thymeleaf Configuration Class:**
    - In your Thymeleaf configuration class, add static variables using the `addStaticVariable` method:

       ```java
       @Bean
       public ViewResolver thymeleafViewResolver() {
           ThymeleafViewResolver resolver = new ThymeleafViewResolver();
           resolver.addStaticVariable("projectName", "Practice Tasks");
           resolver.addStaticVariable("currentDateTime", LocalDateTime.now());
           resolver.setTemplateEngine(templateEngine());
 
           return resolver;
       }
       ```

    - Access these static variables in the Thymeleaf view using the `#vars` syntax.
   - In the example code provided:

      ```html
            <h1 th:utext="${#vars.projectName}">Project Name</h1>
            <h2 th:utext="${#temporals.format(#vars.currentDateTime, 'dd.MM.yy HH:mm')}">Current Date and Time</h2>
      ```
     
## Result

now your page should look like that:
![first-view.png](../../../srcs/a-thymeleaf/first-view.png)

**Conclusion:**

You have successfully explored and implemented various types of local variables in Thymeleaf. Experiment with different scenarios and understand how these variables contribute to dynamic and localized content in your Spring application.

Feel free to refer to the [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html) for more details and advanced features.

# [NEXT TASK: *Variables And Controller*](variables-and-controller.md)