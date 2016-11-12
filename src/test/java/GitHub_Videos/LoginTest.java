package GitHub_Videos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//Video 204: Creating Account on GitHub & Pushing code to the remote repository 
//Video 205: Introduction to Continuous Integration and configuring Jenkins
//Video 206: Creating a free style Jenkins project 

public class LoginTest {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp(){
		
		driver = new FirefoxDriver();
	}
	
	@Test
	public void doLogin() throws InterruptedException{
		
		driver.get("http://gmail.com");
		Thread.sleep(3000L);
		driver.findElement(By.id("Email")).sendKeys("guzzmendoza@gmail.com");
		Thread.sleep(2000L);
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000L);
		driver.findElement(By.id("Passwd")).sendKeys("sdkfksf");
		Thread.sleep(1000L);
		driver.findElement(By.id("signIn")).click();
		
		/*
		 * Added new comments.
		 */
	
	}
	
	@AfterSuite
	public void tearDown(){
		
		//driver.quit();
	}

}

