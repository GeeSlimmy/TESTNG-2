package rough;

import java.util.Hashtable;
import com.qtpselenium.util.TestUtil;
import com.qtpselenium.util.Xls_Reader;

public class ReadData {

	public static void main(String[] args) {
		
		Hashtable<String,String> table = new Hashtable<String,String>();
		table.put("name", "GeeSlimmy");
		table.put("city", "Culver City");
		
		System.out.println(table.get("name"));
		
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//data//Test Cases.xlsx");
        TestUtil.getData("LoginTest", xls);
        TestUtil.getData("FindFriendTest", xls);
        TestUtil.getData("ChangePassword", xls);
	}

}
