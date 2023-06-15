package utilis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ElementHandler {





    public static Boolean isDisplayed (WebDriver driver , String element){

        Boolean isDisplayed = false;

        isDisplayed = driver.findElement(By.xpath(element)).isDisplayed();

        return  isDisplayed;
    }



    public static  String getText (WebDriver driver , String element){

        String text;

        text = driver.findElement(By.xpath(element)).getText();

        return  text;
    }

    public static  void clickElement (WebDriver driver , String element){



        driver.findElement(By.xpath(element)).click();


    }

}
