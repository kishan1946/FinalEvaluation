package initializer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageInitialization {
    public PageInitialization(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


}
