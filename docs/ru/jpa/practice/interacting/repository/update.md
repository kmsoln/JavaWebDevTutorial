# Обновление записей в таблице с использованием слоя репозитория

## Введение

Это руководство иллюстрирует, как обновлять записи в таблице с использованием слоя репозитория в приложении Spring Boot с JPA (Java Persistence API).

## Цель

Цель этого руководства - продемонстрировать процесс обновления записей в таблице, реализовав метод в интерфейсе `StudentRepository` с использованием `EntityManager`.

## Метод репозитория

### StudentRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Student;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }
}
```

### Объяснение

- `@Repository`: Эта аннотация помечает класс как компонент репозитория в слое доступа к данным.

- `@PersistenceContext`: Эта аннотация используется для внедрения экземпляра EntityManager в класс репозитория.

- `entityManager.merge(student)`: Этот код обновляет сущность `Student` в базе данных.

---

# [Далее: Удаление записи](delete.md)
