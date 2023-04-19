package Pages;

import org.openqa.selenium.WebDriver;

public class TeamsPages extends Page{
    public final String ContinueInBrowser = ".primary";
    public final String Username = "username";
    public final String Camera = ".icons-call-video";
    public final String Microphone = ".icons-call-microphone";
    public final String Connect = ".join-btn";

    public TeamsPages(WebDriver driver) {
        super(driver);
    }
}
