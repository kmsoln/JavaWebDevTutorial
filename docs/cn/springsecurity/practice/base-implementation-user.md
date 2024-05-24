# 为用户创建基础实现

在本任务中，我们将专注于为应用中的用户管理创建基础实现。这包括定义 UserDetails 实体，创建管理用户数据的存储库，以及实现 UserDetailsService 以在认证过程中加载用户详情。

## 目标

本任务的目标是在应用中建立一个稳固的用户管理基础。通过实现 UserDetails、UsersRepository 和 UserDetailsService，您将能够对用户进行认证、管理其详情，并高效地执行与用户相关的操作。

## 步骤

1. **定义 UserDetails 实体**

   首先，定义一个代表应用中用户详情的 UserDetails 实体。该实体应实现 Spring Security 提供的 UserDetails 接口。

   ```java
   package edu.labs.yourproject.model;

   import org.springframework.security.core.GrantedAuthority;
   import org.springframework.security.core.userdetails.UserDetails;

   import java.util.Collection;

   public class CustomUserDetails implements UserDetails {
   
       // 在这里实现 UserDetails 方法
   
   }
   ```

   实现 UserDetails 接口所需的方法，以提供用户名、密码、权限等用户详情。

2. **创建 UsersRepository 类**

   由于我们目前使用内存存储，将创建一个简单的 UsersRepository 类来管理用户数据。

   a. **创建 UsersRepository 类**

   在 `edu.labs.yourproject.repository` 包中创建一个名为 `UsersRepository` 的新 Java 类。

   ```java
   package edu.labs.yourproject.repository;

   import org.springframework.stereotype.Repository;
   import edu.labs.yourproject.model.CustomUserDetails;
   import java.util.ArrayList;
   import java.util.List;

   @Repository
   public class UsersRepository {

       private List<CustomUserDetails> users = new ArrayList<>();

       // 根据需要添加管理用户的方法
   }
   ```

   该类将作为管理用户数据的存储库。稍后我们将添加检索、添加、更新和删除用户的方法。

   b. **添加 findByUsername 方法**

   在 `UsersRepository` 类中添加一个名为 `findByUsername` 的方法。该方法将根据用户名从存储库中检索用户详情。

   ```java
   public CustomUserDetails findByUsername(String username) {
       for (CustomUserDetails user : users) {
           if (user.getUsername().equals(username)) {
               return user;
           }
       }
       return null; // 用户未找到
   }
   ```

   `findByUsername` 方法用于根据用户名从存储库中检索用户详情。在此占位实现中，它返回 `null`，但稍后您将用实际的逻辑来替换它，以从数据库或其他数据源中获取用户详情。

3. **实现 UserDetailsService**

   在此步骤中，我们将实现一个 UserDetailsService 以在认证过程中加载用户详情。该服务将从 UsersRepository 中检索用户信息。

   a. **创建 CustomUserDetailsService 类**

   首先，在项目的服务包中创建一个名为 `CustomUserDetailsService` 的新类。该类将实现 Spring Security 提供的 UserDetailsService 接口。

   ```java
   package edu.labs.yourproject.service;

   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.security.core.userdetails.UserDetails;
   import org.springframework.security.core.userdetails.UserDetailsService;
   import org.springframework.security.core.userdetails.UsernameNotFoundException;
   import org.springframework.stereotype.Service;
   import edu.labs.yourproject.model.CustomUserDetails;
   import edu.labs.yourproject.repository.UsersRepository;

   @Service
   public class CustomUserDetailsService implements UserDetailsService {

       private final UsersRepository usersRepository;

       @Autowired
       public CustomUserDetailsService(UsersRepository usersRepository) {
           this.usersRepository = usersRepository;
       }

       // 在这里实现方法
   }
   ```

   我们创建了 `CustomUserDetailsService` 类，并使用构造函数注入的方式自动装配 `UsersRepository` 依赖。

   b. **重写 loadUserByUsername 方法**

   重写 UserDetailsService 接口中定义的 `loadUserByUsername` 方法。该方法将根据提供的用户名从 UsersRepository 中检索用户详情。

   ```java
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       // 从内存存储库中检索用户详情
       CustomUserDetails userDetails = usersRepository.findByUsername(username);
       if (userDetails == null) {
           throw new UsernameNotFoundException("User not found with username: " + username);
       }
       return userDetails;
   }
   ```

   在 `loadUserByUsername` 方法中，我们调用 UsersRepository 的 `findByUsername` 方法，根据用户名检索用户详情。如果未找到用户，我们抛出一个 UsernameNotFoundException。

4. **在 WebSecurityConfig 中配置 Bean**

   打开位于项目配置包中的 WebSecurityConfig 类 (`edu.labs.yourproject.config`)。在此类中，定义 CustomUserDetails 和 UserDetailsRepository 的 bean。

   ```java
   package edu.labs.yourproject.config;

   import edu.labs.yourproject.service.CustomUserDetailsService;
   import edu.labs.yourproject.repository.UsersRepository;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
   import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       // 其他代码...

       @Bean
       public CustomUserDetailsService customUserDetailsService() {
           // 实例化并配置 CustomUserDetailsService bean
           return new CustomUserDetailsService(usersRepository());
       }

       @Bean
       public UsersRepository usersRepository() {
           // 实例化并配置 UsersRepository bean
           return new UsersRepository();
       }
   }
   ```

   定义两个 bean 方法：`customUserDetailsService()` 和 `usersRepository()`。这些方法分别实例化并配置 CustomUserDetailsService 和 UsersRepository bean。

## 文件夹结构

项目的文件夹结构应类似如下：

```
src
└── main
    └── java
        └── edu
            └── labs
                └── yourproject
                    ├── model
                    │   └── CustomUserDetails.java
                    ├── repository
                    │   └── UsersRepository.java
                    └── service
                        └── CustomUserDetailsService.java
```

这种文件夹结构指示了在项目中创建 `CustomUserDetailsService` 类和 `UsersRepository` 接口的位置。以这种方式组织类有助于保持清晰和结构化的代码库。

---

# [下一任务: 密码加密](password-encryption.md)