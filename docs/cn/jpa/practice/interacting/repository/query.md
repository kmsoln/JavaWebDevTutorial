# 在存储库层创建自定义查询以从表中获取记录

## 简介

本指南演示了如何在Spring Boot应用程序中使用存储库层创建自定义查询来从表中获取记录，该应用程序使用了JPA（Java Persistence API）。

## 目标

本指南的目标是通过在`StudentRepository`接口中使用`EntityManager`实现创建自定义查询来从表中获取记录的过程。

## 存储库方法

### StudentRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Student;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Student> findStudentsByMajor(String major) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.major = :major", Student.class)
                .setParameter("major", major)
                .getResultList();
    }
}
```

### 解释

- `@Repository`：此注解将该类标记为数据访问层中的存储库组件。

- `@PersistenceContext`：此注解用于将EntityManager实例注入存储库类中。

- `entityManager.createQuery(...)`：这行代码创建了一个自定义的JPQL（Java Persistence Query Language）查询，以根据提供的条件（在此示例中为`major`）从表中获取记录。

---

# [下一步：创建JpaRepository](../jpa-repository.md)