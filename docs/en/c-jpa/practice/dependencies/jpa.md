# JPA: Setup Dependencies

## Introduction

This guide focuses on setting up dependencies for a Spring Boot project with JPA (Java Persistence API). It covers the necessary steps to include Spring Boot Starter JDBC and Spring Boot Starter Data JPA dependencies.

## Goal

The goal of this guide is to provide clear instructions for setting up the necessary dependencies for Spring Boot and JPA, specifically focusing on Spring Boot Starter JDBC and Spring Boot Starter Data JPA dependencies.

## Setup Dependencies

### Spring Boot Starter JDBC

To enable JDBC support in your Spring Boot application:

#### Gradle

```groovy
implementation "org.springframework.boot:spring-boot-starter-jdbc"
```

#### Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

This dependency provides auto-configuration for JDBC-based data access.

### Spring Boot Starter Data JPA

To include support for JPA (Java Persistence API) in your Spring Boot application:

#### Gradle

```groovy
implementation "org.springframework.boot:spring-boot-starter-data-jpa"
```

#### Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

This dependency simplifies the setup of JPA-based repositories and provides default configurations for Hibernate.

## Conclusion

By configuring the appropriate Spring Boot dependencies for JDBC and JPA, you will be equipped to initiate development on your Spring Boot application with JPA support.

# [Next: Entity Creation](../creation/create-entity.md)