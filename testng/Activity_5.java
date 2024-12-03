import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity_5 {
    WebDriver driver;
    @BeforeTest
    public void beforeTest() {
        driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void getTitle() {
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);
    }

    @Test (groups = {"HeaderTests"})
    public void headerTest1() {
        WebElement h3 = driver.findElement(By.id("third-header"));
        String h3text = h3.getText();
        Assert.assertEquals(h3text,"Third header");
    }

    @Test (groups = {"HeaderTests"})
    public void headerTest2(){
        WebElement h5 = driver.findElement(By.cssSelector(".ui.green.header"));
        String h5text = h5.getCssValue("color");
        Assert.assertEquals(h5text,"rgb(33, 186, 69)");
    }

    @Test (groups = {"ButtonTests"})
    public void buttonTest1() {
        WebElement oliveButton = driver.findElement(By.cssSelector(".ui.olive.button"));
        String oliveT = oliveButton.getCssValue("background-color");
        Assert.assertEquals(oliveT,"rgb(181, 204, 24)");
    }

    @Test (groups = {"ButtonTests"})
    public void buttonTest2(){
        WebElement brown = driver.findElement(By.cssSelector(".ui.brown.button"));
        String brownT = brown.getCssValue("background-color");
        Assert.assertEquals(brownT,"rgb(165, 103, 63)");
    }

    @AfterClass
    public void six() {
        System.out.println("after");
        driver.quit();
    }
}
