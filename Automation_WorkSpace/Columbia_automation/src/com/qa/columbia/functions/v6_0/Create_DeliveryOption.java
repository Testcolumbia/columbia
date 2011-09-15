/**
 * This function is used to create delivery option.
 */

package com.qa.columbia.functions.v6_0;

import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;

public class Create_DeliveryOption
{	
	//Function to create VideoNet Edge device.
	public static void Create_VideoNetEdge(Selenium sel,String videoNet_EdgeDO_Name,String ContentHostIP, String profileName) throws Exception	
	{	
		Utility_Functions utilityFunction = new Utility_Functions(); 
		sel.click(EnvObjectMap_Rep.Lnk_deliveryOption);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_addDeliveryOption, 300);
		sel.click(EnvObjectMap_Rep.Btn_addDeliveryOption);
		sel.addSelection(EnvObjectMap_Rep.Lst_addDeliveryOption, EnvObjectMap_Rep.Lst_addDeliveryOption_VideoNet_EdgeDO);
		sel.click(EnvObjectMap_Rep.Select_VideoNet_edgeDOPT);
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Txt_videoNet_name, 300);
		sel.type(EnvObjectMap_Rep.Txt_videoNet_name, videoNet_EdgeDO_Name);
		if(!sel.isChecked(EnvObjectMap_Rep.Chk_visible_in_Program_and_Audience))
		{
			sel.click(EnvObjectMap_Rep.Chk_visible_in_Program_and_Audience);
		}		
		if(!sel.isChecked(EnvObjectMap_Rep.Chk_ServerRole))
		{
			sel.click(EnvObjectMap_Rep.Chk_ServerRole);
		}
		sel.type(EnvObjectMap_Rep.Txt_rangeCIDR_Proximity, "0.0.0.0/0");
		sel.type(EnvObjectMap_Rep.Txt_metric_Proximity, "0");
		sel.type(EnvObjectMap_Rep.Txt_controlHost_or_IP, ContentHostIP);
		sel.select(EnvObjectMap_Rep.Drp_Profile, "label="+profileName);
		sel.click(EnvObjectMap_Rep.Chk_VideoNetEdge_ManagedDevice);
		if(!sel.isChecked(EnvObjectMap_Rep.Chk_Active))
		{
			sel.click(EnvObjectMap_Rep.Chk_Active);
		}
		sel.click(EnvObjectMap_Rep.Btn_saveVideoNetEdge_deliveryOption);
		sel.waitForPageToLoad("70000");
		if(sel.isTextPresent("You already have an object using this name. Please select an alternate name."))
		{
			sel.click(EnvObjectMap_Rep.Lnk_cancel);
		}
		utilityFunction.waitForElementToVisible(sel, EnvObjectMap_Rep.Btn_addDeliveryOption, 300);
	}
}
