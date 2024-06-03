# Authorize by Authority (Client Side)

This task outlines the process of authorizing users based on their authorities in the client-side view using Thymeleaf. By displaying or hiding elements based on user authorities, you can control the visibility of specific functionalities or actions.

## Goal

Control the visibility of elements related to adding and removing students based on the user's authorities in the Thymeleaf views.

## Steps

1. **Update Thymeleaf Templates:**

   Modify the Thymeleaf templates to conditionally display elements based on the user's authorities.

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
   <head>
       <title>Student Management</title>
   </head>
   <body>
       <h1>Student Management</h1>

       <!-- Add Student Button -->
       <div th:if="${#authorization.expression('hasAuthority(''WRITE'')')}">
           <a href="/addStudent" class="btn btn-primary">Add Student</a>
       </div>

       <!-- Remove Student Button -->
       <div th:if="${#authorization.expression('hasAuthority(''DELETE'')}">
           <a href="/removeStudent" class="btn btn-danger">Remove Student</a>
       </div>

       <!-- Other content -->
       <div>
           <p>Welcome to the student management system. Here you can manage student records.</p>
       </div>
   </body>
   </html>
   ```

   In this template:
    - The `th:if="${#authorization.expression('hasAuthority(''WRITE'')')}"` statement is used to conditionally display the "Add Student" button only if the user has the `WRITE` authority.
    - Similarly, the `th:if="${#authorization.expression('hasAuthority(''DELETE'')')}"` statement is used to conditionally display the "Remove Student" button only if the user has the `DELETE` authority.

## Explanation

- **Thymeleaf Security Dialect**: The `#authorization` object is part of the Thymeleaf Security Dialect, which integrates Spring Security with Thymeleaf.
- **Conditional Display**: The `th:if` attribute is used to conditionally display or hide elements based on the user's authorities.

By following these steps, you can control the visibility of elements in your Thymeleaf views based on user authorities, ensuring that only authorized users can see and interact with specific functionalities.

---

# [NEXT TASK: Custom Login Form](custom-login-form.md)
