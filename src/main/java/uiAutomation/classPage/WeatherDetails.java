package uiAutomation.classPage;

import uiAutomation.initializer.PageInitialization;
import uiAutomation.initializer.WebDriverManagerSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WeatherDetails extends PageInitialization {
    public Actions actions;
    public JavascriptExecutor js;
    public WeatherDetails(WebDriver driver) {
        super(driver);
        this.actions=new Actions(driver);
        this.js=(JavascriptExecutor) driver;
    }

    @FindBy(css = ".text")
    WebElement moreDetails;
    @FindBy(id = "dismiss-button")
    WebElement removeAdd;
    @FindBy(css = ".content-module.subnav-pagination")
    WebElement scrollUptoWeather;
    @FindBy(id = "google_ads_iframe_/6581/web/in/interstitial/weather/local_home_0")
    WebElement frameID;

    public void setMoreDetails(){
        moreDetails.click();
    }
    public void switchToFrame(){
        WebDriverManagerSetup.driver.switchTo().frame(frameID);
        actions.moveToElement(removeAdd).click().build().perform();
    }
    public WebElement switchToiFrame(){
        return frameID;
    }
    public WebElement getRemoveAdd(){
        return removeAdd;
    }
    public void scroll(){
        js.executeScript("arguments[0].scrollIntoView();",scrollUptoWeather);
    }

    public void weatherDetailsClassCall(){
        setMoreDetails();
        switchToFrame();
        scroll();
    }

}
