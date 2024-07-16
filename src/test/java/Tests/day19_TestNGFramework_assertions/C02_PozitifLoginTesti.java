package Tests.day19_TestNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_PozitifLoginTesti {


    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- account linkine basin
    // 3- Kullanici email'i olarak gecerli email girin
    // 4- Kullanici sifresi olarak gecerli password girin
    // 5- Login butonuna basarak login olun
    // 6- Basarili olarak giris yapilabildigini test edin




    @Test
    public void pozitifLoginTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        ReusableMethods.bekle(1);
        testotomasyonuPage.accountLinki.click();

        //3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage
                .loginEmailKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliEmail"));

        //4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage
                .loginPasswordKutusu
                .sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        ReusableMethods.bekle(1);
        //5- Login butonuna basarak login olun
        testotomasyonuPage
                .loginSigninButonu
                .click();

        //6- Basarili olarak giris yapilabildigini test edin
        Assert.assertTrue(testotomasyonuPage.logOutButonu.isDisplayed());

        Driver.quitDriver();

    }
}
