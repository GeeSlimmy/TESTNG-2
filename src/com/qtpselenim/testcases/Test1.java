package com.qtpselenim.testcases;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qtpselenium.util.TestUtil;
import com.qtpselenium.util.Xls_Reader;

public class Test1 {
	
	
	@BeforeTest
	public void checkrunmode(){
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\data\\Test Cases.xlsx");
		if(!TestUtil.isExecutable("Test2", xls))
		throw new SkipException("Skipping the test");	
	}
	
	
	@Test
	public void sampleTest(){
		System.out.println("This is sample test");
	}

}
