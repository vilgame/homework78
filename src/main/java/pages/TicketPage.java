package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница отдельного тикета */
public class TicketPage extends HelpdeskBasePage {

    @FindBy(xpath = "//a[@id='userDropdown']")
    WebElement logInBtn;

    @FindBy(xpath = "//text()[contains(.,'Queue')]") // todo: остальные поля тикета
    WebElement queue;

    @FindBy(xpath = "//th/h3")
    WebElement ticketTitle;

    @FindBy(xpath = "//td[@id='ticket-description']/p")
    WebElement description;

    @FindBy(xpath = "//td[@class='table-warning']")
    WebElement priority;

    @FindBy(xpath = "//th[text()='Submitter E-Mail']")
    WebElement email;

    public TicketPage() {
        PageFactory.initElements(driver, this);
    }

    public void logIn() {
        logInBtn.click();
    }

//    public String getQueue() { // todo: остальные методы получения значений полей
//        return queue.getText();
//    }

    /** Получить имя тикета */
    public String getTicketTitle() {
        return ticketTitle.getText();
    }

    public String getDescription() {
        return description.getText();
    }

//    public int getPriority() {
//        return Integer.parseInt(priority.getText()+1);
//    }

    /** Получить адрес почты */
    public String getEmail() {
        // Получаем значение адреса почты
        return getValue(email);
    }

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
