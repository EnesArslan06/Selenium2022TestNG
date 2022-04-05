package day11;

import Utiletes.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class deneme extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.bestbuy.com");
        System.out.println("2.sayfanin handle degeri : " + driver.getWindowHandle());
        String windowHandleDegeri2=driver.getWindowHandle();
        String hepsiburadaHandle=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        driver.switchTo().window(amazonHandle);
        WebElement aramaKutusu =driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.click();
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);


    }
}
