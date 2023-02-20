package Automation.Pages;

import Automation.Base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class AddSkillPage {
    private WebDriver driver;
    private BaseSetup baseSetup;

    private By AddSkillText = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
    private By nameInput = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//" +
            "div//input[@class='oxd-input oxd-input--active']");
    private By saveBtn = By.xpath("//button[@type='submit']");
    private By myInfo = By.xpath("//span[normalize-space()='My Info']");
    private By myInfoQualification = By.xpath("//a[normalize-space()='Qualifications']");

    public AddSkillPage(WebDriver driver){
        this.driver = driver;
        baseSetup = new BaseSetup(driver);
    }


    public void addskill(String addSkillTextValue, String urlValue, String nameValue){
        Assert.assertTrue(baseSetup.verifyElementtText(AddSkillText, addSkillTextValue),"Không phải nội dung " +
                "trang Add Skill");
        Assert.assertTrue(baseSetup.verifyUrl(urlValue), "Không phải trang Add Skill");
        baseSetup.setText(nameInput, nameValue);
        baseSetup.clickElement(saveBtn);
        baseSetup.clickElement(myInfo);
        baseSetup.clickElement(myInfoQualification);

    }
}
