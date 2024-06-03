# Настройка Thymeleaf в Spring

**Описание:**

Это задание включает в себя настройку Thymeleaf в приложении Spring для обеспечения легкой интеграции шаблонного движка для веб-разработки.

## **Шаги:**

1. **Создайте Класс Конфигурации Thymeleaf:**
    - В вашем проекте Spring создайте новый Java-класс, аннотированный `@Configuration`. Мы рекомендуем разместить этот класс в пакете `config`.
    - Расширьте класс с `WebMvcConfigurer`.

   Пример:

   ```java
   package edu.labs.thymeleaf.config;

   import org.springframework.context.annotation.Configuration;
   import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

   @Configuration
   public class WebMvcConfig implements WebMvcConfigurer {
       // Код конфигурации размещается здесь
   }
   ```

   Размещение класса конфигурации в пакете `config` помогает правильно структурировать ваш код. Скорректируйте имя пэкеджа в зависимости от структуры вашего проекта.

2. **Настройте Разрешитель Шаблонов Thymeleaf:**
    - Создайте метод с аннотацией `@Bean` для конфигурации шаблонизатора Thymeleaf.
    - Используйте `ClassLoaderTemplateResolver` и установите префикс, суффикс, режим шаблона и кодировку символов.

       ```java
       @Bean
       public ClassLoaderTemplateResolver templateResolver() {
           // Создайте bean ClassLoaderTemplateResolver
           ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        
           // Установите путь, где Thymeleaf будет искать шаблоны
           templateResolver.setPrefix("/templates/");
        
           // Установите расширение файла для шаблонов
           templateResolver.setSuffix(".html");
        
           // Установите режим шаблона в HTML
           templateResolver.setTemplateMode(TemplateMode.HTML);
        
           // Установите кодировку символов для шаблонов
           templateResolver.setCharacterEncoding("UTF-8");
 
           // Верните настроенный bean разрешителя шаблонов
           return templateResolver;
       }
       ```

3. **Настройте Источник Сообщений:**
    - Добавьте метод, аннотированный `@Bean`, для настройки источника сообщений с использованием `ReloadableResourceBundleMessageSource`.
    - Установите кодировку по умолчанию.

       ```java
       @Bean
       public MessageSource messageSource() {
           // Создайте bean ReloadableResourceBundleMessageSource
           ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        
           // Установите кодировку по умолчанию для сообщений
           messageSource.setDefaultEncoding("UTF-8");
 
           // Верните настроенный bean источника сообщений
           return messageSource;
       }
       ```

4. **Настройте Разрешитель Представлений Thymeleaf:**
    - Создайте метод, аннотированный `@Bean`, для настройки Thymeleaf.
    - Установите шаблонный движок.

       ```java
       @Bean
       public ViewResolver thymeleafViewResolver() {
           // Создайте bean ThymeleafViewResolver
           ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        
           // Установите шаблонный движок для разрешителя представлений
           resolver.setTemplateEngine(templateEngine());
 
           // Верните настроенный bean ThymeleafViewResolver
           return resolver;
       }
       ```

5. **Настройте Шаблонный Движок Thymeleaf:**
    - Реализуйте метод, аннотированный `@Bean`, для настройки шаблонного движка Thymeleaf.
    - Установите разрешитель шаблонов и источник сообщений шаблонного движка.

       ```java
       @Bean
       public SpringTemplateEngine templateEngine() {
           // Создайте bean SpringTemplateEngine
           SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        
           // Установите разрешитель шаблонов для шаблонного движка
           templateEngine.setTemplateResolver(templateResolver());
        
           // Установите источник сообщений шаблонного движка
           templateEngine.setTemplateEngineMessageSource(messageSource());
 
           // Верните настроенный bean SpringTemplateEngine
           return templateEngine;
       }
       ```

---

# [СЛЕДУЮЩЕЕ ЗАДАНИЕ: *Создание Первого Представления*](create-first-view.md)
