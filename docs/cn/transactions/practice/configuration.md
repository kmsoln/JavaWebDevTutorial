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
---

# [Next: Create the Entities and Repositories](lessons/entities-and-repositories.md)