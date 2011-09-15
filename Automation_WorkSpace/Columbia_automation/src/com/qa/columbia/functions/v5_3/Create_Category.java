/*
 * This method is used to Create Category in the Application.
 * 
*/

package com.qa.columbia.functions.v5_3;

import com.qa.columbia.repository.v5_3.*;
import com.qa.columbia.executor.*;
import com.thoughtworks.selenium.*;

public class Create_Category extends TesterAsserter  {

	public static void create_Category(Selenium sel, String str_CatName) throws Exception 
	{	
		//Fetching values for Global Variables from XML file
		String str_path ="Global_variables.xml";
		Utility_Functions utilityFunction = new Utility_Functions(); 		
		String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");		 
		//Open the Programming menu
	    sel.click(EnvObjectMap_Rep.LNK_Programming);
	    //Open the category page
	    sel.click(EnvObjectMap_Rep.LNK_Category);
	 	//wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);
	    // Click Add button
	    sel.click(EnvObjectMap_Rep.BTN_Add_Cat);
	 	//wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);
	    //Provide category name
	    sel.type(EnvObjectMap_Rep.LNK_Cat_Name,str_CatName);
	    //Active the category
	    sel.click(EnvObjectMap_Rep.LNK_Cat_Active);
	    //click Save button
	    sel.click(EnvObjectMap_Rep.BTN_Cat_Save);
	 	//wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);
	     //verifies the checkpoint for category creation
		//assertTrue("Columbia_LiveProgramVerification","Verify that category is created successfully.",sel.isTextPresent(utilityFunction.GetValue(local_path , "VAR_Cat")));
	}
}
