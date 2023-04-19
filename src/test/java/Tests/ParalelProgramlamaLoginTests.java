package Tests;

import Pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParalelProgramlamaLoginTests {
    private WebDriver driver;
    private LoginPage loginpage;
    private LessonsPage lessonsPage;
    private Page page;
    private LessonsLinkPage lessonsLinkPage;
    private TeamsPages teamsPages;

    @BeforeEach
    void setup () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("use-fake-ui-for-media-stream");
        System.setProperty("webdriver.chrome.driver","/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        loginpage = new LoginPage(driver);
        lessonsPage = new LessonsPage(driver);
        page = new Page(driver);
        lessonsLinkPage = new LessonsLinkPage(driver);
        teamsPages = new TeamsPages(driver);

        String username = System.getenv("EMAIL");
        String password = System.getenv("PASSWORD");

        driver.get("https://lms.ktun.edu.tr/login");
        page.WaitUntilTheElementAppearsId(loginpage.email);
        page.WriteInField(loginpage.email,username);
        page.WriteInField(loginpage.password, password);
        page.ClickSelectedPointId(loginpage.deal);
        page.ClickSelectedPointId(loginpage.deal1);
        page.ClickSelectedPointId(loginpage.loginButton);
    }

    @Test
    void ParalelProgramlamaLoginTesti () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        String winHandleBefore = driver.getWindowHandle();
        page.WaitUntilTheElementAppearsXpath(lessonsPage.algoritmaAnalizi);
        page.ClickSelectedPointXpath(lessonsPage.paralelSistemlerVeProgramlama);
        page.WaitUntilTheElementAppearsXpath(lessonsLinkPage.lessonLink1);
        page.ClickSelectedPointXpath(lessonsLinkPage.lessonLink1);

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        page.WaitUntilTheElementAppearsCss(teamsPages.ContinueInBrowser);
        page.ClickSelectedPointCss(teamsPages.ContinueInBrowser);

        Thread.sleep(10000);
        page.ClickSelectedPointCss(teamsPages.Camera);
        page.ClickSelectedPointCss(teamsPages.Microphone);
        page.WriteInField(teamsPages.Username,"Fatih ARSLAN");
        page.ClickSelectedPointCss(teamsPages.Connect);

        Thread.sleep(1000);
    }
    @AfterEach
    void teardown () {
        driver.close();
    }
}
