# Query Parameter and Validation

**Description:**

In this continuation, we will explore using query parameters to display messages in the view after handling form submissions. This involves adapting the `thirdView` to show both success and error messages based on query parameters.

**Steps:**

1. **Adapt the View (thirdView.html):**

    - Open the `third.html` file and add sections to display both success and error messages:

      ```html
      <!DOCTYPE html>
      <html lang="en" xmlns:th="http://www.thymeleaf.org">
      <head>
          <!-- Other head elements... -->
      </head>
      <body>
          <!-- Other body elements... -->
 
          <div th:if="${param.addedStudent}">
              <p style="color: green;">Student Added Successfully!</p>
          </div>
 
          <div th:if="${param.error}">
              <p style="color: red;">Error: <strong th:text="${param.error}"></strong></p>
          </div>
 
          <!-- Other content... -->
      </body>
      </html>
      ```

    - Explanation:
        - The `<div th:if="${param.error}">` checks if the query parameter `error` is present in the URL.
        - If the parameter is present, it displays an error message in red, retrieved from `${param.error}`.

2. **Handle Form Submission with Additional Validation (PracticeController):**

    - Update the `addStudent` method in `PracticeController` to include additional validation for the student's mark using an `if-else` structure:

      ```java
      import org.springframework.stereotype.Controller;
      import org.springframework.ui.Model;
      import org.springframework.web.bind.annotation.*;
 
      import java.util.ArrayList;
      import java.util.List;
 
      @Controller
      public class PracticeController {
 
          private final List<StudentModel> students = new ArrayList<>();
 
          // Other methods...
 
          @PostMapping("/addStudent")
          public String addStudent(@ModelAttribute("model") StudentModel model) {
              // Additional validation: Check if the mark is more than 5.
              if (model.getMark() > 5) {
                  // If the mark is more than 5, redirect with an error message.
                  return "redirect:/third?error=Mark should not be more than 5";
              } else {
                  students.add(model);
 
                  return "redirect:/third?addedStudent=true";
              }
          }
      }
      ```

## Result
Your view should look like that:
![third-view-error.png](../../../srcs/a-thymeleaf/third-view-success.png)
![third-view-error.png](../../../srcs/a-thymeleaf/third-view-error.png)


**Conclusion:**

You have successfully adapted the `third` to display both success and error messages based on query parameters. This provides a more comprehensive feedback mechanism for users interacting with the form.

# [NEXT TASK: *Fragments and Layouts*](fragments-and-layouts.md)