# Авторизация по ролям

Это задание описывает процесс авторизации пользователей на основе их ролей в вашем приложении. Присваивая различные роли пользователям, вы можете контролировать доступ к определенным ресурсам или функциональностям.

## Цель

Авторизовать доступ к пути `/third` для пользователей с ролью `ROLE_MODERATOR` и к пути `/fourth` для пользователей с ролью `ROLE_ADMIN`.

## Шаги

1. **Обновление конфигурации безопасности:**

   В классе `WebSecurityConfig` измените метод `configure(HttpSecurity http)` для определения контроля доступа на основе ролей для путей `/third` и `/fourth`.

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   // Другие конечные точки...
                   .requestMatchers("/third").hasAuthority("ROLE_MODERATOR")
                   .requestMatchers("/fourth").hasAuthority("ROLE_ADMIN")
                   // Другие конечные точки...
               );
       }
   }
   ```

   В этой конфигурации:
    - Заявление `.requestMatchers("/third").hasAuthority("ROLE_MODERATOR")` указывает, что доступ к пути `/third` должен быть ограничен для пользователей с авторитетом `ROLE_MODERATOR`.
    - Аналогично, `.requestMatchers("/fourth").hasAuthority("ROLE_ADMIN")` ограничивает доступ к пути `/fourth` для пользователей с авторитетом `ROLE_ADMIN`.

---

# [СЛЕДУЮЩЕЕ ЗАДАНИЕ: Авторизация по полномочию](authorize-server-authority.md)