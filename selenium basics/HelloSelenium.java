import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloSelenium {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://v1.training-support.net");
        String URLtitle = driver.getTitle();
        //driver.getTitle();
        System.out.println(URLtitle);
        WebElement Button = driver.findElement(By.xpath("//*[@id='about-link']"));
        Button.click();
        String npTitle = driver.getTitle();
        System.out.println(npTitle);

        // Perform testing and assertions


        // Close the browser
        // Feel free to comment out the line below
        // so it doesn't close too quickly
        //driver.quit();
    }
}