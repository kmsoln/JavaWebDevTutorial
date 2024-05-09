# Чтение записей из таблицы с использованием JpaRepository

## Введение

Это руководство демонстрирует, как извлекать данные из таблицы, используя слой репозитория в приложении Spring Boot с JPA (Java Persistence API) и JpaRepository.

## Цель

Цель этого руководства - проиллюстрировать процесс чтения данных из таблицы путем реализации метода в интерфейсе `CourseRepository` с использованием JpaRepository.

## Метод репозитория

### CourseRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    List<Course> findCoursesByInstructor(String instructor);
}
```

### Объяснение

Сигнатура метода `findCoursesByInstructor(String instructor)` следует определенному соглашению по именованию, распознаваемому Spring Data JPA.

- Ключевое слово `find` указывает, что этот метод используется для извлечения данных.
- `Courses` представляет тип сущности, который мы хотим извлечь.
- `ByInstructor` указывает критерий для фильтрации результатов. В данном случае мы запрашиваем курсы на основе атрибута `instructor`.

Следуя этому соглашению по именованию, Spring Data JPA автоматически генерирует соответствующий SQL-запрос за кулисами, чтобы извлечь необходимые данные из базы данных. Это упрощает процесс разработки, устраняя необходимость писать явные SQL-запросы, что позволяет разработчикам сосредоточиться на определении сигнатур методов, отражающих желаемые операции извлечения данных.

## Заключение

Теперь вы реализовали метод в интерфейсе `CourseRepository` с использованием JpaRepository для извлечения данных из таблицы `Course`. Этот метод позволяет эффективно читать данные из базы данных с использованием JpaRepository в вашем приложении Spring Boot.

# [Далее: Удаление записи](delete.md)
