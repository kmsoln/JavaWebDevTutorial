# Creating Custom Queries in a Table Using Repository Layer

## Introduction

This guide demonstrates how to create custom queries to fetch records from a table using the repository layer in a Spring Boot application with JPA (Java Persistence API).

## Goal

The goal of this guide is to illustrate the process of creating custom queries to fetch records from a table by implementing a method within the `StudentRepository` interface using the `EntityManager`.

## Repository Method

### StudentRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Student;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Student> findStudentsByMajor(String major) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.major = :major", Student.class)
                .setParameter("major", major)
                .getResultList();
    }
}
```

### Explanation

- `@Repository`: This annotation marks the class as a repository component in the data access layer.

- `@PersistenceContext`: This annotation is used to inject an EntityManager instance into the repository class.

- `entityManager.createQuery(...)`: This line of code creates a custom JPQL (Java Persistence Query Language) query to fetch records based on the provided criteria (`major` in this example).

---

# [Next: Create JpaRepository](../jpa-repository.md)