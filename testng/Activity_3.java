import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity_3 {
        WebDriver driver = new FirefoxDriver();
        @BeforeClass
        public void before() {
            driver.get("https://v1.training-support.net/selenium/login-form");
            System.out.println("out");
        }

        @Test(priority = 1)
        public void test() {
            String URLtitle = driver.getTitle();
            System.out.println(URLtitle);
        }

        @Test(priority = 2)
        public void test2() {
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            usernameField.sendKeys("admin");
            passwordField.sendKeys("password");
            WebElement loginButton = driver.findElement(By.xpath("//*[@id='dynamic-attributes-form']/div/button"));
            loginButton.click();
            WebElement confirmationMessage = driver.findElement(By.id("action-confirmation"));
            String message = confirmationMessage.getText();
            System.out.println("Confirmation message: " + message);
            Assert.assertEquals(message, "Welcome Back, admin");

        }



        // Close the browser
        @AfterClass
        public void close() {
            System.out.println("after");
            driver.quit();
        }
    }


