# Spring Boot с JPA: Настройка зависимостей

## Введение

Это руководство сосредотачивается на настройке зависимостей для проекта Spring Boot с JPA (Java Persistence API). Оно охватывает необходимые шаги по включению зависимостей Spring Boot Starter JDBC и Spring Boot Starter Data JPA.

## Цель

Цель этого руководства - предоставить четкие инструкции по настройке необходимых зависимостей для Spring Boot и JPA, с особым упором на зависимости Spring Boot Starter JDBC и Spring Boot Starter Data JPA.

## Настройка зависимостей

### Spring Boot Starter JDBC

Чтобы включить поддержку JDBC в вашем приложении Spring Boot:

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

Эта зависимость обеспечивает автоматическую конфигурацию для доступа к данным на основе JDBC.

### Spring Boot Starter Data JPA

Для включения поддержки JPA (Java Persistence API) в вашем приложении Spring Boot:

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

Эта зависимость упрощает настройку репозиториев на основе JPA и предоставляет конфигурации по умолчанию для Hibernate.

## Заключение

Настроив соответствующие зависимости Spring Boot для JDBC и JPA, вы будете готовы начать разработку вашего приложения Spring Boot с поддержкой JPA.

[Следующая задача: Создание сущностей](../creation/create-entity.md)
