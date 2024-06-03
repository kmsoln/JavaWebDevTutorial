[English](../../en/transactions/lab-work.md) | 中文 | [Русский](../../ru/transactions/lab-work.md)


# 事务实验任务

欢迎来到事务实验任务！这一系列任务的目标是帮助您练习并掌握在Spring应用程序中管理事务。无论您是初学者还是希望提升技能，这些实践任务都将引导您探索事务管理的各个方面，包括传播、隔离级别、嵌套事务等。

## 实验任务的目标

这个实验任务的主要目标是为您提供在Spring环境中管理事务的实践经验和熟练度。通过这些任务，您将深入了解配置事务、处理不同的传播行为、实现嵌套事务，并确保应用程序中的数据完整性。

## 练习任务

1. [事务设置](practice/configuration.md)
2. [第一部分：创建实体和存储库](practice/lessons/entities-and-repositories.md)
3. [第二部分：实现基本的事务操作](practice/lessons/basic-transactional-operations.md)
4. [第三部分：使用详细日志增强事务方法](practice/lessons/transactional-logging.md)
5. [第四部分：实现嵌套事务和非事务操作](practice/lessons/nested-and-non-transactional-operations.md)

## 实验任务

![img.png](../../srcs/transactions/task-chart.png)

- **为事件注册用户**
  - **任务：** 实现一个方法来为事件注册用户。确保该操作完全隔离，以保持数据一致性。无论主事务成功与否，都要单独记录此操作。
  - **传播：** REQUIRED
  - **隔离级别：** SERIALIZABLE
  - **日志传播：** REQUIRES_NEW

- **从事件中移除用户的注册**
  - **任务：** 实现一个方法来从事件中移除用户的注册。确保此方法始终在现有事务中执行。
  - **传播：** MANDATORY

- **获取某个事件的注册用户**
  - **任务：** 实现一个方法来获取特定事件的所有注册用户。确保该方法要么加入现有事务，要么创建一个新事务，只读取已提交的数据。
  - **传播：** REQUIRED
  - **隔离级别：** READ_COMMITTED

- **添加新事件**
  - **任务：** 实现一个方法来添加新事件。此操作应该没有事务保证，以避免不必要的事务开销。
  - **传播：** NOT_SUPPORTED

- **使用嵌套事务更新事件详情和注册**
  - **任务：** 实现一个方法来更新事件详情以及相关的注册信息。确保在嵌套事务中保持一致性。
  - **传播：** REQUIRED
  - **隔离级别：** REPEATABLE_READ
  - **嵌套任务：** 在嵌套事务中更新注册信息。

- **更新注册信息**
  - **任务：** 实现一个方法来更新注册记录。确保这些操作属于嵌套事务。
  - **传播：** NESTED
  - **隔离级别：** REPEATABLE_READ

- **执行非事务操作**
  - **任务：** 实现一个方法用于执行不需要事务上下文的操作，如非关键任务或日志记录。
  - **传播：** None