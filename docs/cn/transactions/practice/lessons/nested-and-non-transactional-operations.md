# 第四课：实现嵌套事务和非事务操作

## 目标

本部分旨在探讨在服务层中使用嵌套事务和非事务操作，为学生提供管理复杂事务场景的见解。

## 步骤

1. **更新课程详情和注册**

   **场景**：作为大学管理员，您经常需要同时更新课程详情和与该课程相关的注册。此操作应确保数据一致性和完整性，即使同时执行多个更新也是如此。

   **实现 `updateCourseAndEnrollments` 方法**：定义一个方法来使用所需的事务行为更新课程详情和注册。我们使用 `Propagation.REQUIRED` 确保此方法参与任何现有事务或在不存在事务时创建新事务。设置 `Isolation.REPEATABLE_READ` 确保此方法读取的数据在整个事务中保持一致。在此方法内部，我们通过调用 `updateEnrollments` 方法执行嵌套事务来更新注册，确保此操作是原子的，并与外部事务隔离。

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
   public void updateCourseAndEnrollments(UUID courseId, String newTitle) {
       // 记录更新过程的开始
       logAction("Update Course and Enrollments", "Start");

       try {
           // 更新课程详情的实现
           // ...

           // 嵌套事务更新注册
           updateEnrollments(courseId);

           // 记录成功的更新
           logAction("Update Course and Enrollments", "Success");
       } catch (Exception e) {
           // 记录失败
           logAction("Update Course and Enrollments", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

2. **独立更新注册**

   **场景**：某些管理任务可能需要独立于课程更新来更新注册。此操作应在维护数据一致性的同时，允许单独的事务控制。

   **实现 `updateEnrollments` 方法**：定义一个方法来使用嵌套事务行为更新课程的注册。我们使用 `Propagation.NESTED` 表示此方法在外部事务范围内执行，但如果需要，可以独立回滚。设置 `Isolation.REPEATABLE_READ` 确保此方法读取的数据在整个事务中保持一致。

   ```java
   @Transactional(propagation = Propagation.NESTED, isolation = Isolation.REPEATABLE_READ)
   public void updateEnrollments(UUID courseId) {
       // 记录更新注册的开始
       logAction("Update Enrollments", "Start");

       try {
           // 更新注册的实现
           // ...

           // 记录成功的更新
           logAction("Update Enrollments", "Success");
       } catch (Exception e) {
           // 记录失败
           logAction("Update Enrollments", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

---

# [下一步：任务](../../lab-work.md)