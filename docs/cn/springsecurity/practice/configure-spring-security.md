# 配置 Spring Security

在本任务中，我们将重点配置项目中的 Spring Security。Spring Security 为 Java 应用程序提供全面的安全功能，包括认证、授权和防止常见安全威胁的保护。

## 目标

本任务的目标是将 Spring Security 集成到现有项目中，确保应用程序的安全性，防止未授权访问。

## 步骤

1. **添加 Spring Security 依赖**

   - 对于 Maven 项目：

     在项目的 `pom.xml` 文件中添加以下依赖：

     ```xml
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-security</artifactId>
     </dependency>
     ```

   - 对于 Gradle 项目：

     在项目的 `build.gradle` 文件中添加以下依赖：

     ```groovy
     implementation 'org.springframework.boot:spring-boot-starter-security'
     ```

   确保包含项目适用的 Spring Security 版本。

2. **创建安全配置类**

   在项目的源码文件夹结构中创建一个名为 `WebSecurityConfig` 的新 Java 类。通常，该类位于 `config` 包中。文件应命名为 `WebSecurityConfig.java`。

   项目的文件夹结构应类似如下：

   ```
   src
   └── main
       └── java
           └── edu
               └── labs
                   └── yourproject
                       ├── config
                       │   └── WebMvcConfig.java
                       │   └── WebSecurityConfig.java
                       └── controller
                           └── PracticeController.java
   ```

3. **配置安全配置类**

   在 `WebSecurityConfig` 类内部，用 `@Configuration` 和 `@EnableWebSecurity` 注解对其进行标注，以表明这是 Spring Security 的配置类。同时，用 `@Bean` 注解标注 `configure` 方法。

   ```java
   package edu.labs.yourproject.config;

   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.security.config.annotation.web.builders.HttpSecurity;
   import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
   import org.springframework.security.web.SecurityFilterChain;

   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig {

       @Bean
       public SecurityFilterChain configure(HttpSecurity http) throws Exception {
           http
               // 在这里进行安全配置
               .authorizeRequests()
                   .anyRequest().authenticated()
                   .and()
               .formLogin()
                   .and()
               .httpBasic();
           return http.build();
       }
   }
   ```

   上述配置示例中：
   - `.authorizeRequests()` 方法用于定义授权规则。
   - `.anyRequest().authenticated()` 表示所有请求都需要认证。
   - `.formLogin()` 和 `.httpBasic()` 启用表单登录和基本 HTTP 认证。

---

# [下一任务: 为用户创建基础实现](base-implementation-user.md)