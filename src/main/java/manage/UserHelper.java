package manage;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        pause(2000);
        type(By.cssSelector("#password"), password);
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#user"), user.getEmail());
        click(By.cssSelector("#login"));
        pause(2000);
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void submitLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public boolean isLogged() {
        return wd.findElements(By.cssSelector("[data-testid='header-member-menu-button']")).size()>0;
    }

    public void logout() {
        click(By.xpath("//button[@data-testid='header-member-menu-button']"));
        click(By.xpath("//button[@data-testid='account-menu-logout']"));
        click(By.xpath("//button[@data-testid='logout-button']"));
    }

    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), email);
        click(By.cssSelector("#login"));
        pause(2000);
        type(By.cssSelector("#password"), password);
        click(By.cssSelector("#login-submit"));
    }

    public void openTabAndSwitch() {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(tabs.size()-1));
        wd.navigate().to("https://www.google.com/");
    }

    public void clickAvatar() {
        click(By.cssSelector("[data-testid='header-member-menu-button']"));
    }

    public void openUserProfile() {
        click(By.cssSelector("[data-testid='account-menu-profile']"));
    }

    public void goToTheAtlassAccount() {
        click(By.cssSelector("[href$='manage-profile']"));
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(tabs.size()-1));
    }
}
