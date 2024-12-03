import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity17 {
    public static void main(String[] args) {

        // Initialize Firefox WebDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Open the URL
            driver.get("https://v1.training-support.net/selenium/selects");

            // Get the page title and print it
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Locate the single select dropdown
            WebElement singleSelectDropdown = driver.findElement(By.id("single-select"));

            // Create a Select object for interacting with the dropdown
            Select select = new Select(singleSelectDropdown);

            // Select the second option by visible text
            select.selectByVisibleText("Option 2");
            System.out.println("Selected: " + select.getFirstSelectedOption().getText());

            // Select the third option by index
            select.selectByIndex(3); // Index is 0-based
            System.out.println("Selected: " + select.getFirstSelectedOption().getText());

            // Select the fourth option by value
            select.selectByValue("4");
            System.out.println("Selected: " + select.getFirstSelectedOption().getText());

            // Get all the options in the dropdown
            List<WebElement> allOptions = select.getOptions();
            System.out.println("All options in the dropdown:");
            for (WebElement option : allOptions) {
                System.out.println(option.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
