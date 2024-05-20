# Lesson 1: Create the Entities and Repositories

## Goal

The goal of this task is to define the core entities (Student, Course, Enrollment, Log) and set up the corresponding repositories in a Spring Boot project using Spring Data JPA.

## Steps

1. **Refer to the provided ER diagram to define the entity classes.**
   ![er-diagram.png](../../../../srcs/transactions/er-diagram.png)
   If you already have the entity classes based on the provided ER diagram, proceed to step 2. Otherwise, analyze the ER diagram and create the following entity classes:

    - Student
    - Course
    - Enrollment
    - Log

   Ensure that each entity class includes the necessary attributes as depicted in the ER diagram.

2. **Create the repositories for the entities.**

   For example, let's create the repository for the `Student` entity:

   ```java
   package com.example.demo.repository;

   import com.example.demo.entity.Student;
   import org.springframework.data.jpa.repository.JpaRepository;

   public interface StudentRepository extends JpaRepository<Student, UUID> {
   }
   ```

   If you already have the entity repositories, proceed to next step. Else, repeat the above step for the repositories of the remaining entities (Course, Enrollment, Log).

---

# [NEXT: Implementing Basic Transactional Operations](second.md)