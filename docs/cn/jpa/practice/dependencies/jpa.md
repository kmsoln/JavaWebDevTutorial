# JPA：设置依赖项

## 简介

本指南专注于为具有JPA（Java Persistence API）的Spring Boot项目设置依赖项。它涵盖了包括Spring Boot Starter JDBC和Spring Boot Starter Data JPA依赖项的必要步骤。

## 目标

本指南的目标是提供清晰的说明，以便设置Spring Boot和JPA的必要依赖项，特别关注Spring Boot Starter JDBC和Spring Boot Starter Data JPA依赖项。

## 设置依赖项

### Spring Boot Starter JDBC

要在Spring Boot应用程序中启用JDBC支持：

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

此依赖项提供了基于JDBC的数据访问的自动配置。

### Spring Boot Starter Data JPA

要在Spring Boot应用程序中包含对JPA（Java Persistence API）的支持：

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

此依赖项简化了JPA存储库的设置，并为Hibernate提供了默认配置。

---

# [下一步：实体创建](../creation/create-entity.md)