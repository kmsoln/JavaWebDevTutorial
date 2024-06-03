# Лабораторная работа: JPA (Java Persistence API)

Добро пожаловать на лабораторную работу по Spring Boot с JPA! В этой лабораторной работе вы попрактикуетесь в различных задачах, связанных с настройкой проекта Spring Boot с JPA (Java Persistence API).

## Цель лабораторной работы

Цель этой лабораторной работы - предоставить практический опыт работы с основными концепциями и задачами, связанными с работой с Spring Boot и JPA. Завершив практические задачи, вы приобретете навыки настройки зависимостей, определения характеристик сущностей, управления отношениями между сущностями и взаимодействия с базой данных с использованием JpaRepository.

## Задачи практики <a name="practice-tasks"></a>

1. **Настройка зависимостей базы данных**
   - [Настройка драйвера базы данных](practice/dependencies/driver.md)
   - [Зависимости Spring Boot и JPA](practice/dependencies/jpa.md)

2. **Создание сущностей, определение характеристик, отношений и стратегий извлечения данных**
   - [Создание сущности](practice/creation/create-entity.md)
   - [Определение характеристик сущности](practice/creation/characteristics.md)
   - [Управление отношениями](practice/creation/relationships.md)
   - [Стратегии извлечения](practice/creation/fetching.md)

3. **Взаимодействие с пользовательским репозиторием**
   - [Создание записи](practice/interacting/repository/create.md)
   - [Чтение записи](practice/interacting/repository/read.md)
   - [Обновление записи](practice/interacting/repository/update.md)
   - [Удаление записи](practice/interacting/repository/delete.md)
   - [Пользовательские запросы](practice/interacting/repository/query.md)

4. **Взаимодействие с репозиторием JPA**
   - [Создание записи](practice/interacting/jpa-repository/create.md)
   - [Чтение записи](practice/interacting/jpa-repository/read.md)
   - [Удаление записи](practice/interacting/jpa-repository/delete.md)
   - [Пользовательские запросы](practice/interacting/jpa-repository/query.md)


## Задачи лабораторной работы <a name="lab-work-tasks"></a>

1. Настройте зависимости базы данных для PostgreSQL, MySQL, Oracle и Microsoft SQL Server.

2. Реализуйте следующую схему сущностей и отношений:
   ![img.png](../../srcs/jpa/task-er-diagram.png)

   1. Определите характеристики сущностей для сущностей Student, Enrollment и Course на основе диаграммы сущностей и отношений.

   2. Создайте классы сущностей для Student, Enrollment и Course в соответствии с определенными характеристиками.

   3. Реализуйте стратегии извлечения для эффективного извлечения данных для оптимизации взаимодействия с базой данных.

   4. Управляйте отношениями между сущностями, такими как Student, Enrollment и Course, установив соответствующие ассоциации и отображения.

   5. Взаимодействуйте с базой данных, создав методы для операций CRUD с использованием слоя Repository и EntityManager как минимум в двух репозиториях.

   6. Взаимодействуйте с базой данных, создав методы для операций CRUD с использованием JpaRepository как минимум в двух репозиториях.

   7. Реализуйте пользовательские запросы для выполнения расширенных операций извлечения и манипулирования данными, необходимых для бизнес-логики приложения.
