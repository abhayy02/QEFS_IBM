import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity13 {
    public static void main(String[] args) {

        // Initialize the WebDriver
        WebDriver driver = new FirefoxDriver();

        // Open the website
        driver.get("https://v1.training-support.net/selenium/tables");

        // Get the title of the page and print it
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Locate the first table using XPath
        WebElement firstTable = driver.findElement(By.xpath("//table[@class='ui celled striped table']"));

        // Find the number of rows in the table
        List<WebElement> rows = firstTable.findElements(By.xpath(".//tbody/tr"));
        int rowCount = rows.size();
        System.out.println("Number of rows: " + rowCount);

        // Find the number of columns in the table
        List<WebElement> columns = firstTable.findElements(By.xpath(".//tbody/tr[1]/td"));
        int colCount = columns.size();
        System.out.println("Number of columns: " + colCount);

        // Print all cell values in the third row
        List<WebElement> thirdRowCells = firstTable.findElements(By.xpath(".//tbody/tr[3]/td"));
        System.out.print("Third row values: ");
        for (WebElement cell : thirdRowCells) {
            System.out.print(cell.getText() + " ");
        }
        System.out.println();

        // Find and print the cell value at the second row, second column
        WebElement cellValue = firstTable.findElement(By.xpath(".//tbody/tr[2]/td[2]"));
        System.out.println("Cell value at 2nd row, 2nd column: " + cellValue.getText());

        // Close the browser
        driver.quit();
    }
}
