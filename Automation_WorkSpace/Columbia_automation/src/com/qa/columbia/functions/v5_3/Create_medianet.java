/*
 * This method is used to Create medianet delivery option in the Application.
 *
*/

package com.qa.columbia.functions.v5_3;

import java.text.MessageFormat;

import com.qa.columbia.repository.v5_3.*;
import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;

public class Create_medianet extends TesterAsserter {
    //Create medianet with DNS
    public static void create_medianetDNS(Selenium sel,String str_medianetName, String str_originWMS, String str_edgeWMS, String str_edgeHost) throws Exception	{
       
	   // Utility_Functions utilityFunction = new Utility_Functions();
    	//Click on Delivery Option
	    sel.click(EnvObjectMap_Rep.LNK_DeliveryOption);
	    //Wait for the page to load
		sel.waitForPageToLoad("30000");
		//Clic on Add button
		sel.click(EnvObjectMap_Rep.Btn_Adddelivery);
		//Select the medianet option from the list box
		sel.addSelection(EnvObjectMap_Rep.SelectType_DO_WMS, "label=MediaNet");
		//Click on Medianet option
		sel.click(EnvObjectMap_Rep.selectMediaNet);
	    //Wait for the page to load
		sel.waitForPageToLoad("80000");
		//Type the name of the medianet
		sel.type(EnvObjectMap_Rep.txt_nameMedianet, str_medianetName);		
		String FirstWMS = sel.getText(EnvObjectMap_Rep.lst_FirstWMSdo);
		String SecondWMS = sel.getText(EnvObjectMap_Rep.lst_SecondWMSdo);
		if(FirstWMS.equals(str_originWMS))
				{
			sel.click(EnvObjectMap_Rep.lst_FirstWMSdo);
				}		
		else
		{
			if(SecondWMS.equals(str_originWMS))
			{
				sel.click(EnvObjectMap_Rep.lst_SecondWMSdo);
			}
			else
			{
			  for (int i = 3; i<50;i=i+1 ){
				  
			    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.lst_selectOrigin, i));
			    	//System.out.println(str_var);			    	
			    	if (str_var.equals(str_originWMS)){
			    		sel.click(MessageFormat.format(EnvObjectMap_Rep.lst_selectOrigin, i));
		              break;
		          }   			    	
		      }
			}
		}		
		sel.click(EnvObjectMap_Rep.lnk_originMoveToSelected);
		
		  for (int i = 1; i<50; i=i+1)
		  {
		    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.lst_selectEdge, i));
		    	if (str_var.equals(str_edgeWMS))
		    	{
		    		sel.click(MessageFormat.format(EnvObjectMap_Rep.lst_selectEdge, i));
	            break;
		    	}                  
		  }
	 
	sel.click(EnvObjectMap_Rep.lnk_edgeMoveToSelected);
	//Type the edge IP
	sel.type(EnvObjectMap_Rep.txt_DNS, str_edgeHost);
	//Save the delivery option
	sel.click(EnvObjectMap_Rep.btn_submit);
    //Wait for the page to load
	sel.waitForPageToLoad("30000");
}
    //Create medianet with proximity defined
    public static void create_medianetProximity(Selenium sel,String str_medianetName, String str_originWMS, String str_edgeWMS, String IPrange1, String IPrange1Metric, String IPrange2, String IPrange2Metric) throws Exception	{
        
	// Utility_Functions utilityFunction = new Utility_Functions();
	sel.click(EnvObjectMap_Rep.LNK_DeliveryOption);
    //Wait for the page to load
	sel.waitForPageToLoad("30000");
	sel.click(EnvObjectMap_Rep.Btn_Adddelivery);
	//("//table[@id='bindContainer']/tbody/tr[1]/td[1]/div/button[2]");
	sel.addSelection(EnvObjectMap_Rep.SelectType_DO_WMS, "label=MediaNet");
	//sel.addSelection("selectselectTypeDialogdoptTypes", "label=MediaNet");
	
	//sel.click("dlvryimpl_medianet");
	sel.click(EnvObjectMap_Rep.selectMediaNet);
	sel.waitForPageToLoad("30000");
	sel.type(EnvObjectMap_Rep.txt_nameMedianet, str_medianetName);	
	String FirstWMS = sel.getText(EnvObjectMap_Rep.lst_FirstWMSdo);
	String SecondWMS = sel.getText(EnvObjectMap_Rep.lst_SecondWMSdo);
	if(FirstWMS.equals(str_originWMS))
			{
		sel.click(EnvObjectMap_Rep.lst_FirstWMSdo);
			}	
	else
	{
		if(SecondWMS.equals(str_originWMS))
		{
			sel.click(EnvObjectMap_Rep.lst_SecondWMSdo);
		}
		else
		{
		  for (int i = 2; i<50;i=i+1 ){
			  
		    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.lst_selectOrigin, i));
		    	//System.out.println(str_var);
		    	
		    	if (str_var.equals(str_originWMS)){
		    		sel.click(MessageFormat.format(EnvObjectMap_Rep.lst_selectOrigin, i));
	              break;
	          }   		    	
	       }
		}
	}	
	sel.click(EnvObjectMap_Rep.lnk_originMoveToSelected);	
	  for (int i = 1; i<50; i=i+1)
	  {
	    	String str_var=sel.getText(MessageFormat.format(EnvObjectMap_Rep.lst_selectEdge, i));
//	    	System.out.println(str_var);
	    	if (str_var.equals(str_edgeWMS))
	    	{
	    		sel.click(MessageFormat.format(EnvObjectMap_Rep.lst_selectEdge, i));
            break;
	    	}                  
	  }
	sel.click(EnvObjectMap_Rep.lnk_edgeMoveToSelected);
	//Select the Proximity radio button
	sel.click("proximityEnabled_2");
	sel.click("editProx_link");
	//sel.click("_eventId_editProximity");
    //Wait for the page to load
	sel.waitForPageToLoad("30000");
	//Add proximity mapping for origin
	sel.click(EnvObjectMap_Rep.btn_addProximityMapOrigin);
	sel.focus(EnvObjectMap_Rep.txt_ProximityOriginCIDR1);
	sel.type(EnvObjectMap_Rep.txt_ProximityOriginCIDR1, IPrange1);
	sel.focus(EnvObjectMap_Rep.txt_ProximityOriginMetric1);
	sel.type(EnvObjectMap_Rep.txt_ProximityOriginMetric1, IPrange1Metric);
	sel.click(EnvObjectMap_Rep.btn_addProximityMapOrigin);
	sel.focus(EnvObjectMap_Rep.txt_ProximityOriginCIDR2);
	sel.type(EnvObjectMap_Rep.txt_ProximityOriginCIDR2, IPrange2);
	sel.focus(EnvObjectMap_Rep.txt_ProximityOriginMetric2);
	sel.type(EnvObjectMap_Rep.txt_ProximityOriginMetric2, IPrange2Metric);
	//Add proximity mapping for edge
	sel.click(EnvObjectMap_Rep.radioEdge);
	sel.click(EnvObjectMap_Rep.btn_addProximityMapEdge);
	sel.focus(EnvObjectMap_Rep.txt_ProximityEdgeCIDR1);
	sel.type(EnvObjectMap_Rep.txt_ProximityEdgeCIDR1, IPrange2);
	sel.focus(EnvObjectMap_Rep.txt_ProximityEdgeMetric1);
	sel.type(EnvObjectMap_Rep.txt_ProximityEdgeMetric1, IPrange1Metric);
	sel.click(EnvObjectMap_Rep.btn_addProximityMapEdge);
	sel.focus(EnvObjectMap_Rep.txt_ProximityEdgeCIDR2);
	sel.type(EnvObjectMap_Rep.txt_ProximityEdgeCIDR2, IPrange1);
	sel.focus(EnvObjectMap_Rep.txt_ProximityEdgeMetric2);
	sel.type(EnvObjectMap_Rep.txt_ProximityEdgeMetric2, IPrange2Metric);
	sel.focus(EnvObjectMap_Rep.btn_saveProximity);
	sel.highlight(EnvObjectMap_Rep.btn_saveProximity);
	//Save the proximity settings
	sel.click(EnvObjectMap_Rep.btn_saveProximity);
    //Wait for the page to load
	sel.waitForPageToLoad("30000");
	//Save the medianet delivery option
	sel.click(EnvObjectMap_Rep.btn_saveMedianet);
    //Wait for the page to load
	sel.waitForPageToLoad("30000");
	}
}
