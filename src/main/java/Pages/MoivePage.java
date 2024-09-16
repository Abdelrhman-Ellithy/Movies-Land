package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MoivePage {
    WebDriver driver;
    public MoivePage(WebDriver driver){
        this.driver=driver;
    }
    public String getMovieTitle(){
       return driver.findElement(By.cssSelector("h1#movie-title")).getText();
    }
}
