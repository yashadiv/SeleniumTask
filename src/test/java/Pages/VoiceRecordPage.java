package Pages;

import Bases.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VoiceRecordPage extends BasePage {
    WebDriverWait wait;
    @FindBy(xpath = "//div[@class='d-flex align-items-center']")
    private WebElement course;
    @FindBy(xpath = "//button[@class='btn-primary btn btn btn-sm btn-primary']")
    private WebElement testKnowledge;
    @FindBy(xpath = "//button[@class='btn-light btn  btn-sm']")
    private WebElement startRecord;


    public VoiceRecordPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void createdVoiceRecord(){
        wait.until(ExpectedConditions.elementToBeClickable(course));
        course.click();
        wait.until(ExpectedConditions.elementToBeClickable(testKnowledge));
        testKnowledge.click();
        wait.until(ExpectedConditions.elementToBeClickable(startRecord));
        startRecord.click();
    }

    public String checkRecord(){
        return startRecord.getText();
    }
}
