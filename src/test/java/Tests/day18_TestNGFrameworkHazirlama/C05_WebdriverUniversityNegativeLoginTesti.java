package Tests.day18_TestNGFrameworkHazirlama;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebdriverUniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C05_WebdriverUniversityNegativeLoginTesti {


    @Test

public void webdriveruniversity(){



    //1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a kadar asagi inin
    //3."Login Portal" a tiklayin
    //4.Diger window'a gecin
    //5."username" ve "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //8.Ok diyerek Popup'i kapatin
    //9.Ilk sayfaya geri donun
    //10.Ilk sayfaya donuldugunu test edin

//1."http://webdriveruniversity.com/" adresine gidin
        //2."Login Portal" a kadar asagi inin
    Driver.getDriver().get("http://webdriveruniversity.com/");
    String ilkSayfaWHD= Driver.getDriver().getWindowHandle();

    WebdriverUniversityPage webdriverUniversityPage=new WebdriverUniversityPage();


    JavascriptExecutor javascriptExecutor= (JavascriptExecutor)  Driver.getDriver();

    javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});"
            , webdriverUniversityPage.loginPortalYazisi);


        //3."Login Portal" a tiklayin

        webdriverUniversityPage.loginPortalYazisi.click();

        //4.Diger window'a gecin


        Set<String> sayfalarinWHD= Driver.getDriver().getWindowHandles();
        String ikinciWindowWHD ="";

        for (String eachWHD : sayfalarinWHD
        ) {
            if ( !  eachWHD.equals(ilkSayfaWHD) ){
                ikinciWindowWHD = eachWHD;
            }

        }

        Driver.getDriver().switchTo().window(ikinciWindowWHD);


        //5."username" ve "password" kutularina deger yazdirin

        Faker faker = new Faker();

        webdriverUniversityPage.usernameKutusu.sendKeys(faker.name().username());

        webdriverUniversityPage.passwordKutusu.sendKeys(faker.internet().password());


        //6."login" butonuna basin

        webdriverUniversityPage.loginButonu.click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        String expectedAlertYazsisi= "validation failed";
        String actualAlertYazisi= Driver.getDriver().switchTo().alert().getText();

        Assert.assertEquals(actualAlertYazisi,expectedAlertYazsisi);

        //8.Ok diyerek Popup'i kapatin


        Driver.getDriver().switchTo().alert().accept();

        //9.Ilk sayfaya geri donun


        ReusableMethods.windowaGec("https://webdriveruniversity.com/",Driver.getDriver());
        //10.Ilk sayfaya donuldugunu test edin

String expectedtitle="WebDriverUniversity.com";
String actualTitle= Driver.getDriver().getTitle();
Assert.assertEquals(actualTitle,expectedtitle);



Driver.getDriver().quit();





    }


}
