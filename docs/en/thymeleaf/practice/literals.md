# Literals

**Description:**

In this task, you will enhance the `second.html` Thymeleaf view by incorporating literals to display modified values based on certain conditions. The literals include adding a constant value to the `id`, displaying "Yes" or "No" for the "Graduated" field, and providing descriptive labels for the "Mark" and "Diploma Type" fields.

**Steps:**

1. **Update students-table Fragment in second.html:**
    - Open the `second.html` Thymeleaf view file.

2. **Enhance Literal for Student Id:**
    - Modify the expression for the `id` field to add a constant value (e.g., 100000) to the actual student id.

   ```html
   <td th:text="${student.id + 100000}"></td>
   ```

3. **Enhance Literal for Graduated Field:**
    - Update the expression for the "Graduated" field to display "Yes" if the student is graduated, and "No" otherwise.

   ```html
   <td th:text="${student.isGraduated ? 'Yes' : 'No'}"></td>
   ```

4. **Enhance Literal for Mark Field:**
    - Add conditional expressions to display descriptive labels for the "Mark" field based on the student's mark.

   ```html
   <td th:if="${student.mark == 3}">Good</td>
   <td th:if="${student.mark == 4}">Very Good</td>
   <td th:if="${student.mark == 5}">Excellent</td>
   <td th:if="${student.mark == 1 or student.mark == 2}">Not Passed</td>
   ```

5. **Add Literal for Diploma Type Field:**
    - Add conditional expressions to display descriptive labels for the "Diploma Type" field based on the student's mark and graduation status.

   ```html
   <td th:if="${student.mark == 3 and student.isGraduated}">Blue</td>
   <td th:if="${student.mark == 4 and student.isGraduated}">Blue</td>
   <td th:if="${student.mark == 5 and student.isGraduated}">Red</td>
   <td th:if="${student.mark == 1 or student.mark == 2 or not student.isGraduated}">No Diploma</td>
   ```

## Result
Your view should look like that:

![second-view-enhanced.png](../../../srcs/thymeleaf/second-view-enhanced.png)

---

# [NEXT TASK: *Forms*](forms.md)