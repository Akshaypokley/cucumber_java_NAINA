package Runner;

import cucumber.api.CucumberOptions;


import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by akshay.pokley on 10/11/2018.
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "E:\\Akshay\\SELENIUM\\Projects\\cucumber_java_NAINA\\src\\main\\java\\Features\\Taging.feature",
        glue = {"StepDefination"},
      //  tags = {"~@Ignore"},
    //  dryRun = true,/*Cheking mapping betwemnn feature and steps defination ,Which method is missing in step defination */
dryRun = false,/*browse lauching  */
      //  monochrome = true,/*it will genrate the output in redabel fromat*/
        //strict = true,/*excuting all properly mapping steps ,it will ceck any steps defination is not avalable */
//tags = {"@RegressionTest,@EndToEndTest"}, /*, is a or oprator*/
       tags = {"~@RegressionTest","~@SmokeTest"}, /*For ignoring any perticular secnario then used '~'*/


        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "junit:target/cucumber-reports/Junittest.xml"
        })


public class TestRunner {


}
