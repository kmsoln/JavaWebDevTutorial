English | [中文](../../cn/transactions/lab-work.md) | [Русский](../../ru/transactions/lab-work.md)


# Transactions Lab Work

Welcome to the Transactions Lab Work! The goal of this series of tasks is to help you practice and master transaction management in a Spring application. Whether you're a beginner or looking to enhance your skills, these hands-on tasks will guide you through various aspects of transaction management, including propagation, isolation levels, nested transactions, and more.

## Goal of the Lab Work

The primary goal of this lab work is to provide you with practical experience and proficiency in managing transactions within a Spring environment. Through these tasks, you will gain valuable insights into configuring transactions, handling different propagation behaviors, implementing nested transactions, and ensuring data integrity in your applications.

## Practice Tasks <a name="practice-tasks"></a>

1. [Transaction Setup](practice/configuration.md)
2. [Part 1: Create the Entities and Repositories](practice/lessons/entities-and-repositories.md)
3. [Part 2: Implementing Basic Transactional Operations](practice/lessons/basic-transactional-operations.md)
4. [Part 3: Enhancing Transactional Methods with Detailed Logging](practice/lessons/transactional-logging.md)
5. [Part 4: Implementing Nested Transactions and Non-Transactional Operations](practice/lessons/nested-and-non-transactional-operations.md)

## Lab Work Tasks <a name="lab-work-tasks"></a>

![img.png](../../srcs/transactions/task-chart.png)

- **Registering a User for an Event**
    - **Task:** Implement a method to register a user for an event. Ensure the operation is completely isolated to maintain data consistency. Log this operation separately, regardless of whether the main transaction succeeds or fails.
    - **Propagation:** REQUIRED
    - **Isolation:** SERIALIZABLE
    - **Logging Propagation:** REQUIRES_NEW

- **Removing a User's Registration from an Event**
    - **Task:** Implement a method to remove a user's registration from an event. Ensure this method is always executed within an existing transaction.
    - **Propagation:** MANDATORY

- **Fetching Registered Users for an Event**
    - **Task:** Implement a method to fetch all users registered for a specific event. Ensure the method either joins an existing transaction or creates a new one, reading only committed data.
    - **Propagation:** REQUIRED
    - **Isolation:** READ_COMMITTED

- **Adding a New Event**
    - **Task:** Implement a method to add a new event. This operation should run without transactional guarantees to avoid unnecessary transactional overhead.
    - **Propagation:** NOT_SUPPORTED

- **Updating Event Details and Registrations with Nested Transactions**
    - **Task:** Implement a method to update event details along with related registrations. Ensure consistency within nested transactions.
    - **Propagation:** REQUIRED
    - **Isolation:** REPEATABLE_READ
    - **Nested Task:** Update registrations within a nested transaction.

- **Updating Registrations**
    - **Task:** Implement a method to update registration records. Ensure these operations are part of a nested transaction.
    - **Propagation:** NESTED
    - **Isolation:** REPEATABLE_READ

- **Performing Non-Transactional Operation**
    - **Task:** Implement a method for operations that do not require a transactional context, such as non-critical tasks or logging.
    - **Propagation:** None

---