package weatherDetailsTest;

import callAPIAndUIDetails.CallAPIAndUIClass;
import jsonData.JSONData;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
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

    private WebDriver driver;
    private WebDriverManagerSetup webDriverManagerSetup=new WebDriverManagerSetup();
    private CallAPIAndUIClass callAPIAndUIClass;

    @BeforeMethod
    public void setup() throws IOException, ParseException {
        String browser=System.getProperty("browser");
        JSONData jsonData=new JSONData();
        jsonData= webDriverManagerSetup.readJSONFile();
        driver=webDriverManagerSetup.factoryDriver(driver);

        callAPIAndUIClass=new CallAPIAndUIClass(driver);
        callAPIAndUIClass.homePage();
        callAPIAndUIClass.weatherDetails();
        callAPIAndUIClass.manageWeatherData();
    }

    @Test(priority = 0)
    public void temperatureTest() throws IOException, ParseException {
        JSONData jsonData=new JSONData();
        jsonData= webDriverManagerSetup.readJSONFile();
        callAPIAndUIClass=new CallAPIAndUIClass(driver);
        double tempDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUITemp())-Double.parseDouble(callAPIAndUIClass.getAPITemp()));
        Reporter.log("tempDifference : "+Double.toString(tempDifference));
        Assert.assertTrue(tempDifference>=Double.parseDouble(jsonData.minVariance) && tempDifference<=Double.parseDouble(jsonData.variance));

    }
    @Test(priority = 1)
    public void pressureTest() throws IOException, ParseException {
        JSONData jsonData=new JSONData();
        jsonData= webDriverManagerSetup.readJSONFile();
        callAPIAndUIClass=new CallAPIAndUIClass(driver);
        double pressureDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUIPressure())-Double.parseDouble(callAPIAndUIClass.getAPIPressure()));
        Reporter.log("pressureDifference : "+Double.toString(pressureDifference));
        Assert.assertTrue(pressureDifference>=Double.parseDouble(jsonData.minVariance) && pressureDifference<=Double.parseDouble(jsonData.pressureVariance));
    }
    @Test(priority = 2)
    public void windTest() throws IOException, ParseException {
        JSONData jsonData=new JSONData();
        jsonData= webDriverManagerSetup.readJSONFile();
        callAPIAndUIClass=new CallAPIAndUIClass(driver);
        double uiWindSpeed=(5/18)*(Double.parseDouble(callAPIAndUIClass.getUIWind()));
        double windDifference=Math.abs(uiWindSpeed-Double.parseDouble(callAPIAndUIClass.getAPIWind()));
        Reporter.log("windDifference : "+Double.toString(windDifference));
        Assert.assertTrue(windDifference>=Double.parseDouble(jsonData.minVariance) && windDifference<=Double.parseDouble(jsonData.windVariance));
    }
    @Test(priority = 3)
    public void humidityTest() throws IOException, ParseException {
        JSONData jsonData=new JSONData();
        jsonData= webDriverManagerSetup.readJSONFile();
        callAPIAndUIClass=new CallAPIAndUIClass(driver);
        double humidityDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUIHumidity())-Double.parseDouble(callAPIAndUIClass.getAPIHumidity()));
        Reporter.log("humidityDifference : "+Double.toString(humidityDifference));
        Assert.assertTrue(humidityDifference>=Double.parseDouble(jsonData.minVariance) && humidityDifference<=Double.parseDouble(jsonData.variance));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

//    Final Evaluation



}
