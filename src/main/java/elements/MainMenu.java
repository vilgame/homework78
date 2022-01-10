package elements;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.*;

/** Элемент главного меню */
public class MainMenu {

    private WebDriver driver;

    // Поиск элементов без аннотации
    private WebElement newTicketBtn;

    // todo: остальные элементы меню

    public MainMenu(WebDriver driver) {
        this.driver = driver;
        newTicketBtn = driver.findElement(By.xpath ("//a[@href='/tickets/submit/']"));
    }

    @Step("Click button NewTicket")
    public void newTicket() { // todo: нажать кнопку создания нового тикета
        newTicketBtn.click();
        attachScreenshot();

    }

    public void logIn() {
        // todo: нажать кнопку авторизации
    }

    public void searchTicket(Ticket ticket) {
        setSearch(ticket.getTitle())
                .search();
    }

    /* Если после вызова void метода, может потребоваться вызов другого метода этого же класса,
        то можно вернуть сам класс и вызвать следующий метод через точку. */
    public MainMenu setSearch(String text) {
        // todo: ввести значение в поле поиска
        return this;
    }

    public void search() {
        // todo: нажать кнопку поиска
    }

    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
