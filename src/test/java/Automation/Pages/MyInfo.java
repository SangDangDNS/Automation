package Automation.Pages;

import Automation.Base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class MyInfo {
    private WebDriver driver;
    private BaseSetup baseSetup;
    private Actions actions;

    private By skillDropdown = By.xpath("//div[@class='oxd-select-text-input']");
    private By yearExp = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//" +
            "input[@class='oxd-input oxd-input--active']");
    private By addBtn = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div" +
            "[1]/div[2]/div[4]/div[1]/div[1]/button[1]");
    private By addLabel = By.xpath("//label[normalize-space()='Skill']");
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");

    public MyInfo(WebDriver driver) {
        this.driver = driver;
        baseSetup = new BaseSetup(driver);
        actions = new Actions(driver);
    }

    public void myinfoskill(String urlValue, String yearValue,String Skilladd){
        Assert.assertTrue(baseSetup.verifyUrl(urlValue), "Không phải trang Add Skill In My Info");
        baseSetup.clickElement(addBtn);
        actions.moveToElement(driver.findElement(addLabel)).build().perform();
        baseSetup.clickElement(skillDropdown);
        driver.findElement(By.xpath("//span[normalize-space()='"+Skilladd+"']")).click();
        assertEquals(driver.findElement(skillDropdown).getText(), Skilladd);
        baseSetup.setText(yearExp,yearValue);
        baseSetup.clickElement(saveBtn);
    }
}
