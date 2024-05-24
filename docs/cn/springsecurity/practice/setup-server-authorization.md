# 设置服务器授权

这个任务指导您通过使用Spring Security配置安全规则来设置应用程序的授权。通过定义授权规则，您可以控制对应用程序中特定路径和端点的访问权限。

## 目标

配置授权规则，以限制或允许访问应用程序中的各种路径和端点。

## 步骤

1. **添加安全配置:**

   在 `WebSecurityConfig` 类中，添加 `configure(HttpSecurity http)` 方法来为应用程序定义安全规则。我们将使用上一个实验任务中定义的路径和端点。

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   .requestMatchers("/first").permitAll()
                   .requestMatchers("/second").permitAll()
                   .requestMatchers("/third").permitAll()
                   .requestMatchers("/fourth").permitAll()
                   .requestMatchers("/addStudent").permitAll()
                   .requestMatchers("/removeStudent").permitAll()
               );
       }
   }
   ```

   在这个配置中:
   - 我们使用 `.authorizeHttpRequests()` 来定义授权规则。
   - 在 lambda 表达式中，我们指定了哪些请求应该被允许。
---

# [下一个任务：授权经过身份验证的用户](authorize-server-authenticated.md)