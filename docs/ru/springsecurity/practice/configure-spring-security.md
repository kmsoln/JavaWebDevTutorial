# Настройка Spring Security

В этом задании мы сосредоточимся на настройке Spring Security в вашем проекте. Spring Security предоставляет обширные средства безопасности для Java-приложений, включая аутентификацию, авторизацию и защиту от распространенных угроз безопасности.

## Цель

Цель этого задания - интегрировать Spring Security в ваш существующий проект, гарантируя, что ваше приложение защищено от несанкционированного доступа.

## Шаги

1. **Добавление зависимости Spring Security**

    - Для проектов Maven:

      Добавьте следующую зависимость в файл `pom.xml` вашего проекта:

      ```xml
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-security</artifactId>
      </dependency>
      ```

    - Для проектов Gradle:

      Добавьте следующую зависимость в файл `build.gradle` вашего проекта:

      ```groovy
      implementation 'org.springframework.boot:spring-boot-starter-security'
      ```

   Убедитесь, что вы используете соответствующую версию Spring Security для вашего проекта.

2. **Создание класса конфигурации безопасности**

   Создайте новый класс Java с именем `WebSecurityConfig` в структуре исходных файлов вашего проекта. Обычно этот класс располагается в пакете `config`. Файл должен называться `WebSecurityConfig.java`.

   Структура папок вашего проекта должна выглядеть примерно так:

   ```
   src
   └── main
       └── java
           └── edu
               └── labs
                   └── yourproject
                       ├── config
                       │   └── WebMvcConfig.java
                       │   └── WebSecurityConfig.java
                       └── controller
                           └── PracticeController.java
   ```

3. **Настройка класса конфигурации безопасности**

   Внутри класса `WebSecurityConfig` отметьте его аннотациями `@Configuration` и `@EnableWebSecurity`, чтобы указать, что это класс конфигурации для Spring Security.

   ```java
   package edu.labs.yourproject.config;

   import org.springframework.context.annotation.Configuration;
   import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
   import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
       
       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
           // Конфигурация безопасности здесь
       }
   }
   ```

## Заключение

Поздравляем! Вы успешно настроили Spring Security в своем проекте. Ваше приложение теперь обладает надежными средствами безопасности для защиты от несанкционированного доступа и обеспечения конфиденциальности и целостности данных пользователей.
