package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.*;

public class Activity2 {

    WebDriver driver;

    @Given("User is on Login page")
    public void userIsOnLoginPage() {
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("User enters username and password")
    public void userEntersUsernameAndPassword() {
        WebElement usernameField = driver.findElement(By.id("username")); // Replace with actual ID or locator
        WebElement passwordField = driver.findElement(By.id("password")); // Replace with actual ID or locator

        usernameField.sendKeys("admin"); // Replace with actual username
        passwordField.sendKeys("password"); // Replace with actual password

        WebElement loginButton = driver.findElement(By.cssSelector("button.ui:nth-child(4)")); // Replace with actual ID or locator
        loginButton.click();
    }

    @Then("Read the page title and confirmation message")
    public void readThePageTitleAndConfirmationMessage() {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        WebElement confirmationMessage = driver.findElement(By.id("action-confirmation")); // Replace with actual ID or locator
        System.out.println("Confirmation Message: " + confirmationMessage.getText());
    }

    @And("Close the Browser")
    public void closeTheBrowser() {
            driver.quit();

    }
}


//public class LoginSteps {
//    WebDriver driver;
//    WebDriverWait wait;
//
//    @Given("^User is on Login page$")
//    public void loginPage() {
//        //Setup instances
//        driver = new FirefoxDriver();
//        wait = new WebDriverWait(driver, 10);
//
//        //Open browser
//        driver.get("https://v1.training-support.net/selenium/login-form");
//    }
//
//    @When("^User enters username and password$")
//    public void enterCredentials() {
//        //Enter username
//        driver.findElement(By.id("username")).sendKeys("admin");
//        //Enter password
//        driver.findElement(By.id("password")).sendKeys("password");
//        //Click Login
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//    }
//
//    @Then("^Read the page title and confirmation message$")
//    public void readTitleAndHeading() {
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
//
//        //Read the page title and heading
//        String pageTitle = driver.getTitle();
//        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
//
//        //Print the page title and heading
//        System.out.println("Page title is: " + pageTitle);
//        System.out.println("Login message is: " + confirmMessage);
//    }
//
//    @And("^Close the Browser$")
//    public void closeBrowser() {
//        //Close browser
//        driver.close();
//    }
//}