# Deleting Records from a Table Using JpaRepository

## Introduction

This guide demonstrates how to delete records from a table using the repository layer in a Spring Boot application with JPA (Java Persistence API) and JpaRepository.

## Goal

The goal of this guide is to illustrate the process of deleting records from a table by implementing a method within the `CourseRepository` interface using JpaRepository.

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

    void deleteById(UUID id);
}
```

## Explanation

The `deleteById(UUID id)` method signature follows a convention recognized by JpaRepository for deleting records based on their unique identifier.

- The `delete` keyword indicates that this method is used for deleting data.
- `ById` specifies the criteria for identifying the record to be deleted. In this case, we are targeting a record with a specific ID.

By adhering to this naming convention, JpaRepository automatically generates the appropriate SQL query behind the scenes to delete the desired record from the database. This simplifies the development process by eliminating the need to write explicit SQL delete statements, allowing developers to focus on defining method signatures that reflect the intended data deletion operations.

## Conclusion

You have now implemented a method within the `CourseRepository` interface using JpaRepository to delete records from the `Course` table. This method provides a convenient way to delete data from the database using JpaRepository in your Spring Boot application.

# [Next: Custom Query](query.md)
