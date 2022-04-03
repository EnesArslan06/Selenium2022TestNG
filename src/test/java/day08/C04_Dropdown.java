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
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
    WebDriver driver;
    Select select;
    WebElement dropDown;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

  //● https://www.amazon.com/ adresine gidin.
  //- Test 1
  //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        @Test
    public void test01()  {
        driver.get("https://www.amazon.com/");
            dropDown= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
           select=new Select(dropDown);
            List<WebElement> options= select.getOptions();
            int actueldrop=options.size();
            int excepteddrop=45;
           Assert.assertEquals(actueldrop, excepteddrop);

    }
     //-Test 2
    //	1. Kategori menusunden Books secenegini  secin
    //	2. Arama kutusuna Java yazin ve aratin
    //	3. Bulunan sonuc sayisini yazdirin
    //	4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void test02(){
      select.selectByVisibleText("Books");
    WebElement arama=driver.findElement(By.id("twotabsearchtextbox"));
    arama.sendKeys("Java"+ Keys.ENTER);
    String sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(sonuc);
        String exceptedSonuc="Java";
        Assert.assertTrue(sonuc.contains(exceptedSonuc));

    }
}
