# Lesson 7: Creating a Test Scenario

## Goal
The goal of this lesson is to create a test scenario by organizing recorded requests and adding dynamic value extraction in JMeter.

## Steps

### 7.1. Adding a Simple Controller
1. **Organizing Requests**
    - Right-click on the **Thread Group**.
    - Select **Add > Logic Controller > Simple Controller**.
    - Rename the Simple Controller to match the function you are testing.
    - Drag and drop all recorded HTTP requests from the **Recording Controller** to the **Simple Controller**.

### 7.2. Adding a Regular Expression Extractor
1. **Dynamic Value Extraction**
    - Right-click on the HTTP request that requires a dynamic value (e.g., `javax.faces.ViewState`).
    - Select **Add > Post Processors > Regular Expression Extractor**.
    - Configure the extractor:
        - **Reference Name:** `jsfViewState`
        - **Regular Expression:** `<input type="hidden" name="javax\.faces\.ViewState" value="(.*?)"`
        - **Template:** `$1$`
        - **Match No.:** `0`

---

# [Next: Parameterizing HTTP Requests](parameterizing-http-requests.md)
