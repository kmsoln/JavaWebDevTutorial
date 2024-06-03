[English](../../en/jpa/lab-work.md) | 中文 | [Русский](../../ru/jpa/lab-work.md)

# 实验任务: JPA (Java Persistence API)

欢迎来到 Spring Boot with JPA 实验任务！在这个实验中，您将练习与使用 Spring Boot 和 JPA (Java Persistence API) 相关的各种任务。

## 实验任务的目标

这个实验的目标是提供与 Spring Boot 和 JPA 相关的关键概念和任务的实践经验。通过完成练习任务，您将掌握设置依赖关系、定义实体特性、管理实体之间关系以及使用 JpaRepository 与数据库交互等方面的技能。

## 练习任务

1. **设置数据库依赖关系**
   - [设置数据库驱动程序](practice/dependencies/driver.md)
   - [Spring Boot 和 JPA 依赖关系](practice/dependencies/jpa.md)

2. **实体创建、特性、关系和获取策略**
   - [创建实体](practice/creation/create-entity.md)
   - [定义实体特性](practice/creation/characteristics.md)
   - [管理关系](practice/creation/relationships.md)
   - [获取策略](practice/creation/fetching.md)

3. **与自定义存储库交互**
   - [创建记录](practice/interacting/repository/create.md)
   - [读取记录](practice/interacting/repository/read.md)
   - [更新记录](practice/interacting/repository/update.md)
   - [删除记录](practice/interacting/repository/delete.md)
   - [自定义查询](practice/interacting/repository/query.md)

4. **与 JPA 存储库交互**
   - [创建记录](practice/interacting/jpa-repository/create.md)
   - [读取记录](practice/interacting/jpa-repository/read.md)
   - [删除记录](practice/interacting/jpa-repository/delete.md)
   - [自定义查询](practice/interacting/jpa-repository/query.md)


## 实验任务

1. 为 PostgreSQL、MySQL、Oracle、MongoDB 和 Microsoft SQL Server 设置数据库依赖关系。

2. 实现下一个实体关系图:
   ![img.png](../../srcs/jpa/task-er-diagram.png)

   1. 根据实体关系图定义 Student、Enrollment 和 Course 实体的特性。

   2. 根据定义的特性创建 Student、Enrollment 和 Course 实体类。

   3. 实现有效的数据检索获取策略，以优化数据库交互。

   4. 通过建立适当的关联和映射，管理实体之间的关系，如 Student、Enrollment 和 Course。

   5. 通过在至少两个存储库中使用 Repository 层和 EntityManager，创建用于 CRUD 操作的方法，与数据库进行交互。

   6. 通过在至少两个存储库中使用 JpaRepository，创建用于 CRUD 操作的方法，与数据库进行交互。

   7. 根据应用程序的业务逻辑需求，实现自定义查询，执行高级数据检索和操作。