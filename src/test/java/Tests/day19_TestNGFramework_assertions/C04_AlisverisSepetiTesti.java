package Tests.day19_TestNGFramework_assertions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_AlisverisSepetiTesti {



        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        //2- phone icin arama yapin
        // 3- Listelenen sonuclardan ilkini tiklayin
        //4- urun ismini kaydedin ve sepete ekleyin
        //5- your cart linkine tiklayin
        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        //7- sayfayi kapatin

    @Test
    public void alisverisSepetiTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //2- belirlenmis arama kelimesi icin arama yapin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        testotomasyonuPage.aramakutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        //3- Listelenen sonuclardan ilkini tiklayin
        testotomasyonuPage.sonucElementleriList.get(0).click();

        //4- urun ismini kaydedin
        String ilkUrunIsmi = testotomasyonuPage.ilkUrunSayfasindaUrunIsimElementi.getText();


        // ve urunu sepete ekleyin
        //testotomasyonuPage.addToCartButonu.click();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", testotomasyonuPage.addToCartButonu);


        //5- your cart linkine tiklayin
        testotomasyonuPage.yourCartLinki.click();

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin

        String sepettekiUrunIsmi = testotomasyonuPage.sepettekiUrunIsimElementi.getText();

        Assert.assertEquals(ilkUrunIsmi,sepettekiUrunIsmi);

        //7- sayfayi kapatin
        Driver.quitDriver();


    }
}
