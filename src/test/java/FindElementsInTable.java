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

public class FindElementsInTable {
    WebDriver driver;
    @BeforeMethod
    public void SetUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod(enabled = true)
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void findCssSelectorInTable() {
        // get numbers of row

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> elements =  wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("tr"))
        );
        System.out.println(elements.size());

//        for (int i = 0; i < elements.size(); i++) {
//            System.out.println(elements.get(i).getText());
//
//        }
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement DE = wait.until(
//                ExpectedConditions.presenceOfElementLocated(By.cssSelector("#customers tr:nth-child(2)"))
//        );
//        System.out.println(DE.getText());
//              List<WebElement> elements = wait.until(
//                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#customers tr"))
//        );
//        for (WebElement element : elements) {
//            System.out.println(element.getText().trim());
//        }
//        WebElement DE = driver.findElement(By.cssSelector("#customers tr:nth-child(2)"));
//        System.out.println(DE.getText());

//        WebElement tr2 = driver.findElement(By.cssSelector("#customers tr td:nth-child(2)"));
//        System.out.println(tr2.getTagName() + " | " + tr2.getAttribute("textContent"));

    }
    }

