package tests.ders13_TestNGreports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProvider {
    @DataProvider
    public static Object [][]aranacakUrunListesi(){

        String[][]urunList= {{"Nutella"},{"Java"},{"Samsung"},{"Apple"}};
        return urunList;
    }

    @Test(dataProvider = "aranacakUrunListesi")
    // amazon anasayfaya gidin

    public void test01(String urunIsmi){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    // istenen urun icin arama yapin

        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusuElementi.sendKeys(urunIsmi+ Keys.ENTER);

    // arama sonuclarinin istenen urun ismini icerdigini test edin

     String actualAramaSonucuYazisi=amazonPage.aramaSonucYaziElementi.getText()  ;
        Assert.assertTrue(actualAramaSonucuYazisi.contains(urunIsmi));
    }
}
