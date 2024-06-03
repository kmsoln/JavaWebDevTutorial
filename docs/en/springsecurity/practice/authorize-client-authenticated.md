# Authorize Authenticated Users (Client Side)

This task outlines the process of authorizing users based on their authentication status in the client-side view using Thymeleaf. By displaying or hiding elements based on whether the user is authenticated, you can control the visibility of specific functionalities or actions.

## Goal

Control the visibility of elements related to adding and removing students based on whether the user is authenticated in the Thymeleaf views.

## Steps

1. **Update Thymeleaf Templates:**

   Modify the Thymeleaf templates to conditionally display elements based on the user's authentication status.

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
   <head>
       <title>Student Management</title>
   </head>
   <body>
       <h1>Student Management</h1>

       <!-- Add Student Button -->
       <div th:if="${#authorization.expression('isAuthenticated()')}">
           <a href="/addStudent" class="btn btn-primary">Add Student</a>
       </div>

       <!-- Remove Student Button -->
       <div th:if="${#authorization.expression('isAuthenticated()')}">
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
    - The `th:if="${#authorization.expression('isAuthenticated()')}"` statement is used to conditionally display the "Add Student" and "Remove Student" buttons only if the user is authenticated.

## Explanation

- **Thymeleaf Security Dialect**: The `#authorization` object is part of the Thymeleaf Security Dialect, which integrates Spring Security with Thymeleaf.
- **Conditional Display**: The `th:if` attribute is used to conditionally display or hide elements based on the user's authentication status.

By following these steps, you can control the visibility of elements in your Thymeleaf views based on whether the user is authenticated, ensuring that only authenticated users can see and interact with specific functionalities.

---

# [NEXT TASK: Authorize by Role](authorize-client-role.md)
