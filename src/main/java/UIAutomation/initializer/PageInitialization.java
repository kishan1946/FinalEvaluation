package uiAutomation.initializer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageInitialization {
//    public Actions actions;
//    public JavascriptExecutor js;
//    public WebDriver driver;
    public PageInitialization(WebDriver driver) {
        PageFactory.initElements(driver,this);
//        this.actions=new Actions(driver);
//        this.js=(JavascriptExecutor) driver;
    }

//    WebDriverManagerSetup webDriverManagerSetup=new WebDriverManagerSetup();
//    public Actions actions=new Actions(webDriverManagerSetup.driver);
//    public JavascriptExecutor js=(JavascriptExecutor) driver;
}
