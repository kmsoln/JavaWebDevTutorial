# Spring Boot中的获取策略与JPA：理解懒加载和急加载

## 介绍

本指南探讨了在使用JPA（Java Persistence API）的Spring Boot项目中的获取策略。具体来说，我们将深入研究懒加载和急加载的概念以及它们在实体关系中的应用。

## 目标

本指南的目标是全面了解JPA中的获取策略。通过本指南，您将了解何时使用懒加载和急加载以及如何在应用程序中实现它们。

## 获取策略

### 场景

在我们的实体关系中，`Student` 实体和 `Enrollment` 实体之间存在一对多的关系。同样，`Course` 实体和 `Enrollment` 实体之间也存在一对多的关系。

#### Student 实体

在 `Student` 实体中，我们与 `Enrollment` 实体之间存在一对多的关系。每个学生可以有多个注册。

为了表示这种关系，我们在 `Student` 实体中使用了 `@OneToMany` 注解，并指定了 `mappedBy = "student"`。在这里，我们可以选择懒加载和急加载策略来获取关联的注册。

```java
@OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
private List<Enrollment> enrollments;
```

在这种情况下，我们选择了急加载（`FetchType.EAGER`）。由于我们通常期望一次访问一个学生的所有注册，急加载确保在加载学生时立即获取所有注册。

#### Course 实体

类似地，在 `Course` 实体中，我们还与 `Enrollment` 实体存在一对多的关系。每个课程可以有多个注册。

为了表示这种关系，我们在 `Course` 实体中使用了 `@OneToMany` 注解，并指定了 `mappedBy = "course"`。在这里，我们可以选择另一种懒加载和急加载策略来获取关联的注册。

```java
@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Enrollment> enrollments;
```

在这种情况下，我们选择了懒加载（`FetchType.LAZY`）。由于我们可能并不总是需要访问一个课程的所有注册，懒加载确保只有在明确请求时才获取注册。

---

# [下一步：创建存储库](../interacting/repository.md)