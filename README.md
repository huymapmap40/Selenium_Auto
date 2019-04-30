# How to run the test
## 1. Install webdriver manager
Use npm to install **webdriver-manager**. The webdriver-manager is a helper tool to easily get an instance of a Selenium Server running:
```
npm install -g webdriver-manager
```

## 2. Update and start wendriver-manager
In order to avoids whatever the problem is with selenium server standalone build latest 4.0.0-alpha-1. We must update webdriver-manager with selenium server standalone version 3.141.59. Run these commands in terminal:
```
webdriver-manager clean
webdriver-manager update --standalone --versions.standalone=3.141.59
webdriver-manager start --versions.standalone=3.141.59
```

## 3. Run the testcase
From the resource in repo, we run test case with **testng.xml** file or <*the specifically test case*> file at src/main/java/test_cases/UI/
