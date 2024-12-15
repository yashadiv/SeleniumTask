package Pages;

import Bases.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExamPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement buttonCreated;
    @FindBy(xpath = "//div[@_key='0'][@class='col-sm-3']//input")
    private WebElement inputName;
    @FindBy(xpath = "//input[@placeholder='ID для перемещения']")
    private WebElement inputIdQuestion;
    @FindBy(xpath = "//button[contains(text(), 'Переместить по Id')]")
    private WebElement buttonMoveQuestionById;
    @FindBy(xpath = "//button[contains(text(), 'Create')]")
    private WebElement saveExam;
    @FindBy(xpath = "//tbody//span")
    private WebElement getNameExam;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement search;


    public ExamPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void createdExam(String name, String idQuestion) {
        buttonCreated.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputName));
        inputName.sendKeys(name);
        inputIdQuestion.sendKeys(idQuestion);
        buttonMoveQuestionById.click();
        saveExam.click();
    }

    public String getNameExam(String nameExam) {
        search.sendKeys(nameExam);
        wait.until(ExpectedConditions.elementToBeClickable(getNameExam));
        return getNameExam.getText();
    }
}
