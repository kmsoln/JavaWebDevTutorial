# Lesson 4: Implementing Nested Transactions and Non-Transactional Operations

## Goal

This part aims to explore the use of nested transactions and non-transactional operations within the service layer, providing students with insights into managing complex transactional scenarios.

## Steps

1. **Updating Course Details and Enrollments**

   **Scenario**: As a university administrator, you often need to update both the course details and the enrollments associated with that course. This operation should ensure data consistency and integrity, even if multiple updates are performed simultaneously.

   **Implement `updateCourseAndEnrollments` Method**: Define a method to update the course details and enrollments with the required transactional behavior. We use `Propagation.REQUIRED` to ensure that this method participates in any existing transaction or creates a new one if none exists. Setting `Isolation.REPEATABLE_READ` ensures that the data read by this method remains consistent throughout the transaction. Inside this method, we perform a nested transaction by calling the `updateEnrollments` method to update enrollments, ensuring that this operation is atomic and isolated from the outer transaction.

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
   public void updateCourseAndEnrollments(UUID courseId, String newTitle) {
       // Log the start of the update process
       logAction("Update Course and Enrollments", "Start");

       try {
           // Implementation to update course details
           // ...

           // Nested transaction to update enrollments
           updateEnrollments(courseId);

           // Log successful update
           logAction("Update Course and Enrollments", "Success");
       } catch (Exception e) {
           // Log failure
           logAction("Update Course and Enrollments", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

2. **Updating Enrollments Independently**

   **Scenario**: Certain administrative tasks may require updating enrollments independently of course updates. This operation should maintain data consistency while allowing for separate transactional control.

   **Implement `updateEnrollments` Method**: Define a method to update enrollments for a course with nested transactional behavior. We use `Propagation.NESTED` to indicate that this method is executed within the scope of the outer transaction but can be rolled back independently if needed. Setting `Isolation.REPEATABLE_READ` ensures that the data read by this method remains consistent throughout the transaction.

   ```java
   @Transactional(propagation = Propagation.NESTED, isolation = Isolation.REPEATABLE_READ)
   public void updateEnrollments(UUID courseId) {
       // Log the start of the enrollment update process
       logAction("Update Enrollments", "Start");

       try {
           // Implementation to update enrollments
           // ...

           // Log successful update
           logAction("Update Enrollments", "Success");
       } catch (Exception e) {
           // Log failure
           logAction("Update Enrollments", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

---

# [NEXT: Tasks](../../lab-work.md)