# 按角色授权

本任务概述了在应用中基于用户角色进行授权的过程。通过为用户分配不同的角色，可以控制对特定资源或功能的访问。

## 目标

为具有 `ROLE_MODERATOR` 角色的用户授权访问 `/third` 路径，为具有 `ROLE_ADMIN` 角色的用户授权访问 `/fourth` 路径。

## 步骤

1. **更新安全配置:**

   在 `WebSecurityConfig` 类中，修改 `configure(HttpSecurity http)` 方法，指定基于角色的访问控制 `/third` 和 `/fourth` 路径。

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // 其他端点...
                   .requestMatchers("/third").hasAuthority("ROLE_MODERATOR")
                   .requestMatchers("/fourth").hasAuthority("ROLE_ADMIN")
                   // 其他端点...
               );
       }
   }
   ```

   在此配置中：
   - `.requestMatchers("/third").hasAuthority("ROLE_MODERATOR")` 语句指定访问 `/third` 路径应限于具有 `ROLE_MODERATOR` 权限的用户。
   - 类似地，`.requestMatchers("/fourth").hasAuthority("ROLE_ADMIN")` 限制访问 `/fourth` 路径仅限于具有 `ROLE_ADMIN` 权限的用户。

---

# [下一任务: 按权限授权](authorize-server-authority.md)