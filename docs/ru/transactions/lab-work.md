[English](../../en/transactions/lab-work.md) | [中文](../../cn/transactions/lab-work.md) | Русский


# Лабораторная работа по Транзакциям

Добро пожаловать в лабораторную работу по транзакциям! Цель этих задач - помочь вам  овладеть управлением транзакциями в приложении на Spring. Независимо от вашего уровня - будь то начинающий или опытный разработчик, эти практические задачи помогут вам освоить различные аспекты управления транзакциями, включая распространение, уровни изоляции, вложенные транзакции и многое другое.

## Цель лабораторной работы

Основная цель этой лабораторной работы - предоставить вам практический опыт и навыки в управлении транзакциями. Через эти задачи вы получите ценные знания о настройке транзакций, обработке различных типов распространения, реализации вложенных транзакций и обеспечении целостности данных в ваших приложениях.

## Задачи практики

1. [Настройка транзакции](practice/configuration.md)
2. [Часть 1: Создание сущностей и репозиториев](practice/lessons/entities-and-repositories.md)
3. [Часть 2: Реализация основных транзакционных операций](practice/lessons/basic-transactional-operations.md)
4. [Часть 3: Улучшение транзакционных методов с подробным журналированием](practice/lessons/transactional-logging.md)
5. [Часть 4: Реализация вложенных транзакций и операций без транзакции](practice/lessons/nested-and-non-transactional-operations.md)

## Задачи лабораторной работы

![img.png](../../srcs/transactions/task-chart.png)

- **Регистрация пользователя на мероприятие**
  - **Задача:** Реализуйте метод для регистрации пользователя на мероприятие. Обеспечьте полную изоляцию операции для поддержания целостности данных. Запишите эту операцию отдельно, независимо от успешного или неудачного выполнения основной транзакции.
  - **Распространение:** REQUIRED
  - **Изоляция:** SERIALIZABLE
  - **Распространение журналирования:** REQUIRES_NEW

- **Удаление регистрации пользователя с мероприятия**
  - **Задача:** Реализуйте метод для удаления регистрации пользователя с мероприятия. Обеспечьте выполнение этого метода в рамках существующей транзакции.
  - **Распространение:** MANDATORY

- **Получение зарегистрированных пользователей на мероприятие**
  - **Задача:** Реализуйте метод для получения всех пользователей, зарегистрированных на конкретное мероприятие. Обеспечьте, чтобы метод либо присоединялся к существующей транзакции, либо создавал новую, читая только подтвержденные данные.
  - **Распространение:** REQUIRED
  - **Изоляция:** READ_COMMITTED

- **Добавление нового мероприятия**
  - **Задача:** Реализуйте метод для добавления нового мероприятия. Эта операция должна выполняться без транзакционных гарантий, чтобы избежать ненужных затрат на транзакции.
  - **Распространение:** NOT_SUPPORTED

- **Обновление деталей мероприятия и регистраций с вложенными транзакциями**
  - **Задача:** Реализуйте метод для обновления деталей мероприятия вместе с соответствующими регистрациями. Обеспечьте согласованность в рамках вложенных транзакций.
  - **Распространение:** REQUIRED
  - **Изоляция:** REPEATABLE_READ
  - **Вложенная задача:** Обновление регистраций в рамках вложенной транзакции.

- **Обновление регистраций**
  - **Задача:** Реализуйте метод для обновления записей регистрации. Обеспечьте, чтобы эти операции были частью вложенной транзакции.
  - **Распространение:** NESTED
  - **Изоляция:** REPEATABLE_READ

- **Выполнение операции без транзакции**
  - **Задача:** Реализуйте метод для операций, не требующих транзакционного контекста, например обычные операции или логгирование.
  - **Распространение:** Нет
