# 自定义登录表单

该任务指导您通过使用Spring Security实现自定义登录表单来启用身份验证。通过实现自定义登录表单，用户可以安全地登录到您的应用程序中。

## 目标

激活已经创建的自定义登录页面，并将其设置在指定的路径上。

## 步骤

1. **更新安全配置：**

   在 `WebSecurityConfig` 类中，修改 `configure(HttpSecurity http)` 方法以指定自定义登录页面。

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // 在此添加其他授权配置
               )
               .formLogin((login) -> login
                   .loginPage("/custom-login-page") // 指定自定义登录页面的URL
                   // 在此添加其他表单登录配置
               );
       }
   }
   ```

   在此配置中：
   - `.loginPage("/custom-login-page")` 语句指定了自定义登录页面的URL。
   - 您可以添加其他配置以自定义表单登录行为，例如设置登录成功或失败的URL，定义表单字段名称等。

---

# [任务列表](../lab-work.md)