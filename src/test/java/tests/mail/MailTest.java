package tests.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import patterns.factory_method.ChromeDriverCreator;
import patterns.factory_method.WebDriverCreator;
import patterns.singleton.WebDriverSingleton;
import tests.mail.page_object.DraftsPage;
import tests.mail.page_object.InboxPage;
import tests.mail.page_object.MainPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MailTest {
    WebDriver driver;
    WebDriverCreator creator = new ChromeDriverCreator();
    @BeforeClass(description = "Start browser")
    private void initBrowser() {
        driver = creator.factoryMethod();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterClass(description = "close browser" )
    public void kill(){
        driver.close();
    }

    @Test(description = "Login To the System ", priority = 0)
    public void loginToSystem() {
        MainPage mainPage = new MainPage(driver).open();
        mainPage.enterLogin().moveToPasswordEnter().enterPassword().clickLoginButton();
    }
    @Test(description = "Login To the System ", priority = 1)
    public void saveLetterToDraft() {
        DraftsPage draftsPage = new InboxPage(driver).writeMailClick().fillLetterInputs().pressSaveLetterOnDraft().closeAndMoveToDraftsPage();
    }
    @Test(description = "check whether letter was placed to the Drafts folder", priority = 2)
    public void openMessageThatWasPlacedToDrafts() throws InterruptedException {
        Thread.sleep(4000);
        new DraftsPage(driver).openAndCheckMessagePlacedToDrafts().clickOnSendButton();
    }

}
