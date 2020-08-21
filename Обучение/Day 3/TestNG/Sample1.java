package ru.technoserv.atmaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Sample1 {
    @Test
    public static void sample1Test() {
        System.setProperty("webdriver.chrome.driver","\\Users\\woon\\Downloads\\InternetDrivers\\chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        try {
            String baseUrl = "http://demo.guru99.com/test/newtours/";


            chromeDriver.get(baseUrl);


            System.out.println("Chrome title = " + chromeDriver.getTitle());
        } finally {

            chromeDriver.quit();
        }
    }
}
