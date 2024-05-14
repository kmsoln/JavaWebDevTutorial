# Создание репозитория

## Введение

Это руководство демонстрирует, как создать репозиторий для управления сущностями в проекте Spring Boot с использованием JPA (Java Persistence API).

## Цель

Цель этого руководства - предоставить четкие инструкции по настройке репозитория для управления сущностями в приложении Spring Boot. По окончании этого руководства вы сможете создать репозиторий для сущности `Student`.

## Структура каталогов

```
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── demo/
                    ├── data/
                    │   └── entites/
                    │       ├── Student.java
                    │       ├── Enrollment.java
                    │       └── Course.java
                    └── repository/
                        └── StudentRepository.java
                    
```

## Класс репозитория

### StudentRepository.java

```java
package com.yourcompany.yourproject.repository;

import com.yourcompany.yourproject.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    // Добавьте методы репозитория для сущности студента
}
```

Аннотация `@Repository` является аннотацией стереотипа Spring, используемой для указания того, что декорированный класс является компонентом репозитория в слое доступа к данным. Она служит маркером для любого класса, который выполняет роль репозитория, облегчая перевод исключений в едиерное иерархия исключений Spring.

---

# [Далее: Создание записи](repository/create.md)
