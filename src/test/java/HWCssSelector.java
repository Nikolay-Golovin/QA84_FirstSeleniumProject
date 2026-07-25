import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HWCssSelector {
    WebDriver driver;
  @BeforeMethod
  public void setup() {
    driver = new ChromeDriver();
      driver.get("https://demowebshop.tricentis.com");
      driver.manage().window().maximize();

//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  }
  @AfterMethod(enabled = true)
    public void tearDown() {
      if (driver != null) {
          driver.quit();
      }
    }
    @Test()
    public void HWCssSelectorTest() {
        List<WebElement> elements1 = driver.findElements(By.cssSelector(".mob-top-menu"));// findClass
        System.out.println(elements1.size());
//        WebElement element2 = driver.findElement(By.cssSelector("li:nth-child(1)"));// Tag(li)+child1
//        System.out.println(element2.getText());
        WebElement element3 = driver.findElement(By.cssSelector("#dialog-notifications-error"));// findID +#
        System.out.println(element3.getAttribute("title"));
        driver.findElement(By.cssSelector("div.header-links-wrapper"));//Tag+class
        driver.findElement(By.cssSelector("div#flyout-cart.flyout-cart"));//Tag+Id+class
        WebElement element4 = driver.findElement(By.cssSelector("img[alt='Tricentis Demo Web Shop']"));//Tag+Attribut
        System.out.println(element4.getAttribute("alt"));
        driver.findElement(By.cssSelector("form[action='/search'][onsubmit='return check_small_search_form()'][novalidate='novalidate']"));//Tag+Attribut+Attribut+
        driver.findElement(By.cssSelector("input[value='Search']"));//Tag+Attribut

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element2 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("li:nth-child(1)")));// Tag(li)+child1
        System.out.println(element2.getText());

        WebElement element5 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='Search']")));
        System.out.println(element5.getAttribute("value"));










////       1. Оно ждёт только появления в HTML-коде (DOM), но НЕ видимости
////        Это самая частая причина:
////       implicitlyWait даёт команду браузеру: «Жди 10 секунд, пока элемент просто не появится в DOM-дереве».
////        Но если элемент уже создался в HTML, но имеет нулевой размер, прозрачен (opacity: 0) или заблокирован загрузкой (disabled) — implicitlyWait считает свою задачу выполненной и отключается!
////       Результат: вы пытаетесь кликнуть или взять .getText(), а элемент ещё визуально не готов → падение теста или пустой результат.









    }
}
