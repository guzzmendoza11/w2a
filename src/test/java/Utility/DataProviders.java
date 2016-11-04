package Utility;


import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

//Video 196: Multiple DataProviders part 2 
public class DataProviders {
	                   
	@DataProvider(name="getDataSuite1") //Here you define the name of the data provider
	public static Object[][] getDataSuite1(Method m){
		
		
		 System.out.println(m.getName()); //This will return the current method name
		 ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		 
		 String testcase = m.getName();
		 
	     return CommonUtils.getData(testcase, excel);	
	}
	
	@DataProvider(name="getDataSuite2") //Here you define the name of the data provider
	public static Object[][] getDataSuite2(Method m){
		
		 System.out.println(m.getName()); //This will return the current method name
//ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/data/Suite1.xlsx");
		 ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		 
		 String testcase = m.getName();
		 
	     return CommonUtils.getData(testcase, excel);	
	}
	

}
