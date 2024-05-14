# Reading Records from a Table Using JpaRepository

## Introduction

This guide demonstrates how to retrieve data from a table using the repository layer in a Spring Boot application with JPA (Java Persistence API) and JpaRepository.

## Goal

The goal of this guide is to illustrate the process of reading data from a table by implementing a method within the `CourseRepository` interface using JpaRepository.

## Repository Method

### CourseRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    List<Course> findCoursesByInstructor(String instructor);
}
```

### Explanation

The `findCoursesByInstructor(String instructor)` method signature follows a specific naming convention recognized by Spring Data JPA.

- The `find` keyword indicates that this method is used for retrieving data.
- `Courses` represents the entity type we want to retrieve.
- `ByInstructor` specifies the criteria for filtering the results. In this case, we are querying for courses based on the `instructor` attribute.

By adhering to this naming convention, Spring Data JPA automatically generates the appropriate SQL query behind the scenes to fetch the required data from the database. This simplifies the development process by eliminating the need to write explicit SQL queries, allowing developers to focus on defining method signatures that reflect the desired data retrieval operations.

---

# [Next: Delete Record](delete.md)