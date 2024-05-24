# 为用户创建身份

本任务概述了在“添加模拟用户”步骤中为用户添加权限和角色的过程。通过为用户分配角色和权限，我们在应用程序中建立了他们的身份，并控制他们对各种资源和功能的访问。

## 目标

通过为之前创建的用户配置角色和权限来增强用户配置文件，从而在应用程序中定义他们的身份和访问权限。

## 步骤

1. **为用户配置文件添加角色和权限：**

   我们将更新在 `CustomUserDetailsService` 类中创建的模拟用户配置文件，以包含角色和权限。这涉及为每个用户分配特定的角色，例如 `ADMIN`、`MODERATOR` 或 `USER`，并根据他们的角色授予相应的权限。

   ```java
   // 在 addDummyUsers() 方法内

   // 定义角色
   String adminRole = "ROLE_ADMIN";
   String moderatorRole = "ROLE_MODERATOR";
   String userRole = "ROLE_USER";

   // 定义权限
   List<GrantedAuthority> adminAuthorities = Arrays.asList(
       new SimpleGrantedAuthority(adminRole),
       new SimpleGrantedAuthority("READ"),
       new SimpleGrantedAuthority("WRITE")
   );

   List<GrantedAuthority> moderatorAuthorities = Arrays.asList(
       new SimpleGrantedAuthority(moderatorRole),
       new SimpleGrantedAuthority("READ")
   );

   List<GrantedAuthority> userAuthorities = Collections.singletonList(
       new SimpleGrantedAuthority(userRole)
   );

   // 创建包含角色和权限的模拟用户
   CustomUserDetails admin = new CustomUserDetails("admin", passwordEncoder.encode("admin"), true, true, true, true);
   admin.setAuthorities(adminAuthorities);
   admin.setRole(adminRole);

   CustomUserDetails moderator = new CustomUserDetails("moderator", passwordEncoder.encode("moderator"), true, true, true, true);
   moderator.setAuthorities(moderatorAuthorities);
   moderator.setRole(moderatorRole);

   CustomUserDetails user = new CustomUserDetails("user", passwordEncoder.encode("user"), true, true, true, true);
   user.setAuthorities(userAuthorities);
   user.setRole(userRole);
   ```

   在这段更新的代码中：
   - 我们定义了角色和权限变量，以便清晰和便于维护。
   - 每个用户配置文件现在都包含一个基于其分配角色的权限列表。
   - 权限表示为 `SimpleGrantedAuthority` 对象，并相应地添加到用户配置文件中。
   - 另外，我们为每个用户设置了角色，以便在后续步骤中实现基于角色的访问控制。

---

# [下一任务：在服务器中创建授权基础](setup-server-authorization.md)