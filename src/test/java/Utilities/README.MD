# BMO_JUSTEAT_Testing

This is the Technical task for BMO QA Automation Position.
Task requires:
* writing code to Navigate to [JustEat](https://www.just-eat.co.uk/)
* Locate the Search Bar
* Search for Restaurants in this postal code area AR51 1AA
* Select a Restaurant to order Food
* Select a menu item, in this case, we choose Salad and Drink
* Add these items to cart 
* Check Out

## Requirements
1. Install Java version "1.8.0_251"
    * Set JAVA_HOME in Environmental Variables, JAVA_HOME = C:\Program Files\Java\jdk1.8.0_251
    * Set Java Bin Folder in Path Variable, Path = C:\Program Files\Java\jdk1.8.0_251\bin
2. Download Java Selenium Jars from [Selenium Jars](https://www.selenium.dev/downloads/)
3. Download Browser related Web drivers like [Chromedriver](https://sites.google.com/a/chromium.org/chromedriver/), [Geckodriver](https://firefox-source-docs.mozilla.org/testing/geckodriver/Support.html)
4. Download IntelliJ IDEA Community Version [IntelliJ](https://www.jetbrains.com/idea/download/#section=windows) and install it
5. Save Selenium Jars, Chromedrivers in your Local MAchine

## Instructions to Setup the Project and Code
* Download the BMO_JUST_EAT_PROJECT_TEST.Zip and Extract the file
* Open IntelliJ IDEA and go to File--> Open --> Locate above folder path and load the project into the IDE. If Not Right click on Project and select Add Framework Support and configure Maven Dependencies
* Once Project is loaded Maven and TestNG will be automatically configured into the project
* Load Selenium Jars into Project, File --> Project Structure --> Modules --> Dependencies --> look for '+' and click it to add Jars
* Locate your Selenium Jars and load them into the project

## Instructions to Run the Code
Before Running the code please follow these Instructions
* Go to src\test\java\Utilities\data.properties, Right Click and Find Filepath of the this file
* Go to src\test\java\hsenid\BMO_JUSTEAT_TESTNG.java and locate the variable 'prop_file_path' and load the data.properties file path here
* Go to Data. Properties and find the Key 'chromepath', 'firefoxpath', 'iepath', and load values for these keys.the values for the keys will be saved filepath of downloaded chromedriver, geckodriver, iedriver. 
* Once the above-mentioned Instructions are followed we can either directly run the tests or modify the locators in data.properties file. 
* Advice to Run the Code as it is with the already loaded locators for web elements
* All the test cases are defined using TestNG and you can find them here src\test\java\hsenid\BMO_JUSTEAT_TESTNG.java
* In order to run the code go to src\test\resources\Order_Food_Testng.xml
and run the Order_Food_Testng.xml file.
* BRowser will be invoked and following operations will be done
 1.  Before starting tests we are invoking browser
2. Test--1 Opening Just Eat URL and validating its title
3. Test--2 Finding SEarch bar and SEarching for given Postal code
4. Test--3 Waiting for all Restaurants to open
5. Test--4 Choosing the restaurant that customer wants to order
6. Test--5 Ordering a Beverage
6. Test--6 Ordering Salad Bowl
7. Test--7 Finally Checking out after customers add everything to cart
8. After the test is done Closing Browsers
* Results will be captured in the console with respective method names.
* Also Please refer to the screen recorded video 'BMO_JUSTEAT_SCREENRECORD'  that shared from my execution to get more clarity about instructions. 


## Contact us
Please feel free to reach out to me through email if you have any Questions [Anvesh Poluri](anvesh.poluri@gmail.com), 'anvesh.poluri@gmail.com' 


## License
