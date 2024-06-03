English | [中文](../../cn/jpa/lab-work.md) | [Русский](../../ru/jpa/lab-work.md)


# Lab Work: JPA (Java Persistence API)

Welcome to the Spring Boot with JPA Lab Work! In this lab work, you will practice various tasks related to setting up a Spring Boot project with JPA (Java Persistence API).

## Goal of the Lab Work

The goal of this lab work is to provide hands-on experience with key concepts and tasks involved in working with Spring Boot and JPA. By completing the practice tasks, you will gain proficiency in setting up dependencies, defining entity characteristics, managing relationships between entities, and interacting with the database using JpaRepository.

## Practice Tasks <a name="practice-tasks"></a>

1. **Database Dependencies Setup**
    - [Database Driver Setup](practice/dependencies/driver.md)
    - [Spring Boot and JPA Dependencies](practice/dependencies/jpa.md)

2. **Entity Creation, Characteristics, Relationships and Fetching Strategies**
    - [Entity Creation](practice/creation/create-entity.md)
    - [Entity Characteristics Definition](practice/creation/characteristics.md)
    - [Managing Relationships](practice/creation/relationships.md)
    - [Fetching Strategies](practice/creation/fetching.md)

3. **Interacting with Custom Repository**
    - [Create Record](practice/interacting/repository/create.md)
    - [Read Record](practice/interacting/repository/read.md)
    - [Update Record](practice/interacting/repository/update.md)
    - [Delete Record](practice/interacting/repository/delete.md)
    - [Custom Queries](practice/interacting/repository/query.md)

4. **Interacting with JPA Repository**
    - [Create Record](practice/interacting/jpa-repository/create.md)
    - [Read Record](practice/interacting/jpa-repository/read.md)
    - [Delete Record](practice/interacting/jpa-repository/delete.md)
    - [Custom Queries](practice/interacting/jpa-repository/query.md)


## Lab Work Tasks <a name="lab-work-tasks"></a>

1. Set up database dependencies for PostgreSQL, MySQL, Oracle, MongoDB, and Microsoft SQL Server.

2. Implement the next Entity-Relationships Diagram:
![img.png](../../srcs/jpa/task-er-diagram.png)

   1. Define entity characteristics for Student, Enrollment, and Course entities based on the Entity Relationships diagram.

   2. Create entity classes for Student, Enrollment, and Course according to the defined characteristics.

   3. Implement fetching strategies for efficient data retrieval to optimize database interactions.

   4. Manage relationships between entities such as Student, Enrollment, and Course by establishing appropriate associations and mappings.

   5. Interact with the database by creating methods for CRUD operations using the Repository layer and EntityManager in at least two repositories.

   6. Interact with the database by creating methods for CRUD operations using JpaRepository in at least two repositories.

   7. Implement custom queries to perform advanced data retrieval and manipulation operations as required by the application's business logic.

