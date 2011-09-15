/*
 * This method is used to Upload the Content in resourceBin. 
 * @param sel selenium object that runs the selenium commands
 * @param str_StorageName is used to provide storage name.
 * @param str_StorageHost is used to provide the HTTP Host Name in the Browser.
 * @param str_mountPoint is used to provide the mount point (Virtual Directory need to be created on IIS) name in the Browser. 
 * @throws Exception 
*/

package com.qa.columbia.functions.v5_3;

import com.qa.columbia.repository.v5_3.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;

public class upload_slides extends TesterAsserter{
	
	public static void Upload_Slides(Selenium sel,String str_SlideName, String str_Upload_Content) throws Exception	{	
        
		Utility_Functions utilityFunction = new Utility_Functions();
		
		//Fetching values for Global Variables from XMl file
		String str_path ="Global_variables.xml";
		String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT");
		//String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_BROWSER_PATH = "*iexplore";
		String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
		String VAR_Upload_Content = utilityFunction.GetValue(str_path ,"VAR_Upload_Content");
			
		//Open the programming menu
		sel.click(EnvObjectMap_Rep.LNK_Programming);
		//Select the Content link
		sel.click(EnvObjectMap_Rep.LNK_Content);
		//Wait for loading the page
		sel.waitForPageToLoad(VAR_MAX_WAIT);
		utilityFunction.waitForChangesToReflect();
		//Click Add Item button
		sel.click(EnvObjectMap_Rep.Btn_AddItem);
		//Wait for loading the page
		utilityFunction.waitForChangesToReflect();
		 utilityFunction.waitForChangesToReflect();
		//Select Slides radio button
		sel.click(EnvObjectMap_Rep.Rbtn_Slides);
		//Click next button
		sel.click(EnvObjectMap_Rep.Btn_Next);
		//Wait for loading the page
		utilityFunction.waitForChangesToReflect();
		if (VAR_BROWSER_PATH=="*iexplore"){			
			//Wait for loading the page
		    utilityFunction.waitForChangesToReflect();
		    //Bring the focus on File upload field 
			sel.focus(EnvObjectMap_Rep.TXT_Selected_File);
			//press tab
			sel.keyPressNative("9");
			//Press tab 
			sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
			//Wait for loading the page
			//utilityFunction.waitForChangesToReflect();
			//Path of the autoit file to upload file
			String auto_it_contentUpload =Var_frameWork_Path + "\\commonfiles\\upload_file.exe";
			
			String filePath = Var_frameWork_Path + "\\commonfiles\\" + str_Upload_Content;
			
			String []cmd = {auto_it_contentUpload, filePath};
			
			Runtime.getRuntime().exec(cmd);
		}
		
		if (VAR_BROWSER_PATH=="*firefox"){		
			//provide Slides location into Content
			sel.type(EnvObjectMap_Rep.TXT_Selected_File, VAR_Upload_Content);	
		}	
		
		//Click next button to upload the slides
		sel.click(EnvObjectMap_Rep.Btn_Upload_Next);
		//Wait for loading the page
		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForChangesToReflect();
		//Provide the slide name
		sel.type(EnvObjectMap_Rep.TXT_Display_Name, str_SlideName);
		//Click Finish button
		sel.click(EnvObjectMap_Rep.BTN_Finish_Content);
		//wait for loading the page
		//sel.waitForPageToLoad(VAR_MAX_WAIT);
		utilityFunction.waitForChangesToReflect();
		utilityFunction.waitForChangesToReflect();
	}
}
