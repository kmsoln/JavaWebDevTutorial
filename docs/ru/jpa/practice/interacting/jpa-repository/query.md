# Пользовательский запрос с использованием JpaRepository

## Введение

Это руководство демонстрирует, как реализовать методы пользовательского запроса, используя аннотацию `@Query` в слое репозитория приложения Spring Boot с JPA (Java Persistence API) и JpaRepository.

## Цель

Цель этого руководства - проиллюстрировать процесс создания методов пользовательского запроса в интерфейсе репозитория для выполнения определенных операций с базой данных, адаптированных к требованиям приложения.

## Метод репозитория

### CourseRepository.java

```java
package com.example.demo.repository;

import com.example.demo.data.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("SELECT c FROM Course c WHERE c.instructor = :instructor")
    List<Course> findCoursesByInstructor(@Param("instructor") String instructor);
}
```

### Объяснение

Аннотация `@Query` позволяет нам определять пользовательские запросы JPQL (Java Persistence Query Language) непосредственно в интерфейсе репозитория.

- `"SELECT c FROM Course c WHERE c.instructor = :instructor"` - это запрос JPQL, который выбирает все курсы, где имя инструктора соответствует предоставленному значению.
- Аннотация `@Param("instructor")` привязывает параметр метода `instructor` к именованному параметру `:instructor` в запросе JPQL.

Используя `@Query`, мы можем создавать сложные запросы, адаптированные к конкретным потребностям извлечения данных, обеспечивая гибкость и контроль над операциями с базой данных.

## Заключение

Теперь вы реализовали метод пользовательского запроса в интерфейсе `CourseRepository` с использованием JpaRepository и аннотации `@Query` для извлечения записей из таблицы `Course` на основе конкретного условия. Этот метод предоставляет мощный способ выполнения пользовательских запросов в вашем приложении Spring Boot, обеспечивая точные операции извлечения данных.
