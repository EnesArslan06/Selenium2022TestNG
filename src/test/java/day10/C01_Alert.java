package day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C01_Alert {
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
WebDriver driver;
@BeforeClass
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.manage().window().maximize();
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
}
    @Test
            public void acceptAlert(){
// ●Bir metod olusturun: acceptAlert
//○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
//“You successfully clicked an alert” oldugunu test edin
    driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
    driver.switchTo().alert().accept();
    WebElement sonucYazisi1 =driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
    String expectedTitle="You successfully clicked an alert";
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(sonucYazisi1.getText().equals(expectedTitle),"Esit Degildir");
}

@Test
    public void test(){
    //○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//“successfuly” icermedigini test edin
    driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
    driver.switchTo().alert().dismiss();
    WebElement sonucYazisi2=driver.findElement(By.xpath("//p[@id='result']"));
    String expected = sonucYazisi2.getText();
    SoftAssert soft=new SoftAssert();
    soft.assertFalse(sonucYazisi2.getText().equals(expected),"esit degil");

}
@Test
    public void test3() throws InterruptedException {
    //○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//    tıklayın ve result mesajın da isminizin görüntülendiğini doğrulayın.
    driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
    driver.switchTo().alert().sendKeys("Enes");
    Thread.sleep(3000);
    driver.switchTo().alert().accept();
    WebElement sonucYazisi3=driver.findElement(By.xpath("//p[@id='result']"));
    String expected3 = "Enes";
    Assert.assertTrue(sonucYazisi3.getText().contains(expected3),"Mesaj okunamadi");

}

}
