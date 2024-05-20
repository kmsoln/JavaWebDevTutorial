# Creating Entities

## Introduction

This guide focuses on creating entities in a Spring Boot project using JPA (Java Persistence API). It provides step-by-step instructions for setting up the folder structure and creating entity classes.

## Goal

The goal of this guide is to demonstrate how to create entity classes in a Spring Boot project, following best practices and utilizing JPA for data persistence.

## Folder Structure

To ensure a well-organized project, it's essential to establish a proper folder structure. Follow these guidelines:

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

In this structure:
- The `src/main/java` directory contains your Java source files.
- The `com/example/demo/entity` directory is where you'll create your entity classes.

## Creating Entity Classes

To create entity classes, follow these steps:

1. Navigate to the `com/example/demo/entity` directory in your project.
2. Create a new Java class file for each entity. You can repeat the following steps for each entity (e.g., Student, Enrollment, Course).
3. Define your entity class with the `@Entity` annotation.

### Example:

```java
package com.example.demo.entity;

import javax.persistence.Entity;

@Entity
public class Student {

}
```

The `@Entity` annotation indicates that this class is a JPA entity.

Repeat the above steps to create `Enrollment` and `Course` entity classes.

---

# [Next: Entity Characteristics Definition](characteristics.md)