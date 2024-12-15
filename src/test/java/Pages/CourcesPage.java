package Pages;

import Bases.BasePage;
import LoginPages.LoginPageAdmin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CourcesPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement buttonAdd;
    @FindBy(xpath ="//div[@class='col-sm-4']//input[@placeholder='Название']")
    private WebElement inputNameCourse;
    @FindBy(xpath = "//button[@class='btn btn-xs btn-default btn-push-add']")
    private WebElement buttonAddModule;
    @FindBy(xpath = "//input[@placeholder ='Модуль']")
    private WebElement inputIdModule;
    @FindBy(xpath = "//button[@class='btn-primary btn ']")
    private WebElement createdButton;
    @FindBy(xpath = "//input[@type='search']")
    private WebElement search;
    @FindBy(xpath = "//table//span")
    private WebElement searchResult;

    public CourcesPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public String getNameCourses(String name){
        search.sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(searchResult));
        return searchResult.getText();
    }
    public void createdCourses(String name, String id){
        wait.until(ExpectedConditions.elementToBeClickable(buttonAdd));
        buttonAdd.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputNameCourse));
        inputNameCourse.sendKeys(name);
        buttonAddModule.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputIdModule));
        inputIdModule.sendKeys(id);
        createdButton.click();
    }
}
