package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {
   WebDriver driver;



    @Test(priority = 1)
    public void test01(){
        System.out.println("test01");
    }
    @Test(priority = 9)
    public void test02(){
        System.out.println("test02");
    }
    @Test
    public void test03(){
        System.out.println("test03");
    }
    @Test(priority = -9)
    public void test04(){
        System.out.println("test04");
    }
    @Test (priority = 9)
    public void youtubeTesti(){
        System.out.println("Youtube testi calisti");
    }


    @Test(priority = 0)
    public void amazonTesti(){ // pririty atanmazsa priority=0 kabul eder
        System.out.println("Amazon testi calisti");
    }


    @Test
    public void bestbuyTesti(){
        System.out.println("Bestbuy testi calisti");
    }

}
