package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class TrelloLoginPage {


    public TrelloLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type=\"email\"]")
    public WebElement loginEmailBox;
    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement loginPasswordBox;
    @FindBy(xpath = "//button[@id=\"login-submit\"]")
    public WebElement loginContinueButton;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement loginButton;

    // Method login with the valid Credentials provided in ConfiqProperties
    public void loginTrelloAccount() {
        TrelloHomePage trelloHomePage = new TrelloHomePage();
        trelloHomePage.loginButton.click();
        loginEmailBox.sendKeys(ConfigReader.getProperty("trelloEmail"));
        loginContinueButton.click();
        loginPasswordBox.sendKeys(ConfigReader.getProperty("trelloPassword"));
        loginButton.click();
    }
}
