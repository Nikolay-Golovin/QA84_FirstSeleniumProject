import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class FirstSeleniumProject {
// Before -> setUP
    WebDriver driver;
    @BeforeMethod
    public void SetUp() {


//            ChromeDriverService service = new ChromeDriverService.Builder()
//                    .usingDriverExecutable(new File("E:\\Tools\\chromedriver.exe"))
//                    .build();
//
//
//            driver = new ChromeDriver(service);


        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com"); //without history
//  driver.navigate().to("https://www.google.com");//with history
//        driver.navigate().back();
//        driver.navigate().refresh();
//        driver.navigate().forward();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
//test  "Register new User "
    @Test
    public void FirstTest(){
        WebElement element1 = driver.findElement(By.tagName("title"));
        System.out.println(element1.getAttribute("text"));
        List<WebElement> elements2 = driver.findElements(By.tagName("link"));
        System.out.println(elements2.size());
        WebElement element3 = driver.findElement(By.id("dialog-notifications-success"));
        System.out.println(element3.getAttribute("id"));
        WebElement element4 = driver.findElement(By.linkText("Wishlist"));
        System.out.println(element4.getText());
        WebElement element5 = driver.findElement(By.tagName("h3"));
        System.out.println(element5.getText());
        WebElement element6 = driver.findElement(By.tagName("h2"));
        System.out.println(element6.getText());
        WebElement element7 = driver.findElement(By.className("header-logo"));
        System.out.println(element7.getAttribute("class"));
        WebElement element8 = driver.findElement(By.className("ico-register"));
        System.out.println(element8.getAttribute("href"));
        WebElement element9 = driver.findElement(By.className("search-box"));
        System.out.println(element9.getAttribute("class"));
        WebElement element10 = driver.findElement(By.className("master-wrapper-content"));
        System.out.println(element10.getAttribute("class"));
        String title = driver.getTitle();
        System.out.println(title);


    }
// after-> tearDawn
   @AfterMethod(enabled = true)
    public void TearDown() {
       driver.quit(); //closes all tabs and browser
      // driver.close(); // closes only current tub in a browser
   }
}
