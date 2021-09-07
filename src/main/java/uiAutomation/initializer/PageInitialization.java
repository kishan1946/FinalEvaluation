package uiAutomation.initializer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageInitialization {
//    private WebDriver driver;
    public PageInitialization(WebDriver driver) {
        PageFactory.initElements(driver,this);
//        this.driver=driver;
    }

//    WebDriverManagerSetup webDriverManagerSetup=new WebDriverManagerSetup();
//    public Actions actions=new Actions(driver);
//    public JavascriptExecutor js=(JavascriptExecutor) driver;
}
