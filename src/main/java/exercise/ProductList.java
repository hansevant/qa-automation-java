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
            name = removeAfter(name, " - ");
            //check product if equal
            if (list.contains(name)) {
                product.findElement(By.className("product-action")).click();
                System.out.println(name);
            }
            Thread.sleep(100);
        }
        clickAndWait(driver, By.className("cart-icon"), 500);
        clickAndWait(driver, By.className("action-block"), 2000);
        clickAndWait(driver, By.xpath("//button[text()='Place Order']"), 2000);
        clickAndWait(driver, By.className("chkAgree"), 1000);
        clickAndWait(driver, By.xpath("//button[text()='Proceed']"), 2000);
        // Close the WebDriver
        driver.quit();
    }
    public static String removeAfter(String input, String delimiter) {
        int index = input.indexOf(delimiter);
        if (index != -1) {
            return input.substring(0, index);
        }
        return input; // Jika delimiter tidak ditemukan, mengembalikan input asli
    }
    public static void clickAndWait(WebDriver driver, By by, long milliseconds) throws InterruptedException {
        driver.findElement(by).click();
        Thread.sleep(milliseconds);
    }
}
