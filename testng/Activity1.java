import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver = new FirefoxDriver();
    @BeforeClass
    public void before() {
        System.out.println("out");
    }

    @Test(priority = 1)
    public void test() {
        driver.get("https://v1.training-support.net");
        String URLtitle = driver.getTitle();
        System.out.println(URLtitle);
        Assert.assertEquals("Training Support",URLtitle);
    }

    @Test(priority = 2)
        public void test2() {
        driver.get("https://v1.training-support.net");
        WebElement Button = driver.findElement(By.xpath("//*[@id='about-link']"));
        Button.click();
        String npTitle = driver.getTitle();
        System.out.println(npTitle);
        Assert.assertEquals("About Training Support",npTitle);
        }



    // Close the browser
    @AfterClass
    public void close() {
        System.out.println("after");
        driver.quit();
    }
}
