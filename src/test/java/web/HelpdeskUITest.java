package web;

import elements.MainMenu;
import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.CreateTicketPage;
import pages.TicketPage;

import java.io.IOException;
import java.time.Duration;

public class HelpdeskUITest {

    private WebDriver driver;
    private Ticket ticket;
    private MainMenu mainMenu;
    private TicketPage ticketPage;

    @BeforeClass
    public void setup() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() {
        // Заполняем объект класс Ticket необходимыми тестовыми данными
        ticket = buildNewTicket();
        driver.get(System.getProperty("site.url")); // todo: открыть главную страницу
        mainMenu = new MainMenu(driver); // todo: создать объект главной страницы и выполнить шаги по созданию тикета
        mainMenu.newTicket();
        CreateTicketPage createTicketPage = new CreateTicketPage();
        createTicketPage.createTicket(ticket);
        // todo: перейти к странице авторизации и выполнить вход
        // todo: найти созданный тикет и проверить поля

        // Закрываем текущее окно браузера
//        driver.close();
    }

    /**
     * Создаём и заполняем объект тикета
     *
     * @return заполненный объект тикета
     */
    protected Ticket buildNewTicket() {
        Ticket ticket = new Ticket();
        ticket.setQueue(2); // todo: заполнить остальные необходимые поля тикета
        ticket.setTitle("Chief, we're done for!");
        ticket.setDescription("The cast is going to be removed, the customer's leaving!");
        ticket.setPriority(0);
        ticket.setEmail("go@go.go");
        return ticket;
    }

//    @AfterTest
//    public void close() {
//        // Закрываем все окна браузера и освобождаем ресурсы
//        driver.quit();
//    }

}
