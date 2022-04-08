package day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {
    @Test
    public void test(){

        System.out.println(System.getProperty("user.home"));//C:\Users\Enes
        //Masa ustundeki deneme klasorunun patch'i
        //C:\Users\Enes\Desktop\Deneme
       String path= System.getProperty("user.home")+"\\Desktop\\Deneme\\Selenium dosya.txt";
       System.out.println(path);//C:\Users\Enes\Desktop\Deneme\Selenium dosya.txt yazdirdi...
       System.out.println("user.dir= "+System.getProperty("user.dir"));
        //Masaustunde deneme klasoru icerisinde selenium deneme.txt dosyasi varmi test edin..

        //1-once bu dosyaya ulasmak icin dinamik path olusturulmali

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Deneme\\Selenium dosya.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//bunun icindeki yol true yada false varmi diye soruyoruz yani dondurecek


        //projemizde pom.xml olup olmadigini test edin
        //C:\Users\Enes\eclipse-workspace\com.TestNGBatch44\pom.xml
        System.out.println(System.getProperty("user.dir"));//bu projenin yolunu verir..
        //C:\Users\Enes\eclipse-workspace\com.TestNGBatch44  bunu verdi. yukaridaki ile asagidakini tek farki
        // pom.xml kısmi
        String pomPath=System.getProperty("user.dir")+"\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));
    }
}
