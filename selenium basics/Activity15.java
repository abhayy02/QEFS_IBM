import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Activity15 {
    public static void main(String[] args) {

        // Initialize Firefox WebDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Open the URL
            driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

            // Get and print the page title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Find username and password fields by dynamic attributes
            WebElement usernameField = driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Username')]"));
            WebElement passwordField = driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Password')]"));

            // Enter credentials
            usernameField.sendKeys("admin");
            passwordField.sendKeys("password");

            // Find and click the login button
            WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
            loginButton.click();

            // Wait for the login message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
            );

            // Print the login message
            System.out.println("Login Message: " + loginMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
