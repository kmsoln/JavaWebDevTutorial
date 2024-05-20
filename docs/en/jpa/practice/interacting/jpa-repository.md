# Creating JpaRepository 

## Introduction

This guide demonstrates how to create repository for entity management in a Spring Boot project with JPA (Java Persistence API) using JpaRepository.

## Goal

The goal of this guide is to provide clear instructions for setting up repository for managing entities in a Spring Boot application. By the end of this guide, you will be able to create repository and service classes for the `Course` entity.

## Folder Structure

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
## Repository Class

### CourseRepository.java

```java
package com.yourcompany.yourproject.repository;

import com.yourcompany.yourproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Add repository methods for course entity
}
```


The `@Repository` annotation is a Spring stereotype annotation used to indicate that the decorated class is a repository component in the data access layer. It serves as a marker for any class that fulfills the role of a repository, facilitating the translation of exceptions into Spring's unified exception hierarchy.


---

# [Next: Create Record](jpa-repository/create.md)

