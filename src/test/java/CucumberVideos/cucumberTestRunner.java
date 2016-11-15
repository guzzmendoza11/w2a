package CucumberVideos;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//Video 209: Starting with Cucumber Basics
//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/CucumberVideos",plugin = {
		
		//glue = "cucumber.steps",
		//plugin={"html:format"},
		// features = {"src/cucumber"}
	   "pretty",
	   "html:target/cucumber", 
	   "json:/Applications/Jenkins/JenkinsHome/jobs/CucumberMavenReportingPlugin/target/cucumber.json",
       })

public class cucumberTestRunner {

}

/*@CucumberOptions(

 format = {"Feature", "jason:target/"},		
 features = {"src/cucumber"}
 
) 

*/