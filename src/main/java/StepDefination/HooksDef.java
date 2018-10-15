package StepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by akshay.pokley on 10/15/2018.
 */
public class HooksDef {

/*@Before  Gobal Hooks
public void Beforetest()
{
    System.out.println("--------Before Test was running Succefully-----");
}

    @After
    public void Aftertest()
    {

        System.out.println("--------After Test was running Succefully-----");

    }*/


   /* @Before("@FIRST")
    public void Beforetest()
    {
        System.out.println("--------Before  FIRSTTest was running Succefully-----");
    }*/


    @Before(order=2)
    public void Beforetest2()
    {
        System.out.println("--------Before  2 was running Succefully-----");
    }

    @After(order = 1)
    public void Beforetest1()
    {
        System.out.println("--------Before  1 was running Succefully-----");
    }


    @Given("^User on Application home page$")
    public void user_on_Application_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^User Apply \"([^\"]*)\"$")
    public void user_Apply(String arg1) throws Throwable {

    }

    @Then("^User Fill proposal details  \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void user_Fill_proposal_details(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10, String arg11, String arg12, String arg13, String arg14, String arg15, String arg16) throws Throwable {

    }

    @Then("^User click on SaveB$")
    public void user_click_on_SaveB() throws Throwable {

    }

    @Then("^Accept Alert by user$")
    public void accept_Alert_by_user() throws Throwable {

    }

    @Then("^Closed Browser$")
    public void closed_Browser() throws Throwable {

    }

}
