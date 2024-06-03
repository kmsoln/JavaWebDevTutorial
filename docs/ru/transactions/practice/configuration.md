# Настройка транзакций

## Введение

Это руководство посвящено настройке управления транзакциями в проекте Spring Boot. Он предоставляет пошаговые инструкции по включению управления транзакциями и настройке атрибутов транзакций.

## Цель

Цель этого руководства - продемонстрировать, как настроить управление транзакциями в приложении Spring Boot, позволяя управлять транзакциями базы данных.

## Настройка управления транзакциями

Чтобы включить управление транзакциями в вашем проекте Spring Boot, выполните следующие шаги:

1. Добавьте необходимые зависимости в ваш файл `pom.xml` или `build.gradle`. Убедитесь, что у вас есть зависимости для Spring Boot, Spring Data JPA и любого драйвера базы данных, который вы используете (например, H2, MySQL, PostgreSQL).

2. Настройте управление транзакциями в вашем приложении Spring Boot. Вы можете сделать это, аннотировав ваш класс основного приложения аннотацией `@EnableTransactionManagement`.

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

3. Если вы используете Spring Web MVC, вам необходимо добавить следующее в ваши файлы конфигурации для настройки менеджера транзакций:

### Пример (XML Config):

```xml
<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
    <property name="entityManagerFactory" ref="entityManagerFactory" />
</bean>
```

### Пример (Java Config):

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
public class TransactionConfig {

    /**
     * Определение бина для Spring Transaction Manager.
     *
     * <p>
     * Этот метод настраивает менеджер транзакций для JPA с использованием настроенной фабрики сущностей.
     * </p>
     *
     * @param entityManagerFactory бин фабрики сущностей
     * @return бин TransactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
```

Следуя этим шагам, вы сможете включить управление транзакциями в вашем приложении Spring Boot, что позволит вам эффективно управлять транзакциями базы данных.

---

# [Далее: Создание сущностей и репозиториев](lessons/entities-and-repositories.md)