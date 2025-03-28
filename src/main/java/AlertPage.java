import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class AlertPage {
    WebDriver chromeDriver;
    WebElement simpleAlertButton;
    WebElement dismissAlertButton;
    WebElement promptAlertButton;

    AlertPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        simpleAlertButton = chromeDriver.findElement(By.xpath("//button[text()='Simple Alert']"));
        dismissAlertButton = chromeDriver.findElement(By.xpath("//button[text()='Confirm Alert']"));
        promptAlertButton = chromeDriver.findElement(By.xpath("//button[text()='Prompt Alert']"));
    }

    public void testSimpleAlert() {
        simpleAlertButton.click();
        Alert alert = chromeDriver.switchTo().alert();
        System.out.println(alert.getText());
        //chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        alert.accept();
    }

    public void dismissAlertCheck() {
        dismissAlertButton.click();
        Alert alert = chromeDriver.switchTo().alert();
        alert.getText();
        alert.dismiss();
        dismissAlertButton.click();
        alert.accept();
    }

    public void promptAlertCheck() {
        promptAlertButton.click();
        Alert alert = chromeDriver.switchTo().alert();
        alert.sendKeys("Denis123");
        alert.accept();
    }


}
