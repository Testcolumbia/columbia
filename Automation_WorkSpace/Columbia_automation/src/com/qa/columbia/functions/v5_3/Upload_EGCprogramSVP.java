/*
 * This method is used to upload an EGC program to the social viewer portal.
 */

package com.qa.columbia.functions.v5_3;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_3.*;
import com.qa.columbia.executor.*;
import com.thoughtworks.selenium.*;

public class Upload_EGCprogramSVP extends TesterAsserter 
{
	public static void test_Upload_EGCprogramSVP(Selenium sel, String str_EGcprogramName,String str_EGCchannelname, String str_streamingMediaFile) throws Exception 
	{
        Utility_Functions utilityFunction = new Utility_Functions();    	
        //Fetching values for Global Variables from XMl file
        String str_path ="Global_variables.xml";
        Date date=Calendar.getInstance().getTime();
     	String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
	  //  String VAR_MAX_WAIT = utilityFunction.GetValue(str_path ,"VAR_MAX_WAIT") ;
	    String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT") ;
	    
		//sel.waitForPageToLoad(VAR_MAX_WAIT);
		sel.click(EnvObjectMap_Rep.lnk_AddProgram_SVP);
		sel.waitForPageToLoad(VAR_MED_WAIT);		
		sel.type(EnvObjectMap_Rep.txt_egcProgramNameSVP, str_EGcprogramName);
		
		sel.select("channel", "label="+str_EGCchannelname);
		
		sel.focus(EnvObjectMap_Rep.fileUPl_egcStreamingMediaSVP);
		//press tab
		sel.keyPressNative("9");
		//Press tab 
		sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
		//Wait for loading the page
		utilityFunction.waitForChangesToReflect();
		//Path of the autoit file to upload file
		String auto_it_contentUpload = Var_frameWork_Path + "\\commonfiles\\upload_file.exe";
		
		String filePath = Var_frameWork_Path + "\\commonfiles\\" + str_streamingMediaFile;
		
		String []cmd = {auto_it_contentUpload, filePath};
		
		Runtime.getRuntime().exec(cmd);			
	
		
		if(sel.isElementPresent(EnvObjectMap_Rep.btn_egcSubmitprogramSVP))
		{
			System.out.println(sel.isElementPresent(EnvObjectMap_Rep.btn_egcSubmitprogramSVP));
			//Variable to click the Submit button.
			sel.click(EnvObjectMap_Rep.btn_egcSubmitprogramSVP);
		}
		else
			{
			System.out.println(sel.isElementPresent(EnvObjectMap_Rep.btn_egcSaveprogramSVP));
			//Variable to click the Submit button if Save button is present.
				sel.click(EnvObjectMap_Rep.btn_egcSaveprogramSVP);
			}

		for (int second = 0;; second++) {
			if (second >= 600) fail("timeout");
			try { if (sel.isTextPresent(str_EGcprogramName)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	
		utilityFunction.waitForChangesToReflect();
	
		assertTrue("Upload_EGCprogramSVP","Social VP: EGC program has been created successfully.",date,sel.isTextPresent(str_EGcprogramName));

	}
}
