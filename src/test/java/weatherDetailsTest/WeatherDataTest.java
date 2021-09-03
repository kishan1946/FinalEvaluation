package weatherDetailsTest;

import callAPIAndUIDetails.CallAPIAndUIClass;
import comparator.Comparator;
import jsonData.JSONData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;
import uiAutomation.initializer.WebDriverManagerSetup;

import java.io.IOException;

@Listeners(ListenerTest.class)
public class WeatherDataTest {
    @DataProvider(name = "setMetricName")
    public Object[][] createdpMethod() {
        return  new Object[][] {{"Temperature"}, {"Pressure"}, {"Wind"}, {"Humidity"}};
    }

    @BeforeMethod
    public void setup() throws IOException, ParseException {
        String browser=System.getProperty("browser");
        JSONData data=new JSONData();
        data= WebDriverManagerSetup.readJSONFile();
        WebDriverManagerSetup.browserSetup(browser, data.url);

        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        callAPIAndUIClass.homePage();
        callAPIAndUIClass.weatherDetails();
        callAPIAndUIClass.manageWeatherData();
    }
    @Test(dataProvider = "setMetricName")
    public void weatherDataTest(String metricName) throws Exception {
        Comparator comparator=new Comparator();
        System.out.println(comparator.metricComparator(metricName));
        String matcher=comparator.metricComparator(metricName);
        String actualMatcher="Metric Data Match";
        Assert.assertEquals(actualMatcher,matcher);
    }
    @AfterMethod
    public void tearDown(){
        WebDriverManagerSetup.tearDown();
    }
}
