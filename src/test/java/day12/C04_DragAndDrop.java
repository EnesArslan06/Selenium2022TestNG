package day12;

import Utiletes.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_DragAndDrop extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        ////2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragme= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropme=driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions act=new Actions(driver);
        act.dragAndDrop(dragme, dropme).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDroppedYazisi=dropme.getText();
        String expectedDroppedYazisi="Dropped!";
        System.out.println(actualDroppedYazisi);
        Assert.assertEquals(actualDroppedYazisi,expectedDroppedYazisi);

        Thread.sleep(3000);

    }
}
