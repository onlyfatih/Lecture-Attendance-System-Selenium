package Pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends Page{

    public final String email = "username";

    public final String password = "password";
    public final String deal = "sozlesme";
    public final String deal1 = "sozlesme1";
    public final String loginButton = "loginbtn";

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
