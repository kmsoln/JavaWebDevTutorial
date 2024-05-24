# 创建实体

## 介绍

本指南侧重于使用JPA（Java Persistence API）在Spring Boot项目中创建实体。它提供了逐步的说明，用于设置文件夹结构和创建实体类。

## 目标

本指南的目标是演示如何在Spring Boot项目中创建实体类，遵循最佳实践并利用JPA进行数据持久化。

## 文件夹结构

为了确保项目组织良好，建立正确的文件夹结构至关重要。请遵循以下准则：

```
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── demo/
                    └── entity/
                        ├── Student.java
                        ├── Enrollment.java
                        └── Course.java

```

在这个结构中：
- `src/main/java` 目录包含您的Java源文件。
- `com/example/demo/entity` 目录是您将创建实体类的地方。

## 创建实体类

要创建实体类，请按照以下步骤操作：

1. 导航到您项目中的 `com/example/demo/entity` 目录。
2. 为每个实体创建一个新的Java类文件。您可以为每个实体（例如，Student、Enrollment、Course）重复以下步骤。
3. 使用 `@Entity` 注解定义您的实体类。

### 示例：

```java
package com.example.demo.entity;

import javax.persistence.Entity;

@Entity
public class Student {

}
```

`@Entity` 注解表示该类是一个JPA实体。

重复以上步骤以创建 `Enrollment` 和 `Course` 实体类。

---

# [下一步：实体特征定义](characteristics.md)