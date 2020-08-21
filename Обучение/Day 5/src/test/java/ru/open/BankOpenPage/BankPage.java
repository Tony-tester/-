package ru.open.BankOpenPage;

import static com.codeborne.selenide.Selenide.$x;

public class BankPage {

    public Double getUsdBuy() {
        return getCourse("//tr[2]//td[2]//*[@class=\"main-page-exchange__rate\"]");
    }
    public Double getUsdSell() {
        return getCourse("//tr[2]//td[4]//*[@class=\"main-page-exchange__rate\"]");
    }
    public Double getEurBuy() {
        return getCourse("//tr[3]//td[2]//*[@class=\"main-page-exchange__rate\"]");
    }
    public Double getEurSell() {
        return getCourse("//tr[3]//td[4]//*[@class=\"main-page-exchange__rate\"]");
    }
    private Double getCourse(String xPath) {
        return Double.parseDouble($x(xPath).getText().replace(",","."));
    }

}
