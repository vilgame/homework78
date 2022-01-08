package pages;

import models.Ticket;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/** Страница создания тикета */
public class CreateTicketPage extends HelpdeskBasePage {

    // Способ объявления элементы страницы, через аннотацию

    @FindBy(xpath = "//select[@id='id_queue']") // todo: остальные элементы
    private WebElement inputQueue;

    @FindBy(xpath = "//input[@id='id_title']")
    private WebElement inputProblemTitle;

    @FindBy(xpath = "//textarea[@id='id_body']")
    private WebElement inputDescription;

    @FindBy(xpath = "//select[@id='id_priority']")
    private WebElement inputPriority;

    @FindBy(xpath = "//input[@id='id_submitter_email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitTicketBtn;

    public CreateTicketPage() {
        // Необходимо инициализировать элементы класса, лучше всего это делать в конструкторе
        PageFactory.initElements(driver, this);
    }

    /** Создание тикета */
    public void createTicket(Ticket ticket) {
        setInputQueue(ticket.getQueue()); // todo: заполнение остальных полей
        setInputProblemTitle(ticket.getTitle());
        setInputDescription(ticket.getDescription());
        setInputPriority(ticket.getPriority());
        setInputEmail(ticket.getEmail());
        createTicket();
    }

    public void setInputQueue(int value) { // todo: методы заполнения остальных полей
        Select selectQueue = new Select(inputQueue);
        selectQueue.getOptions().get(value).click();
    }

    /** Заполнение поля "Summary of the problem" */
    public void setInputProblemTitle(String value) {
        inputProblemTitle.sendKeys(value); // todo: заполнить поле
    }

    public void setInputDescription(String value) {
        inputDescription.sendKeys(value);
    }

    public void setInputPriority(int value) {
        Select selectPriority = new Select(inputPriority);
        selectPriority.getOptions().get(value).click();
    }

    public void setInputEmail(String value) {
        inputEmail.sendKeys(value);
    }

    /** Зажатие кнопки "Submit Ticket" */
    public void createTicket() {
        submitTicketBtn.click(); // todo: нажать кнопку создания задания
    }
}
