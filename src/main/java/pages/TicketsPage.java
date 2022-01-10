package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница со списком тикетов */
public class TicketsPage extends HelpdeskBasePage {

    @FindBy(xpath = "//input[@id='search_query']") // todo: элементы страницы поиска тикетов
    WebElement searchField;

    @FindBy(xpath = "//div[@class='tickettitle']/a")
    WebElement selectTicket;

    public TicketsPage() {
        PageFactory.initElements(driver, this);
    }

    /** Ищем строку с тикетом и нажимаем на нее */
    @Step("Search and click ticket")
    public void openTicket(Ticket ticket) { // todo: найти и открыть тикет
        searchField.sendKeys(ticket.getTitle());
        searchField.sendKeys(Keys.ENTER);
        attachScreenshot();
        selectTicket.click();
        attachScreenshot();
    }

    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
