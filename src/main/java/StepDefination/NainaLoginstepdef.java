package StepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;
import static com.sun.javafx.css.SizeUnits.PT;

/**
 * Created by akshay.pokley on 10/11/2018.
 */
public class NainaLoginstepdef {
public int N=1;
    public int N1=1;
    WebDriver driver;

    @Given("^User is already on  login page$")
    public void user_is_already_on_login_page() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.1.2:8058/BPAMSClient/Default.aspx");

    }

    @When("^Title of login page NAINA$")
    public void title_of_login_page_NAINA() {

        String title = driver.getTitle();
        System.out.println(title);
        try {
            Assert.assertEquals("NAINA BPAMS", title);
        } catch (Throwable w) {
            System.out.println(w.getMessage());
        }

    }

    @Then("^User Enter login name And User enter password$")
    public void user_Enter_login_name_And_User_enter_password() throws InterruptedException {
        WebElement N1 = driver.findElement(By.xpath(".//*[@id='txtUN']"));
        Thread.sleep(2000);
        N1.clear();
        Thread.sleep(2000);
        N1.sendKeys("ARP3");

        WebElement N2 = driver.findElement(By.xpath(".//*[@id='txtPW']"));
        Thread.sleep(2000);
        N2.clear();
        Thread.sleep(2000);
        N2.sendKeys("Autodcr@123");
    }

    @Then("^User click on login page$")
    public void user_click_on_login_page() {

        driver.findElement(By.xpath(".//*[@id='btnImgLog']/img")).click();
    }

    @Then("^User is on Home page$")
    public void user_is_on_Home_page() {
        String title = driver.findElement(By.xpath("./*//*[@id='lblULBName']")).getText();
        System.out.println(title);
        Assert.assertEquals("NAINA Integrated Approval Management System", title);

    }


    /*Reguler expresion
    *1. \"([^\"]*)\"
    *2. \*(.*)\*
    */
    @Then("^User Enters \"([^\"]*)\" And User enters \"([^\"]*)\"$")
    public void user_Enters_And_User_enters(String UseNM, String Pass) throws Throwable {

        WebElement N1 = driver.findElement(By.xpath(".//*[@id='txtUN']"));
        Thread.sleep(2000);
        N1.clear();
        Thread.sleep(2000);
        N1.sendKeys(UseNM);

        WebElement N2 = driver.findElement(By.xpath(".//*[@id='txtPW']"));
        Thread.sleep(2000);
        N2.clear();
        Thread.sleep(2000);
        N2.sendKeys(Pass);

    }


    @Then("^User Apply for \"([^\"]*)\"$")
    public void user_Apply_for_Building_Permission(String PErmisTypo) throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame("ifrmListing");

        driver.findElement(By.xpath(".//*[@id='btnApplyFor']")).click();
        List<WebElement> permission_type= driver.findElements(By.xpath(".//*[@id='UlSend']/li/a"));

        for(WebElement PT:permission_type)
        {
          String PTS=PT.getText();
        if(PTS.equals(PErmisTypo))
        {
            PT.click();
            break;
        }
        }

        Thread.sleep(2000);
        driver.switchTo().frame("IframeAddProposal");

    }

    @Then("^User Fill \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void user_Fill_project_info_and_applicant_Info(String caseType,String Permissiontype,String Location1,String City1,String Tahsil1,
                                                          String Village2,String SurveyNo,String Ownercat2,String OName,String Emai,
                                                          String Mob,String pan,String Addre,String cit,String stat,String Pin


                                                          ) throws InterruptedException {


        WebElement Case_Type=driver.findElement(By.xpath(".//*[@id='cboCaseType']"));
        Select combo1=new Select(Case_Type);
        combo1.selectByVisibleText(caseType);
Thread.sleep(200);
        WebElement PermisssionType=driver.findElement(By.xpath(".//*[@id='cboOffice']"));
        Select combo2=new Select(PermisssionType);
        combo2.selectByVisibleText(Permissiontype);
        Thread.sleep(200);
        WebElement Location=driver.findElement(By.xpath(".//*[@id='ddlLocation']"));
        Select combo3=new Select(Location);
        combo3.selectByVisibleText(Location1);
        Thread.sleep(200);
        WebElement City=driver.findElement(By.xpath(".//*[@id='cboLocation']"));
        Select combo4=new Select(City);
        combo4.selectByVisibleText(City1);

       try{

            List<WebElement> Tahsil= driver.findElements(By.xpath("./*//*[@id='CheckBoxListTahsil']/tbody/tr/td/label"));

            for(WebElement PT:Tahsil)
            { Thread.sleep(4000);
                String PTS=PT.getText();
                Thread.sleep(4000);
                if(PTS.equals(Tahsil1))
                {

                 driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
                    WebElement Tahsilcheck= driver.findElement(By.xpath("./*//*[@id='CheckBoxListTahsil']/tbody/tr["+N+"]/td/input"));
                    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

                    Tahsilcheck.click();
                    ++N;
break;
                }else {
                    ++N;}
            }
        }catch (Throwable s)
        {
            System.out.println(s.getMessage());
        }


        try{
            Thread.sleep(4000);
            List<WebElement> Village= driver.findElements(By.xpath(".//*[@id='CheckBoxListVillage']/tbody/tr[1]/td/label"));
            Thread.sleep(4000);
            for(WebElement PT:Village)
            {Thread.sleep(4000);
                String PTS=PT.getText();
                if(PTS.equals(Village2))
                {driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
                    WebElement Villagecheck= driver.findElement(By.xpath("./*//*[@id='CheckBoxListVillage']/tbody/tr["+N1+"]/td/input"));
                    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
                    Villagecheck.click();
                    ++N1;
break;
                }else {
                    ++N1;}
            }
        }catch (Throwable s)
        {
            System.out.println(s.getMessage());
        }


Thread.sleep(200);
        driver.findElement(By.xpath(".//*[@id='txSurveyNo']")).sendKeys(SurveyNo);

        driver.findElement(By.xpath(".//*[@id='liapplication']/a")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='btnAdd']")).click();
        Thread.sleep(2000);




        WebElement occ= driver.findElement(By.xpath(".//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[4]"));
        Actions actions6 = new Actions(driver);
        actions6.moveToElement(occ);
        actions6.doubleClick();
        actions6.build().perform();
        Thread.sleep(2000);




List<WebElement> ownerCat=driver.findElements(By.xpath(".//*[@class='GLMenuBody GLEnumMenuBody']/div/div/div"));
     for(WebElement oc:ownerCat)
     {
         String Owner=oc.getText();

         if(Owner.equals(Ownercat2))
         {
             oc.click();
             break;
         }
     }
        WebElement name= driver.findElement(By.xpath(".//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[5]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        actions.doubleClick();
        actions.sendKeys(OName);
        actions.build().perform();
        Thread.sleep(1000);

        WebElement Email= driver.findElement(By.xpath(".//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[6]"));

        Actions actions1 = new Actions(driver);
        actions1.moveToElement(Email);
        actions1.doubleClick();
        actions1.sendKeys(Emai);
        actions1.build().perform();
        Thread.sleep(1000);

        WebElement Mobile =    driver.findElement(By.xpath(".//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[7]"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(Mobile);
        actions2.doubleClick();
        actions2.sendKeys(Mob);
        actions2.build().perform();
        Thread.sleep(1000);

        WebElement PAN = driver.findElement(By.xpath(".//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[8]"));
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(PAN);
        actions3.doubleClick();
        actions3.sendKeys(PAN);
        actions3.build().perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath(".//*[@id='txtFlat']")).sendKeys(Addre);
        driver.findElement(By.xpath(".//*[@id='txtCity']")).sendKeys(City1);
        driver.findElement(By.xpath(".//*[@id='txtVillage']")).sendKeys(stat);
        driver.findElement(By.xpath(".//*[@id='txtOwnerPin']")).sendKeys(Pin);


    }

    @Then("^User click on save Button$")
    public void user_click_on_save_Button() {
    driver.findElement(By.xpath(".//*[@id='btnSave']")).click();
    }

    @Then("^User Accept Alert$")
    public void user_Accept_Alert() throws InterruptedException {
        Thread.sleep(2000);
driver.findElement(By.xpath(".//*//div/div[2]/a/span/span")).click();
    }

    @Then("^Close Browser$")
    public void close_Browser() throws Throwable {
        Thread.sleep(5000);
        driver.close();
    }
}