# Удаление записей из таблицы с использованием JpaRepository

## Введение

В этом руководстве показано, как удалять записи из таблицы, используя слой репозитория в приложении Spring Boot с JPA (Java Persistence API) и JpaRepository.

## Цель

Цель этого руководства - проиллюстрировать процесс удаления записей из таблицы путем реализации метода в интерфейсе `CourseRepository` с использованием JpaRepository.

## Метод репозитория

### CourseRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    void deleteById(UUID id);
}
```

## Объяснение

Метод `deleteById(UUID id)` следует соглашению, распознаваемому JpaRepository, для удаления записей на основе их уникального идентификатора.

- Ключевое слово `delete` указывает, что этот метод используется для удаления данных.
- `ById` указывает критерий для идентификации записи, которую нужно удалить. В данном случае мы нацелены на запись с определенным идентификатором.

Следуя этому соглашению по именованию, JpaRepository автоматически генерирует соответствующий SQL-запрос для удаления желаемой записи из базы данных. Это упрощает процесс разработки, устраняя необходимость писать явные SQL-запросы на удаление, что позволяет разработчикам сосредоточиться на определении сигнатур методов, отражающих предполагаемые операции удаления данных.

## Заключение

Теперь вы реализовали метод в интерфейсе `CourseRepository` с использованием JpaRepository для удаления записей из таблицы `Course`. Этот метод предоставляет удобный способ удаления данных из базы данных с использованием JpaRepository в вашем приложении Spring Boot.

# [Далее: Пользовательский запрос](query.md)
