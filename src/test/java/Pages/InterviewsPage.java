package Pages;

import java.time.Duration;

import Bases.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InterviewsPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement buttonAdd;
    @FindBy(xpath = "//a[@href='/interviews']")
    private WebElement interviews;
    @FindBy(xpath = "//tbody//span")
    private WebElement oldNameInterviews;
    @FindBy(xpath = "//input[@placeholder='Название']")
    private WebElement nameInterview;
    @FindBy(xpath = "//div[@class = 'react-datepicker__input-container']//input")
    private WebElement dateInterview;
    @FindBy(xpath = "//select[@class = 'form-control']")
    private WebElement typeInterview;
    private Select select;
    @FindBy(xpath = "//textarea[@placeholder='Собственная оценка интервью']")
    private WebElement evaluationInterview;
    @FindBy(xpath = "//input[@placeholder='Видео ссылка']")
    private WebElement linkInterview;
    @FindBy(xpath = "//button[@class = 'btn-success btn ']")
    private WebElement successButton;
    @FindBy(xpath = "//button[@class='btn-primary btn ']")
    private WebElement createdButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement search;


    public InterviewsPage(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void createdInterview(String name){
        wait.until(ExpectedConditions.elementToBeClickable(buttonAdd));
        buttonAdd.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameInterview));
        nameInterview.sendKeys(name);
        createdButton.click();

    }




    public void enterNameInterview(String name){
        wait.until(ExpectedConditions.elementToBeClickable(nameInterview));
        nameInterview.clear();
        nameInterview.sendKeys(name);
    }

    public void enterTypeInterview(String type){
        typeInterview.click();
        select = new Select(typeInterview);
        select.selectByValue(type);
    }
    public void updateInterviews(String oldName,
                                 String name,
                                 String date,
                                 String type,
                                 String evaluation,
                                 String link){
        search.sendKeys(oldName);
        wait.until(ExpectedConditions.elementToBeClickable(oldNameInterviews));
        oldNameInterviews.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameInterview));
        nameInterview.clear();
        nameInterview.sendKeys(name != null ? name : "");
        linkInterview.clear();
        linkInterview.sendKeys(link != null ? link : "");
        typeInterview.clear();
        select = new Select(typeInterview);
        select.selectByValue(type != null ? type : "");
        evaluationInterview.clear();
        evaluationInterview.sendKeys(evaluation  != null ? evaluation : "");
        dateInterview.clear();
        dateInterview.sendKeys(date != null ? date : "");
        successButton.click();
    }
}
