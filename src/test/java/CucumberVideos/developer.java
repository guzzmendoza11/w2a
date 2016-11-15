package CucumberVideos;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class developer {
	
	
	@Given("^I am a \"([a-zA-Z]{1,})\" Developer$")
	public void I_am_a_CoreJava_Developer(String developerTyp){
	
    System.out.println("---------------------------------------------------");		
	System.out.println("@Given -- I am a "+developerTyp+" developer");	
		
	}
	
	@When("^I started development$")
	public void I_started_development(){
		
		 System.out.println("@When -- I started development");	
	}
	
	@Then("^I created a \"([a-zA-Z]{1,})\" java program$")
	public void I_created_a_simple_java_program(String programType){
		
		
	System.out.println("@Then -- I created a "+programType+" java program");	
		
	}
	
	@And("^I am \"([a-zA-Z]{1,})\" experienced$")
	public void I_am_very_experienced(String experience){
		
	System.out.println("@And -- I am "+experience+" experienced");
		
	}
	
	
	@But("^My Boss is \"([a-zA-Z]{1,})\" satisfied$")
	public void I_am_not_experienced(String satisfactionType){
		
	System.out.println("@And -- My Boss is "+satisfactionType+" satisfied");	
		
	}
	
	
	

}
