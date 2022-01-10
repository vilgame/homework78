package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
    @Step("Create ticket")
    public void createTicket(Ticket ticket) {
        setInputQueue(ticket.getQueue()); // todo: заполнение остальных полей
        setInputProblemTitle(ticket.getTitle());
        setInputDescription(ticket.getDescription());
        setInputPriority(ticket.getPriority());
        setInputEmail(ticket.getEmail());
        createTicket();
        attachScreenshot();
    }

    public void setInputQueue(String inputQueue) { // todo: методы заполнения остальных полей
        Select selectQueue = new Select(this.inputQueue);
        selectQueue.selectByVisibleText(inputQueue);
    }

    /** Заполнение поля "Summary of the problem" */
    public void setInputProblemTitle(String inputProblemTitle) {
        this.inputProblemTitle.sendKeys(inputProblemTitle); // todo: заполнить поле
    }

    public void setInputDescription(String inputDescription) {
        this.inputDescription.sendKeys(inputDescription);
    }

    public void setInputPriority(int inputPriority) {
        Select selectPriority = new Select(this.inputPriority);
        selectPriority.getOptions().get(inputPriority).click();
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail.sendKeys(inputEmail);
    }

    /** Зажатие кнопки "Submit Ticket" */
    public void createTicket() {
        submitTicketBtn.click(); // todo: нажать кнопку создания задания
    }
    @Attachment
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
