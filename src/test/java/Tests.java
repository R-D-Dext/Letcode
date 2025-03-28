import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@Execution(ExecutionMode.CONCURRENT)
public class Tests extends BaseTest {


    @DisplayName("Тестирование страницы Input")
    @ParameterizedTest
    @CsvSource({"Jon Jonovich, Join + TAB", "Jack Jackovich, Join + TAAAAB"})
    void checkInputPage(String fullName, String join) {

        System.out.println("Поток - " + Thread.currentThread().getName());
        MainPage mainPage = new MainPage(chromeDriver);
        mainPage.transitionToInputPage();
        EditPage editPage = new EditPage(chromeDriver);
        editPage.sendKeysInFullName(fullName);
        editPage.joinInputMeytod(join);
        editPage.getMeValueMethod();
        editPage.clearMeMethod();
    }

    @Test
    void checkAlertPage() {
        System.out.println("Поток - " + Thread.currentThread().getName());
        MainPage mainPage = new MainPage(chromeDriver);
        mainPage.transitionToAlertPage();
        AlertPage alertPage = new AlertPage(chromeDriver);
        alertPage.testSimpleAlert();
        alertPage.dismissAlertCheck();
        alertPage.promptAlertCheck();
    }
}