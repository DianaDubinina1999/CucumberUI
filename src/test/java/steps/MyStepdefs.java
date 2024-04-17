package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.ru. * ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
     private static WebDriver driver;


    @BeforeAll
    public static void MyStepdefs () {
        System.setProperty ("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver ();
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
        driver.manage ().window ().maximize ();
        driver.get ("http://localhost:8080");
        driver.findElement(By.id("navbarDropdown")).click();
        driver.findElement(By.linkText("Товары")).click();

    }

    @Когда("открываем сайт {string}")
    public void открываем_сайт (String string) {
    }

    @Тогда("нажимаем кнопку {string}")
    public void нажимаем_кнопку(String string) {
        //driver.findElement(By.id("navbarDropdown")).click();
    }

    @И("выбираем {string}")
    public void выбираем (String arg0) {
        //driver.findElement(By.linkText(arg0)).click();
    }

    @Дано("нажимаем {string}")
    public void нажимаем (String arg0) {
        driver.findElement(By.cssSelector(".btn-grou > .btn")).click();

    }

    @И("в появившемся поле нажимаем {string}")
    public void вПоявившемсяПолеНажимаем (String arg0) {
        driver.findElement(By.id("name")).click();
    }

    @И("вводим {string}")
    public void вводим (String arg0) {
        driver.findElement(By.id("name")).sendKeys(arg0);
    }


    @И("проверяем, что наименование {string} добавлено")
    public void проверяемЧтоНаименованиеДобавлено (String arg0) {if (!driver.findElement (By.id ("name")).isDisplayed ()) {
        throw new AssertionError ("Наименование" + " " + arg0 + " " + "не добавлено");

    }
    }

    @И("нажимаем на {string}")
    public void нажимаемНа (String arg0) {
        driver.findElement(By.id("save")).click();
        driver.navigate().refresh();
    }

    @И("проверяем, что {string} был добавлен на страницу")
    public void проверяемЧтоБылДобавленНаСтраницу (String arg0) {
        if (driver.findElements (By.xpath ("//*[contains(text(),'" + arg0 + "')]")).isEmpty ()) {
            throw new AssertionError ("Продукт" + " " + arg0 + " " + "не добавлен");
        }
    }

    @И("выбираем тип {string}")
    public void выбираемТип (String arg0) {
        WebElement dropdown = driver.findElement(By.id("type"));
        dropdown.findElement(By.xpath("//option[. = '" + arg0 + "']")).click();

    }

    @И("проверяем, что выбран тип {string}")
    public void проверяемЧтоВыбранТип (String arg0) {
        if (!driver.findElement (By.xpath ("//option[. = '" + arg0 + "']")).isSelected ()) {
            throw new AssertionError ("Тип" + " " + arg0 + " " + " не выбран");
        }
    }

    @И("выбираем чек-бокс {string}")
    public void выбираемЧекБокс (String arg0) {
        driver.findElement(By.id("exotic")).click();
    }


    @И("проверяем, что чек-бокс  для {string} выбран")
    public void проверяемЧтоЧекБоксДляВыбран (String arg0) {
        if (!driver.findElement (By.id ("exotic")).isSelected ()) {
            throw new AssertionError ("Чек-бокс для" + " " + arg0 + " " + "не выбран");
        }
    }

    @И ("удаляем все добавленные товары")
    public void удаляемВсеДобавленныеТовары () {

        driver.findElement(By.id("navbarDropdown")).click();
        driver.findElement(By.id("reset")).click();
        driver.navigate().refresh();

    }

    @И("проверяем, что продукт {string} был удален")
    public void проверяемЧтоПродуктБылУдален (String arg0) {
        driver.manage ().timeouts ().implicitlyWait (1, TimeUnit.SECONDS);
        if (!driver.findElements (By.xpath ("//*[contains(text(),'" + arg0 + "')]")).isEmpty ()) {
            throw new AssertionError ("Продукт" + " " + arg0 + " " + "не удален");
        }
        driver.manage ().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);
    }

    @И("закрываем браузер")
    public void закрываемБраузер () {
        driver.close();
    }
}