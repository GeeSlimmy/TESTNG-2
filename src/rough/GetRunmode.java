package rough;

import com.qtpselenium.util.TestUtil;
import com.qtpselenium.util.Xls_Reader;

public class GetRunmode {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\data\\Test Cases.xlsx");
		/*for(int rowNum=2;rowNum<=xls.getRowCount("Test Cases");rowNum++){		 
			 if(xls.getCellData("Test Cases", "Runmode", rowNum).equals("Y"))
				 System.out.println(xls.getCellData("Test Cases", "TCID", rowNum)+" -- "+"Y");
		}*/
		 System.out.println(TestUtil.isExecutable("Test2", xls));
	}

}
