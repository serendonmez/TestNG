package Tests.day19_TestNGFramework_assertions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C33 {


    static TestotomasyonuPage testotomasyonuPage= new TestotomasyonuPage(); ;
    @BeforeMethod
    public void setup(){
        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        //2- account linkine basin
        // 3- 3 farkli test method'u olusturun.
        // - gecerli email, gecersiz password
        // - gecersiz email, gecerli password
        // - gecersiz email, gecersiz password.
        //4- Login butonuna basarak login olmayi deneyin
        //5- Basarili olarak giris yapilamadigini test edin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        testotomasyonuPage.accountLinki.click();

    }
    @Test  // - gecerli email, gecersiz password
    public void gecersizPasswordTest(){
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
    }
    @Test // - gecersiz email, gecerli password
    public void gecersizEmailTest(){
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
    }
    @Test // - gecersiz email, gecersiz password.
    public void gecersizEmailPasswordTest(){
        testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
    }

    @AfterTest //4- Login butonuna basarak login olmayi deneyin
    public void teardown(){


        testotomasyonuPage.loginSigninButonu.click();
      //  testotomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
     //   testotomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        //testotomasyonuPage.loginSigninButonu.click();
        //5- Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(testotomasyonuPage.loginSigninButonu.isDisplayed());



        Driver.getDriver().quit();
       // testotomasyonuPage=null;

    }

}
