package day12;

import Utiletes.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class C02_MouseActions extends TestBase {
    // amazon anasayfaya gidin
    // sag ustte hello,signIn elementinin uzerinde mouse'u bekletin
    // acilan menude new list linkine tiklayin
    // ve new list sayfasinin acildigini test edin
@Test
public void test() throws InterruptedException {
    driver.get("https://www.amazon.com");

    Actions actions=new Actions(driver);
    WebElement helloElement=driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));
    actions.moveToElement(helloElement).perform();

    WebElement listElementi=driver.findElement(By.xpath("//span[text()='Create a List']"));
    actions.click(listElementi).perform();

    String actualtitle= driver.getTitle();
    String arananMetin="Your List";

    Assert.assertTrue(actualtitle.contains(arananMetin));


}

}
