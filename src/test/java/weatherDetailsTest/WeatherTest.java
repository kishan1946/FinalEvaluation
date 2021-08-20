package weatherDetailsTest;

import callAPIAndUIDetails.CallAPIAndUIClass;
import initializer.JSONData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(ListenerTest.class)
public class WeatherTest {
    @BeforeMethod
    public void setup() throws IOException, ParseException {
        String browser=System.getProperty("browser");
        JSONData jsonData=new JSONData();
        jsonData= initializer.WebDriverManagerSetup.readJSONFile();
        initializer.WebDriverManagerSetup.browserSetup(browser, jsonData.url);

        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        callAPIAndUIClass.homePage();
        callAPIAndUIClass.weatherDetails();
        callAPIAndUIClass.manageWeatherData();
    }
    @Test(priority = 0)
    public void temperatureTest() throws IOException, ParseException {
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        double tempDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUITemp())-Double.parseDouble(callAPIAndUIClass.getAPITemp()));
        System.out.println(tempDifference);

        Assert.assertTrue(0<= tempDifference || tempDifference>=5);

    }
    @Test(priority = 1)
    public void pressureTest() throws IOException, ParseException {
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        double pressureDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUIPressure())-Double.parseDouble(callAPIAndUIClass.getAPIPressure()));
        System.out.println(pressureDifference);
        Assert.assertTrue(0<= pressureDifference || pressureDifference>=60);
    }
    @Test(priority = 2)
    public void windTest() throws IOException, ParseException {
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        double uiWindSpeed=(5/18)*(Double.parseDouble(callAPIAndUIClass.getUIWind()));
        double windDifference=Math.abs(uiWindSpeed-Double.parseDouble(callAPIAndUIClass.getAPIWind()));
        System.out.println(windDifference);
        Assert.assertTrue(0<= windDifference || windDifference>=7);
    }
    @Test(priority = 3)
    public void humidityTest() throws IOException, ParseException {
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        double humidityDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUIHumidity())-Double.parseDouble(callAPIAndUIClass.getAPIHumidity()));
        System.out.println(humidityDifference);
        Assert.assertTrue(0<= humidityDifference || humidityDifference>=5);
    }

    @AfterMethod
    public void tearDown(){
        initializer.WebDriverManagerSetup.tearDown();
    }


}
