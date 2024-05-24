# 使用JpaRepository从表中读取记录

## 简介

本指南演示了如何在Spring Boot应用程序的存储库层中使用JPA（Java Persistence API）和JpaRepository检索数据表中的数据。

## 目标

本指南的目标是通过在`CourseRepository`接口中使用JpaRepository实现一个方法，来说明从表中读取数据的过程。

## 存储库方法

### CourseRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    List<Course> findCoursesByInstructor(String instructor);
}
```

### 解释

`findCoursesByInstructor(String instructor)`方法签名遵循Spring Data JPA识别的特定命名约定。

- `find`关键字表示此方法用于检索数据。
- `Courses`表示我们要检索的实体类型。
- `ByInstructor`指定了筛选结果的条件。在本例中，我们基于`instructor`属性查询课程。

通过遵循这种命名约定，Spring Data JPA在幕后自动生成适当的SQL查询，以从数据库中提取所需的数据。这简化了开发过程，无需编写显式的SQL查询，开发人员可以专注于定义反映所需数据检索操作的方法签名。

---

# [下一步：删除记录](delete.md)