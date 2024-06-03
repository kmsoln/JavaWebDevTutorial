# Фрагменты и макеты

**Описание:**

В этом разделе мы реализуем фрагменты и макеты Thymeleaf. Мы обновим существующие представления, чтобы включить в них фрагменты, а затем создадим новое представление, использующее эти фрагменты.

## **Шаги:**

1. **Обновите `first.html` с фрагментом:**

   - Откройте файл `first.html` в каталоге `practice`.
   - Добавьте атрибут `th:fragment` к тегу `<div>` внутри тега `<body>`:

     ```html
     <!-- practice/first.html -->
     <html lang="en" xmlns:th="http://www.thymeleaf.org">
     <head>
         <!-- Другие элементы head... -->
     </head>
     <body>
         <!-- Обновлено: Добавьте атрибут 'th:fragment' к 'div' -->
         <div th:fragment="info">
             <p>Это информационный раздел первого представления.</p>
         </div>
         <!-- Остальное содержимое... -->
     </body>
     </html>
     ```

2. **Обновите `second.html` с фрагментом:**

   - Откройте файл `second.html` в каталоге `practice`.
   - Добавьте атрибут `th:fragment` к тегу `<table>` внутри тега `<body>`:

     ```html
     <!-- practice/second.html -->
     <html lang="en" xmlns:th="http://www.thymeleaf.org">
     <head>
         <!-- Другие элементы head... -->
     </head>
     <body>
         <!-- Обновлено: Добавьте атрибут 'th:fragment' к 'table' -->
         <table border="1" th:fragment="students-table">
             <thead>
             <tr>
                 <th>Id</th>
                 <th>FirstName</th>
                 <th>SecondName</th>
                 <th>Graduated</th>
                 <th>Mark</th>
                 <th>Diploma Type</th>
             </tr>
             </thead>
             <tbody>
             <!-- Данные студента будут вставлены здесь -->
             </tbody>
         </table>
         <!-- Остальное содержимое... -->
     </body>
     </html>
     ```

3. **Обновите `third.html` с фрагментом:**

   - Откройте файл `third.html` в каталоге `practice`.
   - Добавьте атрибут `th:fragment` к тегу `<fieldset>` внутри тега `<body>`:

     ```html
     <!-- practice/third.html -->
     <html lang="en" xmlns:th="http://www.thymeleaf.org">
     <head>
         <!-- Другие элементы head... -->
     </head>
     <body>
         <!-- Обновлено: Добавьте атрибут 'th:fragment' к 'fieldset' -->
         <fieldset th:fragment="add-student-form">
             <legend>Добавление студента</legend>

             <div th:if="${param.addedStudent}">
                 <p style="color: green;">Студент успешно добавлен!</p>
             </div>

             <form action="#" th:action="@{/addStudent}" th:object="${model}" method="post">
                <!-- Другие элементы формы... -->
             </form>
         </fieldset>
         <!-- Остальное содержимое... -->
     </body>
     </html>
     ```

4. **Создайте `fourth.html` с использованием фрагментов:**

   - Создайте новый файл с именем `fourth.html` в каталоге `practice`.
   - Используйте атрибуты `th:insert` и `th:replace`, чтобы включить фрагменты из других представлений:

     ```html
     <!-- practice/fourth.html -->
     <html lang="en" xmlns:th="http://www.thymeleaf.org">
     <head>
         <!-- Другие элементы head... -->
     </head>
     <body>
         <!-- Обновлено: Вставьте фрагмент 'info' из 'first.html' -->
         <div th:insert="~{practice/first :: info}"></div>

         <!-- Обновлено: Замените фрагмент 'students-table' из 'second.html' -->
         <div th:replace="~{practice/second :: students-table}"></div>

         <!-- Обновлено: Вставьте фрагмент 'add-student-form' из 'third.html' -->
         <div th:insert="~{practice/third :: add-student-form}"></div>
         <!-- Остальное содержимое... -->
     </body>
     </html>
     ```

   - Объяснение:
      - `th:insert` используется для включения содержимого указанного фрагмента (`info` и `add-student-form`) в файл `fourth.html`.
      - `th:replace` используется для замены содержимого указанного фрагмента (`students-table`) в файле `fourth.html`.

## Результат
Ваше представление должно выглядеть так:

![fourth-view.png](../../../srcs/thymeleaf/fourth-view.png)

---

# Поздравляю! Вы выполнили все задания. Теперь давайте перейдем к **[Заданиям лабораторной работы](../lab-work.md#задания-лабораторной-работы)**
