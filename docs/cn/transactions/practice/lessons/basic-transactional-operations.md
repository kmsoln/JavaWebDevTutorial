# 第二课：实现基本事务操作

## 目标

本部分旨在为在Spring Boot应用程序中注册学生和管理课程引入简单但重要的事务方法。

## 步骤

1. **将学生注册到课程中**

   **场景**：作为大学管理员，您需要将学生注册到课程中。此操作应顺利进行，并确保即使同时进行多个注册或存在任何数据库问题，数据完整性仍然保持完好。

   **实现 `enrollStudentInCourse` 方法**：创建一个方法来将学生注册到课程中。确保此过程是事务性的，意味着它就像一个整体交易一样，保证所有事情都正确地一起发生。我们使用 `Propagation.REQUIRED` 确保此方法参与任何现有事务或在不存在事务时创建新事务。另外，我们设置 `Isolation.SERIALIZABLE` 以确保即使有并发事务，它们也不会相互干扰，从而保持数据的完整性。

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
   public void enrollStudentInCourse(UUID studentId, UUID courseId) {
       // 实现代码在此处
   }
   ```

2. **检索课程的学生**

   **场景**：为了创建课程的班级名单，您需要检索已注册的学生列表。此操作应确保您始终获得数据库的准确视图，即使同时发生其他活动。

   **实现 `getStudentsForCourse` 方法**：开发一个方法来检索特定课程的学生。它应确保无论有没有正在进行的事务，您检索的数据都是一致的。我们使用 `Propagation.REQUIRED` 确保此方法参与任何现有事务或在不存在事务时创建新事务。我们设置 `Isolation.READ_COMMITTED` 确保我们检索的数据已提交并对其他事务可见，保持一致性。

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
   public List<Student> getStudentsForCourse(UUID courseId) {
       // 实现代码在此处
   }
   ```

3. **添加新课程**

   **场景**：新课程即将纳入课程表。在将其添加到系统时，您希望此操作不会干扰其他正在进行的事务，保持其独立性。

   **实现 `addNewCourse` 方法**：创建一个方法来将新课程添加到系统中。确保此过程不会与任何其他正在进行的事务纠缠在一起。我们使用 `Propagation.NOT_SUPPORTED` 确保此方法不参与任何现有事务，使其具有自主性，并避免与其他操作发生潜在冲突。

   ```java
   @Transactional(propagation = Propagation.NOT_SUPPORTED)
   public Course addNewCourse(String title) {
       // 实现代码在此处
   }
   ```

---

# [下一步：通过详细日志增强事务方法](transactional-logging.md)