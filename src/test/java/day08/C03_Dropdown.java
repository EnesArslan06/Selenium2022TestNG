package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    WebDriver driver;
    Select select;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
//● https://the-internet.herokuapp.com/dropdown adresine gidin.
//	2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    @Test
    public void test01() {
       driver.get("https://the-internet.herokuapp.com/dropdown");
       WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
       select=new Select(dropdown);
       select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

    }

//	3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
@Test
public void test02(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown']"));
        select=new Select(dropdown);
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

    //	4.Tüm dropdown değerleri(value) yazdırın
    List<WebElement> tumEleman=select.getOptions();
    for (WebElement each: tumEleman){
        System.out.println(each.getText());

    }

    //	5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe bulundugunu test edin

    int actuelDropdown=tumEleman.size();
    int expectedDropdown=4;
    Assert.assertEquals(actuelDropdown,expectedDropdown,"Esit degil");
}}
