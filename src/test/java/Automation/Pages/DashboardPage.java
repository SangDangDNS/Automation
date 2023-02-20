package Automation.Pages;

import Automation.Base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {
    private WebDriver driver;
    private BaseSetup baseSetup;

    private By dashboardText = By.xpath("//h6[normalize-space()='Dashboard']");
    private By adminText = By.xpath("//span[normalize-space()='Admin']");
    private By qualificationText = By.xpath("//span[normalize-space()='Qualifications']");
    private By skillText = By.xpath("//a[normalize-space()='Skills']");
    private By addSkill = By.xpath("//button[normalize-space()='Add']");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        baseSetup = new BaseSetup(driver);
    }

    public void dashboard(String elementTextValue, String urlValue){
        Assert.assertTrue(baseSetup.verifyElementtText(dashboardText,elementTextValue),"Không phải nội dung " +
                "trang Dashboard");
        Assert.assertTrue(baseSetup.verifyUrl(urlValue), "Không phải trang Dashboard");
        baseSetup.clickElement(adminText);
        baseSetup.clickElement(qualificationText);
        baseSetup.clickElement(skillText);
        baseSetup.clickElement(addSkill);
    }
}
