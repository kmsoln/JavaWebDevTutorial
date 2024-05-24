# 使用JpaRepository进行自定义查询

## 简介

本指南演示了如何在Spring Boot应用程序的存储库层中使用`@Query`注解实现自定义查询方法，该应用程序使用JPA（Java Persistence API）和JpaRepository。

## 目标

本指南的目标是说明在存储库接口中创建自定义查询方法的过程，以执行特定于应用程序要求的数据库操作。

## 存储库方法

### CourseRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("SELECT c FROM Course c WHERE c.instructor = :instructor")
    List<Course> findCoursesByInstructor(@Param("instructor") String instructor);
}
```

### 解释

`@Query`注解允许我们在存储库接口中直接定义自定义JPQL（Java Persistence Query Language）查询。

- `"SELECT c FROM Course c WHERE c.instructor = :instructor"`是一个JPQL查询，它选择所有教师与提供的值匹配的课程。
- `@Param("instructor")`注解将方法参数`instructor`绑定到JPQL查询中的命名参数`:instructor`。

通过使用`@Query`，我们可以创建适用于特定数据检索需求的复杂查询，从而提供对数据库操作的灵活性和控制。

---

# [下一步：任务](../../../lab-work.md)