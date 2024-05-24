# 事务设置

## 简介

本指南专注于在Spring Boot项目中设置事务管理。它提供了逐步说明，以启用事务管理并配置事务属性。

## 目标

本指南的目标是演示如何在Spring Boot应用程序中配置事务管理，以便管理数据库事务。

## 事务管理设置

要在Spring Boot项目中启用事务管理，请按照以下步骤操作：

1. 在您的 `pom.xml` 或 `build.gradle` 文件中添加必要的依赖项。确保您拥有Spring Boot、Spring Data JPA以及您正在使用的任何数据库驱动程序的依赖项（例如，H2、MySQL、PostgreSQL）。

2. 在您的Spring Boot应用程序中配置事务管理。您可以通过在主应用程序类上添加 `@EnableTransactionManagement` 注解来实现这一点。

### 示例（Java配置）：

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
```
---

# [下一步: 创建实体和存储库](lessons/entities-and-repositories.md)