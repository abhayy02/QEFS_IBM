import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.Set;

public class Activity21 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        try {
            // Open the website
            driver.get("https://v1.training-support.net/selenium/tab-opener");

            // Get and print the title of the page
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Locate and click the button to open a new tab
            WebElement openTabButton = driver.findElement(By.id("launcher"));
            openTabButton.click();

            // Wait for the new tab to open
            Thread.sleep(3000); // Adding a sleep for tab loading

            // Print all window handles
            Set<String> allHandles = driver.getWindowHandles();
            System.out.println("All Window Handles: " + allHandles);

            // Switch to the newly opened tab
            ArrayList<String> handlesList = new ArrayList<>(allHandles);
            driver.switchTo().window(handlesList.get(1));

            // Get and print the title and heading of the new tab
            String newTabTitle = driver.getTitle();
            String newTabHeading = driver.findElement(By.id("actionButton")).getText();
            System.out.println("New Tab Title: " + newTabTitle);
            System.out.println("New Tab Heading: " + newTabHeading);

            // Find and click the button in the new tab to open another tab
            WebElement newTabButton = driver.findElement(By.id("actionButton"));
            newTabButton.click();

            // Wait for the next tab to open
            Thread.sleep(2000); // Adding a sleep for tab loading

            // Print all window handles again
            allHandles = driver.getWindowHandles();
            System.out.println("Updated Window Handles: " + allHandles);

            // Switch to the second new tab
            handlesList = new ArrayList<>(allHandles);
            driver.switchTo().window(handlesList.get(2));

            // Get and print the title and heading of the second new tab
            String secondTabTitle = driver.getTitle();
            String secondTabHeading = driver.findElement(By.className("content")).getText();
            System.out.println("Second Tab Title: " + secondTabTitle);
            System.out.println("Second Tab Heading: " + secondTabHeading);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


//// Open a Web Page
//driver.get("https://www.v1.training-support.net/selenium/tab-opener");
//
//// Store the handle of the current tab in a variable
//// This will help you find the newly opened tab later.
//String parentHandle = driver.getWindowHandle();
//
//// Click on the button that opens a new page in another tab
//driver.findElement(By.id("launcher")).click();
//
//// Wait until there's 2 tabs properly open
//wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//
//// Store the handles of all the open tabs in a variable.
//// Note: getWindowHandles() will always return a Set.
//Set<String> handles = driver.getWindowHandles();
//
//// Loop through the Set and switch to the window
//// whose handle doesn't match the parentHandle
//for(String handle : handles) {
//        if (handle != parentHandle) {
//        driver.switchTo().window(handle);
//    }
//            }
//
//// Wait for the page to actually load
//            wait.until(ExpectedConditions.titleIs("Newtab"));
//
//// The rest of your selenium code goes here

//public class Activity21 {
//
//    public static void main(String[] args) {
//        // Set up Firefox driver
//        WebDriverManager.firefoxdriver().setup();
//        // Create a new instance of the Firefox driver
//        WebDriver driver = new FirefoxDriver();
//        // Create the Wait object
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Open the page
//        driver.get("https://v1.training-support.net/selenium/tab-opener");
//        // Print the title of the page
//        System.out.println("Home page title: " + driver.getTitle());
//
//        // Print the handle of the parent window
//        System.out.println("Current tab: " + driver.getWindowHandle());
//        // Find button to open new tab
//        driver.findElement(By.id("launcher")).click();
//
//        // Wait for the second tab to open
//        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//        // Print all window handles
//        System.out.println("Currently open windows: " + driver.getWindowHandles());
//
//        // Switch focus
//        for(String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//        }
//
//        // Wait for the new page to load
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
//        // Print the handle of the current tab
//        System.out.println("Current tab: " + driver.getWindowHandle());
//        // Print the title and heading of the new page
//        System.out.println("Page title: " + driver.getTitle());
//        String pageHeading = driver.findElement(By.className("content")).getText();
//        System.out.println("Page Heading: " + pageHeading);
//        // Find and click the button on page to open another tab
//        driver.findElement(By.id("actionButton")).click();
//
//        // Wait for new tab to open
//        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
//        // Switch focus
//        for(String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//        }
//
//        // Wait for the new page to load
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
//        // Print the handle of the current tab
//        System.out.println("Current tab: " + driver.getWindowHandle());
//        // Print the title and heading of the new page
//        System.out.println("Page title: " + driver.getTitle());
//        pageHeading = driver.findElement(By.className("content")).getText();
//        System.out.println("Page Heading: " + pageHeading);
//
//        // Close the browser
//        driver.quit();
//    }
//}