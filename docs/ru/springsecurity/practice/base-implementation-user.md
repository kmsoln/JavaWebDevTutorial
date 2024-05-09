# Создание базовой реализации для управления пользователями

В этом задании мы сосредоточимся на создании базовой реализации для управления пользователями в вашем приложении. Это включает в себя определение сущности UserDetails, создание репозитория для управления данными пользователей и реализацию UserDetailsService для загрузки деталей пользователей во время аутентификации.

## Цель

Цель этого задания - установить надежное основание для управления пользователями в вашем приложении. Реализовав UserDetails, UsersRepository и UserDetailsService, вы сможете аутентифицировать пользователей, управлять их данными и эффективно выполнять операции, связанные с пользователями.

## Шаги

1. **Определение сущности UserDetails**

   Начните с определения сущности UserDetails, которая представляет детали пользователя в вашем приложении. Эта сущность должна реализовывать интерфейс UserDetails, предоставляемый Spring Security.

   ```java
   package edu.labs.yourproject.model;

   import org.springframework.security.core.GrantedAuthority;
   import org.springframework.security.core.userdetails.UserDetails;

   import java.util.Collection;

   public class CustomUserDetails implements UserDetails {
   
       // Реализуйте методы UserDetails здесь
   
   }
   ```

   Реализуйте методы, необходимые интерфейсом UserDetails, для предоставления деталей пользователя, таких как имя пользователя, пароль, права доступа и т. д.

2. **Создание класса UsersRepository**

   Поскольку мы используем хранилище в памяти на данный момент, создадим простой класс UsersRepository для управления данными пользователей.

   a. **Создание класса UsersRepository**

   Создайте новый класс Java с именем `UsersRepository` внутри пакета `edu.labs.yourproject.repository`.

      ```java
      package edu.labs.yourproject.repository;

      import org.springframework.stereotype.Repository;
      import edu.labs.yourproject.model.CustomUserDetails;

      @Repository
      public class UsersRepository {
   
          private List<CustomUserDetails> users = new ArrayList<>();
   
          // Добавьте методы для управления пользователями по мере необходимости
      }
      ```

   Этот класс будет служить репозиторием для управления данными пользователей. Мы добавим методы для извлечения, добавления, обновления и удаления пользователей в последующих шагах.

   b. **Добавление метода findByUsername**

   Добавьте метод с именем `findByUsername` в класс `UsersRepository`. Этот метод будет извлекать детали пользователя по имени пользователя из репозитория.

      ```java
        public CustomUserDetails findByUsername(String username) {
            for (CustomUserDetails user : users) {
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
            return null; // Пользователь не найден
        }
      ```

   Метод `findByUsername` используется для извлечения деталей пользователя по имени пользователя из репозитория. В этой заполнительной реализации он возвращает `null`, но вы замените его фактической логикой извлечения деталей пользователя из базы данных или любого другого источника данных.

3. **Реализация UserDetailsService**

   На этом шаге мы реализуем UserDetailsService для загрузки деталей пользователя во время аутентификации. Этот сервис будет извлекать информацию о пользователе из UsersRepository.

   a. **Создание класса CustomUserDetailsService**

   Начните с создания нового класса с именем `CustomUserDetailsService` в пакете сервиса вашего проекта. Этот класс будет реализовывать интерфейс UserDetailsService, предоставляемый Spring Security.

      ```java
      package edu.labs.yourproject.service;

      import org.springframework.beans.factory.annotation.Autowired;
      import org.springframework.security.core.userdetails.UserDetails;
      import org.springframework.security.core.userdetails.UserDetailsService;
      import org.springframework.security.core.userdetails.UsernameNotFoundException;
      import org.springframework.stereotype.Service;
      import com.yourcompany.yourproject.model.CustomUserDetails;
      import com.yourcompany.yourproject.repository.UsersRepository;

      @Service
      public class CustomUserDetailsService implements UserDetailsService {
      
          private final UsersRepository usersRepository;

          @Autowired
          public CustomUserDetailsService(UsersRepository usersRepository) {
              this.usersRepository = usersRepository;
          }

          // Здесь реализуются методы
      }
      ```

   Мы создаем класс `CustomUserDetailsService` и проводим инъекцию зависимости `UsersRepository` с помощ

ью конструктора.

   b. **Переопределение метода loadUserByUsername**

   Переопределите метод `loadUserByUsername`, определенный в интерфейсе UserDetailsService. Этот метод будет извлекать детали пользователя из UsersRepository на основе предоставленного имени пользователя.

      ```java
      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          // Извлечение деталей пользователя из репозитория в памяти
          CustomUserDetails userDetails = usersRepository.findByUsername(username);
          if (userDetails == null) {
              throw new UsernameNotFoundException("Пользователь с именем пользователя не найден: " + username);
          }
          return userDetails;
      }
      ```

   Внутри метода `loadUserByUsername` мы вызываем метод `findByUsername` у UsersRepository для извлечения деталей пользователя по имени пользователя. Если пользователь не найден, мы генерируем исключение UsernameNotFoundException.

4. **Настройка бинов в WebSecurityConfig**

   Откройте класс WebSecurityConfig, расположенный в пакете конфигурации вашего проекта (`edu.labs.yourproject.config`). Внутри этого класса определите бины для CustomUserDetails и UserDetailsRepository.

   ```java
   package edu.labs.yourproject.config;

   import edu.labs.yourproject.model.CustomUserDetails;
   import edu.labs.yourproject.repository.UserDetailsRepository;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;

   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig {

       // Весь остальной код здесь...
    
       @Bean
       public CustomUserDetailsService customUserDetailsService() {
           // Создание и настройка бина CustomUserDetails
           return new CustomUserDetailsService();
       }

       @Bean
       public UserDetailsRepository userDetailsRepository() {
           // Создание и настройка бина UserDetailsRepository
           return new UserDetailsRepository();
       }
   }
   ```

   Определите два метода бина: `CustomUserDetailsService()` и `userDetailsRepository()`. Эти методы создают и настраивают бины CustomUserDetailsService и UserDetailsRepository соответственно.

## Структура папок

Структура папок вашего проекта должна выглядеть примерно так:

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

Эта структура папок показывает, где создать класс `CustomUserDetailsService` и интерфейс `UsersRepository` в вашем проекте. Организация ваших классов таким образом помогает поддерживать чистый и структурированный код.

## Заключение

Поздравляю! Вы успешно создали базовую реализацию для управления пользователями в вашем приложении. С UserDetails, UsersRepository и UserDetailsService вы можете аутентифицировать пользователей, управлять их данными и выполнять операции, связанные с пользователями, эффективно.
