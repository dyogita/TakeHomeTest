Mail Travel Test Automation using **Selenium**, **Cucumber**, **Maven**, **Extent Report** and **Java Language** 
---
---

## Pre-requisites - Java and Maven 

##### [Java 1.8 - Download](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) 
```
Ensure JAVA_HOME environment variable is set and points to your JDK installation
Example: C:\Program Files\Java\jdk1.8.0_291
```

##### [Maven - Download](https://maven.apache.org/download.cgi) as your build tools
```
Unzip apache-maven-<<version>>-bin.zip
Add the bin directory of the created directory apache-maven-<<version>> to the PATH environment variable
Confirm with mvn -v in a new shell
```

## Execution Steps

#### 1. Run the Test
* Navigate to the project directory where pom.xml is there.
* Run the test using `mvn install` from Terminal

#### 2. Test Result 
* Note:- Reports are generated in the below paths once mvn install completes the Tests.
* Spark Report:
*         'Project Dir'\test-output\SparkReport dd-May-21\test-output\SparkReport\Spark.html
*  ![image](https://user-images.githubusercontent.com/84290935/118418042-b14b5100-b6ae-11eb-9dc0-4982e152f0e9.png)
*  ![image](https://user-images.githubusercontent.com/84290935/118418066-cb852f00-b6ae-11eb-9503-0bb08284f0d0.png)


