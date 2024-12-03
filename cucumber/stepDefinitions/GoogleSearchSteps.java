package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Google Home Page$")
    public void userIsOnGooglePage() throws Throwable {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.get("https://www.google.com");

    }

    @When("^User types in Cheese and hits ENTER$")
    public void userTypesInCheeseAndHitsENTER() throws Throwable {
        WebElement searchbar = driver.findElement(By.tagName("textarea"));

        searchbar.sendKeys("cheese");

        Actions builder = new Actions(driver);

        Action a1 = builder.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
        a1.perform();
    }

    @Then("^Show how many search results were shown$")
    public void showHowManySearchResultsWereShown() throws Throwable {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"hdtb-tls\"]")));
        WebElement toolsbutton = driver.findElement(By.xpath("//div[@id=\"hdtb-tls\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"hdtb-tls\"]")));
        toolsbutton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"result-stats\"]")));
        System.out.println(driver.findElement(By.xpath("//div[@id=\"result-stats\"]")).getText());

    }

    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
}