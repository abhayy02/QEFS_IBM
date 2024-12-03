import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7 {
    public static void main(String[] args) {
        // Setup FirefoxDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Initialize the WebDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Open the specified URL
            driver.get("https://v1.training-support.net/selenium/drag-drop");

            // Get and print the page title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Find the ball element and the two dropzone elements
            WebElement ball = driver.findElement(By.id("draggable"));
            WebElement dropzone1 = driver.findElement(By.id("droppable"));
            WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

            // Create Actions object for performing drag and drop
            Actions actions = new Actions(driver);

            // Drag and drop the ball into Dropzone 1
            actions.clickAndHold(ball).moveToElement(dropzone1).release().perform();

            // Verify that the ball has entered Dropzone 1
            //Assert.assertTrue("Ball not found in Dropzone 1", dropzone1.findElements(By.id("draggable")).size() > 0);
            // Verify that the ball has entered Dropzone 1
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement droppedText1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[1]/p")));
            String droppedText1Value = droppedText1.getText();
            System.out.println("Dropzone 1 text: " + droppedText1Value);

            // Drag and drop the ball into Dropzone 2
            actions.clickAndHold(ball).moveToElement(dropzone2).release().perform();

            // Verify that the ball has entered Dropzone 2
            //Assert.assertTrue("Ball not found in Dropzone 2", dropzone2.findElements(By.id("draggable")).size() > 0);
            WebElement droppedText2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[2]/p")));
            String droppedText2Value = droppedText2.getText();
            System.out.println("Dropzone 2 text: " + droppedText2Value);
        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}