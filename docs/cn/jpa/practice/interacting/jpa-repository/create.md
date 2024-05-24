# 使用JpaRepository在表中创建记录

## 简介

本指南演示了如何在Spring Boot应用程序中使用JPA（Java Persistence API）和JpaRepository的存储库层创建表中的记录。

## 目标

本指南的目标是通过在`CourseRepository`接口中实现方法来说明在表中创建记录的过程。

## 存储库方法

### CourseRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    Course save(Course course);
}
```

### 解释

JpaRepository提供的`save(Course course)`方法允许我们将新记录持久化到`Course`表中。

通过调用此方法并将`Course`对象作为参数传递，JpaRepository自动处理将实体持久化到数据库的过程。

---

# [下一步：读取记录](read.md)