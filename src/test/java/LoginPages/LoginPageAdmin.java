package LoginPages;

import Bases.BasePage;
import MainMenu.MainMenuAdmin;
import MainMenu.MainMenuUser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageAdmin extends BasePage {
    @FindBy(xpath = "//input[@id ='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id ='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type ='submit']")
    private WebElement loginButton;

    public LoginPageAdmin(){
        driver.get("https://aqa-admin.javacode.ru/login");
        PageFactory.initElements(driver,this);
    }

    public MainMenuAdmin enterProfile(String username, String password) throws InterruptedException {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        Thread.sleep(3000);
        return  new MainMenuAdmin();
    }
}
