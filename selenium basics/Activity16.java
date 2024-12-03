import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) {
        // Initialize Firefox WebDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Open the URL
            driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

            // Get and print the page title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Locate input fields of the Sign Up form
            // Locate the second username field using CSS selector for "ends with"
            WebElement usernameField = driver.findElement(By.cssSelector("input[class$='-username']"));


            WebElement emailField = driver.findElement(By.xpath("//input[starts-with(@placeholder, 'totally.real.email@xyz.com')]"));
            WebElement passwordField = driver.findElement(By.cssSelector("input[class$='-password']"));
            WebElement confirmPasswordField = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));

            // Fill in the details with your own data
            usernameField.sendKeys("John");
            emailField.sendKeys("johndoe@example.com");
            passwordField.sendKeys("Password123");
            confirmPasswordField.sendKeys("Password123");

            // Find and click the "Sign Up" button
            WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]"));
            signUpButton.click();

            // Wait for the success message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement successMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
            );

            // Print the success message
            System.out.println("Success Message: " + successMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}



//public class Activity16 {
//    public static void main(String[] args) {
//        // Set up Firefox driver
//        WebDriverManager.firefoxdriver().setup();
//        // Create a new instance of the Firefox driver
//        WebDriver driver = new FirefoxDriver();
//        // Create the Wait object
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Open the page
//        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
//        // Print the title of the page
//        System.out.println("Home page title: " + driver.getTitle());
//
//        // Find the fields of the sign-up form
//        WebElement userName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
//        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
//        WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input"));
//        WebElement email = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));
//
//        // Type credentials
//        userName.sendKeys("NewUser");
//        password.sendKeys("Password");
//        confirmPassword.sendKeys("Password");
//        email.sendKeys("real_email@xyz.com");
//        // Click Sign Up
//        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
//
//        // Print login message
//        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
//        System.out.println("Login message: " + loginMessage);
//
//        // Close the browser
//        driver.quit();
//    }
//}