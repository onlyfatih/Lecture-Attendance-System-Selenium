package Pages;

import org.openqa.selenium.WebDriver;

public class LessonsPage extends Page{
    public final String algoritmaAnalizi = "//ul[@class='list-group']/li[1]//div[@class='col-md-6 span6 d-flex align-items-center']//a[1]";
    public final String paralelSistemlerVeProgramlama = "//ul[@class='list-group']/li[4]//div[@class='col-md-6 span6 d-flex align-items-center']//a[1]";

    public LessonsPage(WebDriver driver) {
        super(driver);
    }
}
