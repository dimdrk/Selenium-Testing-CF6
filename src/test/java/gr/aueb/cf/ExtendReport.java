package gr.aueb.cf;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExtendReport {


    // ExtendSparkReporter
    // Extend Reports

    ExtentReports extent;

    @BeforeTest
    public void configs() {

        String path = System.getProperty("user.dir") + "\\reports\\testIndex.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("CF Web Automation Test");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Dimitris Drakopoulos");
    }



    @Test
    public void initialDemos() throws InterruptedException {

        extent.createTest("Coding Factory Test");

        System.setProperty("webdriver.chrome.driver", "C:\\temp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.findElement(By.id("inputUsername")).sendKeys("Giannis");
        driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys("Aleksopoulos");

        Thread.sleep(2000);

        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.className("signInBtn")).click();

        String message = driver.findElement(By.className("error")).getText();

        System.out.println(message);

        Thread.sleep(2000);

        driver.close();

        extent.flush();
    }

}
