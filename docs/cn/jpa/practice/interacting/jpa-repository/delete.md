# 使用JpaRepository从表中删除记录

## 简介

本指南演示了如何在Spring Boot应用程序中使用JPA（Java Persistence API）和JpaRepository的存储库层删除表中的记录。

## 目标

本指南的目标是通过在`CourseRepository`接口中实现方法来说明从表中删除记录的过程。

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

    void deleteById(UUID id);
}
```

## 解释

`deleteById(UUID id)`方法的签名遵循JpaRepository的约定，用于根据唯一标识符删除记录。

- `delete`关键字表示此方法用于删除数据。
- `ById`指定了要删除的记录的标识条件。在本例中，我们针对具有特定ID的记录进行操作。

通过遵循这种命名约定，JpaRepository会在后台自动生成适当的SQL查询，以从数据库中删除所需的记录。这简化了开发过程，无需编写显式的SQL删除语句，使开发人员可以专注于定义反映预期数据删除操作的方法签名。

---

# [下一步：自定义查询](query.md)