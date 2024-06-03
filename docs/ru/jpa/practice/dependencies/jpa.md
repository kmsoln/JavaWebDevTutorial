# Настройка зависимостей JPA

## Введение

Это руководство сосредоточено на настройке зависимостей для проекта Spring Boot с использованием JPA (Java Persistence API). Оно охватывает необходимые шаги для включения зависимостей Spring Boot Starter JDBC и Spring Boot Starter Data JPA.

## Цель

Цель этого руководства - предоставить четкие инструкции по настройке необходимых зависимостей для Spring Boot и JPA, с акцентом на зависимостях Spring Boot Starter JDBC и Spring Boot Starter Data JPA.

## Настройка зависимостей

### Spring Boot Starter JDBC

Для включения поддержки JDBC в вашем приложении Spring Boot:

#### Gradle

```groovy
implementation "org.springframework.boot:spring-boot-starter-jdbc"
```

#### Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```

Эта зависимость обеспечивает автоконфигурацию для доступа к данным на основе JDBC.

### Spring Boot Starter Data JPA

Для включения поддержки JPA (Java Persistence API) в вашем приложении Spring Boot:

#### Gradle

```groovy
implementation "org.springframework.boot:spring-boot-starter-data-jpa"
```

#### Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

Эта зависимость упрощает настройку репозиториев на основе JPA и предоставляет конфигурации по умолчанию для Hibernate.

### Дополнительная конфигурация для Spring WebMVC

Если вы используете Spring WebMVC, вам необходимо добавить дополнительную конфигурацию для настройки бинов и свойств, связанных с сохранением состояния.

#### Создание класса конфигурации Persistence

Создайте новый класс с именем `PersistenceConfig` в пакете `com.example.config`:

```java
package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Класс конфигурации для настройки бинов и свойств, связанных с сохранением состояния.
 *
 * <p>
 * Этот класс настраивает источник данных, фабрику менеджеров сущностей и менеджер транзакций для JPA.
 * Он считывает свойства подключения к базе данных из внешнего файла свойств.
 * </p>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.repository")
@PropertySource({"classpath:application.properties"})
public class PersistenceConfig {

    @Value("${spring.datasource.driver}")
    private String dbDriver;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;

    @Value("${spring.jpa.properties.hibernate.show_sql}")
    private boolean hibernateShowSql;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String hibernateHbm2ddlAuto;

    /**
     * Определение бина DataSource.
     *
     * <p>
     * Этот метод настраивает источник данных, используя свойства, определенные в файле application.properties.
     * </p>
     *
     * @return Бин DataSource
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    /**
     * Определение бина EntityManagerFactory.
     *
     * <p>
     * Этот метод настраивает фабрику менеджеров сущност

ей с использованием настроенного источника данных и свойств Hibernate.
     * </p>
     *
     * @param dataSource бин источника данных
     * @return Бин EntityManagerFactory
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(hibernateDialect);
        vendorAdapter.setShowSql(hibernateShowSql);
        vendorAdapter.setGenerateDdl("update".equalsIgnoreCase(hibernateHbm2ddlAuto));
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    /**
     * Определение бина TransactionManager Spring.
     *
     * <p>
     * Этот метод настраивает менеджер транзакций для JPA с использованием настроенной фабрики менеджеров сущностей.
     * </p>
     *
     * @param entityManagerFactory бин фабрики менеджеров сущностей
     * @return Бин TransactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
```

---

# [Следующий: Создание сущностей](../creation/create-entity.md)