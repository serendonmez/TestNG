package Tests.day18_TestNGFrameworkHazirlama;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C04_FormDoldurma {

    @Test (groups = "smoke")
    public void testOtomasyonu(){
        //1 - https://testotomasyonu.com/form adresine gidin
        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        //5- Secilen değerleri konsolda yazdirin
        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin


        Driver.getDriver().get("https://testotomasyonu.com/form");

        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        Select select = new Select(testOtomasyonuFormPage.gun);
        select.selectByIndex(5);

        Select select1=new Select(testOtomasyonuFormPage.ay);
        select1.selectByValue("nisan");

        Select select2= new Select(testOtomasyonuFormPage.yil);
        select2.selectByVisibleText("1990");

        //5- Secilen değerleri konsolda yazdirin

        System.out.println(select.getFirstSelectedOption().getText() + "-" +
                             select1.getFirstSelectedOption().getText() + "-"
                                + select2.getFirstSelectedOption().getText());

        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın

        List<WebElement> ayOptionList= select1.getOptions();
        System.out.println(ReusableMethods.stringListesineDonustur(ayOptionList));
        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin

        int expectedBoyut = 13;
        int actualBoyut = ayOptionList.size();



        Assert.assertEquals(actualBoyut,expectedBoyut);

        ReusableMethods.bekle(2);

        Driver.quitDriver();
    }
}
