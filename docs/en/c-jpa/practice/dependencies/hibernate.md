# Setup Hibernate with Spring Boot

## Goal:
The goal of this task is to set up Hibernate with Spring Boot for database access.

## Steps:
1. **Add Hibernate Dependency:**

   To integrate Hibernate with Spring Boot, you need to add the `spring-boot-starter-data-jpa` dependency to your project, which includes Hibernate as the default JPA provider.

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
Congratulations! You have successfully set up Hibernate with Spring Boot in your project. This will allow you to easily interact with a database using Hibernate as the JPA provider.