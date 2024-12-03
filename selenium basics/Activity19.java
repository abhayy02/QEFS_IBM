import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Activity19 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        try {
            // Open the website
            driver.get("https://v1.training-support.net/selenium/javascript-alerts");

            // Get and print the title of the page
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Locate and click the button to open a CONFIRM alert
            WebElement confirmButton = driver.findElement(By.id("confirm"));
            confirmButton.click();

            // Switch to the Alert box
            Alert alert = driver.switchTo().alert();

            // Get and print the alert text
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);

            // Accept the alert
            alert.accept();
            System.out.println("Alert accepted.");

            // Reopen the alert to test cancel
            confirmButton.click();
            alert = driver.switchTo().alert();

            // Dismiss the alert
            alert.dismiss();
            System.out.println("Alert dismissed.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

















//// Click the button that triggers the alert
//driver.findElement(By.id("alert-button")).click();
//
//// Wait for the alert to be displayed
//wait.until(ExpectedConditions.alertIsPresent());
//
//// Store the alert in a variable
//Alert alert = driver.switchTo().alert();
//
//// Print the text from the alert
//System.out.println(alert.getText());
//
//// Send text to the alert
//        alert.sendKeys("Hello!");
//
//// Click the OK button on the alert
//alert.accept();