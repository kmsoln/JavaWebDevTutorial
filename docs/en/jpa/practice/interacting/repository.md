# Creating Repository

## Introduction

This guide demonstrates how to create repository  for entity management in a Spring Boot project with JPA (Java Persistence API).

## Goal

The goal of this guide is to provide clear instructions for setting up repository for managing entities in a Spring Boot application. By the end of this guide, you will be able to create repository for the `Student` entity. 

## Folder Structure

```
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── demo/
                    ├── data/
                    │   └── entites/
                    │       ├── Student.java
                    │       ├── Enrollment.java
                    │       └── Course.java
                    └── repository/
                        └── StudentRepository.java
                    
```
## Repository Class

### StudentRepository.java

```java
package com.yourcompany.yourproject.repository;

import com.yourcompany.yourproject.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    // Add repository methods for student entity
}
```


The `@Repository` annotation is a Spring stereotype annotation used to indicate that the decorated class is a repository component in the data access layer. It serves as a marker for any class that fulfills the role of a repository, facilitating the translation of exceptions into Spring's unified exception hierarchy.


## Conclusion

You have now created a repository for managing the `Student` entity in your application.

# [Next: Create Record](repository/create.md)
