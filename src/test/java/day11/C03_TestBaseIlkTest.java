package day11;

import Utiletes.TestBase;
import org.testng.annotations.Test;

public class C03_TestBaseIlkTest extends TestBase {
        //utilates package inden aldi bu classda olmadigi icin...
    @Test
    public void test(){
        driver.get("https://www.amazon.com/");

    }

}
