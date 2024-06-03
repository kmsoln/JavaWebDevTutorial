# JPA：设置依赖关系

## 介绍

本指南侧重于为具有 JPA（Java Persistence API）的 Spring Boot 项目设置依赖关系。它涵盖了包括 Spring Boot Starter JDBC 和 Spring Boot Starter Data JPA 依赖项的必要步骤。

## 目标

本指南的目标是为 Spring Boot 和 JPA 设置必要的依赖关系，并特别关注 Spring Boot Starter JDBC 和 Spring Boot Starter Data JPA 依赖项。

## 设置依赖关系

### Spring Boot Starter JDBC

要在 Spring Boot 应用程序中启用 JDBC 支持：

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

此依赖项为基于 JDBC 的数据访问提供了自动配置。

### Spring Boot Starter Data JPA

要在 Spring Boot 应用程序中包含对 JPA（Java Persistence API）的支持：

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

此依赖项简化了基于 JPA 的存储库的设置，并为 Hibernate 提供了默认配置。

### Spring WebMVC 的附加配置

如果您使用 Spring WebMVC，则需要添加额外的配置以设置与持久性相关的 bean 和属性。

#### 创建持久性配置类

在 `com.example.config` 包中创建一个名为 `PersistenceConfig` 的新类：

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
 * 用于设置与持久性相关的 bean 和属性的配置类。
 *
 * <p>
 * 该类配置了用于 JPA 的数据源、实体管理器工厂和事务管理器。
 * 它从外部属性文件中读取数据库连接属性。
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
     * 数据源的 Bean 定义。
     *
     * <p>
     * 此方法使用在 application.properties 文件中定义的属性设置数据源。
     * </p>
     *
     * @return DataSource bean
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
     * EntityManagerFactory 的 Bean 定义。
     *
     * <p>
     * 此方法使用配置的数据源和 Hibernate 属性设置实体管理器工厂。
     * </p>
     *
     * @param dataSource 数据源 bean
     * @return EntityManagerFactory bean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(hibernateDialect);
        vendorAdapter.setShowSql(hibernate

ShowSql);
        vendorAdapter.setGenerateDdl("update".equalsIgnoreCase(hibernateHbm2ddlAuto));
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    /**
     * Spring 事务管理器的 Bean 定义。
     *
     * <p>
     * 此方法使用配置的实体管理器工厂设置 JPA 的事务管理器。
     * </p>
     *
     * @param entityManagerFactory 实体管理器工厂 bean
     * @return 事务管理器 bean
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

# [下一步：实体创建](../creation/create-entity.md)