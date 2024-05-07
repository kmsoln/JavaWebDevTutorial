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
    
    @Transactional
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

## Заключение

Теперь вы реализовали метод в классе `StudentRepository` для удаления записей из таблицы `Student` с использованием слоя репозитория и `EntityManager`. Этот метод может быть дополнительно расширен и настроен для выполнения дополнительных операций удаления по мере необходимости.

# [Далее: Пользовательский запрос](query.md)
