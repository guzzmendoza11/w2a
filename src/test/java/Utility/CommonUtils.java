package Utility;

import java.util.Hashtable;

import org.testng.SkipException;
//Video 195: Multiple DataProviders part 1
//Video 198: Setting up Runmode at a Test Case level
//Video 199: Creating a common utility for Runmode
public class CommonUtils {
	
	
	public static boolean isTestExecutable(String testCaseName, ExcelReader excel){
		
		
		String sheetName = Constants.TEST_CASE_SHEET;
		
		int rows = excel.getRowCount(sheetName);
		
       for(int rowNum=2; rowNum<=rows; rowNum++){
			
			String testCase = excel.getCellData(sheetName, Constants.TEST_CASE_COL, rowNum);
			
		if(testCase.equalsIgnoreCase(testCaseName)){ //If statement ignores the Case letters.
			
			String runMode = excel.getCellData(sheetName, Constants.TEST_RUNMODE_COL, rowNum);
			if(runMode.equalsIgnoreCase(Constants.RUNMODE_YES)){
				
				return true;
			}else{
				return false;
			}
			
		}
		
	  }
		
	 return false;
		
	}
	                                            
	
	public static boolean isSuiteExecutable(String suiteName){
		
		ExcelReader excel = new ExcelReader(Constants.TEST_SUITE_XLS_PATH);
		String sheetName = Constants.TEST_SUITE_SHEET;
		int rows = excel.getRowCount(sheetName);
		
		for(int rowNum=2; rowNum<=rows; rowNum++){
			
			String testSuiteName = excel.getCellData(sheetName, Constants.TEST_SUITE_COL, rowNum);
			
		if(testSuiteName.equalsIgnoreCase(suiteName)){ //If statement ignores the Case letters.
			
			String runMode = excel.getCellData(sheetName, Constants.SUITE_RUNMODE_COL, rowNum);
			if(runMode.equalsIgnoreCase(Constants.RUNMODE_YES)){
				
				return true;
			}else{
				return false;
			}
			
		}
		
	  }
		
	 return false;
		
   }
	
	public static void checkExecution(String testSuiteName,
                                      String testCaseName,
                                      String dataRunMode, 
                                      ExcelReader excel){

//Check if run mode at Suite level is not executable
   if(!isSuiteExecutable(testSuiteName)){

       throw new SkipException("Skipping the Test : "+testCaseName+" as the Runmode of Test Suite "+testSuiteName+" is No");

     }
   
//Check if run mode at test Case level is not executable
   if(!isTestExecutable(testCaseName,excel)){

       throw new SkipException("Skipping the Test : "+testCaseName+" as the Runmode of Test Case "+testCaseName+" is No");

    }
   
//Check the value in the run mode column
   /*
   if(dataRunMode.equalsIgnoreCase("N")){

       throw new SkipException("Skipping the Test : "+testCaseName+" as the Runmode of Test Data is No");

    }
    */
   
   
    if(dataRunMode.equalsIgnoreCase(Constants.RUNMODE_NO)){

       throw new SkipException("Skipping the Test : "+testCaseName+" as the Runmode of Test Data is No");

    }
   

}
	
	
	public static Object[][] getData(String testcase, ExcelReader excel){
		
 //ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"/src/test/resources/data/Suite1.xlsx");
				
				String sheetName = "TestData";
				String testCase = testcase; //This is now the sheet name
				
				//Test case starts from
				int testCaseRowNum=1; 
				
				while(!excel.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)){
					//System.out.println("Test case starts from : "+testCaseRowNum);
					testCaseRowNum++;
					//xml-apis-1.0.b2.jar
					//xml-apis-1.4.01.jar
					//System.out.println("Test case starts from : "+testCaseRowNum);
				}
				
				System.out.println("Test case starts from : "+testCaseRowNum);
				
				//Next step is to find total columns
				
				int colsStartRowNum=testCaseRowNum+1;
				int dataStartRowNum=colsStartRowNum+1;
				
		        //Find the total number of rows and total number of columns
				int cols=0;
				
				while(!excel.getCellData(sheetName, cols, colsStartRowNum).trim().equals("")){
					
					cols++;
				}
				
				System.out.println("Test cols in a test are : "+cols);
				
			//Get total number of rows in a test
				
				int rows=0;
				
				while(!excel.getCellData(sheetName, 0, dataStartRowNum+rows).trim().equals("")){
					
					rows++;
					
				}
				
				System.out.println("Test rows in a test are : "+rows);
				
				Object[][] data = new Object[rows][1]; 
				
				int i=0; //To return in a form of a table
				
		  //Printing the test data with nested for loops. This is where you're reading the test data
				//this loop is for rows
				
				for(int row=dataStartRowNum; row<dataStartRowNum+rows;row++){
					
				//For every row create a Hash table
					Hashtable<String, String> table =new Hashtable<String, String>();
					
			//this inner loop is for columns		
					for(int col=0;col<cols;col++){
						
			 //System.out.println(excel.getCellData(sheetName, col, row));	
					String Testdata = excel.getCellData(sheetName, col, row); //to get data
					String colName = excel.getCellData(sheetName, col, colsStartRowNum); //to get column name
					
			//To add these values
					table.put(colName, Testdata);
						
					}
			//To return in a form of a table
					data[i][0] = table;
					i++;
					
				}
				
				return data; 
			}

}
