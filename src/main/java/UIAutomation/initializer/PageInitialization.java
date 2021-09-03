package uiAutomation.initializer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageInitialization {
    public PageInitialization(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

//    public Actions actions=new Actions(webDriverManagerSetup.driver);
//    public JavascriptExecutor js=(JavascriptExecutor) driver;
}
