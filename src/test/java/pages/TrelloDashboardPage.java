package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.driver;

public class TrelloDashboardPage {

    public TrelloDashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class=\"board-tile mod-add\"]")
    public WebElement createNewBoardButton;
    @FindBy(xpath = "//*[@data-testid=\"create-board-title-input\"]")
    public WebElement boardTitleTextBox;
    @FindBy(xpath = "//*[@data-testid=\"create-board-submit-button\"]")
    public WebElement boardCreateButton;
    @FindBy(xpath = "//*[@data-testid=\"list-name-textarea\"]")
    public WebElement newListNameTextBox;
    @FindBy(xpath = "//*[@data-testid=\"list-composer-add-list-button\"]")
    public WebElement addNewListButton;
    @FindBy(xpath = "//*[@data-testid=\"list-card-composer-textarea\"]")
    public WebElement cardNameTextBox;
    @FindBy(xpath = "//*[@data-testid=\"list-card-composer-add-card-button\"]")
    public WebElement addCardButton;
    @FindBy(xpath = "//button[@class=\"frrHNIWnTojsww GDunJzzgFqQY_3 bxgKMAm3lq5BpA HAVwIqCeMHpVKh SEj5vUdI3VvxDc\"]")
    public WebElement showMenuIcon;
    @FindBy(xpath = "//*[@class=\"icon-sm icon-remove board-menu-navigation-item-link-icon\"]")
    public WebElement closeBoardButton;
    @FindBy(xpath = "//*[@data-testid=\"close-board-confirm-button\"]")
    public WebElement closeBoardConfirmButton;
    @FindBy(xpath = "//*[@data-testid=\"close-board-delete-board-button\"]")
    public WebElement deleteBoardButton;
    @FindBy(xpath = "//*[@data-testid=\"close-board-delete-board-confirm-button\"]")
    public WebElement deleteBoardConfirmButton;

    // This method creates list with name to provided index
    public void listCreation(String listName, int index) {

        driver.findElement(By.xpath("(//*[@data-testid=\"list-name-textarea\"])[" + index + "]")).sendKeys(listName);
        addNewListButton.click();

    }
    // This method creates card with provided name to list index
    public void cardCreation(String cardName, int listIndex) {

        driver.findElement(By.xpath("(//button[@data-testid=\"list-add-card-button\"])[" + listIndex + "]")).click();
        cardNameTextBox.sendKeys(cardName);
        addCardButton.click();
        cardNameTextBox.sendKeys(Keys.ENTER);

        // Index 1 : Backlog
        // Index 2 : Todo
        // Index 3 : Doing
        // Index 4 : Testing
        // Index 5 : Done

    }
    // This method drag and drop source to target element with the first index text
    public void performDragAndDrop(String sourceCardName, String targetListName) {

        WebElement sourceCardElement = driver.findElement(By.xpath("(//*[text()=\"" + sourceCardName + "\"])[1]"));
        WebElement targetListElement = driver.findElement(By.xpath("(//*[text()=\"" + targetListName + "\"])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceCardElement, targetListElement).perform();
    }
    // This Method close the current board and delete
    public void boardCloseAndDelete() {
        showMenuIcon.click();
        ReusableMethods.wait(1);
        closeBoardButton.click();
        closeBoardConfirmButton.click();
        ReusableMethods.wait(2);
        deleteBoardButton.click();
        ReusableMethods.wait(1);
        deleteBoardConfirmButton.click();
    }

}
