package uiAutomation.classPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiAutomation.initializer.PageInitialization;
import uiAutomation.initializer.WebDriverManagerSetup;

public class WeatherDetails extends PageInitialization {
    public WeatherDetails(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".text")
    WebElement moreDetails;
    @FindBy(id = "dismiss-button")
    WebElement removeAdd;
//    @FindBy(css = ".content-module.subnav-pagination")
//    WebElement scrollUptoWeather;
    @FindBy(id = "google_ads_iframe_/6581/web/in/interstitial/weather/local_home_0")
    WebElement frameID;

    public void setMoreDetails(){
        moreDetails.click();
    }
    public void switchToFrame(){
        WebDriverManagerSetup webDriverManagerSetup=new WebDriverManagerSetup();
        webDriverManagerSetup.driver.switchTo().frame(frameID);
//        actions.moveToElement(removeAdd).click().build().perform();
        removeAdd.click();
    }
    public WebElement switchToiFrame(){
        return frameID;
    }
    public WebElement getRemoveAdd(){
        return removeAdd;
    }
    public void scroll(){
//        js.executeScript("arguments[0].scrollIntoView();",scrollUptoWeather);
    }

    public void weatherDetailsClassCall(){
        setMoreDetails();
        switchToFrame();
        scroll();
    }

}
