import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        String pageTitle=driver.getTitle();
        System.out.println(pageTitle);

        WebElement prompt = driver.findElement(By.id("prompt"));
        prompt.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        alert.sendKeys("Awesome!");

        alert.accept();

        driver.quit();

    }

}
