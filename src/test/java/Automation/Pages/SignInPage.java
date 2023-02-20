package Automation.Pages;

import Automation.Base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage {
    private WebDriver driver;
    private BaseSetup baseSetup;

    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By loginBtn = By.xpath("//button[normalize-space()='Login']");
    private By loginText = By.xpath("//h5[normalize-space()='Login']");
    public SignInPage(WebDriver driver){
        this.driver = driver;
        baseSetup = new BaseSetup(driver);
    }

    public void signIn(String usernameValue, String passwordValue, String loginTextValue, String urlValue ){
        Assert.assertTrue(baseSetup.verifyElementtText(loginText, loginTextValue),"Không phải nội dung " +
                "trang Sign In");
        Assert.assertTrue(baseSetup.verifyUrl(urlValue), "Không phải trang Sign In");
        baseSetup.setText(username,usernameValue);
        baseSetup.setText(password, passwordValue);
        baseSetup.clickElement(loginBtn);
    }




}
