# 创建存储库

## 简介

本指南演示了如何在Spring Boot项目中使用JPA（Java Persistence API）创建用于实体管理的存储库。

## 目标

本指南的目标是提供清晰的说明，以便在Spring Boot应用程序中设置用于管理实体的存储库。通过本指南，您将能够为`Student`实体创建存储库。

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
                        └── StudentRepository.java
                    
```

## 存储库类

### StudentRepository.java

```java
package com.yourcompany.yourproject.repository;

import com.yourcompany.yourproject.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    // 为学生实体添加存储库方法
}
```

`@Repository` 注解是Spring的一种类型注解，用于指示被修饰的类是数据访问层中的存储库组件。它作为任何充当存储库角色的类的标记，有助于将异常转换为Spring的统一异常层次结构。

---

# [下一步：创建记录](repository/create.md)