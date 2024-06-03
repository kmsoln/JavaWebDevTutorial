# 字面值

**描述:**

在这个任务中，您将通过在 `second.html` Thymeleaf 视图中引入字面值来增强视图，以根据特定条件显示修改后的值。字面值包括将常量值添加到 `id`，在“Graduated”字段中显示“是”或“否”，以及为“Mark”和“Diploma Type”字段提供描述性标签。

**步骤:**

1. **更新 second.html 中的 students-table 片段:**
   - 打开 `second.html` Thymeleaf 视图文件。

2. **增强学生 ID 的字面值:**
   - 修改 `id` 字段的表达式，将常量值（例如 100000）添加到实际学生 ID。

   ```html
   <td th:text="${student.id + 100000}"></td>
   ```

3. **增强 Graduated 字段的字面值:**
   - 更新“Graduated”字段的表达式，如果学生毕业，则显示“是”，否则显示“否”。

   ```html
   <td th:text="${student.isGraduated ? '是' : '否'}"></td>
   ```

4. **增强 Mark 字段的字面值:**
   - 添加条件表达式，根据学生的分数显示“Mark”字段的描述性标签。

   ```html
   <td th:if="${student.mark == 3}">良好</td>
   <td th:if="${student.mark == 4}">很好</td>
   <td th:if="${student.mark == 5}">优秀</td>
   <td th:if="${student.mark == 1 or student.mark == 2}">未通过</td>
   ```

5. **为 Diploma Type 字段添加字面值:**
   - 添加条件表达式，根据学生的分数和毕业状态显示“Diploma Type”字段的描述性标签。

   ```html
   <td th:if="${student.mark == 3 and student.isGraduated}">蓝色</td>
   <td th:if="${student.mark == 4 and student.isGraduated}">蓝色</td>
   <td th:if="${student.mark == 5 and student.isGraduated}">红色</td>
   <td th:if="${student.mark == 1 or student.mark == 2 or not student.isGraduated}">无毕业证书</td>
   ```

## 结果
您的页面应如下所示:

![second-view-enhanced.png](../../../srcs/thymeleaf/second-view-enhanced.png)

---

# [下一个任务：*表单*](forms.md)