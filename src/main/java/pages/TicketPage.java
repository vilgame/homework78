package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница отдельного тикета */
public class TicketPage extends HelpdeskBasePage {

    @FindBy(xpath = "//select[@id='queue']") // todo: остальные поля тикета
    WebElement queue;

    @FindBy(xpath = "//input[@id='id_title']")
    WebElement ticketTitle;

    @FindBy(xpath = "//textarea[@id='id_body']]")
    WebElement description;

    @FindBy(xpath = "//select[@id='id_priority']]")
    WebElement priority;

    @FindBy(xpath = "//input[@id='id_submitter_email']")
    WebElement email;

    public TicketPage() {
        PageFactory.initElements(driver, this);
    }

    /** Получить имя тикета */
    public String getTicketTitle() {
        return ticketTitle.getText();
    }

    /** Получить адрес почты */
    public String getEmail() {
        // Получаем значение адреса почты
        return getValue(email);
    }

    // todo: остальные методы получения значений полей

    /**
     * Получить значение элемента таблицы
     *
     * @param columnElem элемент ячейки для которой нужно вернуть значение
     * @return текстовое значение ячейки рядом
     */
    private String getValue(WebElement columnElem) {
        return columnElem
                // Находи следующий элемент находящийся в том же теге
                .findElement(By.xpath("./following-sibling::td[1]"))
                // Получаем текст
                .getText()
                // Обрезаем лишние пробелы
                .trim();
    }

}
