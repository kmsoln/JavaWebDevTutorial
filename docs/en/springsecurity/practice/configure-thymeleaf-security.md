# Configure Thymeleaf with Spring Security

## Goal
The goal of this task is to integrate Thymeleaf with Spring Security, enabling the use of additional Thymeleaf dialects and utilities provided by the `thymeleaf-extras-springsecurity6` library.

## Steps

1. **Gradle (Groovy):**

   Add the `thymeleaf-extras-springsecurity6` dependency to your `build.gradle` file:

   ```groovy
   implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6:3.0.4.RELEASE'
   ```

2. **Maven:**

   Add the following dependency to your `pom.xml` file:

   ```xml
   <dependency>
       <groupId>org.thymeleaf.extras</groupId>
       <artifactId>thymeleaf-extras-springsecurity6</artifactId>
       <version>3.0.4.RELEASE</version>
   </dependency>
   ```

---

# [NEXT TASK: Create a Base Implementation for User](base-implementation-user.md)
