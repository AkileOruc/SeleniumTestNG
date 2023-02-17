package tests.ders13_TestNGreports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    /*
    data provider bir test method'unun birden fazla deger icin
    tekrar calistirilmasini saglar
    ornegin : negatif login testini 5 kullanici adi, 5 password icin denemek isterseniz
              her seferinde yeniden method yazmak yerine
              tek method ve ona data saglayan data provider ile
              tek test 5 kez calistirilabilir.
 */


    @DataProvider
    public static Object[][] kullaniciListesi() {
String [][] kullanicilar={{"ali","123"},{"veli","345"},{"nigar","234"},{"gevre","123"},{"dogan","421"}};
        return kullanicilar;
    }


    @Test (dataProvider = "kullaniciListesi")
    public void negatifLoginTesti(String username,String passeword) {
        // Bir test methodu olusturun
        // qualitydemy anasayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // cookies'i kabul edin

        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();

        // Login linkine tiklayin

        qualitydemyPage.ilkLoginLinki.click();

        // gecerli kullanici adi ve gecersiz password yazip

        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        // login butonuna bastiginizda

        qualitydemyPage.loginButonu.click();

        // basarili olarak giris yapilamadigini test edin

        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        // ve sayfayi kapatin

        Driver.closeDriver();
    }
}
