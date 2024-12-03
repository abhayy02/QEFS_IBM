import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



    public class google {
        public static void main(String[] args) {
            // Initialize the WebDriver
            WebDriver driver = new FirefoxDriver();

            try {
                // Open Google
                driver.get("https://www.google.com");

                // Accept cookies if prompted (may vary based on location, optional)
                try {
                    WebElement acceptCookiesButton = driver.findElement(By.xpath("//button[contains(text(),'Accept all')]"));
                    acceptCookiesButton.click();
                } catch (Exception e) {
                    // If no cookies prompt, continue
                }

                // Find the search box using its name attribute
                WebElement searchBox = driver.findElement(By.name("q"));

                // Type "cheese" into the search box and submit the form
                searchBox.sendKeys("cheese");
                searchBox.submit();

                // Wait for results to load (static wait for simplicity)
                Thread.sleep(3000); // Use WebDriverWait in production for better handling

                WebElement tools = driver.findElement(By.xpath("//*[@id=\"hdtb-tls\"]"));
                tools.click();

                // Locate the element that shows the search result count
                WebElement resultsStats = driver.findElement(By.id("result-stats"));

                // Extract and print the result text
                String resultText = resultsStats.getText();
                System.out.println("Search results text: " + resultText);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // Close the browser
                driver.quit();
            }
        }
    }

