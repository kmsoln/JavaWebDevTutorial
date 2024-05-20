# Настройка транзакций

## Введение

Это руководство посвящено настройке управления транзакциями в проекте Spring Boot. В нем представлены пошаговые инструкции по включению управления транзакциями и конфигурации атрибутов транзакций.

## Цель

Цель данного руководства - продемонстрировать, как настроить управление транзакциями в приложении Spring Boot, что позволит управлять транзакциями базы данных.

## Настройка управления транзакциями

Для включения управления транзакциями в вашем проекте Spring Boot выполните следующие шаги:

1. Добавьте необходимые зависимости в ваш файл `pom.xml` или `build.gradle`. Убедитесь, что у вас есть зависимости для Spring Boot, Spring Data JPA и любого используемого вами драйвера базы данных (например, H2, MySQL, PostgreSQL).

2. Настройте управление транзакциями в вашем приложении Spring Boot. Это можно сделать, аннотируя ваш главный класс приложения с помощью `@EnableTransactionManagement`.

### Пример (Java Config):

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
```
---

# [Далее: Создание сущностей и репозиториев](lessons/first.md)