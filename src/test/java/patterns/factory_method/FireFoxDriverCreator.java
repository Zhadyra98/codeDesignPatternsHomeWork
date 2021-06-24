package patterns.factory_method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverCreator extends WebDriverCreator{

    @Override
    public WebDriver factoryMethod() {
        driver = new FirefoxDriver();
        return driver;
    }
}
