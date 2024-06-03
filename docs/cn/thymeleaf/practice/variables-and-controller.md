# 变量和控制器

**描述:**

在这个任务中，你将创建一个名为 `second.html` 的新的 Thymeleaf 视图，并探索从控制器传递变量到视图的概念。我们将不再在视图中定义标题为局部变量，而是通过控制器传递。

**步骤:**

1. **创建新的视图文件:**
   - 在 `/src/main/resources/templates/` 目录中创建一个名为 `second.html` 的新的 Thymeleaf 视图文件。

   ```plaintext
   项目目录
   └── src
       └── main
           └── resources
               └── templates
                   └── practice
                       └── second.html
   ```

2. **定义控制器:**
   - 在你的控制器类（例如 `PracticeController`）中，定义一个方法，将其映射到与新视图关联的 URL 路径。将所需的变量（例如 `title`）传递到模型中。

   ```java
   @Controller
   public class PracticeController {

       @GetMapping("/second")
       public String secondView(Model model) {
           // 将变量传递到视图
           model.addAttribute("title", "第二页");

           // 返回视图名称
           return "practice/second";
       }
   }
   ```

   此控制器方法将映射到 URL 路径 `/second`，并将变量 `title` 的值设置为 "第二页" 传递给 Thymeleaf 视图。

3. **更新视图以使用控制器传递的变量:**
   - 打开 `second.html` Thymeleaf 视图文件。
   - 在 `<h1>` 标签中使用从控制器传递的 `title` 变量。

   ```html
   <!DOCTYPE html>
   <html lang="en">
       <head>
           <meta charset="UTF-8">
           <title th:text="${title}">标题</title>
       </head>
       <body>
           <h1 th:text="${title}">欢迎来到第二页</h1>
           <!-- 在这里添加你的内容 -->
           <a th:href="@{'/'}">返回首页</a>
       </body>
   </html>
   ```

   `th:text="${title}"` 表达式检索从控制器传递的 `title` 变量的值。

---

# [下一个任务: *迭代*](iteration.md)