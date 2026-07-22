import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

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
        driver.get("https://www.google.com"); //without history
//  driver.navigate().to("https://www.google.com");//with history
//        driver.navigate().back();
//        driver.navigate().refresh();
//        driver.navigate().forward();


    }
//test  "Register new User "
    @Test
    public void FirstTest(){
        System.out.println("Google Search Page is opened");

    }
// after-> tearDawn
   @AfterMethod(enabled = true)
    public void TearDown() {
       driver.quit(); //closes all tabs and browser
      // driver.close(); // closes only current tub in a browser
   }
}
