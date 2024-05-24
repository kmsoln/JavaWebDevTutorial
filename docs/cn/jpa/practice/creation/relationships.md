# Defining Entity Relationships

## Introduction

This guide delves into understanding and implementing relationships between entities in a Spring Boot project using JPA (Java Persistence API). Specifically, we will explore the relationship between the `Enrollment` entity and its associated entities `Student` and `Course`.

## Goal

The goal of this guide is to provide clear instructions for defining and understanding entity relationships in a Spring Boot project with JPA. By the end of this guide, you will comprehend how to establish associations between entities and implement them in your application.

## Entity Associations

![img.png](../../../../srcs/jpa/er-diagram.png)
### Enrollment Entity Characteristics:

- `id` (UUID): Primary key for the entity.
- `student` (Student): Student associated with the enrollment.
- `course` (Course): Course associated with the enrollment.
- `enrollmentDate` (Date): Date of enrollment.
- `grade` (int): Grade achieved in the course.

#### Student Relationship

The relationship between the `Enrollment` entity and the `Student` entity represents a scenario where a student enrolls in a course. This is a Many-to-One relationship, where many enrollments can be associated with one student. To establish this relationship, annotate the `student` attribute in the `Enrollment` entity with `@ManyToOne`.

```java
@ManyToOne
@JoinColumn(name = "student_id")
private Student student;
```

#### Course Relationship

Similarly, the relationship between the `Enrollment` entity and the `Course` entity signifies a scenario where a course is enrolled by multiple students. This is also a Many-to-One relationship, where many enrollments can be associated with one course. Annotate the `course` attribute in the `Enrollment` entity with `@ManyToOne`.

```java
@ManyToOne
@JoinColumn(name = "course_id")
private Course course;
```

---

# [Next: Fetching Strategies](fetching.md)
