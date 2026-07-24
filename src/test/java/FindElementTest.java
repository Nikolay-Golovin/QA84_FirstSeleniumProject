import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class FindElementTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
                 ChromeDriverService service = new ChromeDriverService.Builder()
                 .usingDriverExecutable(new File("E:\\Tools\\chromedriver.exe"))
                  .build();
        driver = new ChromeDriver(service);

        driver.get("https://icarro-v1.netlify.app/search?page=0&size=10");
        //maximize browser to windows
        driver.manage().window().maximize();
        //wait to upload all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void findElementByTagName() {
        WebElement h1 = driver.findElement(By.tagName("h1"));
        System.out.println(h1.getText());
        WebElement h2 = driver.findElement(By.tagName("h2"));
        System.out.println(h2.getText());
        WebElement a = driver.findElement(By.tagName("a"));
        System.out.println(a.getAttribute("class"));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

    }
    @Test
    public void findElement() {
        WebElement city = driver.findElement(By.id("city"));
        System.out.println(city.getAttribute("id"));
    }
    @Test
    public  void findElementByClassName() {
        WebElement telephone = driver.findElement(By.className("telephone"));
        System.out.println(telephone.getText());
        WebElement description = driver.findElement(By.className("description"));
        System.out.println(description.getText());
    }
    @Test
    public void findElementByLinkText() {
        WebElement LinkText = driver.findElement(By.linkText("Let car work"));
        System.out.println(LinkText.getText());
    }
    @Test
    public void findElementByPartialLinkText() {
        WebElement LinkText = driver.findElement(By.partialLinkText(" car work"));
        System.out.println(LinkText.getText());

    }
    @Test
    public void findElementByCssSelector() {
        WebElement CssSelector = driver.findElement(By.cssSelector("h1"));
        System.out.println(CssSelector.getText());
        driver.findElement(By.cssSelector("#city"));//ID
        driver.findElement(By.cssSelector(".telephone"));//.
        WebElement element = driver.findElement(By.cssSelector("[href='/search']"));
        System.out.println(element.getText());
        driver.findElement(By.cssSelector("[for='city']"));
        //contains -> *
        driver.findElement(By.cssSelector("[href*='car']"));
        //start -> ^
        driver.findElement(By.cssSelector("[href^='/terms']"));

        List<WebElement> footerElements = driver.findElements(By.cssSelector("[class^='footer']"));
        System.out.println("Footer elements: " + footerElements.size());
        for (WebElement footer: footerElements){
            System.out.println("Footer element: " + footer.getTagName() +
                    " | class: " + footer.getAttribute("class"));
        }

        driver.findElement(By.cssSelector("a.navigation-link[href='/search']"));

        //one step down
        driver.findElement(By.cssSelector(".logo>img"));
        WebElement element1 = driver.findElement(By.cssSelector(".feedback-card:nth-child(5)"));
        System.out.println(element1.getText());



    }
  }

