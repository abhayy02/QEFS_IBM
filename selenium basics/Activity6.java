import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity6 {
    public static void main(String[] args) {
        // Setup FirefoxDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Initialize the WebDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Open the specified URL
            driver.get("https://v1.training-support.net/selenium/input-events");

            // Get and print the page title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Create Actions object for performing keyboard interactions
            Actions actions = new Actions(driver);

            // Press the first letter of your name in uppercase
            char firstName = 'A'; // Replace with the first letter of your first name
            actions.keyDown(Character.toString(firstName).toUpperCase()).keyUp(Character.toString(firstName).toUpperCase()).perform();

            // Press CTRL+A to select all text on the page
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

            // Press CTRL+C to copy the selected text
            actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}