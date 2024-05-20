# Формы

**Описание:**

В этом задании вы создадите новое представление Thymeleaf с именем `third.html` и реализуете логику обработки форм в контроллере `PracticeController`. Форма позволит пользователям добавлять новых студентов с определенными данными, и контроллер будет обрабатывать отправку формы.

**Шаги:**

1. **Создайте третье представление (third.html):**

   - Создайте новый файл представления Thymeleaf с именем `third.html` в каталоге `/src/main/resources/templates/practice`.

      ```html
      <!DOCTYPE html>
      <html lang="en">
          <head>
              <meta charset="UTF-8">
              <title>Добавление студента</title>
          </head>
          <body>
              <fieldset>
                  <legend>Добавление студента</legend>
      
                  <form action="#" th:action="@{/addStudent}" th:object="${model}" method="post">
                      <!-- Поля формы -->
                      <p>
                          <label for="id">ID:</label>
                          <input type="text" id="id" name="id" th:field="*{id}">
                      </p>
                  </form>
              </fieldset>
          </body>
      </html>
      ```

2. **Настройте отправку формы:**

   - В теге `form` настройте детали отправки формы:

      ```html
      <form action="#" th:action="@{/addStudent}" th:object="${model}" method="post">
      ```

   - Объяснение:
      - `action="#"`: Этот атрибут указывает URL, на который будут отправлены данные формы при отправке. `#` указывает, что форма будет отправлена на тот же URL, с которого она была запрошена.
      - `th:action="@{/addStudent}"`: Этот атрибут Thymeleaf динамически устанавливает атрибут `action` на основе выражения Thymeleaf. `@{/addStudent}` генерирует абсолютный URL для конечной точки `/addStudent`.
      - `th:object="${model}"`: Этот атрибут связывает форму с объектом-моделью (`model`). Thymeleaf использует этот объект для привязки полей формы к свойствам во время отправки формы и рендеринга.
      - `method="post"`: Этот атрибут указывает HTTP-метод, используемый при отправке данных формы на сервер. Установлено значение `post`, указывающее, что данные формы будут отправлены в теле запроса.

3. **Передайте поле 'id':**

   - В форме найдите раздел для поля `id`:

      ```html
      <!-- Поля формы -->
      <p>
          <label for="id">ID:</label>
          <input type="text" id="id" name="id" th:field="*{id}">
      </p>
      ```

   - Объяснение:
      - `th:field="*{id}"`: Этот атрибут Thymeleaf привязывает поле ввода к свойству `id` объекта `model`. Это гарантирует, что значение, введенное в поле ввода, будет установлено в свойство `id` при отправке формы.
      - `id="id"` и `name="id"`: Эти атрибуты предоставляют идентификаторы для поля ввода.

4. **Повторите эти шаги:**

   - Повторите эти шаги для каждого оставшегося поля (`firstName`, `sureName`, `isGraduated` и `mark`). Убедитесь, что вы обновляете атрибуты `label`, `id`, `name` и `th:field` соответственно.
   - Вот пример кода:
   ```html
    <!DOCTYPE html>
    <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Добавление студента</title>
        </head>
        <body>
            <fieldset>
                <legend>Добавление студента</legend>
    
                <form action="#" th:action="@{/addStudent}" th:object="${model}" method="post">
                    <!-- Поля формы -->
                    <p>
                        <label for="id">ID:</label>
                        <input type="text" id="id" name="id" th:field="*{id}">
                    </p>
                    <p>
                        <label for="firstName">Имя:</label>
                        <input type="text" id="firstName" name="firstName" th:field="*{firstName}">
                    </p>
                    <p>
                        <label for="sureName">Фамилия:</label>
                        <input type="text" id="sureName" name="sureName" th:field="*{sureName}">
                    </p>
                    <p>
                        <label for="isGraduated">Выпускник:</label>
                        <input type="checkbox" id="isGraduated" name="isGraduated" th:checked="*{isGraduated}">
                    </p>
                    <p>
                        <label for="mark">Оценка:</label>
                        <input type="number" id="mark" name="mark" th:field="*{mark}">
                    </p>
                    <!-- Кнопка отправки -->
                    <button type="submit">Добавить студента</button>
                </form>
            </fieldset>
        </body>
    </html>
   ```

## Результат
Ваше представление должно выглядеть так:

![third-view.png](../../../srcs/thymeleaf/third-view.png)

**Заключение:**

Вы успешно настроили форму в `third.html` и передали каждое поле в `PracticeController`, используя привязку формы Thymeleaf.

# [СЛЕДУЮЩЕЕ ЗАДАНИЕ: *Обработка Форм*](form-handling.md)