/*
 * This method is used to Place a call from the endpoint to RSS encoder.
 * @param sel selenium object that runs the selenium commands 
 * @throws Exception 
*/

package com.qa.columbia.functions.v6_0;


import java.text.MessageFormat;

import com.thoughtworks.selenium.*;
import com.qa.columbia.executor.*;
import com.qa.columbia.repository.v5_4.*;


public class PlaceCall_endpoint extends TesterAsserter{
	public static void PlaceCall_RSS2k(Selenium sel, String str_EncoderAddress) throws Exception 
	{	
		//Utility_Functions utilityFunction = new Utility_Functions();	
		//Open the end point URL in browser
		sel.open("/u_index2.htm");
		//Click on Place call menu
		sel.click(EnvObjectMap_Rep.lnk_endPointPlaceACall);
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		sel.selectFrame(EnvObjectMap_Rep.frame_endPointCall);
		sel.focus(EnvObjectMap_Rep.txt_endPointDialNumber);
		//Type the Encoder address
		sel.type(EnvObjectMap_Rep.txt_endPointDialNumber, str_EncoderAddress);
		//Click on Dial button
		sel.click(EnvObjectMap_Rep.img_endPointDial);
		//Wait for the page to load
		sel.waitForPageToLoad("30000");
		//assertTrue(" ","Verify that call is placed successfully.",sel.isElementPresent("hangupimage"));
}
	public static void PlaceCall_RSS4kv6(Selenium sel, String str_EncoderAddress, String str_VRRnumber, String str_endPoint) throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions();	
		//sel.open("http://"+str_endPoint+"/u_index2.htm");
		//Open the EndPoint URL
		sel.openWindow("http://"+str_endPoint+"/u_index2.htm", "a");
		sel.selectWindow("a");		
		for (int second = 0;; second++) {
			if (second >= 300) fail("timeout");
			try { if (sel.isElementPresent("main_0")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Click on Place call menu 
		sel.click(EnvObjectMap_Rep.lnk_endPointPlaceACall);
		
		for (int second = 0;; second++) {
			if (second >= 200) fail("timeout");
			try { if (sel.isElementPresent(EnvObjectMap_Rep.img_endPointDial)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//wait
		utilityFunction.waitForChangesToReflect();
		sel.selectFrame(EnvObjectMap_Rep.frame_endPointCall);
		sel.focus(EnvObjectMap_Rep.txt_endPointDialNumber);
		//Type the Encoder address (including VRR number)
		sel.type(EnvObjectMap_Rep.txt_endPointDialNumber, str_EncoderAddress+"##"+str_VRRnumber);
		//Click on Dial button
		sel.click(EnvObjectMap_Rep.img_endPointDial);
		//Wait for the page to load
		sel.waitForPageToLoad("40000");
		//Close the window
		sel.close();
		//assertTrue(" ","Verify that call is placed successfully.",sel.isElementPresent("hangupimage"));
}
	
public static void PlaceCall_RSS2k(Selenium sel, String str_EncoderAddress, String str_endPoint) throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions();	
		//sel.open("http://"+str_endPoint+"/u_index2.htm");
		//Open the EndPoint URL
		sel.openWindow("http://"+str_endPoint+"/u_index2.htm", "a");
		sel.selectWindow("a");	
		for (int second = 0;; second++) {
			if (second >= 500) fail("timeout");
			try { if (sel.isElementPresent(EnvObjectMap_Rep.lnk_endPointPlaceACall)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Click on Place call menu 
		sel.click(EnvObjectMap_Rep.lnk_endPointPlaceACall);
		
		for (int second = 0;; second++) {
			if (second >= 400) fail("timeout");
			try { if (sel.isElementPresent(EnvObjectMap_Rep.img_endPointDial)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		utilityFunction.waitForChangesToReflect();
		sel.selectFrame(EnvObjectMap_Rep.frame_endPointCall);
		sel.focus(EnvObjectMap_Rep.txt_endPointDialNumber);
		//Type the Encoder address
		sel.type(EnvObjectMap_Rep.txt_endPointDialNumber, str_EncoderAddress);
		//Click on Dial button
		sel.click(EnvObjectMap_Rep.img_endPointDial);
		//Wait for the page to load
		sel.waitForPageToLoad("50000");
		//Close the window
		sel.close();
		//assertTrue(" ","Verify that call is placed successfully.",sel.isElementPresent("hangupimage"));
}
	
	public static void HangCall_RSS4kv6(Selenium sel, String str_endPoint) throws Exception {
		Utility_Functions utilityFunction = new Utility_Functions();	
		//sel.open("http://"+str_endPoint+"/u_index2.htm");
		sel.openWindow("http://"+str_endPoint+"/u_index2.htm", "b");
		sel.selectWindow("b");
		
		for (int second = 0;; second++) {
			if (second >= 200) fail("timeout");
			try { if (sel.isElementPresent(EnvObjectMap_Rep.lnk_endPointPlaceACall)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Click on Place call menu 
		sel.click(EnvObjectMap_Rep.lnk_endPointPlaceACall);
		//sel.waitForPageToLoad("30000");
		utilityFunction.waitForChangesToReflect();
		for (int second = 0;; second++) {
			if (second >= 200) fail("timeout");
			try { if (sel.isElementPresent(EnvObjectMap_Rep.img_endPointHang)) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		sel.selectFrame(EnvObjectMap_Rep.frame_endPointCall);
		//Click on hang button
		sel.click(EnvObjectMap_Rep.img_endPointHang);
		//wait for teh page to load
		sel.waitForPageToLoad("80000");
		//wait
		utilityFunction.waitForChangesToReflect();
		Thread.sleep(3000);
		if(!sel.isElementPresent(EnvObjectMap_Rep.img_endPointDial))
		{
			sel.selectFrame(EnvObjectMap_Rep.frame_endPointCall);
			sel.click(EnvObjectMap_Rep.img_endPointHang);
			sel.waitForPageToLoad("80000");	
			utilityFunction.waitForChangesToReflect();
		}
		
		Thread.sleep(3000);
		//Close the window
		//sel.close();
		}
	public static int getCount_ArchiveRSS(Selenium sel, String str_RSSDEviceIP) throws Exception {
		
		Utility_Functions utilityFunction = new Utility_Functions();	
		sel.openWindow("http://"+str_RSSDEviceIP+"/login.php?lang=en&amp;lang_index=0", "c");
		sel.selectWindow("c");
		utilityFunction.waitForChangesToReflect();
		//sel.open("http://"+str_RSSDEviceIP+"/login.php?lang=en&amp;lang_index=0");
		sel.type(EnvObjectMap_Rep.txt_SourceDeviceUsername, "administrator");
		sel.type(EnvObjectMap_Rep.txt_SourceDevicePassword, "polycom");
		sel.click(EnvObjectMap_Rep.btn_SourceDeviceLogin);
		sel.waitForPageToLoad("30000");
		utilityFunction.waitForChangesToReflect();
		sel.click(EnvObjectMap_Rep.menu_SourceDeviceArchives);
		sel.click(EnvObjectMap_Rep.subMenu_SourceDeviceArchives);
		sel.waitForPopUp(EnvObjectMap_Rep.frame_SourceDeviceArchives, "30000");
		sel.selectFrame(EnvObjectMap_Rep.frame_SourceDeviceArchives);
		//String pageCount = sel.getText("//form[@id='archive_admin']/table[2]/tbody/tr/td[8]");
		sel.click(EnvObjectMap_Rep.lnk_SourceDeviceLastPageArchives);
		utilityFunction.waitForChangesToReflect();
		String pageCount = sel.getText(EnvObjectMap_Rep.lbl_SourceDeviceArchivesPageCount);
		System.out.println(pageCount);
		//int count1 = pageCount.lastIndexOf("/", 1);
		int count1 = pageCount.indexOf("/");
		System.out.println(count1);	
		String count = pageCount.substring(0, count1);
		System.out.println(count);
	    int aInt = Integer.parseInt(count);
		int a=0;
		int mediaCount = 0;
		for (int i = 2; i<50;i=i+1 )
		{
			;
	    	a = a+1;
	    	if (!sel.isElementPresent(MessageFormat.format(EnvObjectMap_Rep.chk_archiveMediaRSSsourceDevice, i)))
	    	{
	    		mediaCount = (aInt-1)*10+a;
	    		System.out.println(mediaCount);
              break;
	    	}   	
	    	
      }
		sel.close();
		return mediaCount;
	//	return mediaCount;
	}
	
	public static void StartRecording_RSS2k(Selenium sel, String str_RSSDEviceIP) throws Exception {
		Utility_Functions utilityFunction = new Utility_Functions();	
		sel.openWindow("http://"+str_RSSDEviceIP+"/login.php?lang=en&amp;lang_index=0", "d");
		sel.selectWindow("d");
		utilityFunction.waitForChangesToReflect();
		//sel.open("http://"+str_RSSDEviceIP+"/login.php?lang=en&amp;lang_index=0");
		sel.type(EnvObjectMap_Rep.txt_SourceDeviceUsername, "administrator");
		sel.type(EnvObjectMap_Rep.txt_SourceDevicePassword, "polycom");
		sel.click(EnvObjectMap_Rep.btn_SourceDeviceLogin);
		sel.waitForPageToLoad("30000");
		utilityFunction.waitForChangesToReflect();
		sel.selectFrame(EnvObjectMap_Rep.frame_SourceDeviceConnectedcall);
		utilityFunction.waitForChangesToReflect();
		if(!sel.isElementPresent(EnvObjectMap_Rep.btn_SourceDeviceStopRecording))
		{
			sel.click(EnvObjectMap_Rep.btn_SourceDeviceSartRecording);
		}

		for (int second = 0;; second++) {
		if (second >= 60) fail("timeout");
		try { if (sel.isElementPresent(EnvObjectMap_Rep.btn_SourceDeviceStopRecording)) break; } catch (Exception e) {}
		Thread.sleep(1000);
		}
		sel.close();
	}
	
}

