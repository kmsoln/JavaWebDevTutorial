# 配置 Thymeleaf 与 Spring Security 集成

## 目标
本任务的目标是将 Thymeleaf 与 Spring Security 集成，利用 `thymeleaf-extras-springsecurity6` 库提供的额外 Thymeleaf 方言和实用程序。

## 步骤

1. **Gradle (Groovy):**

   在 `build.gradle` 文件中添加 `thymeleaf-extras-springsecurity6` 依赖：

   ```groovy
   implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.0.4.RELEASE'
   ```

2. **Maven:**

   在 `pom.xml` 文件中添加以下依赖：

   ```xml
   <dependency>
       <groupId>org.thymeleaf.extras</groupId>
       <artifactId>thymeleaf-extras-springsecurity6</artifactId>
       <version>3.0.4.RELEASE</version>
   </dependency>
   ```

---

[下一任务：]()