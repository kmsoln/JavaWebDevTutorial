## Урок 3: Дополнение транзакционных методов подробным журналированием

## Цель

Этот раздел направлен на интеграцию подробного журналирования для каждой транзакционной операции, обеспечивая запись действий с их результатами.

## Шаги

1. **Реализация метода журналирования**

   **Сценарий**: Прежде чем улучшать транзакционные методы с помощью журналирования, нам нужно реализовать метод для обработки журналирования независимо от основной транзакции. Это гарантирует, что журналирование происходит надежно, независимо от результата основной транзакции.

   **Реализация метода `logAction`**: Создайте метод для независимого журналирования действий, обеспечивая точное отслеживание результатов транзакции. Мы используем `Propagation.REQUIRES_NEW`, чтобы выполнить операцию журналирования в отдельной транзакции, делая ее независимой от любых текущих транзакций и гарантируя ее завершение даже в случае сбоя основной транзакции.

   ```java
   @Transactional(propagation = Propagation.REQUIRES_NEW)
   public void logAction(String action, String outcome) {
       Log log = new Log(action, outcome, LocalDateTime.now());
       logRepository.save(log);
   }
   ```

2. **Журналирование зачисления студента на курс**

   **Сценарий**: В качестве администратора университета вам необходимо зарегистрировать зачисление студента на курс для отслеживания успешных зачислений и возможных ошибок.

   **Улучшение метода `enrollStudentInCourse`**: Измените метод для журналирования успешного или неудачного действия.

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
   public void enrollStudentInCourse(UUID studentId, UUID courseId) {
       // Запись начала процесса зачисления
       logAction("Enroll Student", "Start");

       try {
           // Реализация зачисления студента на курс
           // ...

           // Журналирование успешного зачисления
           logAction("Enroll Student", "Success");
       } catch (Exception e) {
           // Журналирование ошибки
           logAction("Enroll Student", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

3. **Журналирование получения списка студентов для курса**

   **Сценарий**: Для поддержания аудита активностей, связанных с курсом, вам необходимо зарегистрировать получение списка студентов для курса и гарантировать, что журналирование происходит даже в случае исключений.

   **Улучшение метода `getStudentsForCourse`**: Измените метод для журналирования успешного или неудачного действия.

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
   public List<Student> getStudentsForCourse(UUID courseId) {
       // Запись начала получения списка студентов для курса
       logAction("Retrieve Students for Course", "Start");

       try {
           // Реализация получения списка студентов для курса
           // ...

           // Журналирование успешного получения
           logAction("Retrieve Students for Course", "Success");
           return students;
       } catch (Exception e) {
           // Журналирование ошибки
           logAction("Retrieve Students for Course", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

4. **Журналирование добавления нового курса**

   **Сценарий**: При добавлении нового курса важно зарегистрировать результат операции для отслеживания успешного или неудачного добавления.

   **Улучшение метода `addNewCourse`**: Измените метод для журналирования успешного или неудачного действия.

   ```java
   @Transactional(propagation = Propagation.NOT_SUPPORTED)
   public Course addNewCourse(String title) {
       // Запись начала добавления нового курса
       logAction("Add New Course", "Start");

       try {
           // Реализация добавления нового курса
           // ...

           // Журналирование успешного добавления
           logAction("Add New Course", "Success");
           return savedCourse;
       } catch (Exception e) {
           // Журналирование ошибки
           logAction("Add New Course", "Failure: " + e.getMessage());
           throw e;
       }
   }
   ```

---

# [ДАЛЕЕ: Реализация вложенных транзакций и непривязанных к транзакции операций](nested-and-non-transactional-operations.md)