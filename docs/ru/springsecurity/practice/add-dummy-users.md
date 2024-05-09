# Добавление фиктивных пользователей

В этом задании описан процесс обновления класса `CustomUserDetailsService` для включения метода добавления фиктивных пользователей в хранилище в памяти, чтобы использовать его в качестве простого демонстрационного примера создания пользователей.

## Цель

Обновить класс `CustomUserDetailsService`, чтобы включить метод добавления фиктивных пользователей, позволяющий инициализировать данные пользователей в хранилище в памяти.

## Шаги

1. **Обновление класса CustomUserDetailsService:**

   Сначала нам нужно обновить класс `CustomUserDetailsService`, чтобы добавить метод добавления фиктивных пользователей. Мы будем использовать этот метод во время инициализации бина для заполнения хранилища в памяти данными о фиктивных пользователях.

   ```java
   @Service
   public class CustomUserDetailsService implements UserDetailsService {

       private final UsersRepository usersRepository;
       private final PasswordEncoder passwordEncoder;

       @Autowired
       public CustomUserDetailsService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
           this.usersRepository = usersRepository;
           this.passwordEncoder = passwordEncoder;
           
           // Вызываем метод addDummyUsers для добавления фиктивных пользователей во время инициализации бина
           addDummyUsers();
       }

       @Override
       public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           // Получаем данные пользователя из репозитория
           CustomUserDetails userDetails = usersRepository.findByUsername(username);
           if (userDetails == null) {
               throw new UsernameNotFoundException("Пользователь с именем пользователя не найден: " + username);
           }
           return userDetails;
       }

       // Метод для добавления фиктивных пользователей
       private void addDummyUsers() {
           // Создаем фиктивных пользователей
           CustomUserDetails admin = new CustomUserDetails("admin", passwordEncoder.encode("admin"), true, true, true, true);
           CustomUserDetails moderator = new CustomUserDetails("moderator", passwordEncoder.encode("moderator"), true, true, true, true);
           CustomUserDetails user = new CustomUserDetails("user", passwordEncoder.encode("user"), true, true, true, true);
           
           // Добавляем пользователей в репозиторий
           usersRepository.save(admin);
           usersRepository.save(moderator);
           usersRepository.save(user);
       }
   }
   ```

   В этом обновленном классе:
    - Мы добавили конструктор, который принимает `UsersRepository` и `PasswordEncoder` в качестве зависимостей.
    - Во время инициализации бина конструктор вызывает метод `addDummyUsers` для заполнения хранилища в памяти фиктивными пользователями.
    - Метод `addDummyUsers` создает фиктивных пользователей с захардкоженными именами пользователей и паролями.
    - Наконец, фиктивные пользователи сохраняются в репозитории с помощью метода `save`.

## Заключение

Поздравляем! Вы успешно добавили фиктивных пользователей для имитации базы данных в вашем приложении с использованием Spring Security. Путем инициализации списка фиктивных пользователей в классе UserRepositoryImpl и заполнения его во время запуска приложения вы теперь можете аутентифицировать и авторизовывать пользователей в вашем приложении.

---

# [СЛЕДУЮЩЕЕ ЗАДАНИЕ: Создание идентификации для пользователей](create-identity-to-users.md)
