package pages;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class Page extends PageParent {
    private WebDriver driver;
    private String pageURL = "https://www.google.com/";
    private Map<String , String> elements = new HashMap<String , String>();




    public  Page (WebDriver driver) {
        this.driver = driver;
        elements.put("searchBox" , "//*[@name='q']");
        elements.put("Search","(//input[@value = 'Google Search'  and @name = 'btnK'])[2]");
    }
    public void navigateToPage(){
        driver.get(pageURL);
    }

    public String getElements(String element) {
        return elements.get(element);
    }

    public void setElements(Map<String, String> elements) {
        this.elements = elements;
    }
}
