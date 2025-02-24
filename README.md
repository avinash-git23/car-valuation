# car-valuation

**Getting Started**
Follow these steps to set up and run the Car Valuation Test Automation Suite:

**Prerequisites**
•	Java: Ensure that Java (JDK 11 or later) is installed on your machine.
•	Maven: Install Maven for building and running the project.
•	Google Chrome: The tests use Google Chrome. Make sure Chrome (version 133) is installed.

**Project Setup**

Clone the Repository:
      git clone <git url>

Review the Project Structure:
car-valuation/

      pom.xml
      Contains project configuration, dependencies, and build plugins.

      README.md
      Provides an overview, setup instructions, and documentation for the project.

      src/main/java
      Contains the main application code.

      com.example.model
      Includes the Car.java class, representing a car with attributes such as registration, make/model, and year.
      
      com.example.pages
      Contains the ValuationPage.java class, which implements the Page Object Model to encapsulate interactions with the car valuation website https://motorway.co.uk/.
     
      com.example.utils
      Includes utility classes:
      RegistrationExtractor.java: Extracts vehicle registration numbers from the free-form text file.
      ExpectedCarDataLoader.java: Loads expected car details from a CSV file.
      
      src/test/java
      Contains all test classes.
      
      com.example.tests
      Contains the ValuationTest.java class, which uses TestNG to run tests that compare the actual car details (obtained via the website) with the expected details.
      
      src/test/resources
      Contains resource files used in tests:
      car_input.txt: A free-form text file containing car registration numbers.
      car_output.txt: A CSV file with expected car details.
      testng.xml: The TestNG configuration file that specifies which tests to run.


**Building and Running Tests**

1.	Clean and Build the Project:
      Open a terminal in the project directory and run:
      mvn clean compile

2.	Run the Tests:
      To execute the TestNG test suite, run:
      mvn test
      This command uses Maven Surefire to run the tests defined in the testng.xml file.

3.	Viewing Test Reports:
      After the tests run, Maven Surefire generates reports in the target/surefire-reports directory. You can open the index.html file in your browser to review the test results.
      

**Additional Information**
 WebDriverManager:
      The project uses WebDriverManager to automatically manage the correct version of ChromeDriver for your installed version of Google Chrome.
 Test Execution Environment:
      The tests are written using Selenium WebDriver and TestNG. The project follows the Page Object Model for maintainability and ease of extension.

