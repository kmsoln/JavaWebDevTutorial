# 第三课：通过详细日志增强事务方法

## 目标

本部分旨在为每个事务操作集成详细的日志记录，确保操作及其结果被记录。

## 步骤

1. **实现日志记录方法**

   **场景**：在增强事务方法的日志记录之前，我们需要实现一个方法来独立处理日志记录，以确保无论主事务的结果如何，日志都能可靠地记录。

   **实现 `logAction` 方法**：创建一个方法来独立记录操作，确保准确跟踪事务结果。我们使用 `Propagation.REQUIRES_NEW` 在单独的事务中执行日志记录操作，使其独立于任何正在进行的事务，并确保即使主事务失败，也能完成日志记录。

   ```java
   @Transactional(propagation = Propagation.REQUIRES_NEW)
   public void logAction(String action, String outcome) {
       Log log = new Log(action, outcome, LocalDateTime.now());
       logRepository.save(log);
   }
   ```

2. **记录学生注册课程**

   **场景**：作为大学管理员，您需要记录学生注册课程的情况，以便跟踪成功的注册和任何潜在的失败。

   **增强 `enrollStudentInCourse` 方法**：修改方法以记录操作的成功或失败。

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
   public void enrollStudentInCourse(UUID studentId, UUID courseId) {
       // 记录注册过程的开始
       logAction("Enroll Student", "Start");

       try {
           // 注册学生到课程的实现
           // ...

           // 记录成功的注册
           logAction("Enroll Student", "Success");
       } catch (Exception e) {
           // 记录失败
           logAction("Enroll Student", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

3. **记录检索课程的学生**

   **场景**：为了维护与课程相关的活动的审计轨迹，您需要记录检索课程的学生，并确保即使发生异常，日志记录也会发生。

   **增强 `getStudentsForCourse` 方法**：修改方法以记录操作的成功或失败。

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
   public List<Student> getStudentsForCourse(UUID courseId) {
       // 记录检索课程学生的开始
       logAction("Retrieve Students for Course", "Start");

       try {
           // 检索课程学生的实现
           // ...

           // 记录成功的检索
           logAction("Retrieve Students for Course", "Success");
           return students;
       } catch (Exception e) {
           // 记录失败
           logAction("Retrieve Students for Course", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

4. **记录添加新课程**

   **场景**：当添加新课程时，记录操作的结果是至关重要的，以跟踪添加的成功或失败。

   **增强 `addNewCourse` 方法**：修改方法以记录操作的成功或失败。

   ```java
   @Transactional(propagation = Propagation.NOT_SUPPORTED)
   public Course addNewCourse(String title) {
       // 记录添加新课程的开始
       logAction("Add New Course", "Start");

       try {
           // 添加新课程的实现
           // ...

           // 记录成功的添加
           logAction("Add New Course", "Success");
           return savedCourse;
       } catch (Exception e) {
           // 记录失败
           logAction("Add New Course", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

---

# [下一步：实现嵌套事务和非事务操作](nested-and-non-transactional-operations.md)