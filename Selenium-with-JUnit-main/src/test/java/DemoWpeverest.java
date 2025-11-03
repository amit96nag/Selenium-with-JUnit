import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoWpeverest {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    @Test
    public void RegistrationForm() {

        driver.get(" https://demo.wpeverest.com/user-registration/guest-registration-form/");
//        WebElement checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
//
//        if (!checkbox.isSelected()) {
//            checkbox.click();
//        }

        List<WebElement> textfields = driver.findElements(By.className("input-text"));// class name diye
        textfields.get(0).sendKeys("Tashrif");
        textfields.get(1).sendKeys("tashrifrhman1+101@gmail.com");
        textfields.get(3).sendKeys("Rahman");
        textfields.get(5).sendKeys("Bangladesh");

        JavascriptExecutor js = (JavascriptExecutor) driver;  // eta scroll down er jonno deya hoice
        js.executeScript("window.scrollBy(0,1000)");

        driver.findElement(By.cssSelector("input#phone_1665627880")).sendKeys("(123) 456-7890"); //number pass korci cssselector use kore

        Select option = new Select(driver.findElement(By.id("country_1665629257")));//dropdown kore bd selected korlam
        option.selectByVisibleText("Bangladesh");

        driver.findElement(By.id("user_pass")).sendKeys("YourPassword123!");

        WebElement dobField = driver.findElement(By.cssSelector("input[data-id='date_box_1665628538']"));
//        js.executeScript("arguments[0].removeAttribute('readonly')", dobField);  // readonly value thakle seta remove korci .ei khan a kono readonly value cilo na
//        dobField.sendKeys("1995-05-20");
        js.executeScript("arguments[0].value='1997-05-13';", dobField);//tai soja suji value bosai deya hoice

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1500)");

        driver.findElement(By.id("radio_1665627729_Male")).click();// radio btn
        driver.findElement(By.id("privacy_policy_1665633140")).click();//checkbox


        WebElement submitBtn = driver.findElement(By.cssSelector("button.ur-submit-button"));//submit kora hoice
        js.executeScript("arguments[0].click();", submitBtn);
        js.executeScript("window.scrollBy(0,1500)");

        String successfulMessageActual = driver.findElement(By.id("ur-submit-message-node")).getText();//assertion kora hoice
        String messageExpected = "User successfully registered.";
        System.out.println(successfulMessageActual);
        Assertions.assertTrue(successfulMessageActual.contains(messageExpected));


    }

     @AfterAll // test ses single tab close korar jonno
    public void teardown() throws InterruptedException {
        Thread.sleep(4000); //4 sec delay korar jonno
        driver.quit();
    }
}
