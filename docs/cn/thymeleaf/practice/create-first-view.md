# 创建第一个视图

**描述:**

在这个任务中，我们将为您的Spring应用程序创建第一个Thymeleaf视图。按照Thymeleaf配置中定义的正确文件路径，并在应用程序中注册视图。

## **步骤:**

1. **创建视图文件:**
   - 导航到Thymeleaf配置中指定的目录，该目录是模板的前缀。
   - 默认情况下，配置的前缀是 `/templates/`。因此，请在此目录中创建您的Thymeleaf视图文件。

   ```plaintext
   项目目录
   └── src
       └── main
           └── resources
               └── templates
                   └── practice
                       └── first.html
   ```

   确保视图文件的命名合适（例如，`first.html`）。`/templates/` 目录对于Thymeleaf正确定位和处理您的模板非常重要。

2. **在配置类中注册视图:**
   - 打开设置Thymeleaf的配置类（例如，`WebMvcConfig`）。
   - 添加以下方法以注册Thymeleaf视图：

   ```java
   public void addViewControllers(ViewControllerRegistry registry) {
       // 第一个视图
       registry.addViewController("/first").setViewName("practice/first");
   }
   ```

   此方法将 URL 路径 `/first` 映射到名为 "practice/first" 的 Thymeleaf 视图。根据项目结构调整路径。

3. **测试视图:**
   - 运行您的Spring应用程序。
   - 打开Web浏览器，导航到 `http://localhost:8080/first`。您应该看到渲染的Thymeleaf视图。

4. **可选: 配置从根路径的重定向:**
   - 要将第一个视图设置为默认页面，您可以在 `addViewControllers` 方法中添加从根路径 ("/") 到第一个视图路径的重定向：

   ```java
   public void addViewControllers(ViewControllerRegistry registry) {
       // 第一个视图
       registry.addViewController("/first").setViewName("practice/first");
       
       // 从根路径重定向到第一个视图
       registry.addRedirectViewController("/", "/first");
   }
   ```

   现在，访问 `http://localhost:8080/` 将自动重定向到第一个视图。

---

# [下一个任务: *使用变量*](working-with-variables.md)