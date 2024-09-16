package UI.Base;

import org.openqa.selenium.WebDriver;

public class BaseStepDefinition {
    public static WebDriver driver;
    public static void setDriver(WebDriver driver2){
        driver=driver2;
    }

}
