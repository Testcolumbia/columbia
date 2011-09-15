/*
*  Classname                                                       TomcatService_Startup 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Ensure the Apache Tomcat is installed.<br>
* What the script does:											    >Start up the apache tomcat service. 
* 																	
* What Verification it performs:									Verify that 'Tomcat service is started successfully.<br> 
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
* Created by/on date: 											    QASource on 15/06/2011
* Updated by/on date: 												QASource on 15/06/2011
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.Patch_Level_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.*;
import java.io.*;

public class Cleanup_Script extends TesterAsserter  {
	
static Date date=Calendar.getInstance().getTime();
public void test_ApacheTomcatService_Startup() throws Exception {	

	String filepath=System.getProperty("user.home")+"/Local Settings/Temp/";
       final File dir = new File(filepath);

		 File[] files = dir.listFiles();

		 if (files==null){
      	    // Either dir does not exist or is not a directory
      	} else {
      	    for (int i=0; i<files.length; i++) {
      	        // Get filename of file or directory
      	        File filename = files[i];
      	        if((filename.isDirectory())& (filename.getName().contains("customProfileDir"))){
      	        	System.out.println(filename.isDirectory());
      	        	System.out.println(filename);
      	        	     	        	
      	        boolean s =deleteDirectoryContent(filename);
      	        	System.out.println(s);
       	        	filename.delete();
      	        	      	        
      	        }else{
      	             System.out.println(filename);
      	        }
      	        	
      	        }
      	}}
	public static boolean deleteDirectoryContent(File fDir)
		   {
		      boolean bRetval = false;

		      if (fDir != null && fDir.isDirectory()) 
		      {
		         File[] files = fDir.listFiles();
		   
		         if (files != null)
		         {
		            bRetval = true;
		            boolean dirDeleted;
		            
		            for (int index = 0; index < files.length; index++)
		            {
		               if (files[index].isDirectory())
		               {

		                  dirDeleted = deleteDirectoryContent(files[index]);
		                  if (dirDeleted)
		                  {
		                     bRetval = bRetval && files[index].delete();
		                  }
		                  else
		                  {
		                     bRetval = false;
		                  }
		               }
		               else
		               {
		                  bRetval = bRetval && files[index].delete();
		               }
		            }
		         }
		      }

		      return bRetval;
		   }	 
		 
		 
      	      
  }
   
  
