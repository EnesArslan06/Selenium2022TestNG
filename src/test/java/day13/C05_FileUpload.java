package day13;

import Utiletes.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C05_FileUpload extends TestBase {
//   1.
//   Tests packagenin altina bir class oluşturun : C05_ UploadFile
//.
//   https://the internet.herokuapp.com/upload adresine gidelim
//           3.
//   chooseFile butonuna basalim
//.
//   Yuklemek istediginiz dosyayi sec elim
//.
//   Upload butonuna bas alim
//.
//       6.“File Uploaded!” textinin goruntulendigini test edelim

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //1-dosya secme butonunu loket edelim
        WebElement fileSecButonu=driver.findElement(By.id("file-upload"));
        //2-yukleyecegimiz dosyanin dinamik pathi
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Deneme\\Selenium dosya.txt";
        //3- senkeys methodu ile dosya yolunu dosya sec butonuna gonderelim
        fileSecButonu.sendKeys(dosyaYolu);
        Thread.sleep(7000);
        driver.findElement(By.id("file-submit")).click();//update tusuna bastık
        WebElement sonucYasisi=driver.findElement(By.tagName("h3"));//update olumlu olunca cikan yaziyi
        //locakte ettik.
        Assert.assertTrue(sonucYasisi.isDisplayed());

    }
}
