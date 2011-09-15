/*
*  Classname                                                        Create_VEasWMS 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Add WMS (Video Edge) Delivery Options.<br>
* What the script does:											    >Login to Admin portal.<br> 
* 																	>Navigate to VideoNetEdge Profiles and create a Video Edge profile<br> 
* 																	>Navigate to VideoNetEdge Devices page and create VideoNet Edge device<br> 
*  																	>Verify that the device is created successfully.<br> 	
* What Verification it performs:									1.Verify that VideoEdge (as WMS) is created successfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 14/06/2011
* Updated by/on date: 												QASource on 14/06/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/

package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.*;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.*;

public class Create_VEasWMS_TCID extends TesterAsserter {
	
	static boolean flag = false;
	static Date date=Calendar.getInstance().getTime();
	public void setUp() throws Exception 
	{		
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String str_path ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(str_path ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path, "VAR_Columbia_APPURL");
			
		if(!flag)
		{				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
		}
		utilityFunction = null;

	}
	public void test_Create_VEasWMS() throws Exception {
		try
			{
				setUp();
				Utility_Functions utilityFunction = new Utility_Functions(); 				
				//Global Variables file
				String global_path ="Global_variables.xml";
				
				//Local Variables file
				String local_path ="Create_VEasWMS.xml";
				
				//Username
				String Var_UserName = utilityFunction.GetValue(global_path, "VAR_USR");				
				//Password
				String Var_Password = utilityFunction.GetValue(global_path, "VAR_PWD");				
				//DomainName
				String Var_DomainName = utilityFunction.GetValue(global_path, "Var_DomainSocial");				
				//VideoNet Edge profile name
				String Var_VideoNetEdge_ProfileName = utilityFunction.GetValue(global_path, "Var_VideoNetEdge_ProfileName");
				//VOD publishing point name
				String Var_vodPP_Name = utilityFunction.GetValue(local_path, "Var_vodPP_Name");
				//Storage name
				String Var_StorageName = utilityFunction.GetValue(global_path, "Var_StorageName");
				//Live publishing point name
				String Var_LivePP_Name = utilityFunction.GetValue(local_path, "Var_LivePP_Name");
				//VideoNet edge device name
				String Var_VideoNetEdgeDO_Name = utilityFunction.GetValue(global_path, "Var_VEasWMS_DO");
				//Host name for VideoNet Edge device
				String ContentHostIP = utilityFunction.GetValue(global_path, "Var_VEasWMS_IP");			
				
				//Reusable action to login to admin portal
				Login.adminPortalLogin(selenium, Var_UserName, Var_Password, Var_DomainName);
				
				//Reusable action to create VideoNet Edge profile
				Create_profileVE.Create_VideoEdge_Profile(selenium, Var_VideoNetEdge_ProfileName, Var_vodPP_Name, Var_StorageName, Var_LivePP_Name);
				for(int i=2;i<=10;i++)
				{
					if(selenium.isTextPresent(Var_VideoNetEdge_ProfileName))
					{
						assertTrue("TC_XXX", "Verify that VideoNet Edge Profile is created successfully.", date, selenium.isTextPresent(Var_VideoNetEdge_ProfileName));	
						break;
					}
					else if(selenium.isElementPresent("link="+i))
					{
						selenium.click("link="+i);
						utilityFunction.waitForChangesToReflect();
					}					
				}		
				//Reusable action to create VideoNet Edge delivery option
				Create_DeliveryOption.Create_VideoNetEdge(selenium, Var_VideoNetEdgeDO_Name, ContentHostIP, Var_VideoNetEdge_ProfileName);
				assertTrue("TC_XXX", "Verify that VideoNet Edge device is created successfully.", date, selenium.isTextPresent(Var_VideoNetEdgeDO_Name));
				selenium.type(EnvObjectMap_Rep.Txt_searchDO_Name, Var_VideoNetEdgeDO_Name);
				selenium.select(EnvObjectMap_Rep.Drp_searchDO_Type, EnvObjectMap_Rep.Lst_addDeliveryOption_VideoNet_EdgeDO);
				utilityFunction.waitForTextToPresent(selenium, Var_VideoNetEdgeDO_Name, 100);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			selenium.close();
			selenium.stop();
		}
		}
}