import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DhakaStockExchange {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void Table() {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        try {
            // ফাইল লেখার জন্য FileWriter তৈরি করছি
            FileWriter writer = new FileWriter("dse_table_data.txt");

            WebElement table = driver.findElement(By.cssSelector(".table-responsive")); //table dhorci
            List<WebElement> allRows = driver.findElements(By.cssSelector(".table-bordered tbody tr")); //then row dhorci

            int i = 0;
            for (WebElement row : allRows) { //row er jonno for loop diche e
                List<WebElement> cells = row.findElements(By.tagName("td"));
                StringBuilder rowData = new StringBuilder();
                for (WebElement cell : cells) { //er vitor a abar for loop diche mane age akta row te dhukbe then sob cell neya ses hoile abar ar akta ro te jabe
                    rowData.append(cell.getText()).append("\t"); // tab দিয়ে cell আলাদা
                }
                writer.write(rowData.toString().trim() + "\n"); // পুরো row এক লাইনে লেখা হবে
            }

            writer.close(); // ফাইল বন্ধ করছি
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    @AfterAll // test ses singer tab close korar jonno
    public void teardown() throws InterruptedException {
        Thread.sleep(4000); //4 sec delay korar jonno
        driver.quit();
    }
    }

