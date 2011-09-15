/*
 * This method is used to create category. 
*/
package com.qa.columbia.functions.v6_0;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.Selenium;

public class Create_Category  extends TesterAsserter{
	
	public static void createCategory(Selenium sel, String str_CatName) throws Exception 
	{	
		//Fetching values for Global Variables from XML file
		String globalVariableFile ="Global_variables.xml";
		Utility_Functions utilityFunction = new Utility_Functions(); 	
		//wait
		String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");	
		
		//Open the Programming menu
		sel.click(EnvObjectMap_Rep.Lnk_programming);
		
	    //Open the category page 
	    sel.click(EnvObjectMap_Rep.Lnk_categories);
	    
	 	//wait
		sel.waitForPageToLoad(VAR_MED_WAIT);
		
	    // Click Add button
	    sel.click(EnvObjectMap_Rep.Btn_Add_Cat);
	    
	 	//wait 
		sel.waitForPageToLoad(VAR_MED_WAIT);
		
	    //Provide category name
	    sel.type(EnvObjectMap_Rep.Lnk_Cat_Name,str_CatName);
	    
	    //Active the category
	    sel.click(EnvObjectMap_Rep.Lnk_Cat_Active);
	    
	    //click Save button
	    sel.click(EnvObjectMap_Rep.Btn_Cat_Save);
	    
	 	//wait 
		sel.waitForPageToLoad(VAR_MED_WAIT);
	     
		
		
	}
	

}
