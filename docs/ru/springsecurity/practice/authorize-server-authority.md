# Авторизация по правам

В этом задании описывается процесс авторизации пользователей на основе их прав в вашем приложении. Присваивая различные права пользователям, вы можете контролировать доступ к определенным функциональностям или действиям.

## Цель

Авторизовать доступ к пути `/addStudent` для пользователей с правами `WRITE` и к пути `/removeStudent` для пользователей с правами `DELETE`.

## Шаги

1. **Обновление конфигурации безопасности:**

   В классе `WebSecurityConfig` измените метод `configure(HttpSecurity http)` для определения контроля доступа на основе прав для путей `/addStudent` и `/removeStudent`.

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // Другие конечные точки...
                   .requestMatchers("/addStudent").hasAuthority("WRITE")
                   .requestMatchers("/removeStudent").hasAuthority("DELETE")
                   // Другие конечные точки...
               );
       }
   }
   ```

   В этой конфигурации:
    - Заявление `.requestMatchers("/addStudent").hasAuthority("WRITE")` указывает, что доступ к пути `/addStudent` должен быть ограничен для пользователей с правами `WRITE`.
    - Аналогично, `.requestMatchers("/removeStudent").hasAuthority("DELETE")` ограничивает доступ к пути `/removeStudent` для пользователей с правами `DELETE`.

## Заключение

Вы успешно настроили контроль доступа на основе прав для путей `/addStudent` и `/removeStudent` в вашем приложении. Присваивая конкретные права пользователям, вы можете контролировать доступ к различным функциональностям или действиям на основе их разрешений.
