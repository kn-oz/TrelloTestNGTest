package tests.TrelloTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TrelloDashboardPage;
import pages.TrelloHomePage;
import pages.TrelloLoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TrelloUITask {

    TrelloLoginPage trelloLoginPage = new TrelloLoginPage();
    TrelloHomePage trelloHomePage = new TrelloHomePage();
    TrelloDashboardPage trelloDashboardPage = new TrelloDashboardPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        trelloLoginPage.loginTrelloAccount();
    }

    @AfterMethod
    public void tearDown() {
        trelloDashboardPage.boardCloseAndDelete();
        Driver.quitDriver();
    }
    @Test
    public void trellotest() {

        trelloDashboardPage.createNewBoardButton.click();
        trelloDashboardPage.boardTitleTextBox.sendKeys("VaultN");
        ReusableMethods.wait(1);
        trelloDashboardPage.boardCreateButton.click();

        trelloDashboardPage.listCreation("Backlog", 1);
        trelloDashboardPage.listCreation("Todo", 2);
        trelloDashboardPage.listCreation("Doing", 3);
        trelloDashboardPage.listCreation("Testing", 4);
        trelloDashboardPage.listCreation("Done", 5);

        trelloDashboardPage.cardCreation("Sign up for Trello", 2);
        trelloDashboardPage.cardCreation("Get key and token", 2);
        trelloDashboardPage.cardCreation("Build a collection", 2);
        ReusableMethods.wait(1);
        trelloDashboardPage.cardCreation("Working on Task", 2);
        trelloDashboardPage.cardCreation("UI Automation", 1);
        ReusableMethods.wait(1);
        trelloDashboardPage.cardCreation("Writing Test Scenarios", 1);

        trelloDashboardPage.performDragAndDrop("Sign up for Trello", "Done");
        trelloDashboardPage.performDragAndDrop("Get key and token", "Testing");
        trelloDashboardPage.performDragAndDrop("Build a collection", "Doing");
        trelloDashboardPage.performDragAndDrop("Working on Task", "Doing");
    }
}
