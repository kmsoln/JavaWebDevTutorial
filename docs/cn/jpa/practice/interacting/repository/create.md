# 使用存储库层在表中创建新记录

## 简介

本指南演示了如何在Spring Boot应用程序中使用存储库层创建表中的新记录，该应用程序使用了JPA（Java Persistence API）。

## 目标

本指南的目标是通过利用存储库层实现在表中创建新记录的过程。我们将通过在`StudentRepository`接口中使用`EntityManager`而不是`JpaRepository`来实现这一目标。

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
    
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }
}
```

### 解释

- `@Repository`：此注解将该类标记为数据访问层中的存储库组件。

- `@PersistenceContext`：此注解用于将EntityManager实例注入存储库类中。

- `entityManager.persist(student)`：这行代码将新的`Student`实体持久化到数据库中。

---

# [下一步：读取记录](read.md)