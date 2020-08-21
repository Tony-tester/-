package ru.open;

import ru.open.BankOpenPage.BankPage;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class Tests {

    @Test
    public void withSelenide() {
        BankPage bp = open("https://www.open.ru", BankPage.class);

        System.out.println("USD: " + bp.getUsdBuy() + " < " + bp.getUsdSell() + "Банк продает доллар дороже чем покупает");
        System.out.println("EUR: " + bp.getEurBuy() + " < " + bp.getEurSell() + "Банк продает евро дороже чем покупает");
        Assert.assertTrue(bp.getUsdBuy() < bp.getUsdSell());
        Assert.assertTrue(bp.getEurBuy() < bp.getEurSell());

    }

}
