package pl.coderslab.shop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopSteps {
    private static WebDriver driver;

    @Given("I'm on the shop authentication page")
    public void imOnTheShopAuthenticationPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @When("^I login using email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void IloginUsingEmailAndPassword(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }

    @And("I go to {string} page")
    public void iGoToPage(String YourAddress) {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");

}
    @Then("I click {string} button")
    public void iClickButton(String CreateNewAddressBtn) {
        driver.findElement(By.cssSelector("a[data-link-action = 'add-address']")).click();
    }

    @When("I enter new data alias {word} Address {word} City {word} PostalCode {string} Country {string} Phone {string}")
    public void iEnterNewDataAliasAddressCityPostalCodeCountryPhone(String alias, String Address, String City, String PostalCode, String Country, String Phone) {
        driver.findElement(By.name("alias")).sendKeys(alias);
        driver.findElement(By.name("address1")).sendKeys(Address);
        driver.findElement(By.name("city")).sendKeys(City);
        driver.findElement(By.name("postcode")).sendKeys(PostalCode);
        driver.findElement(By.id("field-id_country")).sendKeys(Country);
        driver.findElement(By.name("phone")).sendKeys(Phone);
    }

    @Then("I can click {string} button")
    public void iCanClickButton(String buttonName) {
        driver.findElement(By.className("form-control-submit")).click();
  //  }
    //@And("I can see new address.")
  //  public void iCanSeeNewAddress() {
       // WebElement alert = driver.findElement(By.className("alert-success"));
     //   assertTrue(alert.isDisplayed());
     //   assertEquals(messageText, alert.getText());
   // }

   // @Then("I delete new address")
   // public void iDeleteNewAddress() {
        //driver.findElement(By.cssSelector("a[data-link-action = 'delete-address']")).click();
    }

    //@And("I can see that address is deleted")
   // public void iCanSeeThatAddressIsDeleted() {
        //WebElement alert =  driver.findElement(By.className("alert-success"));
       // assertTrue(alert.isDisplayed());
       // assertEquals(messageText, alert.getText());

   // }
    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();

    }
}

