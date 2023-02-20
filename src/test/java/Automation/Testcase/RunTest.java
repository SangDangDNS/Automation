package Automation.Testcase;

import Automation.Base.BaseSetup;
import Automation.Base.SetupBrowser;
import Automation.Base.SetupExcel;
import Automation.Pages.AddSkillPage;
import Automation.Pages.DashboardPage;
import Automation.Pages.MyInfo;
import Automation.Pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunTest extends SetupBrowser {

    private WebDriver driver;
    private SignInPage sgi;
    private SetupExcel excel;
    private DashboardPage db;
    private AddSkillPage addskill;
    private MyInfo mif;

    @BeforeClass
    public void setup() throws Exception {
        driver = getDriver();
        excel = new SetupExcel();
        excel.setExcelFile("src/test/resources/Book1.xlsx","Sheet1");
    }

    @Test(priority = 0)
    public void signinpage() throws Exception {
        sgi = new SignInPage(driver);
        sgi.signIn(excel.getCellData("Value",1), excel.getCellData("Value",2),excel.getCellData("Value",3),
                excel.getCellData("Value",4));
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void dboard() throws Exception {
        db = new DashboardPage(driver);
        db.dashboard(excel.getCellData("Value",5), excel.getCellData("Value",6));
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void addskill() throws Exception {
        addskill = new AddSkillPage(driver);
        addskill.addskill(excel.getCellData("Value",7), excel.getCellData("Value",8),excel.getCellData("Value",10));
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void addskillmyinfo() throws Exception {
        mif = new MyInfo(driver);
        mif.myinfoskill(excel.getCellData("Value",9), excel.getCellData("Value",11),excel.getCellData("Value",10));
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void resultExcel() throws Exception {
        for(int i = 1; i <12; i++){
            excel.setCellData("Done",i,2);
        }
        Thread.sleep(2000);
    }

    @AfterClass
    public void close() {
        driver.close();
    }


}
