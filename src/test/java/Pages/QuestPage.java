package Pages;

import java.time.Duration;

import Bases.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class QuestPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//button[@class = 'btn btn-default']")
    private WebElement buttonAdd;
    @FindBy(xpath = "//textarea[@class = 'w-md-editor-text-input ']")
    private WebElement nameQuest;
    @FindBy(xpath = "//button[@class = 'btn-primary btn ']")
    private WebElement buttonCreated;


    public QuestPage(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void createdQuest(String name){
        wait.until(ExpectedConditions.elementToBeClickable(buttonAdd));
        buttonAdd.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameQuest));
        nameQuest.sendKeys(name);
        buttonCreated.click();
    }
}
