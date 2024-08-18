package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TrelloHomePage {

    public TrelloHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']")
    public WebElement loginButton;

}
