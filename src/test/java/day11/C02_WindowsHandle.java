package day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowsHandle {
///           Tests package’inda yeni bir class olusturun: WindowHandle 2
//           ●https://the internet.herokuapp.com/windows adresine gidin.
//           ●Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//           ●Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//           ●Click Here butonuna basın.
//           ●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//           ●Sayfadaki textin “New Window” olduğunu doğrulayın.
//           ●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
//   doğrulayın.

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test() {
        //     https://the internet.herokuapp.com/windows adresine gidin.
//           ●Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
//           ●Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
//           ●Click Here butonuna basın.
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement textYazisi = driver.findElement(By.tagName("h3"));
        String expected = "Opening a new window";
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(textYazisi.getText(), expected, "Sayfadaki Sayi bekleneden farkli");
        soft.assertEquals(driver.getTitle(), "The Internet", "Sayfa Basligi dogru degil");

        //window handle degerini bilmedigim bir windoew aciliyor ,
        //o sayfanin window handle degerini bulmak icin gectigim saygfalardaki
        //window handle degerlerini kaydetmeliyim
        String windowHandle1 = driver.getWindowHandle();
        //2. sayfaya gecmek icin yeni acilan pencerenin handle degerine ihtiyacimiz var.
        //once acilan yen sayfanin handle degerini elde edelim.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //Sey olusturup butun handle degerleri bir sete atayalım ilk sayfaninkine esit olmayan
        //yeni sayfamizin handle degeridir.

        Set<String> windowHandleDegerleriSet = driver.getWindowHandles();
        String windowHandle2 = "";
        for (String each : windowHandleDegerleriSet) {
            if (!each.equals(windowHandle1)) {
                windowHandle2 = each;
            }}
            //elimizde bir set var ve 2 tane handle degeri var 1. sayfasninkine esit olmayan 2. sayfaninkidir.
// ●Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
//  ●Sayfadaki textin “New Window” olduğunu doğrulayın.
//  ●Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
//  doğrulayın.
            driver.switchTo().window(windowHandle2);
            soft.assertEquals(driver.getTitle(), "New Window", "Yeni Sayfanin degeri esit degil");

            WebElement yeniSayfaText = driver.findElement(By.tagName("h3"));
            soft.assertEquals(yeniSayfaText.getText(), "New Window");


            driver.switchTo().window(windowHandle1);//burada da 1. sayfaya gectik
        //orayi test ediyoruzzle
        soft.assertEquals(driver.getTitle(),"The Internet")   ;
            soft.assertAll();

    }
}




