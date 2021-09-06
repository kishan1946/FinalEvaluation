# FinalEvaluation

**Patterns Used in Application**

* Factory Pattern - [Initializer](https://gitlab.com/kishank1946/finalevaluation/-/tree/main/src/main/java/uiAutomation/initializer) Added Factory Pattern in initializer package.

    * Classes- [WebDriverSetup Class](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/main/java/uiAutomation/initializer/WebDriverManagerSetup.java)    [PageInitialization Class](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/main/java/uiAutomation/initializer/PageInitialization.java)

* Page Object Model -
    * [HomePage Class](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/main/java/uiAutomation/classPage/HomePage.java)
    * [WeatherDetails Class](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/main/java/uiAutomation/classPage/WeatherDetails.java)
    * [ManageWeatherData Class](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/main/java/uiAutomation/classPage/ManageWeatherData.java)


**Features**

1 Cross browser testing handled for both *Chrome* as well as *Firefox* browser.

2 Test created for comparing data for certain variance.

3 *`TestNG Report`* and *`Suit Report`* created.


**Test**

* [WeatherDataTest Class](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/test/java/weatherDetailsTest/WeatherDataTest.java) comparing UI and API data test by using comparator if test is failed throws matcher exception [MatcherException Class](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/test/java/exception/MatcherException.java)

* [WeatherTest Class](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/test/java/weatherDetailsTest/WeatherTest.java) comapring UI and API value by *Assert.assertTrue*.
* [CallAPIAndUiClass](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/test/java/exception/MatcherException.java) created for fetching all the data  by calling all the class of APIAutomation and UIAutomation.

* [comparator](https://gitlab.com/kishank1946/finalevaluation/-/tree/main/src/test/java/comparator) created for comparator and variance difference calculator.

* Used four `metric` for test- *Temperature* , *Pressure* , *WindSpeed* , *Humidity*.

**Data Driven**
* All the data fetched from `JSON` [inputData.json](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/json/inputData.json)
* [JsonData Class](https://gitlab.com/kishank1946/finalevaluation/-/blob/main/src/main/java/jsonData/JSONData.java) created class for fetching all json data.

**Maven Command-**

#### To run the test suite by default browser
    mvn clean test
#### To run for clean compile
    mvn clean compile
#### To run without any specific test
    mvn clean test
#### To run the specific test
    mvn -Dtest=WeatherDataTest/WaetherTest test
#### To run the test suite on specific browser
    mvn -Dbrowser=chrome/firefox test
