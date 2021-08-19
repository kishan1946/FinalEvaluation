package UIAutomation.classPage;

import UIAutomation.initializer.PageInitialization;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageInitialization {
    public Actions actions;
    public HomePage(WebDriver driver) {
        super(driver);
        this.actions=new Actions(driver);
    }

    @FindBy(css = ".search-input[name=\"query\"]")
    WebElement searchBar;
    @FindBy(css = ".search-bar-result.search-result")
    WebElement locationSelection;

    public void setSearchBar(String city){
        searchBar.sendKeys(city);
        actions.moveToElement(locationSelection).click().build().perform();
    }

}
