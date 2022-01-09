package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница авторизации */
public class LoginPage extends HelpdeskBasePage {


    @FindBy(xpath = "//input[@id='username']") // todo: элементы страницы
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[contains(@class, 'btn-lg')]")
    WebElement loginBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Авторизация пользователя
     *
     * @param user     логин пользователя
     * @param password пароль пользователя
     */
    public void login(String user, String password) { // todo: заполнить поля и нажать кнопку авторизации
        setUsername(user);
        setPassword(password);
        login();
    }

    public void setUsername(String username) { // todo: методы работы с элементами
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void login() {
        loginBtn.click();
    }
}
