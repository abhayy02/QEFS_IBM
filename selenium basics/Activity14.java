import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity14 {
    public static void main(String[] args) {

        // Initialize the WebDriver
        WebDriver driver = new FirefoxDriver();

        // Open the website
        driver.get("https://v1.training-support.net/selenium/tables");

        // Get the title of the page and print it
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Locate the second table using XPath
        WebElement secondTable = driver.findElement(By.xpath("(//table)[2]"));

        // Find the number of rows in the table
        List<WebElement> rows = secondTable.findElements(By.xpath(".//tbody/tr"));
        int rowCount = rows.size();
        System.out.println("Number of rows: " + rowCount);

        // Find the number of columns in the table
        List<WebElement> columns = secondTable.findElements(By.xpath(".//tbody/tr[1]/td"));
        int colCount = columns.size();
        System.out.println("Number of columns: " + colCount);

        // Find and print the cell value at the second row, second column
        WebElement cellValueBeforeSort = secondTable.findElement(By.xpath(".//tbody/tr[2]/td[2]"));
        System.out.println("Cell value at 2nd row, 2nd column (before sorting): " + cellValueBeforeSort.getText());

        // Click the header of the first column to sort by name
        WebElement firstColumnHeader = secondTable.findElement(By.xpath(".//thead/tr/th[1]"));
        firstColumnHeader.click();

        // Wait for sorting to complete (simple static wait for demonstration purposes)
        try {
            Thread.sleep(2000); // Use better wait mechanisms like WebDriverWait in production
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find and print the cell value at the second row, second column after sorting
        WebElement cellValueAfterSort = secondTable.findElement(By.xpath(".//tbody/tr[2]/td[2]"));
        System.out.println("Cell value at 2nd row, 2nd column (after sorting): " + cellValueAfterSort.getText());
        
        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Cell values of the footer: ");
        for(WebElement cell : footer) {
            System.out.println(cell.getText());
        }
    }
}

//public class Activity14 {
//    public static void main(String[] args) {
//        // Set up Firefox driver
//        WebDriverManager.firefoxdriver().setup();
//        // Create a new instance of the Firefox driver
//        WebDriver driver = new FirefoxDriver();
//        // Create the Wait object
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Open the page
//        driver.get("https://v1.training-support.net/selenium/tables");
//        // Print the title of the page
//        System.out.println("Home page title: " + driver.getTitle());
//
//        // Print the number of columns
//        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
//        System.out.println("Number of columns: " + cols.size());
//        // Print the number of rows
//        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
//        System.out.println("Number of rows: " + rows.size());
//
//        // Print the cell value of the second row and second column
//        WebElement cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
//        System.out.println("Second row, second cell value: " + cellValue.getText());
//
//        // Sort the table
//        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th")).click();
//
//        // Print the cell value of the second row and second column again
//        cellValue = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
//        System.out.println("Second row, second cell value: " + cellValue.getText());
//
//        // Print the cell values of the footer
//        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
//        System.out.println("Cell values of the footer: ");
//        for(WebElement cell : footer) {
//            System.out.println(cell.getText());
//        }
//
//        // Close the browser
//        driver.quit();
//    }
//}