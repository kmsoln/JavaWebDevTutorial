# Variables and Controller

**Description:**

In this task, you will create a new Thymeleaf view named `second.html` and explore the concept of passing variables from the controller to the view. Instead of defining the title as a local variable in the view, we will pass it through the controller.

**Steps:**

1. **Create the New View File:**
    - Create a new Thymeleaf view file named `second.html` in the `/src/main/resources/templates/` directory.

   ```plaintext
   Project Directory
   └── src
       └── main
           └── resources
               └── templates
                   └── practice
                       └── second.html
   ```

2. **Define the Controller:**
    - In your controller class (e.g., `PracticeController`), define a method that maps to the URL path associated with the new view. Pass the desired variable (e.g., `title`) to the model.

   ```java
   @Controller
   public class PracticeController {

       @GetMapping("/second")
       public String secondView(Model model) {
           // Pass variables to the view
           model.addAttribute("title", "Second Page");

           // Return the view name
           return "practice/second";
       }
   }
   ```

   This controller method maps to the URL path `/second` and passes the variable `title` with the value "Second Page" to the Thymeleaf view.

3. **Update the View to Use Controller-Passed Variable:**
    - Open the `second.html` Thymeleaf view file.
    - Use the `title` variable passed from the controller in the `<h1>` tag.

   ```html
   <!DOCTYPE html>
   <html lang="en">
       <head>
           <meta charset="UTF-8">
           <title th:text="${title}">Title</title>
       </head>
       <body>
           <h1 th:text="${title}">Welcome to the Second Page</h1>
           <!-- Add your content here -->
           <a th:href="@{'/'}">Go Back to Home</a>
       </body>
   </html>
   ```

   The `th:text="${title}"` expression retrieves the value of the `title` variable passed from the controller.

**Conclusion:**

You have successfully created a new Thymeleaf view (`second.html`) and explored the process of passing variables from the controller to the view. This approach allows for dynamic content generation based on controller logic. Feel free to extend this concept to pass more variables and customize your views further. Now let's continue to the task

# [NEXT TASK: *Iteration*](iteration.md)