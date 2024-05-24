# 使用存储库层从表中删除记录

## 简介

本指南演示了如何在Spring Boot应用程序中使用存储库层删除表中的记录，该应用程序使用了JPA（Java Persistence API）。

## 目标

本指南的目标是通过在`StudentRepository`接口中使用`EntityManager`实现删除表中记录的过程。

## 存储库方法

### StudentRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Student;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public void deleteStudent(UUID id) {
        Student studentToDelete = entityManager.find(Student.class, id);
        entityManager.remove(studentToDelete);
    }
}
```

### 解释

- `@Repository`：此注解将该类标记为数据访问层中的存储库组件。

- `@PersistenceContext`：此注解用于将EntityManager实例注入存储库类中。

- `entityManager.remove(studentToDelete)`：这行代码从数据库中删除`Student`实体。

---

# [下一步：自定义查询](query.md)