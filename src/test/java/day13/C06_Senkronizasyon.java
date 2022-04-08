package day13;

import Utiletes.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C06_Senkronizasyon extends TestBase {
    @Test
    public void test() throws InterruptedException {

     //  driver.get("https://the-internet.herokuapp.com/upload");
     //  driver.findElement(By.id("file-submit")).click();
     //  Thread.sleep(3000);

    //   driver.get("https://www.amazon.com.tr");
    //   driver.findElement(By.id("sp-cc-accept")).click();

    //    driver.get("https://www.techproeducation.com");
    //    driver.findElement(By.xpath("(//a[text()='info@techproeducation.com'])[2]")).click();

        // https://the-internet.herokuapp.com/dynamic_controls sayfasina gidin
        // disable butonuna basin
        // disabled yazisinin ciktigini test edin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebElement itsDisabledYazielementi=driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsDisabledYazielementi.isDisplayed());

    }
}
