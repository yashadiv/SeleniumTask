package Pages;

import java.time.Duration;

import Bases.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModulePage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//button[@class = 'btn btn-default']")
    private WebElement buttonAdd;
    @FindBy(xpath = "//input[@placeholder = 'Название']")
    private WebElement nameModule;
    @FindBy(xpath = "//input[@placeholder = 'ID для перемещения']")
    private WebElement idQuest;
    @FindBy(xpath =  "//button[text()= 'Создать']")
    private WebElement createButton;
    @FindBy(xpath = "//div[@class='col-sm-6']//button[text()='Переместить по Id']")
    private WebElement addQuestButton;
    public ModulePage (){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void createdModules(String name, String id){
        wait.until(ExpectedConditions.elementToBeClickable(buttonAdd));
        buttonAdd.click();
        wait.until(ExpectedConditions.elementToBeClickable(nameModule));
        nameModule.sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(idQuest));
        idQuest.sendKeys(id);
        addQuestButton.click();
        createButton.click();
    }
}
