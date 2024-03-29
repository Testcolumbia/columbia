/**
 * This class contains the Utility functions.
 *  
 */

package com.qa.columbia.functions.v5_3;		

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.Random;
import com.thoughtworks.selenium.Selenium;
import com.qa.columbia.executor.TesterAsserter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Utility_Functions extends TesterAsserter{

	String str_Data1=null;  
	Random _m_rand = new Random();
	//This Utility functions is used to get data from the XML file.
	
	public void waitForElementToPresent(Selenium sel,String str_ElementName, int int_Time) throws Exception
	{
		for (int second = 0;; second++) {
			if (second >= int_Time) fail("timeout");
			try { if (sel.isElementPresent(str_ElementName)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	public void waitForElementToVisible(Selenium sel,String str_ElementName, int int_Time) throws Exception
	{
		for (int second = 0;; second++) {
			if (second >= int_Time) fail("timeout");
			try { if (sel.isVisible(str_ElementName)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	public void waitForTextToPresent(Selenium sel,String str_Text, int int_Time) throws Exception
	{
		for (int second = 0;; second++) {
			if (second >= int_Time) fail("timeout");
			try { if (sel.isTextPresent(str_Text)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
	}
	
	public String GetValue(String str_path ,String str_value )throws Exception {
		
       DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	   DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	   Document doc = docBuilder.parse(new File("E:\\Automation_WorkSpace\\Columbia_automation\\src\\com\\qa\\columbia\\testdata\\v5_3\\"+ str_path));
	   doc.getDocumentElement ().normalize ();
	   NodeList var = doc.getElementsByTagName(str_value);
	   String First2 = var.item(0).getTextContent();
	   return First2;
	}
	
	//This Utility functions is used to set the test data to excel sheet
	  
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
	
	public String getRandomNumber() {
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
	
	public void fun_WaitForElement(Selenium sel, String str_Element) throws InterruptedException{
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
	}
		 		  
		  
	public void waitForChangesToReflect() {
		 // wait for 20 seconds
	   try {
		   Thread.sleep(20000);
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
		 		  
		 		  
		 /**
		   * This Utility function is used for wait condition for all AJAX elements.
		   * @param sel for the selenium object
		   * @param str_Element for the object properties to identify the object
		 */
		  		  public void fun_WaitForText(Selenium sel, String str_Element)throws InterruptedException{
		 	 			  
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
		 		 	}
		  		  
		  		 
		  		   
		        

}
		  		  
	