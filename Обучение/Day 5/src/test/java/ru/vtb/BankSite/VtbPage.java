package ru.vtb.BankSite;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class VtbPage {

        @FindBy(xpath = "//li[text() = 'RUR']")
        public SelenideElement dropDownChangedFromCurrencyRUR;

        @FindBy(xpath = "//li[text() = 'USD']")
        public SelenideElement dropDownChangedToCurrencyUSD;

        @FindBy(xpath = "//select[@ng-change=\"changedFromCurrency()\"]/..")
        public SelenideElement fromCurrency;

        @FindBy(xpath = "//select[@ng-change=\"changedToCurrency()\"]/..")
        public SelenideElement toCurrency;

        @FindBy(xpath = "//*[@id=\"method1\"]")
        public SelenideElement method1;

        @FindBy(xpath = "//*[@id=\"method2\"]")
        public SelenideElement method2;

        @FindBy(xpath = "//div[@class = 'currency-exchange__info-ex ng-binding ng-scope']")
        public SelenideElement fullCurce;

        @FindBy(xpath = "//*[@id=\"cookiemsgoffpls\"]/p[1]")
        public SelenideElement skipCookie;


    public Double getDollarBuy() {
       fromCurrency.click();
       dropDownChangedToCurrencyUSD.click();
       toCurrency.click();
       dropDownChangedFromCurrencyRUR.click();
       double db = Double.parseDouble(fullCurce.getText().substring(9, 13).replace(",", "."));
       return db;

    }
    public Double getDollarSell() {
        fromCurrency.click();
        dropDownChangedFromCurrencyRUR.click();
        toCurrency.click();
        dropDownChangedToCurrencyUSD.click();
        double ds = Double.parseDouble(fullCurce.getText().substring(0, 5).replace(",", "."));
        return ds;
    }

    public String getDollarBuyOver() {
        fromCurrency.click();
        dropDownChangedToCurrencyUSD.click();
        toCurrency.click();
        dropDownChangedFromCurrencyRUR.click();
        method1.setValue("30000");
        method2.click();
        return $x("//div[@class = 'currency-exchange__info-ex ng-binding ng-scope']").getText().substring(9, 13).replace(',', '.');
    }
    public String getDollarSellOver() {
        fromCurrency.click();
        dropDownChangedFromCurrencyRUR.click();
        toCurrency.click();
        dropDownChangedToCurrencyUSD.click();
        method2.setValue("30000");
        method1.click();
        return $x("//div[@class = 'currency-exchange__info-ex ng-binding ng-scope']").getText().substring(0, 5).replace(',', '.');
    }
    public Double getInputValue() {
        return Double.parseDouble(method1.getValue());
    }
    public Double getOutputValue() throws InterruptedException {
        return getPrice(method2);
    }

    private Double getPrice(SelenideElement selenideElement) throws InterruptedException {
        Thread.sleep(1000);
        return Double.parseDouble(selenideElement.getValue().replace(",", ".").replace("\u00a0", ""));
    }


}
