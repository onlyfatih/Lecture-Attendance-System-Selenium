package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    WebDriver driver;
    public Page (WebDriver driver) {
        this.driver = driver;
    }
    public void WaitUntilTheElementAppearsId(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
    }
    public void WaitUntilTheElementAppearsXpath(String elementXpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }
    public void WaitUntilTheElementAppearsCss(String elementCss) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementCss)));
    }

    public void ClickSelectedPointId(String pointId) {
        driver.findElement(By.id(pointId)).click();
    }
    public void ClickSelectedPointXpath(String pointXpath) {
        driver.findElement(By.xpath(pointXpath)).click();
    }
    public void ClickSelectedPointCss(String pointCss) {
        driver.findElement(By.cssSelector(pointCss)).click();
    }
    public void WriteInField(String writeId, String loginInformation) {
        driver.findElement(By.id(writeId)). sendKeys(loginInformation);
    }


}
