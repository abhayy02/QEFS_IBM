import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        // Configure Firefox options (optional, but can help with certain setups)
        FirefoxOptions options = new FirefoxOptions();

        // Initialize the WebDriver
        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        // Get and print the title of the page
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Locate the checkbox toggle button
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));

        // Click the button to hide the checkbox
        toggleButton.click();

        // Wait until the checkbox disappears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));

        // Click the button to show the checkbox again
        toggleButton.click();

        // Wait until the checkbox appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));

        // Locate the checkbox and select it
        WebElement checkbox = driver.findElement(By.id("dynamicCheckbox"));
        checkbox.click();


        driver.quit();
    }

}

//public class Activity8 {
//    public static void main(String[] args) {
//        // Set up Firefox driver
//        WebDriverManager.firefoxdriver().setup();
//        // Create a new instance of the Firefox driver
//        WebDriver driver = new FirefoxDriver();
//        // Create the Wait object
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Open the page
//        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
//        // Print the title of the page
//        System.out.println("Home page title: " + driver.getTitle());
//
//        // Find the toggle button and click it
//        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
//        toggleButton.click();
//        // Wait for the toggleButton to disappear
//        WebElement dynamicBox = driver.findElement(By.id("dynamicCheckbox"));
//        wait.until(ExpectedConditions.invisibilityOf(dynamicBox));
//        System.out.println(dynamicBox.isDisplayed());
//        // Click the button again
//        toggleButton.click();
//        // Wait for the element to appear
//        wait.until(ExpectedConditions.visibilityOf(dynamicBox));
//        System.out.println(dynamicBox.isDisplayed());
//
//        // Close the browser
//        driver.close();
//    }
//}