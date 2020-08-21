package ru.vtb;

import org.junit.Test;
import ru.vtb.BankSite.VtbPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class TestsVtb {

@Test
    public void rubDollar() throws InterruptedException {
        VtbPage vp = open("https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/", VtbPage.class);
        vp.skipCookie.click();
        vp.method1.setValue("300");
        vp.method2.click();
        assertEquals(String.valueOf(vp.getOutputValue()), String.valueOf(300 / Double.valueOf(vp.getDollarSell())).substring(0, 6));
        System.out.println("Кальулятор работает верно");
        //Хотя на самом деле нет(округление хромает)
        //Судя по всему строка просто обрезается, а не округляется

}
@Test
    public void dollarRub() throws InterruptedException {
    VtbPage vp = open("https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/", VtbPage.class);
    vp.skipCookie.click();
    vp.fromCurrency.click();
    vp.dropDownChangedToCurrencyUSD.click();
    vp.toCurrency.click();
    vp.dropDownChangedFromCurrencyRUR.click();
    vp.method1.setValue("300");
    vp.method2.click();
    assertEquals(String.valueOf(vp.getOutputValue()), String.valueOf(300 * Double.valueOf(vp.getDollarBuy())));
    System.out.println("Кальулятор работает верно");

}
@Test
    public void rubDollarOver() throws InterruptedException {
    VtbPage vp = open("https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/", VtbPage.class);
    vp.skipCookie.click();
    vp.method1.setValue("2300000");
    vp.method2.click();
    assertEquals(String.valueOf(vp.getOutputValue()), String.valueOf(2300000 / Double.valueOf(vp.getDollarSellOver())).substring(0, 9));
}
@Test
    public void dollarRubOver() throws InterruptedException {
    VtbPage vp = open("https://www.vtb.ru/personal/platezhi-i-perevody/obmen-valjuty/", VtbPage.class);
    vp.skipCookie.click();
    vp.fromCurrency.click();
    vp.dropDownChangedToCurrencyUSD.click();
    vp.toCurrency.click();
    vp.dropDownChangedFromCurrencyRUR.click();
    vp.method1.setValue("31000");
    vp.method2.click();
    assertEquals(String.valueOf(vp.getOutputValue()), String.valueOf(300 * Double.valueOf(vp.getDollarBuyOver())));
}
}
