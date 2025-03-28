import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Data
public class MainPage {
    WebDriver chromeDriver;
    WebElement edit;
    WebElement alert;

    MainPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        edit = chromeDriver.findElement(By.xpath("//a[@class='card-footer-item' and text()=' Edit ']"));
        alert = chromeDriver.findElement(By.xpath("//p[text()=' Alert ']/ancestor::app-menu//a[@class='card-footer-item']"));
    }

    public void transitionToInputPage() {
        edit.click();
    }

    public void transitionToAlertPage() {
        alert.click();
    }

}