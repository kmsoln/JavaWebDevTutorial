# Lesson 3: Enhancing Transactional Methods with Detailed Logging

## Goal

This part aims to integrate detailed logging for each transactional operation, ensuring actions are logged with their outcomes.

## Steps

1. **Implementing the Logging Method**

   **Scenario**: Before enhancing transactional methods with logging, we need to implement a method to handle logging independently of the main transaction. This ensures that logging occurs reliably, regardless of the outcome of the main transaction.

   **Implement `logAction` Method**: Create a method to log actions independently, ensuring accurate tracking of transaction outcomes. We use `Propagation.REQUIRES_NEW` to execute the logging operation in a separate transaction, making it independent of any ongoing transactions and guaranteeing its completion even if the main transaction fails.

   ```java
   @Transactional(propagation = Propagation.REQUIRES_NEW)
   public void logAction(String action, String outcome) {
       Log log = new Log(action, outcome, LocalDateTime.now());
       logRepository.save(log);
   }
   ```

2. **Logging Enrollment of a Student in a Course**

   **Scenario**: As a university administrator, you need to log the enrollment of a student in a course to keep track of successful enrollments and any potential failures.

   **Enhance `enrollStudentInCourse` Method**: Modify the method to log the action's success or failure.

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
   public void enrollStudentInCourse(UUID studentId, UUID courseId) {
       // Log the start of the enrollment process
       logAction("Enroll Student", "Start");

       try {
           // Implementation to enroll the student in the course
           // ...

           // Log successful enrollment
           logAction("Enroll Student", "Success");
       } catch (Exception e) {
           // Log failure
           logAction("Enroll Student", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

3. **Logging Retrieval of Students for a Course**

   **Scenario**: To maintain an audit trail of course-related activities, you need to log the retrieval of students for a course and ensure that the logging occurs even in case of exceptions.

   **Enhance `getStudentsForCourse` Method**: Modify the method to log the action's success or failure.

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
   public List<Student> getStudentsForCourse(UUID courseId) {
       // Log the start of retrieving students for the course
       logAction("Retrieve Students for Course", "Start");

       try {
           // Implementation to retrieve students for the course
           // ...

           // Log successful retrieval
           logAction("Retrieve Students for Course", "Success");
           return students;
       } catch (Exception e) {
           // Log failure
           logAction("Retrieve Students for Course", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

4. **Logging Addition of a New Course**

   **Scenario**: When adding a new course, it's essential to log the outcome of the operation to track the success or failure of the addition.

   **Enhance `addNewCourse` Method**: Modify the method to log the action's success or failure.

   ```java
   @Transactional(propagation = Propagation.NOT_SUPPORTED)
   public Course addNewCourse(String title) {
       // Log the start of adding a new course
       logAction("Add New Course", "Start");

       try {
           // Implementation to add a new course
           // ...

           // Log successful addition
           logAction("Add New Course", "Success");
           return savedCourse;
       } catch (Exception e) {
           // Log failure
           logAction("Add New Course", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

---

# [NEXT: Implementing Nested Transactions and Non-Transactional Operations](fourth.md)
