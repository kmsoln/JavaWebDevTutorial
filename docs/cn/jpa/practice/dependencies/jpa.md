# JPA：设置依赖项

## 介绍

本指南重点介绍了如何为具有JPA（Java持久性API）的Spring Boot项目设置依赖项。它涵盖了包含Spring Boot Starter JDBC和Spring Boot Starter Data JPA依赖项所需的必要步骤。

## 目标

本指南的目标是为Spring Boot和JPA设置必要依赖项，具体重点放在Spring Boot Starter JDBC和Spring Boot Starter Data JPA依赖项上，并提供清晰的说明。

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

此依赖项为基于JDBC的数据访问提供了自动配置。

### Spring Boot Starter Data JPA

要在Spring Boot应用程序中包含对JPA（Java持久性API）的支持：

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

此依赖项简化了设置基于JPA的存储库，并为Hibernate提供了默认配置。

### 为Spring WebMVC进行附加配置

如果您使用Spring WebMVC，则需要添加额外的配置来设置与持久性相关的bean和属性。

#### 创建持久性配置类

在`com.example.config`包中创建一个名为`PersistenceConfig`的新类：

```java
// 这里是java代码，因此不需要翻译
```

---

# [下一步：创建实体](../creation/create-entity.md)