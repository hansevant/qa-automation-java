package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.ArrayList;

public class ProductList {
    public static void main(String[] args) throws InterruptedException {
        // Set up the WebDriver
        WebDriver driver = new ChromeDriver();
        // String[] pilihan = {"Carrot", "Tomato", "Cucumber"};
        List<String> list = new ArrayList<>(List.of("Pista", "Pears", "Onion"));
        // Navigate to the desired webpage
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        // Find all elements with the class name 'product-name'
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));

        // Print the text of each product name
        for (WebElement product : products) {
            String name = product.getText().trim();
            // Remove text after the first occurrence of ' - '
            int index = name.indexOf(" - ");
            if (index != -1) {
                name = name.substring(0, index);
            }

            if (list.contains(name)) {
                product.findElement(By.className("product-action")).click();
                System.out.println(name);
            }
            Thread.sleep(200);
        }
        driver.findElement(By.className("cart-icon")).click();
        Thread.sleep(500);
        driver.findElement(By.className("action-block")).click();
        Thread.sleep(2000);
        // Close the WebDriver
        driver.quit();
    }
}
