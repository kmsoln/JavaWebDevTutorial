# Авторизация по ролям (клиентская сторона)

Это задание описывает процесс авторизации пользователей на клиентской стороне веб-интерфейса с использованием Thymeleaf. Путем отображения или скрытия элементов на основе ролей пользователя можно контролировать видимость определенных функций или действий.

## Цель

Контроль видимости элементов, связанных с добавлением и удалением студентов, в зависимости от ролей пользователя в представлениях Thymeleaf.

## Шаги

1. **Обновление шаблонов Thymeleaf:**

   Измените шаблоны Thymeleaf, чтобы условно отображать элементы в зависимости от ролей пользователя.

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
   <head>
       <title>Управление студентами</title>
   </head>
   <body>
       <h1>Управление студентами</h1>

       <!-- Кнопка Добавить студента -->
       <div th:if="${#authorization.expression('hasRole(''ROLE_ADMIN'')')}">
           <a href="/addStudent" class="btn btn-primary">Добавить студента</a>
       </div>

       <!-- Кнопка Удалить студента -->
       <div th:if="${#authorization.expression('hasRole(''ROLE_MANAGER'')')}">
           <a href="/removeStudent" class="btn btn-danger">Удалить студента</a>
       </div>

       <!-- Другое содержимое -->
       <div>
           <p>Добро пожаловать в систему управления студентами. Здесь вы можете управлять записями студентов.</p>
       </div>
   </body>
   </html>
   ```

   В этом шаблоне:
   - Используется оператор `th:if="${#authorization.expression('hasRole(''ROLE_ADMIN'')')}"`, чтобы условно отображать кнопку "Добавить студента" только в том случае, если у пользователя есть роль `ROLE_ADMIN`.
   - Аналогично, оператор `th:if="${#authorization.expression('hasRole(''ROLE_MANAGER'')')}"` используется для условного отображения кнопки "Удалить студента" только в том случае, если у пользователя есть роль `ROLE_MANAGER`.

## Объяснение

- **Диалект безопасности Thymeleaf**: Объект `#authorization` является частью диалекта безопасности Thymeleaf, который интегрирует Spring Security с Thymeleaf.
- **Условное отображение**: Атрибут `th:if` используется для условного отображения или скрытия элементов на основе ролей пользователя.

Следуя этим шагам, вы можете контролировать видимость элементов в ваших представлениях Thymeleaf в зависимости от ролей пользователей, гарантируя, что только авторизованные пользователи могут видеть и взаимодействовать с определенными функциями.

---

# [СЛЕДУЮЩЕЕ ЗАДАНИЕ: Авторизация по авторитету](authorize-client-authority.md)