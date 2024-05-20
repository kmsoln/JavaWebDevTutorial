# Lesson 2: Implementing Basic Transactional Operations

## Goal

This part aims to introduce simple yet important transactional methods for enrolling students and managing courses in a Spring Boot application.

## Steps

1. **Enrolling a Student in a Course**

   **Scenario**: As a university administrator, you need to enroll a student in a course. This action should be smooth and ensure that even if multiple enrollments happen at the same time or if there are any database issues, data integrity remains intact.

   **Implement `enrollStudentInCourse` Method**: Create a method to enroll a student in a course. Ensure that this process is transactional, meaning it's like a single package deal that guarantees everything happens correctly together. We use `Propagation.REQUIRED` to ensure that this method participates in any existing transaction or creates a new one if none exists. Additionally, we set `Isolation.SERIALIZABLE` to ensure that even if there are concurrent transactions, they don't interfere with each other, maintaining the integrity of the data.

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
   public void enrollStudentInCourse(UUID studentId, UUID courseId) {
       // Your implementation here
   }
   ```

2. **Fetching Students for a Course**

   **Scenario**: To create a class roster for a course, you need to fetch a list of students who have enrolled. This operation should make sure that you always get an accurate view of the database, even if other activities are happening simultaneously.

   **Implement `getStudentsForCourse` Method**: Develop a method to retrieve students for a particular course. It should ensure that the data you fetch is consistent, regardless of any ongoing transactions. We use `Propagation.REQUIRED` to make sure this method participates in any existing transaction or creates a new one if none exists. We set `Isolation.READ_COMMITTED` to ensure that the data we fetch is committed and visible to other transactions, maintaining consistency.

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
   public List<Student> getStudentsForCourse(UUID courseId) {
       // Your implementation here
   }
   ```

3. **Adding a New Course**

   **Scenario**: A new course is about to be introduced to the curriculum. When adding it to the system, you want to make sure this operation doesn't interfere with anything else going on, maintaining its independence.

   **Implement `addNewCourse` Method**: Create a method to add a new course to the system. Make sure this process doesn't get tangled up with any other ongoing transactions. We use `Propagation.NOT_SUPPORTED` to ensure that this method doesn't participate in any existing transaction, giving it autonomy and avoiding any potential conflicts with other operations.

   ```java
   @Transactional(propagation = Propagation.NOT_SUPPORTED)
   public Course addNewCourse(String title) {
       // Your implementation here
   }
   ```

---

# [NEXT: Enhancing Transactional Methods with Detailed Logging](third.md)