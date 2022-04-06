package day12;

import Utiletes.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class C03_MouseActions extends TestBase {

    @Test
    public void test(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement cerceve=driver.findElement(By.id("hot-spot"));
        //3- Cizili alan uzerinde sag click yapalim
        Actions action=new Actions(driver);
        action.contextClick(cerceve).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String yazi=driver.switchTo().alert().getText();
        System.out.println(yazi);
        String expected="You selected a context menu";
        Assert.assertTrue(yazi.equals(expected));
        //5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHAndle=driver.getWindowHandle();
        WebElement seleniumElement= driver.findElement(By.xpath("//a[@target='_blank']"));
        action.click(seleniumElement).perform();
        String ikincisayfaHandler=driver.getWindowHandle();
//7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> handleDegerleri=driver.getWindowHandles();

       for (String each : handleDegerleri) {
           if (!each.equals(ikincisayfaHandler))
               ikincisayfaHandler=each;
       }

       driver.switchTo().window(ikincisayfaHandler);
       WebElement sonTest=driver.findElement(By.tagName("h1"));
       String expected2="Elemental Selenium";
        Assert.assertTrue(sonTest.getText().contains(expected2),"degerleri icermiyor");
       }
    }

