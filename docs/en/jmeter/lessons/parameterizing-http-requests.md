# Lesson 8: Parameterizing HTTP Requests

## Goal
The goal of this lesson is to parameterize HTTP requests in JMeter using extracted dynamic values.

## Steps

### 8.1. Modifying HTTP Requests
1. **Using Extracted Values**
    - In each HTTP request that uses the parameter `javax.faces.ViewState`, replace the value with `${jsfViewState}`.
    - Ensure the **Encode** checkbox is selected if needed.

---

# [Next: Adding Listeners and Running Tests](adding-listeners-and-running-tests.md)
