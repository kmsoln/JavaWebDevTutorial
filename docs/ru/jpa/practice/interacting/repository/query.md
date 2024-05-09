# Создание пользовательских запросов в таблице с использованием слоя репозитория

## Введение

В этом руководстве показано, как создавать пользовательские запросы для извлечения записей из таблицы, используя слой репозитория в приложении Spring Boot с JPA (Java Persistence API).

## Цель

Цель этого руководства - проиллюстрировать процесс создания пользовательских запросов для извлечения записей из таблицы, реализовав метод в интерфейсе `StudentRepository` с использованием `EntityManager`.

## Метод репозитория

### StudentRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Student;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Student> findStudentsByMajor(String major) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.major = :major", Student.class)
                .setParameter("major", major)
                .getResultList();
    }
}
```

### Объяснение

- `@Repository`: Эта аннотация помечает класс как компонент репозитория в слое доступа к данным.

- `@PersistenceContext`: Эта аннотация используется для внедрения экземпляра EntityManager в класс репозитория.

- `entityManager.createQuery(...)`: Этот код создает пользовательский запрос на JPQL (Java Persistence Query Language) для извлечения записей на основе предоставленного критерия (`major` в этом примере).

## Заключение

Теперь вы реализовали метод в классе `StudentRepository` для создания пользовательских запросов и извлечения записей из таблицы `Student` с использованием слоя репозитория и `EntityManager`. Этот метод может быть дополнительно расширен и настроен для выполнения дополнительных операций пользовательских запросов по мере необходимости.

# [Далее: Создание JpaRepository](../jpa-repository.md)
