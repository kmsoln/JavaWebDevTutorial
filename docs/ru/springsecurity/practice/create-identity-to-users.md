# Создание идентификации пользователей

Это задание описывает процесс добавления ролей и полномочий пользователям, созданным на предыдущем этапе, "Добавление фиктивных пользователей". Присваивая роли и полномочия пользователям, мы устанавливаем их идентификацию в приложении и контролируем доступ к различным ресурсам и функционалу.

## Цель

Расширить профили пользователей, созданные на предыдущем этапе, присвоив им роли и полномочия, тем самым определив их идентификацию и разрешения на доступ в приложении.

## Шаги

1. **Обновление профилей пользователей с ролями и полномочиями:**

   Мы обновим фиктивные профили пользователей, созданные в классе `CustomUserDetailsService`, чтобы добавить роли и полномочия. Это включает в себя назначение конкретных ролей каждому пользователю, таких как `ADMIN`, `MODERATOR` или `USER`, и предоставление соответствующих полномочий на основе их ролей.

   ```java
   // Внутри метода addDummyUsers()

   // Определение ролей
   String adminRole = "ROLE_ADMIN";
   String moderatorRole = "ROLE_MODERATOR";
   String userRole = "ROLE_USER";

   // Определение полномочий
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

   // Создание фиктивных пользователей с ролями и полномочиями
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

   В этом обновленном коде:
    - Мы определяем роли и полномочия в виде переменных для ясности и удобства обслуживания.
    - Теперь каждый профиль пользователя включает список полномочий на основе назначенных им ролей.
    - Полномочия представлены объектами `SimpleGrantedAuthority` и добавляются в профили пользователей соответственно.
    - Кроме того, мы устанавливаем роль для каждого пользователя, чтобы в дальнейшем использовать контроль доступа на основе ролей.

## Заключение

Вы успешно улучшили профили пользователей в вашем приложении, назначив роли и полномочия фиктивным пользователям. Определив их идентификацию и разрешения на доступ, теперь вы можете контролировать действия и функциональность, доступные каждому пользователю в приложении.
