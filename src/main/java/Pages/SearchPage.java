package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver=driver;
        returnHome();
    }
    public void searchItem(String itemName){
        driver.findElement(By.id("search-input")).sendKeys(itemName);
    }
    public void clickEnter(){
        driver.findElement(By.id("search-input")).sendKeys(Keys.ENTER);
    }
    public MoivePage clickItem(String id){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("movie-card-533535")).click();
        return new MoivePage(driver);
    }
    public String getTextInSearchField(){
       return driver.findElement(By.id("search-input")).getAttribute("value");
    }
    public List<String> getResultsNames(){
        List<WebElement> items=driver.findElements(By.xpath("//div[contains(@id, movie-card)]//img"));
        List<String>itemsName=new ArrayList<>();
        for (WebElement item:items){
            itemsName.add(item.getAttribute("alt").toLowerCase());
        }
        System.out.println(itemsName);
        return itemsName;
    }
    public void returnHome(){
        String URL=System.getProperty("URL");
        driver.navigate().to(URL);
    }
}
