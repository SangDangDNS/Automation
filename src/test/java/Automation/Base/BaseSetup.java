package Automation.Base;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;

public class BaseSetup {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int timeOut = 20;

    //Hàm xây dựng class BaseSetup
    public BaseSetup(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Hàm xử lý hành động Sendkeys()
    public void setText (By element, String value){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }

    //Hàm xử lý hành động Click()
    public void clickElement (By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    //Hàm Scroll

    public void scrollElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Hàm xử lý load Page
    public void waitForPageLoaded(){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver){
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(expectation);
        } catch (Throwable error){
            Assert.fail("Timeout waiting for Page Load Request");
        }
    }

    //Hàm xác nhận URL
    public boolean verifyUrl(String url){
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);

        return driver.getCurrentUrl().contains(url);
    }

    //Hàm xác nhận text của Element
    public boolean verifyElementtText(By element,String value){
        return driver.findElement(element).getText().equals(value);
    }

    //Hàm xác nhận Element tồn tại
    public boolean verifyElementtExist(By element){
        List<WebElement> listElement = driver.findElements(element);
        int total = listElement.size();
        if (total > 0) {
            return true;
        }
        return false;
    }
}
