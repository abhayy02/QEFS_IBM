import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        // Initialize the Chrome WebDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Navigate to the login page
            driver.get("https://v1.training-support.net/selenium/login-form");

            // Get and print the page title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Find username field using ID and enter "admin"
            WebElement usernameField = driver.findElement(By.xpath("//*[@id='username']"));
            usernameField.sendKeys("admin");

            // Find password field using name attribute and enter "password"
            WebElement passwordField = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/input"));
            passwordField.sendKeys("password");

            // Find login button using CSS Selector and click it
            //WebElement loginButton = driver.findElement(By.cssSelector(".ui.button"));
            //loginButton.click();
            driver.findElement(By.xpath("//button[text()='Log in']")).click();
            // Add a small delay to see the result
            //Thread.sleep(2000);
            String message = driver.findElement(By.id("action-confirmation")).getText();
            System.out.println("Login message: " + message);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}