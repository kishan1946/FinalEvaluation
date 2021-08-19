package callAPIAndUIDetails;

import apiManage.apiResonse.GetWeatherDetailsResponse;
import apiManage.apiResonse.ManageWeatherDetails;
import initializer.JSONData;
import initializer.WebDriverManagerSetup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import uiAutomation.classPage.HomePage;
import uiAutomation.classPage.ManageWeatherData;
import uiAutomation.classPage.WeatherDetails;
import uiAutomation.weatherData.Data;

import java.io.IOException;

public class CallAPIAndUIClass {
    public void homePage() throws IOException, ParseException {
        JSONData jsonData=new JSONData();
        jsonData=WebDriverManagerSetup.readJSONFile();
        HomePage homePage=new HomePage(WebDriverManagerSetup.driver);
        homePage.setSearchBar(jsonData.city);

    }
    public void weatherDetails(){
        WeatherDetails weatherDetails=new WeatherDetails(WebDriverManagerSetup.driver);
        weatherDetails.setMoreDetails();
        WebElement switchToiFrame=weatherDetails.switchToiFrame();
        WebElement removeAdd=weatherDetails.getRemoveAdd();
        WebDriverManagerSetup.driver.switchTo().frame(switchToiFrame);
        removeAdd.click();
        weatherDetails.scroll();
    }
    public void manageWeatherData(){
        ManageWeatherData manageWeatherData=new ManageWeatherData(WebDriverManagerSetup.driver);
        Data weatherData=new Data();
        weatherData.setTemp(manageWeatherData.getTemp());
        weatherData.setPressure(manageWeatherData.getPressure());
        weatherData.setWind(manageWeatherData.getWind());
        weatherData.setHumidity(manageWeatherData.getHumidity());

//        System.out.println(getUITemp());
//        System.out.println(getUIPressure());
//        System.out.println(getUIWind());
//        System.out.println(getUIHumidity());

    }
    public String getUITemp(){
        ManageWeatherData manageWeatherData=new ManageWeatherData(WebDriverManagerSetup.driver);
        Data data=new Data();
        data.setTemp(manageWeatherData.getTemp());
        return data.getTemp();
    }
    public String getUIPressure(){
        ManageWeatherData manageWeatherData=new ManageWeatherData(WebDriverManagerSetup.driver);
        Data data=new Data();
        data.setPressure(manageWeatherData.getPressure());
        return data.getPressure();
    }
    public String getUIWind(){
        ManageWeatherData manageWeatherData=new ManageWeatherData(WebDriverManagerSetup.driver);
        Data data=new Data();
        data.setWind(manageWeatherData.getWind());
        return data.getWind();
    }
    public String getUIHumidity(){
        ManageWeatherData manageWeatherData=new ManageWeatherData(WebDriverManagerSetup.driver);
        Data data=new Data();
        data.setHumidity(manageWeatherData.getHumidity());
        return data.getHumidity();
    }



    public void apiPackageCall() throws IOException, ParseException {
        ManageWeatherDetails manageWeatherDetails=new ManageWeatherDetails();
        GetWeatherDetailsResponse getWeatherDetailsResponse=new GetWeatherDetailsResponse();
        getWeatherDetailsResponse.setTemp(manageWeatherDetails.getTemp());
        getWeatherDetailsResponse.setPressure(manageWeatherDetails.getPressure());
        getWeatherDetailsResponse.setHumidity(manageWeatherDetails.getHumidity());
        getWeatherDetailsResponse.setWind(manageWeatherDetails.getWind());
//        System.out.println(getWeatherDetailsResponse.getTemp());
//
//        System.out.println(getAPITemp());
//        System.out.println(getAPIPressure());
//        System.out.println(getAPIWind());
//        System.out.println(getAPIHumidity());

    }

    public String getAPITemp() throws IOException, ParseException {
        ManageWeatherDetails manageWeatherDetails=new ManageWeatherDetails();
        GetWeatherDetailsResponse getWeatherDetailsResponse=new GetWeatherDetailsResponse();
        getWeatherDetailsResponse.setTemp(manageWeatherDetails.getTemp());

        return getWeatherDetailsResponse.getTemp();
    }
    public String getAPIPressure() throws IOException, ParseException {
        ManageWeatherDetails manageWeatherDetails=new ManageWeatherDetails();
        GetWeatherDetailsResponse getWeatherDetailsResponse=new GetWeatherDetailsResponse();
        getWeatherDetailsResponse.setPressure(manageWeatherDetails.getPressure());
        return getWeatherDetailsResponse.getPressure();
    }
    public String getAPIWind() throws IOException, ParseException {
        ManageWeatherDetails manageWeatherDetails=new ManageWeatherDetails();
        GetWeatherDetailsResponse getWeatherDetailsResponse=new GetWeatherDetailsResponse();
        getWeatherDetailsResponse.setWind(manageWeatherDetails.getWind());
        return getWeatherDetailsResponse.getWind();
    }
    public String getAPIHumidity() throws IOException, ParseException {
        ManageWeatherDetails manageWeatherDetails=new ManageWeatherDetails();
        GetWeatherDetailsResponse getWeatherDetailsResponse=new GetWeatherDetailsResponse();
        getWeatherDetailsResponse.setHumidity(manageWeatherDetails.getHumidity());
        return getWeatherDetailsResponse.getHumidity();
    }
}
