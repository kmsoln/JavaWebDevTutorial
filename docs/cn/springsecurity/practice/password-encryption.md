# 密码加密

在这个任务中，我们将为Spring Security启用的应用程序中的用户身份验证配置密码加密。通过加密密码，可以通过安全地存储它们在数据库中来增强安全性。

## 目标

此设置的目标是使用Spring Security提供的BCryptPasswordEncoder配置密码加密。这样可以确保在将密码存储在数据库之前对其进行安全哈希处理。

## 步骤

1. **添加 BCryptPasswordEncoder Bean**

   打开位于项目的配置包（`edu.labs.yourproject.config`）中的 `WebSecurityConfig` 类。在这个类中，为 BCryptPasswordEncoder 定义一个 bean。

   ```java
   package edu.labs.yourproject.config;

   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

   @Configuration
   public class WebSecurityConfig {

       @Bean
       public BCryptPasswordEncoder passwordEncoder() {
           // 实例化和配置 BCryptPasswordEncoder bean
           return new BCryptPasswordEncoder();
       }
   }
   ```

   定义一个名为 `passwordEncoder()` 的 bean 方法，它实例化并配置了一个 BCryptPasswordEncoder bean。这个 bean 将用于在将密码存储在数据库之前对其进行编码。

2. **加密密码**

   a. **更新 CustomUserDetailsService 类**

   打开位于项目的服务包（`edu.labs.yourproject.service`）中的 `CustomUserDetailsService` 类。将 BCryptPasswordEncoder bean 注入到这个类中。

      ```java
      package edu.labs.yourproject.service;

      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
      import org.springframework.stereotype.Service;
      import edu.labs.yourproject.model.CustomUserDetails;
      import edu.labs.yourproject.repository.UsersRepository;

      @Service
      public class CustomUserDetailsService implements UserDetailsService {

          private final UsersRepository usersRepository;

          @Autowired
          private BCryptPasswordEncoder passwordEncoder;

          @Autowired
          public CustomUserDetailsService(UsersRepository usersRepository) {
              this.usersRepository = usersRepository;
          }
      }
      ```

   b. **实现注册方法**

   在 `CustomUserDetailsService` 类中定义一个方法来处理用户注册。在这个方法中，加密用户的密码然后保存到数据库中。

      ```java
          public void registerUser(CustomUserDetails user) {
              // 保存用户之前加密密码
              String encodedPassword = passwordEncoder.encode(user.getPassword());
              user.setPassword(encodedPassword);
              usersRepository.save(user);
          }
      ```

   此方法接受一个表示要注册的用户的 CustomUserDetails 对象。它使用 BCryptPasswordEncoder bean 对用户的密码进行加密，然后将用户保存到数据库中。

---
# [下一个任务：添加虚拟用户](add-dummy-users.md)