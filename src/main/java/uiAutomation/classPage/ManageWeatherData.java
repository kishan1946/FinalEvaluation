package uiAutomation.classPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiAutomation.initializer.PageInitialization;
import uiAutomation.weatherData.Data;

public class ManageWeatherData extends PageInitialization {
    public ManageWeatherData(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".display-temp")
    WebElement temp;
    @FindBy(xpath = "//div[1]/div[3][@class=\"detail-item spaced-content\"]/div[2]")
    WebElement wind;
    @FindBy(xpath = "//div[1]/div[6][@class=\"detail-item spaced-content\"]/div[2]")
    WebElement humidity;
    @FindBy(xpath = "//div[2]/div[2][@class=\"detail-item spaced-content\"]/div[2]")
    WebElement pressure;

    public String getTemp() {
        return temp.getText().replaceAll("[^\\d]","").trim();
    }
    public String getWind() {
        return wind.getText().replaceAll("[^\\d]","").trim();
    }
    public String getHumidity() {
        return humidity.getText().replaceAll("[^\\d]","").trim();
    }
    public String getPressure() {
        return pressure.getText().replaceAll("[^\\d]","").trim();
    }

    public void setData(){
        Data data=new Data();
        data.setTemp(getTemp());
        data.setPressure(getPressure());
        data.setWind(getWind());
        data.setHumidity(getHumidity());
    }

}
