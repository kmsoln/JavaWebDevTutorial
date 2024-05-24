# 添加虚拟用户

本任务概述了更新 `CustomUserDetailsService` 类的过程，以包含用于将虚拟用户添加到内存存储的方法，从而作为用户创建的简单演示。

## 目标

更新 `CustomUserDetailsService` 类以包含添加虚拟用户的方法，允许在内存存储中初始化用户数据。

## 步骤

1. **更新 CustomUserDetailsService 类:**

   首先，我们需要更新 `CustomUserDetailsService` 类，以包含用于添加虚拟用户的方法。我们将在 bean 初始化期间利用此方法将虚拟用户数据填充到内存存储中。

   ```java
   @Service
   public class CustomUserDetailsService implements UserDetailsService {

       private final UsersRepository usersRepository;
       private final PasswordEncoder passwordEncoder;

       @Autowired
       public CustomUserDetailsService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
           this.usersRepository = usersRepository;
           this.passwordEncoder = passwordEncoder;
           
           // 在 bean 初始化期间调用 addDummyUsers 方法以添加虚拟用户
           addDummyUsers();
       }

       @Override
       public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           // 从存储库中检索用户详细信息
           CustomUserDetails userDetails = usersRepository.findByUsername(username);
           if (userDetails == null) {
               throw new UsernameNotFoundException("User not found with username: " + username);
           }
           return userDetails;
       }

       // 添加虚拟用户的方法
       private void addDummyUsers() {
           // 创建虚拟用户
           CustomUserDetails admin = new CustomUserDetails("admin", passwordEncoder.encode("admin"), true, true, true, true);
           CustomUserDetails moderator = new CustomUserDetails("moderator", passwordEncoder.encode("moderator"), true, true, true, true);
           CustomUserDetails user = new CustomUserDetails("user", passwordEncoder.encode("user"), true, true, true, true);
           
           // 将用户添加到存储库
           usersRepository.save(admin);
           usersRepository.save(moderator);
           usersRepository.save(user);
       }
   }
   ```

   在这个更新的类中：
   - 我们添加了一个接受 `UsersRepository` 和 `PasswordEncoder` 作为依赖项的构造函数。
   - 在 bean 初始化期间，构造函数调用 `addDummyUsers` 方法，将虚拟用户数据填充到内存存储中。
   - `addDummyUsers` 方法创建具有硬编码用户名和密码的虚拟用户。
   - 最后，虚拟用户通过 `save` 方法保存到存储库中。

---

# [下一任务: 为用户创建身份](create-identity-to-users.md)