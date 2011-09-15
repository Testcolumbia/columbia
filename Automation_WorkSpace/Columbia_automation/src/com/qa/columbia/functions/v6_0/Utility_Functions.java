/**
 * This class contains the Utility functions.
 *  
 */

package com.qa.columbia.functions.v6_0;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.Random;
import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.executor.TesterAsserter;
/*import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import com.thoughtworks.selenium.DefaultSelenium;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;*/
import com.qa.columbia.repository.v6_0.EnvObjectMap_Rep;

public class Utility_Functions extends TesterAsserter{

	String str_Data1=null;  
	Random _m_rand = new Random();

	//This Utility functions is used to wait for the element to present on the page	
	public void waitForElementToPresent(Selenium sel,String str_ElementName, int int_Time) throws Exception
	{
		for (int second = 0;; second++) {
			if (second >= int_Time) fail("timeout");
			try { if (sel.isElementPresent(str_ElementName)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	//This Utility functions is used to wait for the element to visible on the page
	public void waitForElementToVisible(Selenium sel,String str_ElementName, int int_Time) throws Exception
	{
		for (int second = 0;; second++) {
			if (second >= int_Time) fail("timeout");
			try { if (sel.isVisible(str_ElementName)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	//This Utility functions is used to wait for the text to present on the page
	public void waitForTextToPresent(Selenium sel,String str_Text, int int_Time) throws Exception
	{
		for (int second = 0;; second++) {
			if (second >= int_Time) fail("timeout");
			try { if (sel.isTextPresent(str_Text)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	//This Utility functions is used to wait for the element to dissapear from page
	public void waitForElementTodisappear(Selenium sel,String str_ElementName, int int_Time) throws Exception
	{
		try
		{
			for (int second = 0;; second++) {
			if (second >= int_Time) fail("timeout");
				if(!sel.isVisible(str_ElementName))
				{
				break;
				}
		}
				
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			waitForElementToVisible(sel, EnvObjectMap_Rep.Lnk_advSearch, 300);
		}
		}


	
	//This Utility functions is used to get data from the XML file.
	public String GetValue(String str_path ,String str_value )throws Exception {
		
       DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	   DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	   Document doc = docBuilder.parse(new File("E:\\Automation_WorkSpace\\Columbia_automation\\src\\com\\qa\\columbia\\testdata\\v6_0\\"+ str_path));
	   doc.getDocumentElement ().normalize ();
	   NodeList var = doc.getElementsByTagName(str_value);
	   String First2 = var.item(0).getTextContent();
	   return First2;
	}
	
	  
	  
	public void waitForChangesToReflect() {
		 // wait for 20 seconds
	   try {
		   Thread.sleep(15000);
		   } catch (InterruptedException e) {
		   throw new RuntimeException(e);
	   }
	}
		 		  
		 		  
	public boolean assertTextContains(String stringBeingSearched, String stringSearchedFor) {

	        if (!stringBeingSearched.contains(stringSearchedFor)) {
	            throw new AssertionError("String expression: '" + stringSearchedFor + "' is not found in String expression:"
	                    + stringBeingSearched + "'");
	        }
	        
	        return true;
	    }	
	
/*	public void setUp() throws Exception {
	
		boolean flag = false;
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String str_path ="Global_variables.xml";
		String VAR_ProxURL = utilityFunction.GetValue(str_path ,"VAR_ProxURL");
		String VAR_BROWSER_PATH = utilityFunction.GetValue(str_path ,"VAR_BROWSER_PATH");
		String VAR_Columbia_APPURL = utilityFunction.GetValue(str_path, "VAR_Columbia_APPURL");
			
		if(!flag){				
			selenium = new DefaultSelenium(VAR_ProxURL, 4444, VAR_BROWSER_PATH, VAR_Columbia_APPURL);
			selenium.start();
			flag = true;
			selenium.setTimeout("0");
		}

	}*/	

	
	 public void keyEvent(Selenium sel, String path)
	 {
		 try
		 {
				int key1 = path.length(); 
				String key2;
				String key;
				for(int i=0;i<key1;i++)
				{
					key2 = path.substring(i,i+1);
					key = key2.trim();
			/*	Thread.sleep(2000);
				}*/
			if (key.equals("A")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_A + "");
			}
			else if (key.equals("B")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_B + "");
			}
			else if (key.equals("C")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_C + "");
			}
			else if (key.equals("D")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_D + "");
			}
			else if (key.equals("E")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_E + "");
			}
			else if (key.equals("F")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_F + "");
			}
			else if (key.equals("G")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_G + "");
			}
			else if (key.equals("H")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_H + "");
			}
			else if (key.equals("I"))
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_I + "");
			}
			else if (key.equals("J")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_J + "");
			}
			else if (key.equals("K")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_K + "");
			}
			else if (key.equals("L")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_L + "");
			}
			else if (key.equals("M")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_M + "");
			}
			else if (key.equals("N")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_N + "");
			}
			else if (key.equals("O")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_O + "");
			}
			else if (key.equals("P")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_P + "");
			}
			else if (key.equals("Q")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_Q + "");
			}
			else if (key.equals("R")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_R + "");
			}
			else if (key.equals("S")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_S + "");
			}
			else if (key.equals("T")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_T + "");
			}
			else if (key.equals("U")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_U + "");
			}
			else if (key.equals("V")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_V + "");
			}
			else if (key.equals("W")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_W + "");
			}
			else if (key.equals("X")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_X + "");
			}
			else if (key.equals("Y")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_Y + "");
			}
			else if (key.equals("Z")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_Z + "");
			}
			else if (key.equals("1")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_1 + "");
			}
			else if (key.equals("2")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_2 + "");
			}
			else if (key.equals("3")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_3 + "");
			}
			else if (key.equals("4")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_4 + "");
			}
			else if (key.equals("5")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_5 + "");
			}
			else if (key.equals("6")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_6 + "");
			}
			else if (key.equals("7")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_7 + "");
			}
			else if (key.equals("8")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_8 + "");
			}
			else if (key.equals("9")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_9 + "");
			}
			else if (key.equals("0")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_0 + "");
			}
			else if (key.equals(":")) 
			{
				sel.keyDownNative(java.awt.event.KeyEvent.VK_SHIFT+""); 
				sel.keyPressNative(java.awt.event.KeyEvent.VK_SEMICOLON+""); 
				sel.keyUpNative(java.awt.event.KeyEvent.VK_SHIFT+""); 
			}
			else if (key.equals("."))
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_PERIOD + "");
			}
			else if (key.equals("\\")) 
			{
				sel.keyPressNative(java.awt.event.KeyEvent.VK_BACK_SLASH + "");
			}
			else if (key.equals("_")) 
			{
				sel.keyDownNative(java.awt.event.KeyEvent.VK_SHIFT+""); 
				sel.keyPressNative(java.awt.event.KeyEvent.VK_MINUS + "");
				sel.keyUpNative(java.awt.event.KeyEvent.VK_SHIFT+""); 
			}
			}
		 }
		 catch(Exception e)
		 {
			 
		 }
		 

	 }

	
/*	//This Utility functions is used to set the test data to excel sheet
	  
	public void fun_SetExcel(String str_Path,String str_Sheet,int int_Column,int int_Row,String str_Data)	{
		try {			
			Workbook workbook = Workbook.getWorkbook(new File(str_Path));
			WritableWorkbook copy = Workbook.createWorkbook(new File(str_Path), workbook); 
			WritableSheet sheet2 = copy.getSheet(str_Sheet); 
			Label label = new Label(int_Column, int_Row, str_Data);
			sheet2.addCell(label); 
			copy.write(); 
			copy.close(); 
			workbook.close();
		}catch(Exception e)	{
		}
			
	}
		
	// This Utility function is used to get the test data from the excel sheet
	
	public String fun_GetExcel(String str_Path, String str_Sheet, int int_Column, int int_Row) {
		File fp = new File(str_Path);
		try	{
			Workbook wb = Workbook.getWorkbook(fp);
			Sheet sheet = wb.getSheet(str_Sheet);
			str_Data1 = sheet.getCell(int_Column,int_Row).getContents();
		}catch(Exception ioe){
		System.out.println("Error: " + ioe);
		}
	return str_Data1;
	}
			
	/**
	 * This Utility function is used to generate the random number
	 * @return String A random number
	 */
	
	/*public String getRandomNumber() {
	return  String.valueOf(createRandomNumber(1000, 9999));
	}
		  
	private int createRandomNumber(int lowLimit, int hiLimit) {
		int n = hiLimit - lowLimit + 1;
		int i = _m_rand.nextInt() % n;
		if (i < 0) {
		i = -i;
		}
	    return lowLimit + i;
	}
 
	/**
	* This Utility function is used for wait condition for all AJAX elements.
	* @param sel for the selenium object
	* @param str_Element for the object properties to identify the object
	*/
	
/*	public void fun_WaitForElement(Selenium sel, String str_Element) throws InterruptedException{
		for (int sec=0;; sec++){
			if (sec >= 60) {
		 		fail("timeout");
		 		break;
		 	}else {	
		 	Thread.sleep(1000);
		 	if (sel.isElementPresent(str_Element));	{				
		 		break;
		 		}
		 	}
	    }
	}*/
 				   		  
		 		  
		 		  
		 /**
		   * This Utility function is used for wait condition for all AJAX elements.
		   * @param sel for the selenium object
		   * @param str_Element for the object properties to identify the object
		 */
/*		  		  public void fun_WaitForText(Selenium sel, String str_Element)throws InterruptedException{
		 	 			  
		 			for (int sec=0;; sec++){
		 		 				
		 				if (sec >= 60) 
		 		 		{
		 		 			fail("timeout");
		 		 			break;
		 		 		}
		 		 		else
		 		 			{	
		 		 				Thread.sleep(1000);
		 		 				if (sel.isTextPresent(str_Element));
		 		 				{					
		 		 					break;
		 		 					
		 		 				}
		 		 										
		 		 			}		
		 		 						
		 		 		}
		 		 	}*/
}
		  		  
	