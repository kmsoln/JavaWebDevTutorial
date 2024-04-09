## Setup JDBC Drivers

To connect your Java application to different databases, you need to include the JDBC driver for the respective database in your project's dependencies.

### MySQL Driver

#### Maven
```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

#### Gradle (Groovy)
```groovy
implementation 'mysql:mysql-connector-java'
```

### PostgreSQL Driver

#### Maven
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

#### Gradle (Groovy)
```groovy
implementation 'org.postgresql:postgresql'
```

### Oracle Database Driver

#### Maven
```xml
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
</dependency>
```

#### Gradle (Groovy)
```groovy
implementation 'com.oracle.database.jdbc:ojdbc8'
```

Certainly! Below are the dependencies for MongoDB and Microsoft SQL Server JDBC drivers:

### MongoDB Driver (MongoDB Java Driver)

#### Gradle Groovy
```groovy
implementation 'org.mongodb:mongodb-driver-sync:4.4.3'
```

#### Maven
```xml
<dependency>
    <groupId>org.mongodb</groupId>
    <artifactId>mongodb-driver-sync</artifactId>
    <version>4.4.3</version>
</dependency>
```

### Microsoft SQL Server JDBC Driver

#### Gradle Groovy
```groovy
implementation 'com.microsoft.sqlserver:mssql-jdbc:9.4.0.jre11'
```

#### Maven
```xml
<dependency>
    <groupId>com.microsoft.sqlserver</groupId>
    <artifactId>mssql-jdbc</artifactId>
    <version>9.4.0.jre11</version>
</dependency>
```
