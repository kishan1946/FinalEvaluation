package uiAutomation.initializer;

import io.github.bonigarcia.wdm.WebDriverManager;
import jsonData.JSONData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import uiAutomation.classPage.HomePage;
import uiAutomation.classPage.ManageWeatherData;
import uiAutomation.classPage.WeatherDetails;
import uiAutomation.weatherData.Data;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManagerSetup {
    public static WebDriver driver;
    public static JSONObject jsonobj;
    public static void browserSetup(String browser, String url){
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
//            options.addArguments("--headless");
            driver=new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options=new FirefoxOptions();
//            options.addArguments("--headless");
            driver=new FirefoxDriver(options);
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static JSONData readJSONFile() throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        FileReader reader = new FileReader("./json/inputData.json");
        Object obj=jsonParser.parse(reader);
        jsonobj=(JSONObject) obj;

        return new JSONData((String) jsonobj.get("browser"),(String) jsonobj.get("city"),(String) jsonobj.get("url"),
                (String) jsonobj.get("userDetailsApi"),(String) jsonobj.get("q"),(String) jsonobj.get("units"),
                (String) jsonobj.get("appid"),(String) jsonobj.get("variance"),
                (String) jsonobj.get("pressureVariance"),(String) jsonobj.get("windVariance"),(String) jsonobj.get("minVariance"));
    }

    public static void tearDown(){
        driver.close();
    }

    public static void main(String[] args) throws IOException, ParseException {

        JSONData data1=new JSONData();
        data1=readJSONFile();
        System.out.println(data1.browser);
        browserSetup(data1.browser, data1.url);

        HomePage homePage=new HomePage(driver);
        homePage.setSearchBar(data1.city);

        WeatherDetails weatherDetails=new WeatherDetails(driver);
//        weatherDetails.setMoreDetails();
//        weatherDetails.switchToFrame();
//        weatherDetails.scroll();
        weatherDetails.weatherDetailsClassCall();

        Data data=new Data();
        ManageWeatherData manageWeatherData=new ManageWeatherData(driver);
        data.setTemp(manageWeatherData.getTemp());
        data.setPressure(manageWeatherData.getPressure());
        data.setWind(manageWeatherData.getWind());
        data.setHumidity(manageWeatherData.getHumidity());

        System.out.println("Temperature: "+data.getTemp()+" °C");
        System.out.println("Pressure: "+data.getPressure()+" mbar");
        System.out.println("Humodity: "+data.getHumidity()+" %");
        System.out.println("Wind Speed: "+data.getWind()+" km/h");

        tearDown();
    }
}
