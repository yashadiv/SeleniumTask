package Pages;

import java.time.Duration;

import Bases.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class QuizPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement buttAdd;

    @FindBy(xpath = "//textarea[@class='w-md-editor-text-input ']")
    private WebElement nameQuiz;
    @FindBy(xpath = "//button[@class='btn-primary btn ']")
    private WebElement createdButton;
    public QuizPage(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void createdQuiz(String name){
        wait.until(ExpectedConditions.elementToBeClickable(buttAdd));
        buttAdd.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameQuiz));
        nameQuiz.sendKeys(name);
        createdButton.click();
    }
}
