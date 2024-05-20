# Add Dummy Users

This task outlines the process of updating the `CustomUserDetailsService` class to include a method for adding dummy users to the in-memory storage to serving as a simple demonstration of user creation.

## Goal

Update the `CustomUserDetailsService` class to include a method for adding dummy users, allowing for the initialization of user data in the in-memory storage.

## Steps

1. **Update CustomUserDetailsService Class:**

   First, we need to update the `CustomUserDetailsService` class to include a method for adding dummy users. We'll leverage this method during bean initialization to populate the in-memory storage with dummy user data.

   ```java
   @Service
   public class CustomUserDetailsService implements UserDetailsService {

       private final UsersRepository usersRepository;
       private final PasswordEncoder passwordEncoder;

       @Autowired
       public CustomUserDetailsService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
           this.usersRepository = usersRepository;
           this.passwordEncoder = passwordEncoder;
           
           // Call the addDummyUsers method to add dummy users during bean initialization
           addDummyUsers();
       }

       @Override
       public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           // Retrieve user details from the repository
           CustomUserDetails userDetails = usersRepository.findByUsername(username);
           if (userDetails == null) {
               throw new UsernameNotFoundException("User not found with username: " + username);
           }
           return userDetails;
       }

       // Method to add dummy users
       private void addDummyUsers() {
           // Create dummy users
           CustomUserDetails admin = new CustomUserDetails("admin", passwordEncoder.encode("admin"), true, true, true, true);
           CustomUserDetails moderator = new CustomUserDetails("moderator", passwordEncoder.encode("moderator"), true, true, true, true);
           CustomUserDetails user = new CustomUserDetails("user", passwordEncoder.encode("user"), true, true, true, true);
           
           // Add users to the repository
           usersRepository.save(admin);
           usersRepository.save(moderator);
           usersRepository.save(user);
       }
   }
   ```

   In this updated class:
    - We've added a constructor that accepts `UsersRepository` and `PasswordEncoder` as dependencies.
    - During bean initialization, the constructor calls the `addDummyUsers` method to populate the in-memory storage with dummy users.
    - The `addDummyUsers` method creates dummy users with hardcoded usernames and passwords.
    - Finally, the dummy users are saved to the repository using the `save` method.

---

# [NEXT TASK: Create Identity to Users](create-identity-to-users.md)