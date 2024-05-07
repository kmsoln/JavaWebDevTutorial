# Creating New Records in a Table Using Repository Layer

## Introduction

This guide illustrates how to create new records in a table using the repository layer in a Spring Boot application with JPA (Java Persistence API).

## Goal

The goal of this guide is to demonstrate the process of creating new records in a table by utilizing the repository layer. We will achieve this by implementing a method within the `StudentRepository` interface using the `EntityManager` instead of `JpaRepository`.

## Repository Method

### StudentRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Student;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }
}
```

### Explanation

- `@Repository`: This annotation marks the class as a repository component in the data access layer.

- `@PersistenceContext`: This annotation is used to inject an EntityManager instance into the repository class.

- `@Transactional`: This annotation ensures that the method is executed within a transactional context. It allows the EntityManager to perform database operations.

- `entityManager.persist(student)`: This line of code persists the new `Student` entity to the database.

## Conclusion

You have now implemented a method within the `StudentRepository` class to create new records in the `Student` table using the repository layer and `EntityManager`. This method can be further extended and customized to accommodate additional functionalities as needed.

# [Next: Read Record](read.md)