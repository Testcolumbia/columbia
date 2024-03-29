/*
 * This method is used to upload an EGC program to the classic viewer portal.
 */

package com.qa.columbia.functions.v5_4;

import java.util.Calendar;
import java.util.Date;

import com.qa.columbia.repository.v5_4.*;
import com.qa.columbia.executor.*;
import com.thoughtworks.selenium.*;

public class Upload_EGCprogramCVP extends TesterAsserter 
{
	public static void test_Upload_EGCprogramCVP(Selenium sel, String str_EGcprogramName, String streamingMediaFile) throws Exception 
	{
        Utility_Functions utilityFunction = new Utility_Functions();    	
        //Fetching values for Global Variables from XMl file
        String str_path ="Global_variables.xml";
        Date date=Calendar.getInstance().getTime();
     	String Var_frameWork_Path = utilityFunction.GetValue(str_path ,"Var_frameWork_Path");
	    String VAR_MED_WAIT = utilityFunction.GetValue(str_path ,"VAR_MED_WAIT") ;
		sel.click(EnvObjectMap_Rep.lnk_myProgramCVP);
		sel.waitForPageToLoad(VAR_MED_WAIT);
		sel.click(EnvObjectMap_Rep.lnk_addEGCprogramCVP);
		sel.waitForPageToLoad(VAR_MED_WAIT);		
		sel.type(EnvObjectMap_Rep.txt_egcProgramNameCVP, str_EGcprogramName);
		sel.focus(EnvObjectMap_Rep.fileUPl_egcStreamingMediaCVP);
		//press tab
		sel.keyPressNative("9");
		//Press tab 
		sel.keyPressNative(java.awt.event.KeyEvent.VK_SPACE + ""); 
		//Wait for loading the page
	//	utilityFunction.waitForChangesToReflect();
		//Path of the autoit file to upload file
		String auto_it_contentUpload = Var_frameWork_Path + "\\commonfiles\\upload_file.exe";
		
		String filePath = Var_frameWork_Path + "\\commonfiles\\" + streamingMediaFile;
		
		String []cmd = {auto_it_contentUpload, filePath};
		
		Runtime.getRuntime().exec(cmd);			
		//sel.type(EnvObjectMap_Rep.fileUPl_egcStreamingMediaCVP, streamingMediaFile);		
		sel.click(EnvObjectMap_Rep.btn_egcSaveprogramCVP);
		sel.waitForPageToLoad("200000");
		utilityFunction.waitForChangesToReflect();
		assertTrue("Upload_EGCprogramCVP","Classic VP: Ensure that wmv file is uploaded from viewer portal.",date,sel.isElementPresent(EnvObjectMap_Rep.lnk_programNameCVP + str_EGcprogramName));
	}
}



	  