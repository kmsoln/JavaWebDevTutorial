# Чтение записей из таблицы с использованием слоя репозитория

## Введение

В этом руководстве показано, как читать записи из таблицы, используя слой репозитория в приложении Spring Boot с JPA (Java Persistence API).

## Цель

Цель этого руководства - проиллюстрировать процесс чтения записей из таблицы, реализовав метод в интерфейсе `StudentRepository` с использованием `EntityManager`.

## Метод репозитория

### StudentRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Student;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public Student findStudentById(UUID id) {
        return entityManager.find(Student.class, id);
    }
}
```

### Объяснение

- `@Repository`: Эта аннотация помечает класс как компонент репозитория в слое доступа к данным.

- `@PersistenceContext`: Эта аннотация используется для внедрения экземпляра EntityManager в класс репозитория.

- `entityManager.find(Student.class, id)`: Этот код извлекает сущность `Student` из базы данных на основе предоставленного `id`.

## Заключение

Теперь вы реализовали метод в классе `StudentRepository` для чтения записей из таблицы `Student` с использованием слоя репозитория и `EntityManager`. Этот метод может быть дополнительно расширен и настроен для выполнения дополнительных операций чтения по мере необходимости.

# [Далее: Обновление записи](update.md)
