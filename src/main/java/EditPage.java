import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Data
public class EditPage {

    //Заполнить поле +
    //Добавить текст и нажать TAB +
    //Проверить что находится в поле
    //Очистить поле
    //Подтвердить что редактирование отключено
    //Подтвердить что текст доступен только для чтения

    WebDriver chromeDriver;
    WebElement fullNameInput;
    WebElement joinInput;
    WebElement getMe;
    WebElement clearMe;

    EditPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        fullNameInput = chromeDriver.findElement(By.xpath("//input[@id='fullName']"));
        joinInput = chromeDriver.findElement(By.xpath("//input[@id='join']"));
        getMe = chromeDriver.findElement(By.xpath("//input[@id='getMe']"));
        clearMe = chromeDriver.findElement(By.xpath("//input[@id='clearMe']"));
    }

    void sendKeysInFullName(String fullName) {
        fullNameInput.sendKeys(fullName);
    }

    void joinInputMeytod(String valueInput) {
        joinInput.sendKeys(valueInput);
        joinInput.sendKeys(Keys.TAB);
    }

    void getMeValueMethod() {
        String value = getMe.getAttribute("value");
        System.out.println(value);
    }

    void clearMeMethod() {
        clearMe.clear();
    }

}
