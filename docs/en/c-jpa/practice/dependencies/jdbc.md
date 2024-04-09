# Setup JDBC with Spring Boot

## Goal:
The goal of this task is to set up JDBC with Spring Boot for database access.

## Steps:
1. **Add JDBC Dependency:**

   To use JDBC with Spring Boot, you need to add the `spring-boot-starter-jdbc` dependency to your project.

   ```xml
   <!-- Maven -->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-jdbc</artifactId>
   </dependency>
   ```

   ```groovy
   // Gradle Groovy
   implementation 'org.springframework.boot:spring-boot-starter-jdbc'
   ```

## Conclusion:
Congratulations! You have successfully set up JDBC with Spring Boot in your project. This will allow you to easily interact with your chosen database using JDBC. Make sure to replace the placeholders with the actual database driver dependencies according to your specific database requirements.