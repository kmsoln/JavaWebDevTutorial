# 表单处理

**描述:**

在这个续集中，我们将专注于处理表单提交并使用 `PracticeController` 渲染视图。这涉及在显示视图时将模型传递给视图，并实现处理表单提交的逻辑。

**步骤:**

1. **显示表单视图（PracticeController）:**

   - 打开 `PracticeController` 类并添加一个方法来显示表单视图：

     ```java
     import org.springframework.stereotype.Controller;
     import org.springframework.ui.Model;
     import org.springframework.web.bind.annotation.GetMapping;

     @Controller
     public class PracticeController {

         // 其他方法...

         @GetMapping("/third")
         public String showAddStudentForm(Model model) {
             model.addAttribute("model", new StudentModel());
             return "practice/third";
         }
     }
     ```

   - 解释:
      - `@GetMapping("/addStudentForm")`: 这个注解将方法映射到处理 `/addStudentForm` 端点的 GET 请求。
      - `showAddStudentForm(Model model)`: 这个方法接受一个 `Model` 参数，向其添加一个新的 `StudentModel`，并返回视图名称（在这种情况下为 `"thirdView"`）。更新以反映视图的正确命名。
      - `Model` 被填充了一个新的 `StudentModel` 实例，该实例将用于绑定表单字段。

2. **处理表单提交（PracticeController）:**

   - 在 `PracticeController` 中添加一个方法来处理表单提交：

     ```java
     import org.springframework.stereotype.Controller;
     import org.springframework.ui.Model;
     import org.springframework.web.bind.annotation.*;

     import java.util.ArrayList;
     import java.util.List;

     @Controller
     public class PracticeController {

         private final List<StudentModel> students = new ArrayList<>();

         // 其他方法...

         @PostMapping("/addStudent")
         public String addStudent(@ModelAttribute("model") StudentModel model) {
             students.add(model);

             return "redirect:/third";
         }
     }
     ```

   - 解释:
      - `@PostMapping("/addStudent")`: 这个注解将方法映射到处理 `/addStudent` 端点的 POST 请求。
      - `addStudent(@ModelAttribute("model") StudentModel model)`: 这个方法从表单提交中获取 `model` 属性（`@ModelAttribute`），并处理它。表单数据会自动绑定到 `model` 对象。
      - 此方法内的逻辑将学生添加到 `students` 列表中。在实际情况下，您通常会将学生保存到数据库或执行其他必要的操作。
      - `return "redirect:/third";`: 此行将用户重定向回表单视图（`/third`）。

---

# [下一个任务: *查询参数和验证*](validation.md)