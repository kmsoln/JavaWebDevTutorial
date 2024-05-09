# JPA: Setup Dependencies

## Introduction

This guide focuses on setting up dependencies for a Spring Boot project with JPA (Java Persistence API). It covers the necessary steps to include database drivers for various databases such as PostgreSQL, MySQL, Oracle, MongoDB, and Microsoft SQL Server. By following this guide, you will configure all the required dependencies to establish connections with these databases in your Spring Boot application.

## Goal
The goal of this guide is to provide clear instructions for setting up the necessary dependencies for Spring Boot and JPA, specifically focusing on database drivers for different databases.

## Setup Dependencies

### Database Drivers

To connect to different databases in your Spring Boot application, include the appropriate database drivers.

#### PostgreSQL

**For Gradle:**
```groovy
implementation "org.postgresql:postgresql"
```

**For Maven:**
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>INSERT_VERSION_HERE</version>
</dependency>
```

#### MySQL

**For Gradle:**
```groovy
implementation "mysql:mysql-connector-java"
```

**For Maven:**
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>INSERT_VERSION_HERE</version>
</dependency>
```

#### Oracle Database Driver

**For Gradle:**
```groovy
implementation 'com.oracle.database.jdbc:ojdbc8'
```

**For Maven:**
```xml
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
</dependency>
```

#### MongoDB Driver (MongoDB Java Driver)

**For Gradle:**
```groovy
implementation 'org.mongodb:mongodb-driver-sync:4.4.3'
```

**For Maven:**
```xml
<dependency>
    <groupId>org.mongodb</groupId>
    <artifactId>mongodb-driver-sync</artifactId>
    <version>4.4.3</version>
</dependency>
```

#### Microsoft SQL Server JDBC Driver

**For Gradle:**
```groovy
implementation 'com.microsoft.sqlserver:mssql-jdbc:9.4.0.jre11'
```

**For Maven:**
```xml
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <version>9.4.0.jre11</version>
</dependency>
```

These dependencies facilitate database connectivity.

## Conclusion

By configuring the appropriate database drivers for various databases, you will be equipped to initiate development on your Spring Boot application with JPA.

# [Next: Spring Boot and JPA Dependencies](jpa.md)

