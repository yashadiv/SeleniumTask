package MainMenu;

import Bases.BasePage;
import Pages.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainMenuAdmin extends BasePage {
    @FindBy(linkText = "Интервью")
    private WebElement interviews;
    @FindBy(linkText = "Вопросы")
    private WebElement question;
    @FindBy(linkText = "Квизы")
    private WebElement quizes;
    @FindBy(linkText = "Модули")
    private WebElement modules;
    @FindBy(linkText = "Курсы")
    private WebElement courses;
    @FindBy(linkText = "Пользователи")
    private WebElement users;
    @FindBy(linkText = "Экзамены")
    private WebElement exam;
    @FindBy(xpath = "//div[@class = 'menuProfile']")
    WebElement profile;

    public MainMenuAdmin (){
        PageFactory.initElements(driver, this);
    }

    public InterviewsPage linkInterviews(){
        interviews.click();
        return  new InterviewsPage();
    }

    public QuestPage linkQuest(){
        question.click();
        return  new QuestPage();
    }

    public ModulePage linkModules(){
        modules.click();
        return  new ModulePage();
    }
    public QuizPage linkQuizes(){
        quizes.click();
        return  new QuizPage();
    }
    public CourcesPage linkCourses(){
        courses.click();
        return new CourcesPage();
    }
    public UsersPage linkUsers(){
        users.click();
        return new UsersPage();
    }
    public ExamPage linkExam(){
        exam.click();
        return new ExamPage();
    }

    public String getNameUser() {
        return profile.getText();
    }
}
