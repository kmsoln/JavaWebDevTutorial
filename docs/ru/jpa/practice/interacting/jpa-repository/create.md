# Создание записей в таблице с использованием JpaRepository

## Введение

Это руководство демонстрирует, как создавать записи в таблице, используя слой репозитория в приложении Spring Boot с JPA (Java Persistence API) и JpaRepository.

## Цель

Цель этого руководства - проиллюстрировать процесс создания записей в таблице путем реализации метода в интерфейсе `CourseRepository` с использованием JpaRepository.

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

    Course save(Course course);
}
```

### Объяснение

Метод `save(Course course)`, предоставленный JpaRepository, позволяет нам сохранить новую запись в таблице `Course`.

Вызывая этот метод и передавая объект `Course` в качестве параметра, JpaRepository автоматически обрабатывает процесс сохранения сущности в базе данных.

## Заключение

Теперь вы реализовали метод в интерфейсе `CourseRepository` с использованием JpaRepository для создания записей в таблице `Course`. Этот метод предоставляет удобный способ сохранения данных в базе данных с использованием JpaRepository в вашем приложении Spring Boot.

# [Далее: Чтение записи](read.md)
