package day15;

import Utiletes.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class deneme extends TestBase {
    @Test
    public void test() throws IOException, InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        //    go to url :http://demo.automationtesting.in/Alerts.html
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        //    accept Alert(I am an alert box!) and print alert on console
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        //    cancel Alert  (Press a Button !)
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        //    finally print on console this message "Hello TechproEducation How are you today"

       driver.findElement(By.xpath("//a[text()='Click Here']")).click();
            WebElement name=driver.findElement(By.xpath("//input[@name='emailid']"));
            name.click();
            name.sendKeys("Enes"+Keys.ENTER);
    }
}
