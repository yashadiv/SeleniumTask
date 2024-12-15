import Bases.BaseTestPage;
import LoginPages.LoginPageAdmin;
import Pages.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.testng.annotations.AfterMethod;

//datafacker для создания пользователя
public class SeleniumTests extends BaseTestPage {
    private final String login = "divichinskiy_yakov";
    private final String password = "+–z9U+v?z>fLcYd";


    @Test
    public void LoginTest() throws InterruptedException {
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin();

        Assert.assertEquals(loginPageAdmin.enterProfile(login,password).getNameUser(),"Яков Д");

    }
    @Test
    public void createdNewInterviews() throws InterruptedException {
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin();

        InterviewsPage interviewsPage = loginPageAdmin
                .enterProfile(login,password)
                .linkInterviews();

        interviewsPage.createdInterview("newTestInterview");
    }

    @Test
    public void createdNewQuest() throws InterruptedException {
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin();

        QuestPage questPage = loginPageAdmin
                .enterProfile(login,password)
                .linkQuest();

        questPage.createdQuest("newTest");
    }
    @Test
    public void createdNewQuiz() throws InterruptedException {
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin();

        QuizPage quizPage = loginPageAdmin
                .enterProfile(login,password)
                .linkQuizes();
        quizPage.createdQuiz("newQuiz");
    }
    @Test
    public void createdNewModule() throws InterruptedException {
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin();

        ModulePage modulePage = loginPageAdmin
                .enterProfile(login,password)
                .linkModules();

        modulePage.createdModules("New Module", "1001");
    }
    @Test
    public void createdCourses() throws InterruptedException{
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin();
        CourcesPage coursesPage = loginPageAdmin
                .enterProfile(login,password)
                .linkCourses();

        coursesPage.createdCourses("testCourses1","1000");

        Assert.assertEquals(coursesPage.getNameCourses("testCourses1"),"testCourses1");
    }

    @CsvFileSource(resources = "user.csv")
    @ParameterizedTest
    public void createdUsers(String firstName,
                             String surname,
                             String email,
                             String loginUser,
                             String passwordUser,
                             String role,
                             String isCV,
                             String calendar,
                             String status) throws InterruptedException {
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin();
        UsersPage usersPage = loginPageAdmin
                .enterProfile(login,password)
                .linkUsers();
        usersPage.createdUsers(firstName,
                surname,
                email,
                loginUser,
                passwordUser,
                role,
                isCV,
                calendar,
                status);
    }

    @CsvFileSource(resources = "/interviews.csv")
    @ParameterizedTest
    public void upadtedInterviews(String name,
                                  String date,
                                  String type,
                                  String evaluation,
                                  String link) throws InterruptedException {
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin();
        InterviewsPage interviewsPage = loginPageAdmin
                .enterProfile(login,password)
                .linkInterviews();
        interviewsPage.updateInterviews("newTest",name,date,type,evaluation,link);
    }
    @Test
    public void createdExam() throws InterruptedException {
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin();
        ExamPage examPage = loginPageAdmin
                .enterProfile(login,password)
                .linkExam();
        examPage.createdExam("NewTestExam","1002");

        Assert.assertEquals(examPage.getNameExam("NewTestExam"),"NewTestExam");
    }

}
