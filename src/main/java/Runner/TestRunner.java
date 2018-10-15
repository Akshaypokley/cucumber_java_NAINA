package Runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;


import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by akshay.pokley on 10/11/2018.
 */


@RunWith(Cucumber.class)

@CucumberOptions(
        features = "E:\\Akshay\\SELENIUM\\Projects\\cucumber_java_NAINA\\src\\main\\java\\Features\\CreateProsDtatable.feature",
        glue = {"StepDefination"},
      //  tags = {"~@Ignore"},
    //  dryRun = true,/*Cheking mapping betwemnn feature and steps defination ,Which method is missing in step defination */
dryRun = false,/*browse lauching  */
      //  monochrome = true,/*it will genrate the output in redabel fromat*/
        //strict = true,/*excuting all properly mapping steps ,it will ceck any steps defination is not avalable */
//tags = {"@RegressionTest,@EndToEndTest"}, /*, is a or oprator*/
       tags = {"~@RegressionTest","~@SmokeTest"}, /*For ignoring any perticular secnario then used '~'*/
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },

        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "junit:target/cucumber-reports/Junittest.xml"
        })


public class TestRunner {

    @Before
    public void beforeScenario(Scenario scenario) {
        Reporter.assignAuthor("ToolsQA - AKSHAY ");
        if (scenario.getName().equals("Some scenario name")) {
            Reporter.assignAuthor("ToolsQA - AKSHAY");
        }
    }



    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("E:\\Akshay\\SELENIUM\\Projects\\cucumber_java_NAINA\\src\\main\\java\\config\\extent-config.xml");
        Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");

    }



}
