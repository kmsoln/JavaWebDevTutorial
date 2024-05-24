# 使用存储库层从表中读取记录

## 简介

本指南演示了如何在Spring Boot应用程序中使用存储库层从表中读取记录，该应用程序使用了JPA（Java Persistence API）。

## 目标

本指南的目标是通过在`StudentRepository`接口中使用`EntityManager`实现方法来从表中读取记录的过程。

## 存储库方法

### StudentRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Student;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public Student findStudentById(UUID id) {
        return entityManager.find(Student.class, id);
    }
}
```

### 解释

- `@Repository`：此注解将该类标记为数据访问层中的存储库组件。

- `@PersistenceContext`：此注解用于将EntityManager实例注入存储库类中。

- `entityManager.find(Student.class, id)`：这行代码根据提供的`id`从数据库中检索`Student`实体。

---

# [下一步：更新记录](update.md)
