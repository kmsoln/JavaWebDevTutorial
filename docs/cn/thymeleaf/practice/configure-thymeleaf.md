# 在Spring中配置Thymeleaf

**描述:**

此任务涉及在Spring应用程序中设置Thymeleaf，实现模板引擎与Web开发的无缝集成。

## 步骤:

1. **创建Thymeleaf配置类:**
   - 在您的Spring项目中，创建一个带有 `@Configuration` 注解的新Java类。我们建议将此类放置在 `config` 包中。
   - 将该类扩展为 `WebMvcConfigurer`。

   示例:

   ```java
   package edu.labs.thymeleaf.config;

   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

   @Configuration
   public class WebMvcConfig implements WebMvcConfigurer {
       // 配置代码放在这里
   }
   ```

   将配置类放置在 `config` 包中有助于组织，并确保项目结构清晰。根据项目的结构调整包名称。

2. **配置Thymeleaf模板解析器:**
   - 定义一个带有 `@Bean` 注解的方法，以配置Thymeleaf模板解析器。
   - 使用 `ClassLoaderTemplateResolver`，设置前缀、后缀、模板模式和字符编码。

      ```java
      @Bean
      public ClassLoaderTemplateResolver templateResolver() {
          // 创建一个 ClassLoaderTemplateResolver bean
          ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
       
          // 设置Thymeleaf查找模板的路径
          templateResolver.setPrefix("/templates/");
       
          // 设置模板的文件扩展名
          templateResolver.setSuffix(".html");
       
          // 设置模板模式为HTML
          templateResolver.setTemplateMode(TemplateMode.HTML);
       
          // 设置模板的字符编码
          templateResolver.setCharacterEncoding("UTF-8");

          // 返回配置的模板解析器bean
          return templateResolver;
      }
      ```

3. **配置消息源:**
   - 添加一个带有 `@Bean` 注解的方法，使用 `ReloadableResourceBundleMessageSource` 配置消息源。
   - 设置默认编码。

      ```java
      @Bean
      public MessageSource messageSource() {
          // 创建一个 ReloadableResourceBundleMessageSource bean
          ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
       
          // 设置消息的默认编码
          messageSource.setDefaultEncoding("UTF-8");

          // 返回配置的消息源bean
          return messageSource;
      }
      ```

4. **配置Thymeleaf视图解析器:**
   - 创建一个带有 `@Bean` 注解的方法，以配置Thymeleaf视图解析器。
   - 设置模板引擎。

      ```java
      @Bean
      public ViewResolver thymeleafViewResolver() {
          // 创建一个 ThymeleafViewResolver bean
          ThymeleafViewResolver resolver = new ThymeleafViewResolver();
       
          // 设置视图解析器的模板引擎
          resolver.setTemplateEngine(templateEngine());

          // 返回配置的 ThymeleafViewResolver bean
          return resolver;
      }
      ```

5. **配置Thymeleaf模板引擎:**
   - 实现一个带有 `@Bean` 注解的方法，以配置Thymeleaf模板引擎。
   - 设置模板解析器和模板引擎消息源。

      ```java
      @Bean
      public SpringTemplateEngine templateEngine() {
          // 创建一个 SpringTemplateEngine bean
          SpringTemplateEngine templateEngine = new SpringTemplateEngine();
       
          // 为模板引擎设置模板解析器
          templateEngine.setTemplateResolver(templateResolver());
       
          // 设置模板引擎消息源
          templateEngine.setTemplateEngineMessageSource(messageSource());

          // 返回配置的 SpringTemplateEngine bean
          return templateEngine;
      }
      ```

---

# [下一步任务：*创建第一个视图*](create-first-view.md)