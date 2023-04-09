package manage;

import model.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardHelper extends HelperBase{
    public CardHelper(WebDriver wd) {
        super(wd);
    }

    public void initCardCreation() {
        click(By.cssSelector(".open-card-composer"));
    }

    public void fillInCardCreationForm(Card card) {
        type(By.cssSelector(".list-card-composer-textarea"), card.getCardName());
        if (card.getColor()!=null)
        {
            openCardMenu();
            selectLable();
            click(By.cssSelector("[data-color='"+card.getColor()+"']"));
        }
        //click(By.cssSelector(".js-add-card"));
    }

    public void selectLable() {
        click(By.cssSelector(".js-label-selector"));
    }

    public void openCardMenu() {
        click(By.cssSelector(".js-cc-menu"));
    }

    public void submitCardCreation() {
        click(By.cssSelector(".js-add-card"));
    }

    public void submitCardCreation2() {
        click(By.cssSelector(".pop-over-header-close-btn"));
    }
}
