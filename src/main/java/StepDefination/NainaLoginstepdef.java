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

/**
 * Created by akshay.pokley on 10/11/2018.
 */
public class NainaLoginstepdef {

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
        driver.close();
    }

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
}