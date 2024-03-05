# Create First View

**Description:**

In this task, we'll create the first Thymeleaf view for your Spring application. Follow the correct file path as defined in the Thymeleaf configuration and register the view in the application.

## **Steps:**

1. **Create the View File:**
    - Navigate to the directory specified in the Thymeleaf configuration as the prefix for templates.
    - By default, the configured prefix is `/templates/`. Therefore, create your Thymeleaf view file within this directory.

   ```plaintext
   Project Directory
   └── src
       └── main
           └── resources
               └── templates
                   └── practice
                       └── first.html
   ```

   Ensure the view file is named appropriately (e.g., `first.html`). The `/templates/` directory is crucial for Thymeleaf to locate and process your templates correctly.

2. **Register the View in Configuration Class:**
    - Open the configuration class where you set up Thymeleaf (e.g., `WebMvcConfig`).
    - Add the following method to register the Thymeleaf view:

   ```java
   public void addViewControllers(ViewControllerRegistry registry) {
       // First View
       registry.addViewController("/first").setViewName("practice/first");
   }
   ```

   This method maps the URL path `/first` to the Thymeleaf view named "practice/first". Adjust the path accordingly based on your project structure.

3. **Test the View:**
    - Run your Spring application.
    - Open a web browser and navigate to `http://localhost:8080/first`. You should see the rendered Thymeleaf view.

4. **Optional: Configure Redirect from Root Path:**
    - To set the first view as the default page, you can add a redirect from the root path ("/") to the path of the first view in the `addViewControllers` method:

   ```java
   public void addViewControllers(ViewControllerRegistry registry) {
       // First View
       registry.addViewController("/first").setViewName("practice/first");
       
       // Redirect from root path to the first view
       registry.addRedirectViewController("/", "/first");
   }
   ```

   Now, visiting `http://localhost:8080/` will automatically redirect to the first view.

---

**Conclusion:**

You have successfully created and registered your first Thymeleaf view. Ensure you follow the correct file path as defined in the Thymeleaf configuration.

# [NEXT TASK: *Working With Variables*](working-with-variables.md)