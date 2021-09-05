package weatherDetailsTest;

import callAPIAndUIDetails.CallAPIAndUIClass;
import comparator.Comparator;
import jsonData.JSONData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import uiAutomation.initializer.WebDriverManagerSetup;

import java.io.IOException;

@Listeners(ListenerTest.class)
public class WeatherDataTest {

    private WebDriver driver;
    private WebDriverManagerSetup webDriverManagerSetup=new WebDriverManagerSetup();
    private CallAPIAndUIClass callAPIAndUIClass;
    private Comparator comparator;

    @DataProvider(name = "setMetricName")
    public Object[][] createdpMethod() {
        return  new Object[][] {{"Temperature"}, {"Pressure"}, {"Wind"}, {"Humidity"}};
    }

    @BeforeMethod
    public void setup() throws IOException, ParseException {
        String browser=System.getProperty("browser");
        JSONData data=new JSONData();
        data= webDriverManagerSetup.readJSONFile();
        driver=webDriverManagerSetup.factoryDriver(driver);

        callAPIAndUIClass=new CallAPIAndUIClass(driver);
        callAPIAndUIClass.homePage();
        callAPIAndUIClass.weatherDetails();
        callAPIAndUIClass.manageWeatherData();
    }
    @Test(dataProvider = "setMetricName")
    public void weatherDataTest(String metricName) throws Exception {
        comparator=new Comparator(driver);
        String matcher=comparator.metricComparator(metricName);
        String actualMatcher="Metric Data Match";
        Assert.assertEquals(actualMatcher,matcher);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
