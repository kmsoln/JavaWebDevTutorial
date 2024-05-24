## 实体特性

### 学生实体特性：

- `id`（UUID）：实体的主键。
- `name`（String）：学生的姓名（不能为空）。
- `email`（String）：学生的电子邮件地址（必须是有效的电子邮件地址）。
- `major`（String）：学生的专业或研究领域（不能为空）。
- `year`（int）：学生的年级（不能为空）。
- `international`（boolean）：指示学生是否为国际学生（不能为空）。

### 定义 `id` 属性

向 `Student` 类添加 `id` 属性。该属性将作为实体的主键。

```java
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID id;
```

- `@Id`：表示该字段是实体的主键。
- `@GeneratedValue`：指定生成主键值的策略。

### 定义 `name` 属性

向 `Student` 类添加 `name` 属性。该属性表示学生的姓名，不能为空。

```java
@NotBlank
private String name;
```

- `@NotBlank`：确保 `name` 的值不为 null 并包含至少一个非空白字符。

### 定义 `email` 属性

向 `Student` 类添加 `email` 属性。该属性表示学生的电子邮件地址，必须是有效的电子邮件地址。

```java
@NotBlank
@Email
private String email;
```

- `@Email`：验证 `email` 的值是否为有效的电子邮件地址。

### 定义 `major` 属性

向 `Student` 类添加 `major` 属性。该属性表示学生的专业或研究领域，不能为空。

```java
@NotBlank
private String major;
```

- `@NotBlank`：确保 `major` 的值不为 null 并包含至少一个非空白字符。

### 定义 `year` 属性

向 `Student` 类添加 `year` 属性。该属性表示学生的年级，不能为空。

```java
@NotNull
private int year;
```

- `@NotNull`：确保 `year` 的值不为 null。

### 定义 `international` 属性

向 `Student` 类添加 `international` 属性。该属性表示学生是否为国际学生，不能为空。

```java
@NotNull
private boolean international;
```

- `@NotNull`：确保 `international` 的值不为 null。

您可以重复上述步骤，为 `Course` 和 `Enrollment` 实体创建实体特性，确保为每个属性应用适当的注释。

### Enrollment 实体特性：

- `id`（UUID）：实体的主键。
- `enrollmentDate`（Date）：注册日期。
- `grade`（int）：课程中获得的成绩。

### Course 实体特性：

- `id`（UUID）：实体的主键。
- `name`（String）：课程名称。
- `instructor`（String）：课程讲师姓名。
- `schedule`（String）：课程的安排详情。
- `capacity`（int）：课程的最大容量。
- `online`（boolean）：指示课程是否在线。
- `startDate`（Date）：课程的开始日期。
---

# [下一步：管理关系](relationships.md)