package StepDefination;
import cucumber.api.DataTable;
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


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by akshay.pokley on 10/15/2018.
 */
public class CPDTMAP {

    public int N=1;
    public int N1=1;
    WebDriver driver;


    @Given("^User is already on login Window")
    public void user_is_already_on_login_Screen() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://192.168.1.2:8058/BPAMSClient/Default.aspx");
    }

    @When("^Title of login screen is NAINA$")
    public void title_of_login_page_is_NAINA() throws Throwable {
        String title = driver.getTitle();
        System.out.println(title);
        try {
            Assert.assertEquals("NAINA BPAMS", title);
        } catch (Throwable w) {
            System.out.println(w.getMessage());
        }

    }

    @Then("^User Enter username And User enter password$")
    public void user_Enters_username_And_User_enters_password(DataTable arg1) throws Throwable {

        /*When we try to get than value using DDF in data table there is have two option
        * raw :-using raw we get the value with giving the hardcoded input /get set of value are not possibale.
        * map :- here we get the input without hardcode value .get set of value are possibale
        */

        for( Map<String,String>loginvaalue:arg1.asMaps(String.class,String.class))
        {
            WebElement N1 = driver.findElement(By.xpath(".//*[@id='txtUN']"));
            Thread.sleep(2000);
            N1.clear();
            Thread.sleep(2000);
            N1.sendKeys(loginvaalue.get("Username"));

            WebElement N2 = driver.findElement(By.xpath(".//*[@id='txtPW']"));
            Thread.sleep(2000);
            N2.clear();
            Thread.sleep(2000);
            N2.sendKeys(loginvaalue.get("Password"));

        }

    }

    @Then("^User click on Signup Button$")
    public void user_click_on_login_Button() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='btnImgLog']/img")).click();

    }

    @Then("^User should have on home Screen$")
    public void user_should_have_on_home_page() throws Throwable {
        String title = driver.findElement(By.xpath("./*//*[@id='lblULBName']")).getText();
        System.out.println(title);
        Assert.assertEquals("NAINA Integrated Approval Management System", title);


    }

    @Then("^User Click on Type of work$")
    public void user_Apply_for_Type_of_work(DataTable arg1) throws Throwable {
       for (Map<String,String>worktype :arg1.asMaps(String.class,String.class)){

           Thread.sleep(2000);
           driver.switchTo().frame("ifrmListing");

           driver.findElement(By.xpath(".//*[@id='btnApplyFor']")).click();
           List<WebElement> permission_type= driver.findElements(By.xpath(".//*[@id='UlSend']/li/a"));

           for(WebElement PT:permission_type)
           {
               String PTS=PT.getText();
               if(PTS.equals(worktype.get("Type_of_Work")))
               {
                   PT.click();
                   break;
               }
           }

           Thread.sleep(2000);
           driver.switchTo().frame("IframeAddProposal");
       }



    }

    @Then("^User Fill Genral and Applicant details$")
    public void user_Fill_Genral_and_Applicant_details(DataTable arg1) throws Throwable {

        for (Map<String,String>GPvalue :arg1.asMaps(String.class,String.class))
        {
            WebElement Case_Type=driver.findElement(By.xpath(".//*[@id='cboCaseType']"));
            Select combo1=new Select(Case_Type);
            combo1.selectByVisibleText(GPvalue.get("Case_Type"));
            Thread.sleep(2000);
            WebElement PermisssionType=driver.findElement(By.xpath(".//*[@id='cboOffice']"));
            Select combo2=new Select(PermisssionType);
            combo2.selectByVisibleText(GPvalue.get("PermisssionType2"));
            Thread.sleep(2000);
            WebElement Location=driver.findElement(By.xpath(".//*[@id='ddlLocation']"));
            Select combo3=new Select(Location);
            combo3.selectByVisibleText(GPvalue.get("Location"));
            Thread.sleep(2000);
            WebElement City=driver.findElement(By.xpath(".//*[@id='cboLocation']"));
            Select combo4=new Select(City);
            combo4.selectByVisibleText(GPvalue.get("City"));

            try{
                driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
                List<WebElement> Tahsil= driver.findElements(By.xpath("./*//*[@id='CheckBoxListTahsil']/tbody/tr/td/label"));

                for(WebElement PT:Tahsil)
                {    Thread.sleep(5000);
                    String PTS=PT.getText();
                    Thread.sleep(5000);
                    if(PTS.equals(GPvalue.get("Tahsil")))
                    {
                        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                        WebElement Tahsilcheck= driver.findElement(By.xpath("./*//*[@id='CheckBoxListTahsil']/tbody/tr["+N+"]/td/input"));
                        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
                Thread.sleep(5000);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                List<WebElement> Village= driver.findElements(By.xpath(".//*[@id='CheckBoxListVillage']/tbody/tr[1]/td/label"));
                Thread.sleep(5000);
                for(WebElement PT:Village)
                {   Thread.sleep(5000);
                    String PTS=PT.getText();
                    if(PTS.equals(GPvalue.get("Village")))
                    {
                        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                        WebElement Villagecheck= driver.findElement(By.xpath("./*//*[@id='CheckBoxListVillage']/tbody/tr["+N1+"]/td/input"));
                        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
            driver.findElement(By.xpath(".//*[@id='txSurveyNo']")).sendKeys(GPvalue.get("SurveyNo"));

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

                if(Owner.equals(GPvalue.get("OwnerCategory")))
                {
                    oc.click();
                    break;
                }
            }
            WebElement name= driver.findElement(By.xpath(".//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[5]"));
            Actions actions = new Actions(driver);
            actions.moveToElement(name);
            actions.doubleClick();
            actions.sendKeys(GPvalue.get("OwnerName"));
            actions.build().perform();
            Thread.sleep(1000);

            WebElement Email= driver.findElement(By.xpath(".//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[6]"));

            Actions actions1 = new Actions(driver);
            actions1.moveToElement(Email);
            actions1.doubleClick();
            actions1.sendKeys(GPvalue.get("Email"));
            actions1.build().perform();
            Thread.sleep(1000);

            WebElement Mobile =    driver.findElement(By.xpath(".//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[7]"));
            Actions actions2 = new Actions(driver);
            actions2.moveToElement(Mobile);
            actions2.doubleClick();
            actions2.sendKeys(GPvalue.get("Mobile"));
            actions2.build().perform();
            Thread.sleep(1000);

            WebElement PAN = driver.findElement(By.xpath(".//*[@id='tgOwner']/tbody/tr[2]/td[2]/div/div[1]/table/tbody/tr[2]/td[8]"));
            Actions actions3 = new Actions(driver);
            actions3.moveToElement(PAN);
            actions3.doubleClick();
            Thread.sleep(1000);
            actions3.sendKeys(GPvalue.get("PAN_Card"));
            actions3.build().perform();
            Thread.sleep(1000);

            driver.findElement(By.xpath(".//*[@id='txtFlat']")).sendKeys(GPvalue.get("Address1"));
            driver.findElement(By.xpath(".//*[@id='txtCity']")).sendKeys(GPvalue.get("City2"));
            driver.findElement(By.xpath(".//*[@id='txtVillage']")).sendKeys(GPvalue.get("State"));
            driver.findElement(By.xpath(".//*[@id='txtOwnerPin']")).sendKeys(GPvalue.get("PIN_Code"));

        }


    }

    @Then("^User Save Genral and Applicant details$")
    public void user_click_on_Submit_Button() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='btnSave']")).click();

    }

    @Then("^User Accept Alert Window$")
    public void user_Accept_Alert_message() throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*//div/div[2]/a/span/span")).click();

    }

    @Then("^Close Test Browser$")
    public void close_Test_Browser() throws Throwable {
        Thread.sleep(5000);
        driver.close();

    }

}
