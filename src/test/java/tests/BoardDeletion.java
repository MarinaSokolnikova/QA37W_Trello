package tests;

import org.testng.annotations.Test;

public class BoardDeletion extends TestBase{

    @Test
    public void boardDeletion(){
        app.getBoard().clickTheFirstBoard();
        app.getBoard().pause(2000);
        app.getBoard().openSideBoard();
        app.getBoard().openMore();
        app.getBoard().closeBoard();
        app.getBoard().deleteBoard();
    }

    @Test
    public void refuseBoardDeletion(){
        app.getBoard().clickTheFirstBoard();
        app.getBoard().pause(1000);
        //app.getBoard().openSideBoard();
        app.getBoard().openMore();
        app.getBoard().closeBoard();
        app.getBoard().openBoard();
        app.getBoard().pause(1000);
        app.getBoard().returnToHomePage();
    }
}
