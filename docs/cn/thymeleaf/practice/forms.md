# Forms

**Description:**

In this task, you will create a new Thymeleaf view named `third.html` and implement form handling logic in the `PracticeController`. The form allows users to add a new student with specific details, and the controller will process the form submission.

**Steps:**

1. **Create Third View (third.html):**

    - Create a new Thymeleaf view file named `third.html` in the `/src/main/resources/templates/practice` directory.

      ```html
      <!DOCTYPE html>
      <html lang="en">
          <head>
              <meta charset="UTF-8">
              <title>Add Student Form</title>
          </head>
          <body>
              <fieldset>
                  <legend>Add Student</legend>
      
                  <form action="#" th:action="@{/addStudent}" th:object="${model}" method="post">
                      <!-- Form fields -->
                      <p>
                          <label for="id">ID:</label>
                          <input type="text" id="id" name="id" th:field="*{id}">
                      </p>
                  </form>
              </fieldset>
          </body>
      </html>
      ```

2. **Configure Form Submission:**

    - In the `form` tag, configure the form submission details:

      ```html
      <form action="#" th:action="@{/addStudent}" th:object="${model}" method="post">
      ```

    - Explanation:
        - `action="#"`: This attribute specifies the URL to which the form data will be sent upon submission. `#` indicates the form will be submitted to the same URL it originated from.
        - `th:action="@{/addStudent}"`: This Thymeleaf attribute dynamically sets the form action based on the Thymeleaf expression. `@{/addStudent}` generates the absolute URL for the `/addStudent` endpoint.
        - `th:object="${model}"`: This attribute associates the form with a backing object (`model`). Thymeleaf uses this object to bind form fields to properties during form submission and rendering.
        - `method="post"`: This attribute specifies the HTTP method used when sending form data to the server. It's set to `post`, indicating that the form data will be sent in the request body.

3. **Pass the 'id' Field:**

    - In the form, locate the section for the `id` field:

      ```html
      <!-- Form fields -->
      <p>
          <label for="id">ID:</label>
          <input type="text" id="id" name="id" th:field="*{id}">
      </p>
      ```

    - Explanation:
        - `th:field="*{id}"`: This Thymeleaf attribute binds the input field to the `id` property of the `model` object. It ensures that the value entered in the input field will be set to the `id` property when the form is submitted.
        - `id="id"` and `name="id"`: These attributes provide identifiers for the input field.

4. **Repeat these steps:**

    - Repeat these steps for each remaining field (`firstName`, `sureName`, `isGraduated`, and `mark`). Ensure that you update the `label`, `id`, `name`, and `th:field` attributes accordingly.
    - There is code example:
    ```html
     <!DOCTYPE html>
     <html lang="en">
         <head>
             <meta charset="UTF-8">
             <title>Add Student Form</title>
         </head>
         <body>
             <fieldset>
                 <legend>Add Student</legend>
     
                 <form action="#" th:action="@{/addStudent}" th:object="${model}" method="post">
                     <!-- Form fields -->
                     <p>
                         <label for="id">ID:</label>
                         <input type="text" id="id" name="id" th:field="*{id}">
                     </p>
                     <p>
                         <label for="firstName">First Name:</label>
                         <input type="text" id="firstName" name="firstName" th:field="*{firstName}">
                     </p>
                     <p>
                         <label for="sureName">Sure Name:</label>
                         <input type="text" id="sureName" name="sureName" th:field="*{sureName}">
                     </p>
                     <p>
                         <label for="isGraduated">Graduated:</label>
                         <input type="checkbox" id="isGraduated" name="isGraduated" th:checked="*{isGraduated}">
                     </p>
                     <p>
                         <label for="mark">Mark:</label>
                         <input type="number" id="mark" name="mark" th:field="*{mark}">
                     </p>
                     <!-- Submit button -->
                     <button type="submit">Add Student</button>
                 </form>
             </fieldset>
         </body>
     </html>
     ```

## Result
Your view should look like that:

![third-view.png](../../../srcs/thymeleaf/third-view.png)

**Conclusion:**

You have successfully set up the form in `third.html` and passed each field to the `PracticeController` using Thymeleaf's form binding. 

# [NEXT TASK: *Form Handling*](form-handling.md)