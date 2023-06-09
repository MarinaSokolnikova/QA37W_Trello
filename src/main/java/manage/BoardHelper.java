package manage;

import model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BoardHelper extends HelperBase{

    public BoardHelper(WebDriver wd) {
        super(wd);
    }


    public void initBoardCreationFromHeader() {
        click(By.xpath("//button[@data-testid='header-create-menu-button']"));
        click(By.xpath("//button[@data-testid='header-create-board-button']"));

    }

    public void fillInBoardCreationForm(String title) {
        type(By.xpath("//input[@data-testid='create-board-title-input']"), title);

    }

    public void fillInBoardCreationForm(Board board) {
        type(By.xpath("//input[@data-testid='create-board-title-input']"), board.getTitle());

    }


    public void scrollDownTheForm() {
        Actions action = new Actions(wd);
        WebElement container = wd.findElement(By.cssSelector("[data-testid='header-create-menu-popover']"));
        Rectangle rect = container.getRect();
        int x = rect.getX()+20;
        int y = rect.getY()+rect.getHeight()/2;
        action.moveByOffset(x,y).click().perform();
    }

    public void submitBoardCreation() {
        click(By.cssSelector("[data-testid='create-board-submit-button']"));
    }

    public boolean isCreated() {
        return wd.findElements(By.cssSelector(".list-name-input")).size()>0;

    }

    public void returnToHomePage() {
        click(By.cssSelector(".qsCZSrobO7JoSv"));
    }

    public int getBoardCount() {
        return wd.findElements(By.cssSelector(".board-tile-details")).size()-1-recentlyViewed();
    }

    private int recentlyViewed() {
        return wd.findElements(By.xpath("//*[contains(@class, 'icon-clock')]/../..//div")).size();
    }

    public void clickTheFirstBoard() {
        click(By.cssSelector(".board-tile-details"));
    }

    public void openSideBoard() {
        click(By.cssSelector(".show-sidebar-button-react-root"));
    }

    public void openMore() {
        click(By.className("js-open-more"));
    }

    public void closeBoard() {
        click(By.className("js-close-board"));
        click(By.className("js-confirm"));
    }

    public void deleteBoard() {
        click(By.xpath("//button[@data-testid='close-board-delete-board-button']"));
        click(By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']"));
    }

    public void startBoardCreation() {
        click(By.xpath("//li[@data-testid='create-board-tile']"));
    }

    public void openBoard() {
        click(By.cssSelector("[data-testid='workspace-chooser-trigger-button']"));
        pause(1000);//!!!
        click(By.xpath("//div[@class='atlaskit-portal']//div/button"));
    }

    public void closeCreationWindow() {
        click(By.cssSelector("[data-testid='popover-close']"));
    }

    public void returnToCreation() {
        click(By.cssSelector(".Uz5Itgv85sjPQ_"));
    }
}
