import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Activity_6 {
    WebDriver driver;
    @BeforeClass
    public void beforeTest() {
        driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) {
        // Locate the username and password fields and login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));

        // Enter credentials and click the login button
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage, "Welcome Back, admin");
    }


    @AfterClass
    public void close() {
        System.out.println("after");
        driver.quit();
    }
}
