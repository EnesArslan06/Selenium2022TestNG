package Utiletes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestBase {
    //access modifier yazmazsak default olur ve extends iliskisinde default ayni pacgece icerisinde gorulmez
    //protected yaparsak child classlarda bu driveri gorebilir.
    //buraya yukleme methodlarini koyarsak child class kendi classinda goremezse parent classa bakar.
    //buradaki metodlari gorur ve alir.
    //buradaki extendsi abstrak yazarsakda olur o zaman bizn buraya extends ettigimiz classda obje olusturulamaz.
    //yani baskalari gelip bizim child classdaki driverimizda obje olusturulamaz....

    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void teardown(){
      // driver.close();
    }
    public void tumSayfaScreenshot() throws IOException {

        TakesScreenshot tss=(TakesScreenshot) driver;

        String tarih=new SimpleDateFormat("yyMMddhhmmss").format(new Date());

        File tumSayfa= new File("target/screenShot/tumSayfa"+tarih+".jpg");

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumSayfa);

    }
}
