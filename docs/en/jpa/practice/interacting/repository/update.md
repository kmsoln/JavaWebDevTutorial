# Updating Records in a Table Using Repository Layer

## Introduction

This guide illustrates how to update records in a table using the repository layer in a Spring Boot application with JPA (Java Persistence API).

## Goal

The goal of this guide is to demonstrate the process of updating records in a table by implementing a method within the `StudentRepository` interface using the `EntityManager`.

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
    
    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }
}
```

### Explanation

- `@Repository`: This annotation marks the class as a repository component in the data access layer.

- `@PersistenceContext`: This annotation is used to inject an EntityManager instance into the repository class.

- `entityManager.merge(student)`: This line of code updates the `Student` entity in the database.

## Conclusion

You have now implemented a method within the `StudentRepository` class to update records in the `Student` table using the repository layer and `EntityManager`. This method can be further extended and customized to accommodate additional update operations as needed.

# [Next: Delete Record](delete.md)