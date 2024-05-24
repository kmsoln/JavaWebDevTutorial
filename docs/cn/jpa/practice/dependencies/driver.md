# JPA: 设置依赖项

## 简介

本指南着重介绍了如何为具有JPA（Java Persistence API）的Spring Boot项目设置依赖项。它涵盖了包括PostgreSQL、MySQL、Oracle、MongoDB和Microsoft SQL Server等各种数据库的数据库驱动程序的必要步骤。通过按照本指南的步骤，您将配置所有必需的依赖项，以在Spring Boot应用程序中与这些数据库建立连接。

## 目标

本指南的目标是提供清晰的说明，以便设置Spring Boot和JPA的必要依赖项，特别关注不同数据库的数据库驱动程序。

## 设置依赖项

### 数据库驱动程序

要连接Spring Boot应用程序中的不同数据库，请包含相应的数据库驱动程序。

#### PostgreSQL

**对于Gradle：**
```groovy
implementation "org.postgresql:postgresql"
```

**对于Maven：**
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>INSERT_VERSION_HERE</version>
</dependency>
```

#### MySQL

**对于Gradle：**
```groovy
implementation "mysql:mysql-connector-java"
```

**对于Maven：**
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>INSERT_VERSION_HERE</version>
</dependency>
```

#### Oracle数据库驱动程序

**对于Gradle：**
```groovy
implementation 'com.oracle.database.jdbc:ojdbc8'
```

**对于Maven：**
```xml
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
</dependency>
```

#### MongoDB驱动程序（MongoDB Java驱动程序）

**对于Gradle：**
```groovy
implementation 'org.mongodb:mongodb-driver-sync:4.4.3'
```

**对于Maven：**
```xml
<dependency>
    <groupId>org.mongodb</groupId>
    <artifactId>mongodb-driver-sync</artifactId>
    <version>4.4.3</version>
</dependency>
```

#### Microsoft SQL Server JDBC驱动程序

**对于Gradle：**
```groovy
implementation 'com.microsoft.sqlserver:mssql-jdbc:9.4.0.jre11'
```

**对于Maven：**
```xml
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <version>9.4.0.jre11</version>
</dependency>
```

这些依赖项有助于数据库连接。

---

# [下一步：Spring Boot和JPA依赖项](jpa.md)