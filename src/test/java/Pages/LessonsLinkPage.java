package Pages;

import org.openqa.selenium.WebDriver;

public class LessonsLinkPage extends Page{
    public final String lessonLink = "//span[contains(.,'Algoritma Analizi Dersi 2. Öğretim Bağlantısı (Tüm Haftalar İçin Aynı Bağlantı K')]";
    public final String lessonLink1 = "//span[.='Ders Katılım Linki URL']";

    public LessonsLinkPage(WebDriver driver) {
        super(driver);
    }
}
