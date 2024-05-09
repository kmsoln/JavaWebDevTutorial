# Iteration

**Description:**

In this task, you will explore the concept of iteration in Thymeleaf by creating a `StudentModel` class in the `models/` package and populating a list of students in the `PracticeController`. The goal is to pass the list of students to the `secondView` and render a table displaying the student details.

**Steps:**

1. **Create StudentModel:**
    - In the `models/` package, create a `StudentModel` class with the following attributes:

   ```java
   public class StudentModel {
       private Integer id = 0;
       private String firstName = "";
       private String sureName = "";
       private Boolean isGraduated = false;
       private Integer mark = 0;
   
       // Constructor, getters, and setters
   }
   ```

2. **Populate List of Students in PracticeController:**
    - In the `PracticeController` class, create a list of `StudentModel` and populate it with fake student details:

   ```java
   @Controller
   public class PracticeController {
       private final List<StudentModel> students = new ArrayList<>();
   
       public PracticeController() {
           // Populate the list with users
           this.students.add(new StudentModel(1, "First", "User", true, 4));
           this.students.add(new StudentModel(2, "Second", "User", false, 2));
           this.students.add(new StudentModel(3, "Third", "User", true, 5));
           this.students.add(new StudentModel(4, "Fourth", "User", false, 3));
       }
   
       // Rest of the controller methods
   }
   ```

3. **Pass Students to secondView:**
    - In the `secondView` method of the `PracticeController`, add the list of students to the model.

   ```java
   @Controller
   public class PracticeController {
       // Other methods...
   
       @GetMapping("/second")
       public String secondView(Model model) {
           // Pass the list of students to the view
           model.addAttribute("students", students);
           // Rest of the method...
       }
   }
   ```

4. **Render Students Table in second.html:**
    - Open the `second.html` Thymeleaf view file.

5. **Render Table Header:**
    - Add the table header section within the `<thead>` tag:

   ```html
   <table border="1">
       <thead>
       <tr>
           <th>Id</th>
           <th>FirstName</th>
           <th>sureName</th>
           <th>Graduated</th>
           <th>Mark</th>
       </tr>
       </thead>
       <!-- Rest of the table... -->
   </table>
   ```

6. **Render Table Body with Iteration:**
    - Add the table body section within the `<tbody>` tag and iterate over the list of students to render each row:

   ```html
   <tbody>
       <!-- Iterate over the list of students and render each row -->
       <tr th:each="student : ${students}">
           <td th:text="${student.id}"></td>
           <td th:text="${student.firstName}"></td>
           <td th:text="${student.sureName}"></td>
           <td th:text="${student.isGraduated}"></td>
           <td th:text="${student.mark}"></td>
       </tr>
   </tbody>
   ```

## Result
Your page should look like that:

![second-view.png](../../../srcs/a-thymeleaf/second-view.png)

**Conclusion:**

You have successfully implemented iteration in Thymeleaf by creating a list of `StudentModel` objects, passing it to the `secondView`, and rendering a table of students in the `second.html` view. This approach allows you to dynamically display data in tables based on the provided model.

# [NEXT TASK: *Literals*](literals.md)