package org.mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args)
    {
//        System.setProperty("webdriver.chrome.driver",
//                "/Users/swag/IdeaProjects/demo/chromedriver-mac-arm64/chromedriver"
//        );

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

       driver.findElement(By.id("inputUsername")).sendKeys("OpenAI ChatGPT");
       driver.findElement(By.name("inputPassword")).sendKeys("OpenAI ChatGPT");
        driver.findElement(By.className("form")).submit();


    }
}
