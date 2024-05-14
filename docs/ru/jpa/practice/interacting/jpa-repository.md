# Создание JpaRepository

## Введение

Это руководство демонстрирует, как создать репозиторий для управления сущностями в проекте Spring Boot с использованием JPA (Java Persistence API) с помощью JpaRepository.

## Цель

Цель этого руководства - предоставить четкие инструкции по настройке репозитория для управления сущностями в приложении Spring Boot. По окончании этого руководства вы сможете создать классы репозитория и сервиса для сущности `Course`.

## Структура каталогов

```
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── demo/
                    ├── data/
                    │   └── entities/
                    │       ├── Student.java
                    │       ├── Enrollment.java
                    │       └── Course.java
                    └── repository/
                        ├── StudentRepository.java
                        └── CourseRepository.java
                    
```

## Класс репозитория

### CourseRepository.java

```java
package com.yourcompany.yourproject.repository;

import com.yourcompany.yourproject.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Добавьте методы репозитория для сущности курса
}
```

Аннотация `@Repository` является аннотацией стереотипа Spring, используемой для указания того, что декорированный класс является компонентом репозитория в слое доступа к данным. Она служит маркером для любого класса, который выполняет роль репозитория, облегчая перевод исключений в едиерное иерархия исключений Spring.

---

# [Далее: Создание записи](jpa-repository/create.md)
