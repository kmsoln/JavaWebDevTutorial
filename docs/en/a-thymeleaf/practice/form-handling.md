# Form Handling

**Description:**

In this continuation, we will focus on handling form submissions and rendering the view using the `PracticeController`. This involves passing the model to the view when displaying it and implementing the logic to handle form submissions.

**Steps:**

1. **Show Form View (PracticeController):**

    - Open the `PracticeController` class and add a method to show the form view:

      ```java
      import org.springframework.stereotype.Controller;
      import org.springframework.ui.Model;
      import org.springframework.web.bind.annotation.GetMapping;
 
      @Controller
      public class PracticeController {
 
          // Other methods...
 
          @GetMapping("/third")
          public String showAddStudentForm(Model model) {
              model.addAttribute("model", new StudentModel());
              return "practice/third";
          }
      }
      ```

    - Explanation:
        - `@GetMapping("/addStudentForm")`: This annotation maps the method to handle GET requests for the `/addStudentForm` endpoint.
        - `showAddStudentForm(Model model)`: This method takes a `Model` parameter, adds a new `StudentModel` to it, and returns the view name (`"thirdView"` in this case). Updated to reflect the correct naming of the view.
        - The `Model` is populated with a new `StudentModel` instance, which will be used to bind form fields.

2. **Handle Form Submission (PracticeController):**

    - Add a method in `PracticeController` to handle form submissions:

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
              students.add(model);
 
              return "redirect:/third";
          }
      }
      ```

    - Explanation:
        - `@PostMapping("/addStudent")`: This annotation maps the method to handle POST requests for the `/addStudent` endpoint.
        - `addStudent(@ModelAttribute("model") StudentModel model)`: This method takes the `model` attribute from the form submission (`@ModelAttribute`) and processes it. The form data is automatically bound to the `model` object.
        - The logic inside this method adds the student to the `students` list. In a real-world scenario, you would typically save the student to a database or perform other necessary actions.
        - `return "redirect:/third";`: This line redirects the user back to the form view (`/third`).

**Conclusion:**

You have successfully implemented form handling in Thymeleaf, including showing the form view and handling form submissions in the `PracticeController`. Users can navigate to the form, submit student details.

# [NEXT TASK: *Query Parameter and Validation*](validation.md)