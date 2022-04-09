package day14;

import Utiletes.TestBase;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class deneme extends TestBase {
    @Test
    public void testDeneme(){
        driver.get("https://www.trendyol.com");
        Set<Cookie> cookieler=driver.manage().getCookies();
        System.out.println(cookieler);
        int sayac=1;
        for (Cookie each : cookieler
             ) {
            System.out.println(sayac +" .cooikes: "+ each);
            sayac++;
        }
        System.out.println(cookieler.size());
        Cookie myCookie = new Cookie("en sevdigim","cikolatali");
        driver.manage().addCookie(myCookie);
        System.out.println(cookieler.size());
        Set<Cookie> cookieler2=driver.manage().getCookies();
        int sayac2=1;
        for (Cookie each : cookieler2
        ) {
            System.out.println(sayac +" .cooikes: "+ each);
            sayac++;
        }
    }
}
