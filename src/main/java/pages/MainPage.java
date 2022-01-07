package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Главная страница */
public class MainPage extends AbstractPage {

    public MainPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "a[href^='/tickets/submit/']")
    private WebElement newTicketBtn;
    @FindBy(xpath = "//*[@id=\"userDropdown\"]")
    private WebElement LogInBtn;


    public void newTicket() {
        newTicketBtn.click();

    }

    public void logIn() {
        LogInBtn.click();
    }
}
