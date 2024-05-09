# Custom Query Using JpaRepository

## Introduction

This guide demonstrates how to implement custom query methods using the `@Query` annotation in the repository layer of a Spring Boot application with JPA (Java Persistence API) and JpaRepository.

## Goal

The goal of this guide is to illustrate the process of creating custom query methods in the repository interface to perform specific database operations tailored to application requirements.

## Repository Method

### CourseRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("SELECT c FROM Course c WHERE c.instructor = :instructor")
    List<Course> findCoursesByInstructor(@Param("instructor") String instructor);
}
```

### Explanation

The `@Query` annotation allows us to define custom JPQL (Java Persistence Query Language) queries directly within the repository interface.

- `"SELECT c FROM Course c WHERE c.instructor = :instructor"` is a JPQL query that selects all courses where the instructor matches the provided value.
- `@Param("instructor")` annotation binds the method parameter `instructor` to the named parameter `:instructor` in the JPQL query.

By using `@Query`, we can create complex queries tailored to specific data retrieval needs, providing flexibility and control over the database operations.

## Conclusion

You have now implemented a custom query method within the `CourseRepository` interface using JpaRepository and the `@Query` annotation to retrieve records from the `Course` table based on a specific condition. This method offers a powerful way to execute custom queries in your Spring Boot application, enabling precise data retrieval operations.

