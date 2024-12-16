package MainMenu;

import Bases.BasePage;
import Pages.VoiceRecordPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainMenuUser extends BasePage {
    @FindBy(xpath = "//a[@href='/courses']")
    private WebElement courses;

    public MainMenuUser(){
        PageFactory.initElements(driver,this);
    }

    public VoiceRecordPage clickLinkCourses(){
        courses.click();
        return new VoiceRecordPage();
    }
}
