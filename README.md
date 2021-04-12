# The simple example project how to work with UIAutomator framework

## Test scenario:
- Create application for authorization (Login and Register).
- Create automation scripts for Login and Register.
- Generate report for automation scripts. 
    
## Requirements:
- Use any *object-oriented language* (Java or Kotlin).
- Use UIAutomator.
- Use automation patterns like *PageObject*, *data-driven* tests, etc.
- Use any testing frameworks (JUnit or TestNG). 
- provide code and clear instructions how to run it.

**Note**: please put your code in public repository.

**Note**: Please send link to this repo when you are done.

**Note**: Before launching the application, you need to create an account on the site https://www.back4app.com/ After it needs to add app_id and app_key

You will need the following technologies available to try it out:
* Git
* Gradle 3+
* JDK 8
* Android Studio 
* Web browser Chrome

### Ho w to run

```./gradlew connectedAndroidTest```

- [x] ability to run tests for different browsers/os by configuring;
- [x] ability to run tests for different environments(urls) by configuring/by command-line.

```./gradlew test``` 

### Generate Allure report 

```gradle allure:report```

### Open Allure report in browser

```gradle allure:serve```


![](https://a.radikal.ru/a39/2006/0b/a94fed92741c.png) 

![](https://b.radikal.ru/b31/2006/b7/a83835f0d1a6.png)
