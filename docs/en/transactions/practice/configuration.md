# Transaction Setup

## Introduction

This guide focuses on setting up transaction management in a Spring Boot project. It provides step-by-step instructions for enabling transaction management and configuring transaction attributes.

## Goal

The goal of this guide is to demonstrate how to configure transaction management in a Spring Boot application, allowing for the management of database transactions.

## Transaction Management Setup

To enable transaction management in your Spring Boot project, follow these steps:

1. Add the necessary dependencies to your `pom.xml` or `build.gradle` file. Ensure that you have dependencies for Spring Boot, Spring Data JPA, and any database driver you are using (e.g., H2, MySQL, PostgreSQL).

2. Configure transaction management in your Spring Boot application. You can do this by annotating your main application class with `@EnableTransactionManagement`.

### Example (Java Config):

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

3. If you are using Spring Web MVC, you need to add the following to your configuration files to set up the transaction manager:

### Example (XML Config):

```xml
<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
    <property name="entityManagerFactory" ref="entityManagerFactory" />
</bean>
```

### Example (Java Config):

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
public class TransactionConfig {

    /**
     * Bean definition for the Spring Transaction Manager.
     *
     * <p>
     * This method sets up the transaction manager for JPA using the configured entity manager factory.
     * </p>
     *
     * @param entityManagerFactory the entity manager factory bean
     * @return TransactionManager bean
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
```

By following these steps, you will have transaction management enabled in your Spring Boot application, allowing you to manage database transactions effectively.

---

# [Next: Create the Entities and Repositories](lessons/entities-and-repositories.md)