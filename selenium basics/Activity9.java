import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//
import java.time.Duration;
//
//public class Activity9 {
//    public static void main(String[] args) {
//
//        // Initialize the WebDriver
//        WebDriver driver = new FirefoxDriver();
//
//        try {
//            // Open the URL
//            driver.get("https://v1.training-support.net/selenium/ajax");
//
//            // Get and print the title of the page
//            String title = driver.getTitle();
//            System.out.println("Page Title: " + title);
//
//            // Locate the "Change content" button and click it
//            WebElement changeContentButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/button"));
//            changeContentButton.click();
//
//            // Create an explicit wait
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//            // Wait for the text to say "HELLO!" and print it
//            WebElement helloMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ajax-content")));
//            System.out.println("First Message: " + helloMessage.getText());
//
//            // Wait for the text to change to contain "I'm late!" and print it
//            WebElement lateMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/h3")));
//            System.out.println("Second Message: " + lateMessage.getText());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Close the browser
//            driver.quit();
//        }
//    }
//}
//
//
////wait.until(ExpectedConditions.visibilityOf(dynamicBox));
////        System.out.println(dynamicBox.isDisplayed());

public class Activity9 {
    public static void main(String[] args) {
        // Setup the driver
        WebDriverManager.firefoxdriver().setup();
        // Driver object reference
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/ajax");

        // Find the button and click it
        driver.findElement(By.cssSelector("button.violet")).click();
        // Wait for the new elements to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        // Find and print the new text
        String text = driver.findElement(By.tagName("h1")).getText();
        System.out.println(text);

        WebElement delayedText = driver.findElement(By.tagName("h3"));
        System.out.println(delayedText.getText());
        // Wait for the delayed text and print it
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        String lateText = driver.findElement(By.tagName("h3")).getText();
        System.out.println(lateText);

        // Close the browser
        driver.quit();}}