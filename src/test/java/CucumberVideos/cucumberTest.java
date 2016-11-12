package CucumberVideos;



import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//Video 209: Starting with Cucumber Basics
public class cucumberTest {
	
	
	@Given("^I am a \"([a-zA-Z]{1,})\" Tester$")
	public void i_am_a_Manual_Tester(String testerType, DataTable table) throws Throwable {
	
		
		List<Map<String,String>> data = table.asMaps(String.class, String.class);
        System.out.println("---------------------------------------------------");		
System.out.println("@Given -- I am a "+testerType+" Tester"+" current location is "+data.get(0).get("Location")+" and the position is "+data.get(0).get("Position"));	
System.out.println("@Given -- I am a "+testerType+" Tester"+" current location is "+data.get(1).get("Location")+" and the position is "+data.get(1).get("Position"));
	}
	
	@When("^I apply for a job$")
	public void i_apply_for_a_job() throws Throwable {
		
		System.out.println("@When -- I apply for a job");
	}
	
	@Then("^I got a \"([a-zA-Z]{1,})\" paid job$")
	public void I_got_a_less_paid_job(String jobType) throws Throwable {
		
		System.out.println("@Then -- I got a "+jobType+" paid job");	
	}
		
	@And("^I am \"([a-zA-Z]{1,})\" satisfied with my salary$")
	public void I_am_not_satisfied_with_my_salary(String satisfactionType) throws Throwable {
		
		System.out.println("@And -- I am "+satisfactionType+" satisfied with my salary");
		
	}
	
	@But("^My parents are \"([a-zA-Z]{1,})\" satisfied$")
	public void My_parents_are_highly_satisfied(String parentSatisfaction) throws Throwable {
		
		System.out.println("@But --  My parents are "+parentSatisfaction+" satisfied");
		
System.out.println("---------------------------------------------------");
		
	}
	
	

}
