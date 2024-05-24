# Defining Entity Characteristics

## Introduction

This guide focuses on defining entity columns or characteristics in a Spring Boot project using JPA (Java Persistence API).

## Goal
The goal of this guide is to provide clear instructions for defining the characteristics of entities in a Spring Boot project with JPA, utilizing annotations to enforce constraints and behaviors for each attribute.


## Entity Characteristics

### Student Entity Characteristics:
- `id` (UUID): Primary key for the entity.
- `name` (String): Name of the student (must not be blank).
- `email` (String): Email address of the student (must be a valid email address).
- `major` (String): Major or field of study of the student (must not be blank).
- `year` (int): Year of study for the student (must not be null).
- `international` (boolean): Indicates if the student is international (must not be null).

### Define `id` Attribute

Add the `id` attribute to the `Student` class. This attribute will serve as the primary key for the entity.

```java
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID id;
```

- `@Id`: Indicates that this field is the primary key for the entity.
- `@GeneratedValue`: Specifies the strategy for generating primary key values automatically.

### Define `name` Attribute

Add the `name` attribute to the `Student` class. This attribute represents the name of the student and must not be blank.

```java
@NotBlank
private String name;
```

- `@NotBlank`: Ensures that the value of `name` is not null and contains at least one non-whitespace character.

### Define `email` Attribute

Add the `email` attribute to the `Student` class. This attribute represents the email address of the student and must be a valid email address.

```java
@NotBlank
@Email
private String email;
```

- `@Email`: Validates that the value of `email` is a valid email address.

### Define `major` Attribute

Add the `major` attribute to the `Student` class. This attribute represents the major or field of study of the student and must not be blank.

```java
@NotBlank
private String major;
```

- `@NotBlank`: Ensures that the value of `major` is not null and contains at least one non-whitespace character.

### Define `year` Attribute

Add the `year` attribute to the `Student` class. This attribute represents the year of study for the student and must not be null.

```java
@NotNull
private int year;
```

- `@NotNull`: Ensures that the value of `year` is not null.

### Define `international` Attribute

Add the `international` attribute to the `Student` class. This attribute indicates whether the student is international and must not be null.

```java
@NotNull
private boolean international;
```

- `@NotNull`: Ensures that the value of `international` is not null.


You can repeat the previous steps to create entity characteristics for the `Course` and `Enrollment` entities, ensuring appropriate annotations are applied to each attribute.

### Enrollment Entity Characteristics:

- `id` (UUID): Primary key for the entity.
- `enrollmentDate` (Date): Date of enrollment.
- `grade` (int): Grade achieved in the course.

### Course Entity Characteristics:

- `id` (UUID): Primary key for the entity.
- `name` (String): Name of the course.
- `instructor` (String): Name of the course instructor.
- `schedule` (String): Schedule details of the course.
- `capacity` (int): Maximum capacity of the course.
- `online` (boolean): Indicates if the course is online.
- `startDate` (Date): Start date of the course.

---

# [Next: Managing Relationships](relationships.md)