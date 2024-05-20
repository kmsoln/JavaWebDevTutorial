# Reading Records from a Table Using Repository Layer

## Introduction

This guide demonstrates how to read records from a table using the repository layer in a Spring Boot application with JPA (Java Persistence API).

## Goal

The goal of this guide is to illustrate the process of reading records from a table by implementing a method within the `StudentRepository` interface using the `EntityManager`.

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
    
    public Student findStudentById(UUID id) {
        return entityManager.find(Student.class, id);
    }
}
```

### Explanation

- `@Repository`: This annotation marks the class as a repository component in the data access layer.

- `@PersistenceContext`: This annotation is used to inject an EntityManager instance into the repository class.

- `entityManager.find(Student.class, id)`: This line of code retrieves the `Student` entity from the database based on the provided `id`.

---

# [Next: Update Record](update.md)
