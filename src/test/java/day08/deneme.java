package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class deneme {

      //    ●Bir class olusturun: Alert s
//●https://the internet.herokuapp.com/javascript_alerts adresine gidin.
// ●Bir metod olusturun: acceptAlert
//○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//“You successfully clicked an alert” oldugunu test edin
//●Bir metod olusturun: dismissAlert
//○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//“successfuly” icermedigini test edin
//●Bir metod olusturun: sendKeysAlert
//○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//    tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.


        @Test
        public void test(){
            WebDriverManager.chromedriver().setup();
           WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://the-internet.herokuapp.com/iframe");
            WebElement ifareme= driver.findElement(By.xpath("//iframe[@class='tox-edit-area__iframe']"));
            driver.switchTo().frame(ifareme);
            WebElement textBox = driver.findElement(By.tagName("p"));
            textBox.clear();
            textBox.sendKeys("Merhaba Dunya");
}
}








