package gr.aueb.cf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();



        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");      // opens the url

        driver.manage().window().maximize();                                            // maximises the browser

        driver.findElement(By.name("search")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("search")).sendKeys("Macbook");    // Type 'Macbook'
        Thread.sleep(2000);
        driver.findElement(By.className("input-group-btn")).click();

        driver.findElement(By.linkText("MacBook")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("quantity")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("quantity")).clear();
        Thread.sleep(2000);
        driver.findElement(By.name("quantity")).sendKeys("2");
        Thread.sleep(2000);
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(4000);

        driver.close();

    }
}
