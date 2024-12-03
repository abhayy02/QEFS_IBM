import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

 public class ActivitySus {
    WebDriver driver;
    @BeforeTest
    public void one() {
        driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void two() {
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
        Assert.assertEquals(pageTitle, "Target Practice");
    }

    @Test
    public void three() {
        WebElement blackB = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
        String text = blackB.getText();
        Assert.assertEquals("oops", text);
    }

    @Test(enabled = false)
    public void four() {
        System.out.println("Skipped");
    }

    @Test
    public void five() {
        System.out.println("Skipping this test explicitly.");
        throw new SkipException("Skipping this test case intentionally.");
    }


    @AfterClass
    public void six() {
        System.out.println("after");
        driver.quit();
    }
}
