## Урок 2: Внедрение основных транзакционных операций

## Цель

Этот раздел направлен на введение простых, но важных транзакционных методов для зачисления студентов и управления курсами в приложении Spring Boot.

## Шаги

1. **Зачисление студента на курс**

   **Сценарий**: В качестве администратора университета вам необходимо зачислить студента на курс. Это действие должно быть не должно вызвать проблем и гарантировать целостность данных, даже если происходит несколько зачислений одновременно или возникают проблемы с базой данных.

   **Реализация метода `enrollStudentInCourse`**: Создайте метод для зачисления студента на курс. Обеспечьте, чтобы этот процесс был транзакционным, что означает, что это как единый пакетный процесс, гарантирующий, что весь процесс единый. Мы используем `Propagation.REQUIRED`, чтобы убедиться, что этот метод участвует в любой существующей транзакции или создает новую, если таковой не существует. Кроме того, мы устанавливаем `Isolation.SERIALIZABLE`, чтобы гарантировать, что даже если есть параллельные транзакции, они не мешают друг другу, сохраняя целостность данных.

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
   public void enrollStudentInCourse(UUID studentId, UUID courseId) {
       // Ваша реализация здесь
   }
   ```

2. **Получение списка студентов для курса**

   **Сценарий**: Чтобы создать список группы для курса, вам необходимо получить список студентов, которые зачислены на него. Эта операция должна гарантировать, что вы всегда получаете точные данные базы данных, даже если происходят другие действия одновременно.

   **Реализация метода `getStudentsForCourse`**: Разработайте метод для извлечения студентов для определенного курса. Он должен гарантировать, что данные, которые вы извлекаете, согласованы, независимо от любых текущих транзакций. Мы используем `Propagation.REQUIRED`, чтобы убедиться, что этот метод участвует в любой существующей транзакции или создает новую, если таковая не существует. Мы устанавливаем `Isolation.READ_COMMITTED`, чтобы гарантировать, что данные, которые мы извлекаем, зафиксированы и видны другим транзакциям, поддерживая последовательность.

   ```java
   @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
   public List<Student> getStudentsForCourse(UUID courseId) {
       // Ваша реализация здесь
   }
   ```

3. **Добавление нового курса**

   **Сценарий**: Новый курс готовится к новому учебному году. При добавлении нового курса в систему вы хотите убедиться, что это действие не мешает ничему другому, происходящему в системе, сохраняя свою независимость.

   **Реализация метода `addNewCourse`**: Создайте метод для добавления нового курса в систему. Убедитесь, что этот процесс не запутывается с другими текущими транзакциями. Мы используем `Propagation.NOT_SUPPORTED`, чтобы убедиться, что этот метод не участвует в какой-либо текущей транзакции, обеспечивая его автономность и избегая потенциальных конфликтов с другими операциями.

   ```java
   @Transactional(propagation = Propagation.NOT_SUPPORTED)
   public Course addNewCourse(String title) {
       // Ваша реализация здесь
   }
   ```
   
---

# [СЛЕДУЮЩЕЕ: Улучшение транзакционных методов с подробным логированием](transactional-logging.md)
