package pl.coderslab.shop;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Date;


public class ShoppingSteps {
    WebDriver driver;

    @Given("I'm on the MyStore")
    public void iMOnTheMyStore() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }
    @When("^I login my email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void IloginUsingEmailAndPassword(String email, String password) {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }
    @Then("I click on {string} category")
    public void iClickOnCategory(String clothes) {

        driver.findElement(By.id("category-3")).click();
    }

    @And("I choice {string}")
    public void iChoiceHummingbirdSweater(String sweater) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//img[@alt='Brown bear printed sweater']")).click();
    }

    @Then("I choice size and number of items")
    public void iChoiceSizeAndNumberOfItems() throws InterruptedException {
        WebElement sizeDropdown = driver.findElement(By.xpath("//select[@id='group_1']"));
        Thread.sleep(500);
        sizeDropdown.click();
        sizeDropdown.sendKeys("M");
        sizeDropdown.click();
        WebElement inputElement = driver.findElement(By.xpath("//input[@id='quantity_wanted']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '5'", inputElement);
    }

   @And("I add the product to cart")
    public void iAddTheProductToCart() throws InterruptedException {
        driver.findElement(By.className("add-to-cart")).click();
        driver.findElement(By.xpath("//div[@id='blockcart-modal']//a")).click();
    }

    @Then("I go to option {string} and I click {string} button")
   public void iGoToOptionAndIClickButton(String arg0, String arg1) throws InterruptedException {
       driver.findElement(By.xpath("//a[@href=\"https://mystore-testlab.coderslab.pl/index.php?controller=order\" and @class=\"btn btn-primary\"]")).click();
        Thread.sleep(500);
    }

    @Then("I confirm address")
    public void iConfirmAddress() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary continue float-xs-right\" and @name=\"confirm-addresses\"]")).click();
        Thread.sleep(500);
    }

    @Then("I choice shopping method {string}")
    public void iChoiceShoppingMethod(String arg0) {
        driver.findElement(By.xpath("//label[@for=\"delivery_option_8\" and @class=\"col-xs-9 col-sm-11 delivery-option-2\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"continue btn btn-primary float-xs-right\" and @name=\"confirmDeliveryOption\"]")).click();
    }

    @And("I choice payment option {string}")
    public void iChoicePaymentOption(String arg0) {
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
    }

    @Then("I click on {string} button")
   public void iClickOnButton(String arg0) {
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary center-block\"]")).click();
   }

   @And("I'm doing screenshot with order confirmation")
   public void iMDoingScreenshotWithOrderConfirmation() throws IOException {
        Date currentdate = new Date();
        String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":","-");
       System.out.println(screenshotfilename);
    File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    Files.copy(f.toPath(), new File("F:\\KASIA\\CodersLab\\ZadaniaZaliczeniowe\\screenshot\\" + screenshotfilename +".jpg").toPath());
    }
    @Then("I quit")
    public void iQuit() {
        driver.quit();
    }
}

