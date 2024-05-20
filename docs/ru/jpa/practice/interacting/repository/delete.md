# Удаление записей из таблицы с использованием слоя репозитория

## Введение

В этом руководстве показано, как удалять записи из таблицы, используя слой репозитория в приложении Spring Boot с JPA (Java Persistence API).

## Цель

Цель этого руководства - продемонстрировать процесс удаления записей из таблицы, реализовав метод в интерфейсе `StudentRepository` с использованием `EntityManager`.

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
    
    public void deleteStudent(UUID id) {
        Student studentToDelete = entityManager.find(Student.class, id);
        entityManager.remove(studentToDelete);
    }
}
```

### Объяснение

- `@Repository`: Эта аннотация помечает класс как компонент репозитория в слое доступа к данным.

- `@PersistenceContext`: Эта аннотация используется для внедрения экземпляра EntityManager в класс репозитория.

- `entityManager.remove(studentToDelete)`: Этот код удаляет сущность `Student` из базы данных.

---

# [Далее: Пользовательский запрос](query.md)
