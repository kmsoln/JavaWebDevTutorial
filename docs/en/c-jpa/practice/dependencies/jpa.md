# Setup JPA

## Goal:
The goal of this task is to set up Java Persistence API (JPA) with Spring Boot for database access.

## Steps:
1. **Add JPA Dependency:**

   To integrate JPA with Spring Boot, you need to add the `spring-boot-starter-data-jpa` dependency to your project.

   ```xml
   <!-- Maven -->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-jpa</artifactId>
   </dependency>
   ```

   ```groovy
   // Gradle Groovy
   implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
   ```

## Conclusion:
Congratulations! You have successfully set up JPA with Spring Boot in your project. This will allow you to easily interact with a database using the Java Persistence API.