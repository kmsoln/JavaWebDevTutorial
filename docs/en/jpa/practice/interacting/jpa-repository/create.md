# Creating Records in a Table Using JpaRepository

## Introduction

This guide demonstrates how to create records in a table using the repository layer in a Spring Boot application with JPA (Java Persistence API) and JpaRepository.

## Goal

The goal of this guide is to illustrate the process of creating records in a table by implementing a method within the `CourseRepository` interface using JpaRepository.

## Repository Method

### CourseRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    Course save(Course course);
}
```

### Explanation

The `save(Course course)` method provided by JpaRepository allows us to persist a new record in the `Course` table.

By invoking this method and passing a `Course` object as a parameter, JpaRepository automatically handles the process of persisting the entity to the database.

---

# [Next: Read Record](read.md)