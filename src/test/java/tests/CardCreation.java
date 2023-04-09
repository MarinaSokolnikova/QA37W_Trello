package tests;

import model.Card;
import org.testng.annotations.Test;

public class CardCreation extends TestBase{

    @Test
    public void cardCreation(){
        Card card = Card.builder()
                .cardName("testqa37")
                .color("green")
                .build();
        app.getBoard().clickTheFirstBoard();
        app.getBoard().pause(3000);
        app.getList().createList("test37");
        app.getList().pause(2000);
        app.getCard().initCardCreation();
        app.getCard().fillInCardCreationForm(card);
        app.getCard().submitCardCreation();
        app.getBoard().returnToHomePage();
    }

    @Test
    public void cardCreation2(){
        Card card = Card.builder()
                .cardName("testqa37")
                .color("green")
                .build();
        app.getBoard().clickTheFirstBoard();
        app.getBoard().pause(3000);
        app.getList().createList("test37");
        app.getList().pause(2000);
        app.getCard().initCardCreation();
        app.getCard().fillInCardCreationForm(card);
        app.getCard().submitCardCreation2();
        app.getBoard().returnToHomePage();
    }
}
