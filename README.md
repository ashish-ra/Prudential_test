# Test Project for Prudential
This project uses following dependencies for BDD Automation testing of [OpenWeatherMap](https://openweathermap.org/) and openweather 16 days forecast APIs
  - Cucumber
  - RestAssured
  - Gherkin
  - WebDriverManager
  - Cucumber-Reporter for reporting
  
## Test Cases Grouping
  _Feature file is located inside folder *featureFiles*_ 
  - End to End test cases for [OpenWeatherMap](https://openweathermap.org/) UI are grouped with tag
    `@E2Etest`
  - API Automation test cases are grouped under 
    `@APItest`
  
  
## Running Project
  1. Navigate to **src\test\java\main\MainClass.java**
     and run as JAVA Project and select tags to run from "Test Annotation Selector" from javaSwing
     
  2. Navigate to **src\test\java\cucRunner\Runner.java** update _tags_ as required and run as TestNG Tests
  
## Reporting
 Reports are generated at **\target\cucumber-reports** with screenshots embeded in it for failed cases.
