# 按权限授权

本任务概述了在应用中基于用户权限进行授权的过程。通过为用户分配不同的权限，可以控制对特定功能或操作的访问。

## 目标

为具有 `WRITE` 权限的用户授权访问 `/addStudent` 路径，为具有 `DELETE` 权限的用户授权访问 `/removeStudent` 路径。

## 步骤

1. **更新安全配置:**

   在 `WebSecurityConfig` 类中，修改 `configure(HttpSecurity http)` 方法，指定基于权限的访问控制 `/addStudent` 和 `/removeStudent` 路径。

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // 其他端点...
                   .requestMatchers("/addStudent").hasAuthority("WRITE")
                   .requestMatchers("/removeStudent").hasAuthority("DELETE")
                   // 其他端点...
               );
       }
   }
   ```

   在此配置中：
   - `.requestMatchers("/addStudent").hasAuthority("WRITE")` 语句指定访问 `/addStudent` 路径应限于具有 `WRITE` 权限的用户。
   - 类似地，`.requestMatchers("/removeStudent").hasAuthority("DELETE")` 限制访问 `/removeStudent` 路径仅限于具有 `DELETE` 权限的用户。

---

# [下一任务: 自定义登录表单](custom-login-form.md)