# Create Identity for Users

This task outlines the process of adding authorities and roles to the users created in the previous step, "Add Dummy Users." By assigning roles and authorities to users, we establish their identity within the application and control their access to various resources and functionalities.

## Goal

Enhance the user profiles created in the previous step by assigning roles and authorities, thereby defining their identities and access permissions within the application.

## Steps

1. **Update User Profiles with Roles and Authorities:**

   We'll update the dummy user profiles created in the `CustomUserDetailsService` class to include roles and authorities. This involves assigning specific roles to each user, such as `ADMIN`, `MODERATOR`, or `USER`, and granting corresponding authorities based on their roles.

   ```java
   // Inside addDummyUsers() method

   // Define roles
   String adminRole = "ROLE_ADMIN";
   String moderatorRole = "ROLE_MODERATOR";
   String userRole = "ROLE_USER";

   // Define authorities
   List<GrantedAuthority> adminAuthorities = Arrays.asList(
       new SimpleGrantedAuthority(adminRole),
       new SimpleGrantedAuthority("READ"),
       new SimpleGrantedAuthority("WRITE")
   );

   List<GrantedAuthority> moderatorAuthorities = Arrays.asList(
       new SimpleGrantedAuthority(moderatorRole),
       new SimpleGrantedAuthority("READ")
   );

   List<GrantedAuthority> userAuthorities = Collections.singletonList(
       new SimpleGrantedAuthority(userRole)
   );

   // Create dummy users with roles and authorities
   CustomUserDetails admin = new CustomUserDetails("admin", passwordEncoder.encode("admin"), true, true, true, true);
   admin.setAuthorities(adminAuthorities);
   admin.setRole(adminRole);

   CustomUserDetails moderator = new CustomUserDetails("moderator", passwordEncoder.encode("moderator"), true, true, true, true);
   moderator.setAuthorities(moderatorAuthorities);
   moderator.setRole(moderatorRole);

   CustomUserDetails user = new CustomUserDetails("user", passwordEncoder.encode("user"), true, true, true, true);
   user.setAuthorities(userAuthorities);
   user.setRole(userRole);
   ```

   In this updated code:
    - We define roles and authorities as variables for clarity and ease of maintenance.
    - Each user profile now includes a list of authorities based on their assigned roles.
    - Authorities are represented as `SimpleGrantedAuthority` objects and added to the user profiles accordingly.
    - Additionally, we set the role for each user to enable role-based access control in subsequent steps.

---

# [NEXT TASK: Create a Base for Authorization in Server](setup-server-authorization.md)