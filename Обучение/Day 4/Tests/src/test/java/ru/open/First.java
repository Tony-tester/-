package ru.open;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;



public class First {
    @Test
    public void First() {
        System.setProperty("webdriver.chrome.driver", "\\Users\\woon\\IdeaProjects\\Tests\\driver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.open.ru/");
        String dollar_buy = driver.findElement(By.cssSelector("div > table > tbody > tr:nth-child(2) > td:nth-child(2) > div > span")).getText();
        String dollar_sell = driver.findElement(By.cssSelector("#main > div > div > div:nth-child(7) > section > div > div > div:nth-child(1) > div > div > div > div > div.ant-tabs.ant-tabs-top.main-page-exchange__tabs.ant-tabs-line > div.ant-tabs-content.ant-tabs-content-animated.ant-tabs-top-content > div.ant-tabs-tabpane.ant-tabs-tabpane-active > div > table > tbody > tr:nth-child(2) > td:nth-child(4) > div > span")).getText();

        double db = Double.parseDouble(dollar_buy.replace(",", "."));
        double ds = Double.parseDouble(dollar_sell.replace(",", "."));
        if (db< ds) {
            System.out.println("Банк покупает доллар дешевле чем продает");

        }
        else {
            System.out.println("Банк работает в минус");
        }
        String euro_buy = driver.findElement(By.cssSelector("#main > div > div > div:nth-child(7) > section > div > div > div:nth-child(1) > div > div > div > div > div.ant-tabs.ant-tabs-top.main-page-exchange__tabs.ant-tabs-line > div.ant-tabs-content.ant-tabs-content-animated.ant-tabs-top-content > div.ant-tabs-tabpane.ant-tabs-tabpane-active > div > table > tbody > tr:nth-child(3) > td:nth-child(2) > div > span")).getText();
        String euro_sell = driver.findElement(By.cssSelector("#main > div > div > div:nth-child(7) > section > div > div > div:nth-child(1) > div > div > div > div > div.ant-tabs.ant-tabs-top.main-page-exchange__tabs.ant-tabs-line > div.ant-tabs-content.ant-tabs-content-animated.ant-tabs-top-content > div.ant-tabs-tabpane.ant-tabs-tabpane-active > div > table > tbody > tr:nth-child(3) > td:nth-child(4) > div > span")).getText();
        double eb = Double.parseDouble(euro_buy.replace(",", "."));
        double es = Double.parseDouble(euro_sell.replace(",", "."));
        if (eb < es) {
            System.out.println("Банк покупает евро дешевле чем продает");
        }
        else {
            System.out.println("Банк работает в минус");
        }
        driver.close();
    }

}
