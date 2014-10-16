package com.qtpselenium.util;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qtpselenim.testcases.TestBase;

public class TestUtil {
	// Returns: true if test has to be executed
	// Returns: false if test has to be skipped
	public static boolean isExecutable(String testName, Xls_Reader xls){
		
	
	for(int rowNum=2;rowNum<=xls.getRowCount("Test Cases");rowNum++){
		if(xls.getCellData("Test Cases", "TCID", rowNum).equals(testName)){
			if(xls.getCellData("Test Cases", "Runmode", rowNum).equals("Y"))
			return true;
			else
				return false;
		 
		}
		 
	  }
	
	 return false;
	}
	
	public static void taskScreenshot(String filename){
		File scrFile = ((TakesScreenshot)TestBase.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static Object[][] getData(String testName, Xls_Reader xls){
		// find the row num from which row starts
		// find num of columns in the test
		// find num of rows
		// put the data in hashtable and put hashtable in array
		
		int testStartRowNum=0;
		// find the row num from which row starts
		for(int rNum=1;rNum<=xls.getRowCount("Test Data");rNum++){
			if(xls.getCellData("Test Data", 0, rNum).equals(testName)){
				testStartRowNum=rNum;
				break;
			}
		}
		System.out.println("Test "+testName+" starts from "+testStartRowNum);
		
		int colStartRowNum=testStartRowNum+1;
		int totalCols=0;
		while(!xls.getCellData("Test Data", totalCols, colStartRowNum).equals("")){
			totalCols++;
			
		}
		System.out.println("Total Cols in test "+ testName + " are "+totalCols);
		
		// rows
		int dataStartRowNum=testStartRowNum+2;
		int totalRows=0;
		while(!xls.getCellData("Test Data", 0, dataStartRowNum+totalRows).equals("")){
			totalRows++;
		}
		System.out.println("Total Rows in test "+ testName + " are "+ totalRows);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// extract data
		Object[][] data = new Object[totalRows][1];
		int index=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+totalRows);rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<totalCols;cNum++){
				table.put(xls.getCellData("Test Data", cNum, colStartRowNum), xls.getCellData("Test Data", cNum, rNum));
				System.out.println(xls.getCellData("Test Data", cNum, rNum) + " -- ");
			}
			data[index][0]=table;
			index++;
			System.out.println();
		}
		
		System.out.println("all done");
		return data;
		
	}
}
