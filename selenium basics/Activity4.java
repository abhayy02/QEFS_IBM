import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class Activity4 {
    public static void main(String[] args) {
        // Setup FirefoxDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Configure Firefox options (optional, but can help with certain setups)
        FirefoxOptions options = new FirefoxOptions();

        // Initialize the WebDriver
        WebDriver driver = new FirefoxDriver(options);

        try {
            // Open the specified URL
            driver.get("https://v1.training-support.net/selenium/target-practice");

            // Get and print the page title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Find and print the 3rd header using xpath
            WebElement thirdHeader = driver.findElement(By.xpath("//*[@id='third-header']"));
            System.out.println("3rd Header Text: " + thirdHeader.getText());

            // Find and print the 5th header's color using xpath
            WebElement fifthHeader = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
            System.out.println("5th Header Color: " + fifthHeader.getCssValue("color"));

            // Find and print the classes of the violet button
            WebElement violetButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]/button[3]"));
            System.out.println("Violet Button Classes: " + violetButton.getAttribute("class"));

            // Find and print all elements within the same class as the violet button
            /*WebElement violetButtonParent = violetButton.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]"));
            List<WebElement> elementsInVioletClass = violetButtonParent.findElements(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[2]"));

            System.out.println("\nAll Elements in Violet Button's Parent Class:");
            for (int i = 0; i < elementsInVioletClass.size(); i++) {
                WebElement element = elementsInVioletClass.get(i);
                System.out.println("Element " + (i+1) + ":");
                System.out.println("  Tag: " + element.getTagName());
                System.out.println("  Text: " + element.getText());
                System.out.println("  Classes: " + element.getAttribute("class"));
            }*/

            // Find and print the text of the grey button
            WebElement greyButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
            System.out.println("Grey Button Text: " + greyButton.getText());

        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}