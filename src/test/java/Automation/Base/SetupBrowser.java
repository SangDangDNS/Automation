package Automation.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class SetupBrowser {
    static String driverPath = "resources\\drivers\\";
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    //Hàm tùy chọn Browser
    public void setDriver(String browserType, String webUrl){
        switch (browserType) {
            case "chrome":
                driver = InitChromeDriver(webUrl);
                break;
            case "firefox":
                driver = InitFirefoxDriver(webUrl);
            default:
                System.out.println("Browser: " + browserType + "is invalid, Launching Chrome as browser of choice...");
                driver = InitChromeDriver(webUrl);
        }
    }

    //Khởi tạo cấu hình của các Browser
    private WebDriver InitChromeDriver(String webUrl){

        System.out.println("Launching Chrome Browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;

    }

    private WebDriver InitFirefoxDriver(String webUrl){

        System.out.println("Launching Firefox Browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(webUrl);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;

    }

    //Chạy hàm initBaseSetup trước khi class này được gọi
    @Parameters({"browserType","webUrl"})
    @BeforeClass
    public void initBaseSetup(String browserType,String webUrl){
        try {
            //Khởi tạo driver và Browser
            setDriver(browserType, webUrl);
        }
        catch (Exception e){
            System.out.println("Error..." + e.getStackTrace());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
