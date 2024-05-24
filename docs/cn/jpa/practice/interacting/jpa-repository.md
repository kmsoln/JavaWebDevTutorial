# 创建JpaRepository

## 介绍

本指南演示了如何在Spring Boot项目中使用JpaRepository创建实体管理的存储库（Repository）。

## 目标

本指南的目标是提供清晰的说明，以便在Spring Boot应用程序中设置用于管理实体的存储库。通过本指南，您将能够为`Course`实体创建存储库和服务类。

## 文件夹结构

```
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── demo/
                    ├── data/
                    │   └── entities/
                    │       ├── Student.java
                    │       ├── Enrollment.java
                    │       └── Course.java
                    └── repository/
                        ├── StudentRepository.java
                        └── CourseRepository.java
                    
```

## 存储库类

### CourseRepository.java

```java
package com.yourcompany.yourproject.repository;

import com.yourcompany.yourproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // 添加用于课程实体的存储库方法
}
```

`@Repository` 注解是一个Spring的构造型注解，用于指示被修饰的类是数据访问层中的存储库组件。它作为任何充当存储库角色的类的标记，有助于将异常转换为Spring的统一异常层次结构。

---

# [下一步：创建记录](jpa-repository/create.md)