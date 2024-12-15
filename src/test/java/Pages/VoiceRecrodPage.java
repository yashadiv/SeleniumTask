package Pages;

import Bases.BasePage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VoiceRecrodPage extends BasePage {
    WebDriverWait wait;
    public VoiceRecrodPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
}
