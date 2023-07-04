package pl.coderslab.shop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourAddressesPage {
    private static WebDriver driver;
    @FindBy(name = "submitAddress")
    private WebElement newAddressBtn;

    @FindBy(className = "clearfix")
    private static List<WebElement> addresses;
    @FindBy(className = "alert-success")
    private WebElement successAlert;

    public YourAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static boolean addressIsVisible() {
        return addressIsVisible();
    }

    public boolean isSuccessAlertDisplayed() {

        return successAlert.isDisplayed();
    }

    public String getSuccessMessage() {

        return successAlert.getText();
    }

    public String getUserName() {
        Alert userInfo = null;
        return userInfo.getText();
  
    }
}
