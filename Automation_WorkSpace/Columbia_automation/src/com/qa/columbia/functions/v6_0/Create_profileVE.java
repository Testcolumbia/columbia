/**
 * This function is used to create profile for VideoNet Edge.
 */

package com.qa.columbia.functions.v6_0;

import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;

public class Create_profileVE
{	

	public static void Create_VideoEdge_Profile(Selenium sel,String profileName,String vodPP_name, String storageName, String livePP_name) throws Exception	
	{
		Utility_Functions utilityFunction = new Utility_Functions(); 
		sel.click(EnvObjectMap_Rep.Lnk_delivery);
		sel.click(EnvObjectMap_Rep.Lnk_videoNetEdgeProfile);
		utilityFunction.waitForTextToPresent(sel, "Device Profile", 300);
		Thread.sleep(2000);
		sel.click(EnvObjectMap_Rep.Btn_addVideoNetEdge_Profile);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_nameVideoNetEdge_Profile, 300);
		sel.type(EnvObjectMap_Rep.Txt_nameVideoNetEdge_Profile, profileName);
		if(!sel.isChecked(EnvObjectMap_Rep.Chk_WMS_Service_Active))
		{
			sel.click(EnvObjectMap_Rep.Chk_WMS_Service_Active);
		}
		if(!sel.isChecked(EnvObjectMap_Rep.Chk_enableHTTP_streaming))
		{
			sel.click(EnvObjectMap_Rep.Chk_enableHTTP_streaming);
		}
		sel.click(EnvObjectMap_Rep.Txt_HTTP_port);
		if(!sel.isChecked(EnvObjectMap_Rep.Chk_enableRTSP_streaming))
		{
			sel.click(EnvObjectMap_Rep.Chk_enableRTSP_streaming);
		}
		sel.click(EnvObjectMap_Rep.Txt_RTSP_port);
		if(!sel.isChecked(EnvObjectMap_Rep.Chk_enableMulticast))
		{
			sel.click(EnvObjectMap_Rep.Chk_enableMulticast);
		}
		//sel.type("multicastAddress", "multicastIP");
		sel.type(EnvObjectMap_Rep.Txt_vodPP_name, vodPP_name);
		sel.select(EnvObjectMap_Rep.Drp_vodPP_storage, storageName);
		sel.click(EnvObjectMap_Rep.Btn_addVOD_PP);
		sel.type(EnvObjectMap_Rep.Txt_livePP, livePP_name);
		sel.click(EnvObjectMap_Rep.Btn_addlivePP);
		sel.click(EnvObjectMap_Rep.Btn_saveVideoNetEdge_Profile);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_addVideoNetEdge_Profile, 300);
		Thread.sleep(5000);
	}

}
