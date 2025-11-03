import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DigitalUnit {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @DisplayName("Fillup The User Form")
    @Test
    public void fillupUserForm() throws InterruptedException{
        driver.get("https://www.digitalunite.com/practice-webform-learners");
 //cookies tab er jonno
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
//field a data deyar jonno
        List<WebElement> txtfields = driver.findElements(By.className("form-control"));
        txtfields.get(0).sendKeys("Tashrif Rahman");
        txtfields.get(1).sendKeys("01744757831");
        txtfields.get(2).sendKeys("05/13/1997");
        txtfields.get(3).sendKeys("tashrifrahman151@gmail.com");
        txtfields.get(4).sendKeys("My name is Tashrif Rahman, and I am a passionate and motivated ");
// scroll korar jonno
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
//pic upload
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys("C:\\Users\\ASUS\\Desktop\\Reports\\tashu.jpg");
//checkbox click deya
        WebElement checkbox = driver.findElement(By.id("edit-age"));
        js.executeScript("arguments[0].click();", checkbox);
//click on submit button
        WebElement submitbtn = driver.findElement(By.id("edit-submit"));
        js.executeScript("arguments[0].click();", submitbtn);
        driver.switchTo().alert().accept();
//assert message
        String Actual = driver.findElement(By.id("block-pagetitle-2")).getText();
        String Expected = "Thank you for your submission!";
        Assertions.assertTrue(Actual.contains(Expected));
    }
     @AfterAll // test ses singer tab close korar jonno
    public void teardown() throws InterruptedException {
         Thread.sleep(4000); //4 sec delay korar jonno
        driver.quit();
    }
}
