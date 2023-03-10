package tests.ders13_TestNGreports;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluPositiveLoginTest extends TestBaseRapor {

    /*
        Yeni hedefimiz test datalarini manuel olarak girmek degil
        test datalarini configuration.properties dosyasindan alip kullanmak
        Boylece test datalarinda herhangi bir update yapilmasi istendiginde
        sadece configuration.properties'deki degeri degistirerek
        tum testlerimizi update edebilmek
     */


    @Test
    public void test01() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Login Testi","Dogru bilgilerle giris yapilabilmeli");
        // Bir test methodu olusturun
        // qualitydemy anasayfasina gidin

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        extentTest.info("qualitydemy anasayfaya gidildi");

        // cookies'i kabul edin

        QualitydemyPage qualitydemyPage= new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();

        extentTest.info("cookies kabul edildi");

        Thread.sleep(2000);

        // Login linkine tiklayin

        qualitydemyPage.ilkLoginLinki.click();

        extentTest.info("login tiklandi");
        // gecerli kullanici adi ve gecerli password yazip

        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        // login butonuna bastiginizda

        qualitydemyPage.loginButonu.click();

        // basarili olarak giris yapildigini test edin

        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isEnabled());

        extentTest.pass("basarili sekilde test edildi");


        Driver.closeDriver();
    }
}