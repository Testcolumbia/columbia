/*
 * This method is used to Create Channel in the Application.
 * 
*/

package com.qa.columbia.functions.v5_3;

import com.qa.columbia.repository.v5_3.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;

public class Create_Channel extends TesterAsserter
{	
	public static void create_Channel(Selenium sel, String str_ChannelName) throws Exception {       
		 
		Utility_Functions utilityFunction = new Utility_Functions();
		    
		//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT");
		//Click on Programming (Menu Link)
		sel.click(EnvObjectMap_Rep.LNK_Programming);  		   
		//Click on Channel link under Programming
		sel.click(EnvObjectMap_Rep.LNK_Channel);			
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);				
		//click Add button to add channel
		sel.click(EnvObjectMap_Rep.BTN_AddChannel);			
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);			
		//Enter Channel Name			
		sel.type(EnvObjectMap_Rep.TXT_ChannelName, str_ChannelName);			
		//Click Enable checkbox			
		sel.click(EnvObjectMap_Rep.CHK_EnableChannel);			
		//Select the Category			
		sel.click(EnvObjectMap_Rep.Select_Category_Chnl);			
		//Move the category to selected list box			
		sel.click(EnvObjectMap_Rep.Move_Category_Chnl);			
		//Click Save button to save the channel created			
		sel.click(EnvObjectMap_Rep.BTN_SaveChannel);			
		//wait for loading the page
		sel.waitForPageToLoad(VAR_MED_WAIT);				
		}
}
