# 基于角色授权用户（客户端）

本任务概述了如何在客户端视图中根据用户的角色对用户进行授权，使用Thymeleaf来实现。通过根据用户角色显示或隐藏元素，您可以控制特定功能或操作的可见性。

## 目标

在Thymeleaf视图中根据用户的角色控制与添加和删除学生相关的元素的可见性。

## 步骤

1. **更新Thymeleaf模板：**

   修改Thymeleaf模板以根据用户的角色有条件地显示元素。

   ```html
   <!DOCTYPE html>
   <html xmlns:th="http://www.thymeleaf.org">
   <head>
       <title>学生管理</title>
   </head>
   <body>
       <h1>学生管理</h1>

       <!-- 添加学生按钮 -->
       <div th:if="${#authorization.expression('hasRole(''ROLE_ADMIN'')')}">
           <a href="/addStudent" class="btn btn-primary">添加学生</a>
       </div>

       <!-- 删除学生按钮 -->
       <div th:if="${#authorization.expression('hasRole(''ROLE_MANAGER'')')}">
           <a href="/removeStudent" class="btn btn-danger">删除学生</a>
       </div>

       <!-- 其他内容 -->
       <div>
           <p>欢迎使用学生管理系统。在这里您可以管理学生记录。</p>
       </div>
   </body>
   </html>
   ```

   在此模板中：
    - 使用`th:if="${#authorization.expression('hasRole(''ROLE_ADMIN'')')}"`语句仅在用户具有`ROLE_ADMIN`角色时条件显示“添加学生”按钮。
    - 同样，使用`th:if="${#authorization.expression('hasRole(''ROLE_MANAGER'')')}"`语句仅在用户具有`ROLE_MANAGER`角色时条件显示“删除学生”按钮。

## 解释

- **Thymeleaf安全方言**：`#authorization`对象是Thymeleaf安全方言的一部分，它将Spring Security与Thymeleaf集成在一起。
- **条件显示**：使用`th:if`属性根据用户的角色有条件地显示或隐藏元素。

通过按照这些步骤，您可以根据用户的角色控制Thymeleaf视图中元素的可见性，确保只有授权用户才能看到和与特定功能进行交互。

---

# [下一个任务：根据权限授权用户](authorize-client-authority.md)