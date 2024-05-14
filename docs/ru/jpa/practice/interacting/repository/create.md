# Создание новых записей в таблице с использованием слоя репозитория

## Введение

Это руководство иллюстрирует, как создавать новые записи в таблице, используя слой репозитория в приложении Spring Boot с JPA (Java Persistence API).

## Цель

Цель этого руководства - продемонстрировать процесс создания новых записей в таблице с использованием слоя репозитория. Мы достигнем этого, реализовав метод в интерфейсе `StudentRepository`, используя `EntityManager` вместо `JpaRepository`.

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
    
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }
}
```

### Объяснение

- `@Repository`: Эта аннотация помечает класс как компонент репозитория в слое доступа к данным.

- `@PersistenceContext`: Эта аннотация используется для внедрения экземпляра EntityManager в класс репозитория.

- `entityManager.persist(student)`: Этот код сохраняет новую сущность `Student` в базе данных.

---

# [Далее: Чтение записи](read.md)
