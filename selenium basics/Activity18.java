import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//public class Activity18 {
//    public static void main(String[] args) {
//
//        // Initialize Firefox WebDriver
//        WebDriver driver = new FirefoxDriver();
//
//        try {
//            // Open the URL
//            driver.get("https://v1.training-support.net/selenium/selects");
//
//            // Get the page title and print it
//            String pageTitle = driver.getTitle();
//            System.out.println("Page Title: " + pageTitle);
//
//            // Locate the multi-select dropdown
//            WebElement multiSelectDropdown = driver.findElement(By.id("multi-select"));
//
//            // Create a Select object for interacting with the dropdown
//            Select select = new Select(multiSelectDropdown);
//
//            // Select the "JavaScript" option using visible text
//            select.selectByVisibleText("Javascript");
//            System.out.println("Selected: JavaScript");
//
//            // Select the 4th, 5th, and 6th options using index (index is 0-based)
//            select.selectByIndex(3); // 4th option
//            System.out.println("Selected: " + select.getOptions().get(3).getText());
//            select.selectByIndex(4); // 5th option
//            System.out.println("Selected: " + select.getOptions().get(4).getText());
//            select.selectByIndex(5); // 6th option
//            System.out.println("Selected: " + select.getOptions().get(5).getText());
//
//            // Select the "NodeJS" option using the value
//            select.selectByValue("node");
//            System.out.println("Selected: NodeJS");
//
//            // Deselect the 5th option using index
//            select.deselectByIndex(4);
//            System.out.println("Deselected: " + select.getOptions().get(4).getText());
//
//            // Print all currently selected options
//            List<WebElement> selectedOptions = select.getAllSelectedOptions();
//            System.out.println("Currently selected options:");
//            for (WebElement option : selectedOptions) {
//                System.out.println(option.getText());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // Close the browser
//            driver.quit();
//        }
//    }
//}


public class Activity18 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://v1.training-support.net/selenium/selects");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the dropdown
        WebElement selectElement = driver.findElement(By.id("multi-select"));
        // Pass the WebElement to the Select object
        Select multiSelect = new Select(selectElement);

        // Select "Javascript" using visible text
        multiSelect.selectByVisibleText("Javascript");
        // Select 4th, 5th, and 6th index options
        for(int i = 4; i<=6 ; i++) {
            multiSelect.selectByIndex(i);
        }
        // Select "NodeJS" using value attribute
        multiSelect.selectByValue("node");
        // Print the selected options
        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        // Deselect the 5th index option
        multiSelect.deselectByIndex(5);
        // Print the selected options
        selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println("Selected options are: ");
        for(WebElement option : selectedOptions) {
            System.out.println(option.getText());
        }

        // Close the browser
        driver.quit();
    }
}
