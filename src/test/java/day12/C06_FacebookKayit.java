package day12;

import Utiletes.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class C06_FacebookKayit extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        WebElement ilkyer=driver.findElement(By.xpath("//input[@placeholder='Adın']"));
        Actions act=new Actions(driver);
        act.click(ilkyer).sendKeys("Mehmet")
                .sendKeys(Keys.TAB)
                .sendKeys("Bulutluoz")
                .sendKeys(Keys.TAB)
                .sendKeys("asdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("asdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12qwasQ.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("1972")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
