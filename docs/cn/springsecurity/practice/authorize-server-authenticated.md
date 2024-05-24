# 授权已认证用户

本任务概述了在应用中授权已认证用户的过程。通过为特定路径或端点要求认证，可以确保只有已登录的用户才能访问某些资源。

## 目标

仅允许已认证用户访问 `/second` 路径，同时允许其他路径的公共访问。

## 步骤

1. **更新安全配置:**

   在 `WebSecurityConfig` 类中，修改 `configure(HttpSecurity http)` 方法，指定访问 `/second` 路径应仅限于已认证用户。

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // 其他端点...
                   .requestMatchers("/second").authenticated()
                   // 其他端点...
               );
       }
   }
   ```

   在此配置中：
   - 我们使用 `.authorizeHttpRequests()` 定义授权规则。
   - `.requestMatchers("/second").authenticated()` 语句指定访问 `/second` 路径应仅限于已认证用户。

---

# [下一任务: 按角色授权](authorize-server-role.md)