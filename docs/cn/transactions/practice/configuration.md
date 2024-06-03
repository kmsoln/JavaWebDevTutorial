# 事务设置

## 简介

本指南专注于在Spring Boot项目中设置事务管理。它提供了启用事务管理和配置事务属性的逐步说明。

## 目标

本指南的目标是演示如何在Spring Boot应用程序中配置事务管理，从而实现对数据库事务的管理。

## 事务管理设置

要在Spring Boot项目中启用事务管理，请按照以下步骤操作：

1. 在您的 `pom.xml` 或 `build.gradle` 文件中添加必要的依赖项。确保您具有Spring Boot、Spring Data JPA以及您正在使用的任何数据库驱动程序的依赖项（例如，H2、MySQL、PostgreSQL）。

2. 在您的Spring Boot应用程序中配置事务管理。您可以通过在主应用程序类上注释 `@EnableTransactionManagement` 来实现这一点。

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

3. 如果您使用的是Spring Web MVC，则需要将以下内容添加到您的配置文件中以设置事务管理器：

### 示例（XML配置）：

```xml
<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
    <property name="entityManagerFactory" ref="entityManagerFactory" />
</bean>
```

### 示例（Java配置）：

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
public class TransactionConfig {

    /**
     * Spring事务管理器的Bean定义。
     *
     * <p>
     * 此方法使用配置的实体管理器工厂设置JPA的事务管理器。
     * </p>
     *
     * @param entityManagerFactory 实体管理器工厂bean
     * @return 事务管理器bean
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
```

通过按照这些步骤操作，您将在Spring Boot应用程序中启用事务管理，从而有效地管理数据库事务。

---

# [下一步：创建实体和存储库](lessons/entities-and-repositories.md)