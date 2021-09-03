package weatherDetailsTest;

import callAPIAndUIDetails.CallAPIAndUIClass;
import jsonData.JSONData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiAutomation.initializer.WebDriverManagerSetup;

import java.io.IOException;

@Listeners(ListenerTest.class)
public class WeatherTest {
    @BeforeMethod
    public void setup() throws IOException, ParseException {
        String browser=System.getProperty("browser");
        JSONData jsonData=new JSONData();
        jsonData= WebDriverManagerSetup.readJSONFile();
        WebDriverManagerSetup.browserSetup(browser, jsonData.url);

        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        callAPIAndUIClass.homePage();
        callAPIAndUIClass.weatherDetails();
        callAPIAndUIClass.manageWeatherData();
    }
    @Test(priority = 0)
    public void temperatureTest() throws IOException, ParseException {
        JSONData jsonData=new JSONData();
        jsonData= WebDriverManagerSetup.readJSONFile();
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        double tempDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUITemp())-Double.parseDouble(callAPIAndUIClass.getAPITemp()));
        System.out.println(tempDifference);
        Reporter.log("tempDifference : "+Double.toString(tempDifference));
        Assert.assertTrue(tempDifference>=Double.parseDouble(jsonData.minVariance) && tempDifference<=Double.parseDouble(jsonData.variance));

    }
    @Test(priority = 1)
    public void pressureTest() throws IOException, ParseException {
        JSONData jsonData=new JSONData();
        jsonData= WebDriverManagerSetup.readJSONFile();
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        double pressureDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUIPressure())-Double.parseDouble(callAPIAndUIClass.getAPIPressure()));
        System.out.println(pressureDifference);
        Reporter.log("pressureDifference : "+Double.toString(pressureDifference));
        Assert.assertTrue(pressureDifference>=Double.parseDouble(jsonData.minVariance) && pressureDifference<=Double.parseDouble(jsonData.pressureVariance));
    }
    @Test(priority = 2)
    public void windTest() throws IOException, ParseException {
        JSONData jsonData=new JSONData();
        jsonData= WebDriverManagerSetup.readJSONFile();
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        double uiWindSpeed=(5/18)*(Double.parseDouble(callAPIAndUIClass.getUIWind()));
        double windDifference=Math.abs(uiWindSpeed-Double.parseDouble(callAPIAndUIClass.getAPIWind()));
        System.out.println(windDifference);
        Reporter.log("windDifference : "+Double.toString(windDifference));
        Assert.assertTrue(windDifference>=Double.parseDouble(jsonData.minVariance) && windDifference<=Double.parseDouble(jsonData.windVariance));
    }
    @Test(priority = 3)
    public void humidityTest() throws IOException, ParseException {
        JSONData jsonData=new JSONData();
        jsonData= WebDriverManagerSetup.readJSONFile();
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        double humidityDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUIHumidity())-Double.parseDouble(callAPIAndUIClass.getAPIHumidity()));
        System.out.println(humidityDifference);
        Reporter.log("humidityDifference : "+Double.toString(humidityDifference));
        Assert.assertTrue(humidityDifference>=Double.parseDouble(jsonData.minVariance) && humidityDifference<=Double.parseDouble(jsonData.variance));
    }

    @AfterMethod
    public void tearDown(){
        WebDriverManagerSetup.tearDown();
    }


}
