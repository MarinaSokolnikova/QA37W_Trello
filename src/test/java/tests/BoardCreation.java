package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase{

    @Test
    public void boardCreation1(){
         app.getBoard().initBoardCreationFromHeader();
         app.getBoard().fillInBoardCreationForm("qa37");
         //app.getBoard().scrollDownTheForm();
         app.getBoard().pause(2000);
         app.getBoard().submitBoardCreation();
         app.getBoard().pause(2000);

        Assert.assertTrue(app.getBoard().isCreated());
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        //Assert
    }

    @Test
    public void boardCreation2(){
        int boardCountBeforeCreation = app.getBoard().getBoardCount();

        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillInBoardCreationForm("qa37");
        //app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        app.getBoard().pause(2000);

        int boardCountAfterCreation = app.getBoard().getBoardCount();

        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation+1);
    }
}
