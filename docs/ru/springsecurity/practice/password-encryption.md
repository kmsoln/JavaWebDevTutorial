# Шифрование паролей

В этой задаче мы настроим шифрование паролей для аутентификации пользователей в приложении, использующем Spring Security. Шифрование паролей повышает безопасность, сохраняя их в базе данных в зашифрованном виде.

## Цель

Цель этой настройки - настроить шифрование паролей с использованием BCryptPasswordEncoder, предоставляемого Spring Security. Это обеспечит защиту паролей путем их безопасного хеширования перед сохранением в базе данных.

## Шаги

1. **Добавление бина BCryptPasswordEncoder**

   Откройте класс WebSecurityConfig, находящийся в пакете конфигурации вашего проекта (`edu.labs.yourproject.config`). Внутри этого класса определите бин для BCryptPasswordEncoder.

   ```java
   package edu.labs.yourproject.config;

   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

   @Configuration
   public class WebSecurityConfig {

       @Bean
       public BCryptPasswordEncoder passwordEncoder() {
           // Создание и настройка бина BCryptPasswordEncoder
           return new BCryptPasswordEncoder();
       }
   }
   ```

   Определите метод бина `passwordEncoder()`, который создает и настраивает бин BCryptPasswordEncoder. Этот бин будет использоваться для шифрования паролей перед их сохранением в базе данных.

2. **Шифрование паролей**

   a. **Обновление класса CustomUserDetailsService**

   Откройте класс CustomUserDetailsService, находящийся в вашем пакете сервисов (`edu.labs.yourproject.service`). Внедрите бин BCryptPasswordEncoder в этот класс.

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

   b. **Реализация метода регистрации**

   Определите метод в классе CustomUserDetailsService для обработки регистрации пользователя. В этом методе зашифруйте пароль пользователя перед сохранением его в базе данных.

      ```java
          public void registerUser(CustomUserDetails user) {
              // Шифрование пароля перед сохранением пользователя
              String encodedPassword = passwordEncoder.encode(user.getPassword());
              user.setPassword(encodedPassword);
              usersRepository.save(user);
          }
      ```

   Этот метод принимает объект CustomUserDetails, представляющий пользователя для регистрации. Он шифрует пароль пользователя с использованием бина BCryptPasswordEncoder, а затем сохраняет пользователя в базе данных.

---

# [СЛЕДУЮЩЕЕ ЗАДАНИЕ: Добавить тестовых пользователей](add-dummy-users.md)
