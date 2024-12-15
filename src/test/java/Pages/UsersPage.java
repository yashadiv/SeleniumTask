package Pages;

import Bases.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UsersPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//button[@class = 'btn btn-default']")
    private WebElement buttonAdd;
    @FindBy(xpath = "//div[@_key='2']//input")
    private WebElement inputFirstName;
    @FindBy(xpath = "//div[@_key='3']//input")
    private WebElement inputSurname;
    @FindBy(xpath = "//div[@_key='4']//input")
    private WebElement inputEmail;
    @FindBy(xpath = "//div[@_key='5']//input")
    private WebElement inputLogin;
    @FindBy(xpath = "//div[@_key='6']//input")
    private WebElement inputPassword;
    @FindBy(xpath = "//div[@_key='7']//input")
    private WebElement inputRoles;
    @FindBy(xpath = "//div[@_key='8']//input")
    private WebElement inputIsCV;
    @FindBy(xpath = "//div[@_key='9']//input")
    private WebElement inputCalendar;
    @FindBy(xpath = "//button[text()='---']")
    private WebElement buttonStatusDefault;
    @FindBy(xpath = "//button[text()='На поиске']")
    private WebElement buttonStatusSearch;
    @FindBy(xpath = "//button[text()='Пауза поиска']")
    private WebElement buttonStatusPause;
    @FindBy(xpath = "//button[text()='На проекте']")
    private WebElement buttonStatusProject;
    @FindBy(xpath = "//button[@class = 'btn-primary btn ']")
    private WebElement createdButton;

    public UsersPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void createdUsers(String firstName,
                             String surname,
                             String email,
                             String login,
                             String password,
                             String role,
                             String isCV,
                             String calendar,
                             String status){
        wait.until(ExpectedConditions.elementToBeClickable(buttonAdd));
        buttonAdd.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputFirstName));
        inputFirstName.sendKeys(firstName!=null?firstName:"");
        inputSurname.sendKeys(surname!=null?surname:"");
        inputEmail.sendKeys(email!=null?email:"");
        inputLogin.sendKeys(login!=null?login:"");
        inputPassword.sendKeys(password!=null?password:"");
        inputRoles.sendKeys(role!=null?role:"");
        inputIsCV.sendKeys(isCV!=null?isCV:"");
        inputCalendar.sendKeys(calendar!=null?calendar:"");
        switch (status) {
            case "active_search" -> buttonStatusSearch.click();
            case "on_project" -> buttonStatusProject.click();
            case "pause_search" -> buttonStatusPause.click();
            default -> buttonStatusProject.click();
        }
        createdButton.click();
    }
}
