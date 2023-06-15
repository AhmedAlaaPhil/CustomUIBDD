package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Page;
import utilis.ElementHandler;
import utilis.PropertiesReader;

import java.io.IOException;
import java.util.Map;

public class TestBDD {
    WebDriver driver;
    Page page ;
    String tcFilepath = "src/test/resources/TC.property";
    @BeforeTest
    public void Init (){
        // set up the web driver manger
        WebDriverManager.chromedriver().setup();
        // set up options for chrome driver
        ChromeOptions options = new ChromeOptions();
        // set options to headless mode
        //options.addArguments("--headless");
        // init web driver
        driver = new ChromeDriver(options);
        page = new Page(driver);

    }
    @Test
    public void getPaths () throws IOException {

        Map<String , String> property = PropertiesReader.propertiesReader(tcFilepath);
        page.navigateToPage();
       String elements = property.get("Elements");
       String[] element = elements.split(",");
       for(String e : element){

           System.out.println(page.getElements(e));

       }

       if(property.get("AssertType").equals("True") ){
           String asserts = property.get("Assert");
           String[] asser = asserts.split(",");
           if(asser[0].equals("IsDisplayed")){

                for(String s : asser) {
                    if (s == asser[0]) continue;
                    System.out.println(page.getElements(s));
                    Assert.assertTrue(ElementHandler.isDisplayed(driver,page.getElements(s) ));
                }
           }
       }




    }

}
