/**
 * This function is used to play the programs.
 */
package com.qa.columbia.functions.v6_0;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.Selenium;

public class Play_Program extends TesterAsserter{
	
	public static void play_Porgram(Selenium sel, String DomainID, String ProgName) throws Exception
	{
		
		Utility_Functions utilityFunction = new Utility_Functions();
		
		//global file
		String global_path ="Global_variables.xml";
		
		
		//framework path will user for screen shot saving
		String Var_frameWork_Path = utilityFunction.GetValue(global_path ,"Var_frameWork_Path");
	
		
			
		    sel.click(EnvObjectMap_Rep.LNK_showall);
		
		    utilityFunction.waitForChangesToReflect();	
	        sel.type(EnvObjectMap_Rep.TBX_SearchSVP, ProgName);
	
	        sel.typeKeys(EnvObjectMap_Rep.TBX_SearchSVP, "A");
	        utilityFunction.waitForChangesToReflect();
		   //click search arrow link
	       sel.click(EnvObjectMap_Rep.ICN_SearchBoxArrowlinkSVP);
		   utilityFunction.waitForChangesToReflect();
		   
		   //choose dynamic program
		   for (int i = 1; i<50; i++){
				 String str_var1=sel.getText(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult,i));
				 System.out.println(str_var1);	   
				 if(str_var1.equals(ProgName)){
					 sel.click(MessageFormat.format(EnvObjectMap_Rep.LST_Searchresult, i));
					 break;
				 }                  
			 }
		
		     //Wait
			 utilityFunction.waitForChangesToReflect();
			 //Capture the screenshot at the specified path
			 String screenShot_SVPvideo = Var_frameWork_Path + "\\commonfiles\\" + ProgName + ".jpg";		
			 //Capture the screen shot of the live program
			 sel.captureScreenshot(screenShot_SVPvideo);
			 //Wait
			 utilityFunction.waitForChangesToReflect();
		

		
	}

}
