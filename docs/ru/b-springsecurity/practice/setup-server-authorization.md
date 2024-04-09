# Настройка авторизации на сервере

В этой задаче мы настроим авторизацию в вашем приложении, определив правила безопасности с использованием Spring Security. Определяя правила авторизации, вы можете контролировать доступ к определенным путям и конечным точкам в вашем приложении.

## Цель

Настроить правила авторизации для ограничения или разрешения доступа к различным путям и конечным точкам в приложении.

## Шаги

1. **Добавление конфигурации безопасности:**

   В классе `WebSecurityConfig` добавьте метод `configure(HttpSecurity http)`, чтобы определить правила безопасности для приложения. Мы будем использовать пути и конечные точки, определенные в предыдущей лабораторной работе.

   ```java
   @Configuration
   @EnableWebSecurity
   public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

       @Override
       protected void configure(HttpSecurity http) throws Exception {
           http
               .authorizeHttpRequests((requests) -> requests
                   .requestMatchers("/first").permitAll()
                   .requestMatchers("/second").permitAll()
                   .requestMatchers("/third").permitAll()
                   .requestMatchers("/fourth").permitAll()
                   .requestMatchers("/addStudent").permitAll()
                   .requestMatchers("/removeStudent").permitAll()
               );
       }
   }
   ```

   В этой конфигурации:
    - Мы используем `.authorizeHttpRequests()`, чтобы определить правила авторизации.
    - Внутри лямбда-выражения мы указываем, какие запросы следует разрешить.

## Вывод

Вы успешно настроили правила авторизации в вашем приложении для управления доступом к различным путям и конечным точкам. Определяя конкретные разрешения для каждого пути, вы можете гарантировать, что пользователи смогут получить доступ только к ресурсам, к которым у них есть соответствующие разрешения.

---

# [СЛЕДУЮЩАЯ ЗАДАЧА: Авторизация аутентифицированных пользователей](authorize-server-authenticated.md)
