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

## Conclusion
After adding the dependency, Thymeleaf will be configured to work seamlessly with Spring Security, providing additional features and utilities for integrating security-related functionality into your web application. Remember to sync your project to download the dependency and make it available for use.

---

[NEXT TASK:]()
