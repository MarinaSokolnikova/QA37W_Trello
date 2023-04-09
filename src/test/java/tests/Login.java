package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login  extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if (app.getUser().isLogged())
        {
            app.getUser().logout();
        }
    }
    @Test
    public void login(){
        User user = User.builder()
                .email("sokolnikovam92@gmail.com")
                .password("FF22Kseriesqq!")
                .build();
        app.getUser().initLogin();
        app.getUser().pause(2000);
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().pause(2000);

        Assert.assertTrue(app.getUser().isLogged());



    }
}
