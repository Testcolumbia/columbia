/*
 * This method is used to create VOD and Automated File Broadcast Template. 
*/
package com.qa.columbia.functions.v6_0;

import com.qa.columbia.executor.TesterAsserter;
import com.qa.columbia.functions.v6_0.Utility_Functions;
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;
import com.thoughtworks.selenium.Selenium;

public class Create_ProgramTemplate extends TesterAsserter
{

	//Create VODTemplate
	public static void test_Create_VODTemplate(Selenium sel,String str_ProgramTemplatename,String str_MediaFormat,String str_deliveryoption) throws Exception
	{
		
        Utility_Functions utilityFunction = new Utility_Functions();
		
		//Fetching values for Global Variables from XMl file
		String globalVariableFile ="Global_variables.xml";
		//wait
		String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
		String VAR_MIN_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MIN_WAIT");
		
		String VAR_Stroage= utilityFunction.GetValue(globalVariableFile ,"Var_StorageName");
		String VAR_HTTPDOPT=utilityFunction.GetValue(globalVariableFile ,"VAR_httpName");
        //Click Programming menu link
		sel.click(EnvObjectMap_Rep.Lnk_programming);
		//Click Program Templates link
		sel.click(EnvObjectMap_Rep.Lnk_programTemplates);
		
		sel.waitForPageToLoad(VAR_MIN_WAIT);
//		//select program template option.
//		sel.click(EnvObjectMap_Rep.Btn_AdddPrgTemplate);
//		sel.addSelection(EnvObjectMap_Rep.Drp_PrgTemplatechoose,"label=On-Demand");
//		sel.click(EnvObjectMap_Rep.Drp_PrgTemplatechoose);
//		//wait
//		sel.waitForPageToLoad(VAR_MED_WAIT);
//		//provide program template name
//		sel.type(EnvObjectMap_Rep.Txt_PrgTemplate, str_ProgramTemplatename);
//		//seelct the storage
//		sel.select(EnvObjectMap_Rep.Txt_PrgTemplateStorage, "label="+VAR_Stroage);
//		//sel.click("id=storageOption");
//		Thread.sleep(1000);
//		//select add delivery button
//		sel.click(EnvObjectMap_Rep.Btn_AddDelivery);
//		//wait
//		sel.waitForPageToLoad(VAR_MIN_WAIT);
//		//provide Delivery mode as download
//		sel.select(EnvObjectMap_Rep.Drp_AddDeliveryName, "label=Download");
//		Thread.sleep(2000);
//		//select delivery option
//		//input[3]
//		 String Strvar=sel.getText(EnvObjectMap_Rep.Txt_Templatedelivery);
//         String [] temp = null;
//         temp = Strvar.split("\n");
// 
//          for(int i = 0; i<50; i=i+1)
//          {
//           String str_var=temp[i].trim();    
//          System.out.println(str_var);
//          
//          if (str_var.equals(VAR_HTTPDOPT))
//         {
//              
//              i++;
//              
//              //selenium.focus("//div[@id='doptEnclosure']/input["+i+"]");
//             sel.click("//div[@id='doptEnclosure']/input["+i+"]");
//             i++;
//              Thread.sleep(1000);
//              sel.click("//div[@id='doptEnclosure']/input["+i+"]");
//            
//         break;
//         }
//          
//          }
//		
//		sel.click(EnvObjectMap_Rep.Btn_AddDeliverySave);
//		sel.waitForPageToLoad(VAR_MIN_WAIT);
//		
//		//Add VOD delivery method
//		          sel.click(EnvObjectMap_Rep.Btn_AddDelivery);
//		
//        sel.waitForPageToLoad(VAR_MIN_WAIT);
//		
//		sel.select(EnvObjectMap_Rep.Drp_AddDeliveryName, "label=VOD");
//		 utilityFunction.waitForChangesToReflect();
//	   utilityFunction.waitForElementToPresent(sel, EnvObjectMap_Rep.Drp_MediaFormat, 100);
//		
//		sel.select(EnvObjectMap_Rep.Drp_MediaFormat, "label="+str_MediaFormat);
//		Thread.sleep(3000);
//		
//		//select delivery option
//		//input[3]
//		 String Strvar1=sel.getText(EnvObjectMap_Rep.Txt_Templatedelivery);
//         String [] temp1 = null;
//         temp1 = Strvar1.split("\n");
// 
//          for(int i = 0; i<50; i=i+1)
//          {
//           String str_var=temp1[i].trim();    
//          System.out.println(str_var);
//          
//          if (str_var.equals(str_deliveryoption))
//         {
//              System.out.println(i);
//              i++;
//              
//              //selenium.focus("//div[@id='doptEnclosure']/input["+i+"]");
//             sel.click("//div[@id='doptEnclosure']/input["+i+"]");
//              i++;
//              Thread.sleep(1000);
//              sel.click("//div[@id='doptEnclosure']/input["+i+"]");
//            
//         break;
//         }
//          
//          }
//		
//		//sel.click(EnvObjectMap_Rep.Chk_AddDeliveryOption);
//		
//		//Save the VOD delivery method
//		sel.click(EnvObjectMap_Rep.Btn_AddDeliverySave);
//		
//		sel.waitForPageToLoad(VAR_MIN_WAIT);
//		//save the program template
//		sel.click(EnvObjectMap_Rep.Btn_SaveProgramTemplate);
//		sel.waitForPageToLoad(VAR_MIN_WAIT);
    	
	}
	
	
	//Create AutomatedFileBroadcastTemplate
	public static void test_Create_AutomatedFileBroadcastTemplate(Selenium sel,String str_ProgramTemplatename,String str_MediaFormat,String str_deliveryoption) throws Exception
	{
		
        Utility_Functions utilityFunction = new Utility_Functions();
		
		//Fetching values for Global Variables from XMl file
		String globalVariableFile ="Global_variables.xml";
		//wait
		String VAR_MED_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MED_WAIT");
		String VAR_MIN_WAIT = utilityFunction.GetValue(globalVariableFile ,"VAR_MIN_WAIT");
		
		String VAR_Storage= utilityFunction.GetValue(globalVariableFile ,"Var_StorageName");
		String VAR_HTTPDOPT=utilityFunction.GetValue(globalVariableFile ,"VAR_httpName");
        //Click Programming menu link
		sel.click(EnvObjectMap_Rep.Lnk_programming);
		
		sel.click(EnvObjectMap_Rep.Lnk_programTemplates);
		
//		sel.waitForPageToLoad(VAR_MIN_WAIT);
//		
//		sel.click(EnvObjectMap_Rep.Btn_AdddPrgTemplate);
//		
//		sel.addSelection(EnvObjectMap_Rep.Drp_PrgTemplatechoose, "label=Automated File Broadcast");
//		sel.click(EnvObjectMap_Rep.Drp_PrgTemplatechoose);
//		
//		sel.waitForPageToLoad(VAR_MED_WAIT);
//		sel.type(EnvObjectMap_Rep.Txt_PrgTemplate, str_ProgramTemplatename);
//		
//		sel.select(EnvObjectMap_Rep.Txt_PrgTemplateStorage, "label="+VAR_Storage);
//		//sel.click("id=storageOption");
//		Thread.sleep(1000);
//		sel.click(EnvObjectMap_Rep.Btn_AddDelivery);
//		
//		sel.waitForPageToLoad(VAR_MIN_WAIT);
//		
//		sel.select(EnvObjectMap_Rep.Drp_AddDeliveryName, "label=Download");
//		Thread.sleep(4000);
//		
//		String Strvar=sel.getText(EnvObjectMap_Rep.Txt_Templatedelivery);
//        String [] temp = null;
//        temp = Strvar.split("\n");
//
//         for(int i = 0; i<50; i=i+1)
//         {
//          String str_var=temp[i].trim();    
//         System.out.println(str_var);
//         
//         if (str_var.equals(VAR_HTTPDOPT))
//        {
//             
//             i++;
//             
//             //selenium.focus("//div[@id='doptEnclosure']/input["+i+"]");
//            sel.click("//div[@id='doptEnclosure']/input["+i+"]");
//            i++;
//             Thread.sleep(1000);
//             sel.click("//div[@id='doptEnclosure']/input["+i+"]");
//           
//        break;
//        }
//         
//         }
//		
//		sel.click(EnvObjectMap_Rep.Btn_AddDeliverySave);
//		sel.waitForPageToLoad(VAR_MIN_WAIT);
//		
//		
//           sel.click(EnvObjectMap_Rep.Btn_AddDelivery);
//		
//           sel.waitForPageToLoad(VAR_MIN_WAIT);
//		
//		sel.select(EnvObjectMap_Rep.Drp_AddDeliveryName, "label=Live");
//		
//		Thread.sleep(3000);
//		sel.select(EnvObjectMap_Rep.Drp_MediaFormat, "label="+str_MediaFormat);
//		Thread.sleep(3000);
//
//		String Strvar1=sel.getText(EnvObjectMap_Rep.Txt_Templatedelivery);
//        String [] temp1 = null;
//        temp1 = Strvar1.split("\n");
//
//         for(int i = 0; i<50; i=i+1)
//         {
//          String str_var=temp1[i].trim();    
//         System.out.println(str_var);
//         
//         if (str_var.equals(str_deliveryoption))
//        {
//             System.out.println(i);
//             i++;
//             
//           
//            sel.click("//div[@id='doptEnclosure']/input["+i+"]");
//             i++;
//             Thread.sleep(1000);
//             sel.click("//div[@id='doptEnclosure']/input["+i+"]");
//           
//        break;
//        }
//         
//         }
//		sel.click(EnvObjectMap_Rep.Btn_AddDeliverySave);
//		sel.waitForPageToLoad(VAR_MIN_WAIT);
//		
//		sel.click(EnvObjectMap_Rep.Btn_SaveProgramTemplate);
//		sel.waitForPageToLoad(VAR_MIN_WAIT);
//		
}
	
}