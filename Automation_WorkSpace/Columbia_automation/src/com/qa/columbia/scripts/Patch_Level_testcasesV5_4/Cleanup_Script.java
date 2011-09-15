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
package com.qa.columbia.scripts.Patch_Level_testcasesV5_4;


import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.*;
import java.io.*;

public class Cleanup_Script extends TesterAsserter  {
	
static Date date=Calendar.getInstance().getTime();
public void test_ApacheTomcatService_Startup() throws Exception {	
    	//System.out.println(System.getProperty("user.name"));
    	//System.out.println(System.getProperty("user.home"));
    	//System.out.println(System.getProperty("user.dir"));
     // 	System.out.println(fileOrDir.getPath()); }

	String filepath=System.getProperty("user.home")+"/Local Settings/Temp/";
final File dir = new File(filepath);
		//String[] list =dir.list();
		 File[] files = dir.listFiles();
		//if (list == null)
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
      	             // System.out.println(filename);
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
		                  // TODO: Performance: Implement this as a queue where you add to
		                  // the end and take from the beginning, it will be more efficient
		                  // than the recursion
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
   
      	
     // It is also possible to filter the list of returned files.
     // This example does not return any files that start with `.'.
     /*FilenameFilter filter = new FilenameFilter() {
         public boolean accept(File dir, String name) {
             return name.startsWith("customProfileDir");
             
         }
     };
     list = dir.list(filter);

     // The list of files can also be retrieved as File objects
     File[] files = dir.listFiles();

     // This filter only returns directories
       FileFilter fileFilter = new FileFilter() {
         public boolean accept(File file) {
             return file.isDirectory();
             
         }
     };
     files = dir.listFiles(fileFilter);*/
		
 	  /*   public static boolean recursiveDelete(File fileOrDir) throws Exception {
      {
    	  
         	
      
      
      	//Runtime.getRuntime().exec(System.getProperty("user.home")+"\\Local Settings"+"\\temp");
      /*	Runtime.getRuntime().exec("cmd /c start %temp%");
      	
      	
      	/***
      	  * Recursively delete file or directory
      	 * @param fileOrDir
      	 *          the file or dir to delete
      	 * @return
      	 *          true iff all files are successfully deleted
      	 */
 
      	
      	  /*  if(fileOrDir.isDirectory())
      	    {
      	        // recursively delete contents
      	        for(File innerFile: fileOrDir.listFiles())
      	        {
      	           if(!FileUtilities.recursiveDelete(innerFile))
      	            {
      	                return false;
      	            }
      	       }
      	    }

      	   return fileOrDir.delete();
     	}*/
   
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	
      	/* Process servstate2=null;
	Process serv_state= null; 
	String line2,lineval=null;
	
    try {
		Utility_Functions utilityFunction = new Utility_Functions(); 
		String global_path ="Global_variables.xml";
		
		String Var_TomcatServiceName= utilityFunction.GetValue(global_path,"VAR_TomcatServiceName");
		String Var_Service_Status="cmd.exe /c sc query " + Var_TomcatServiceName;
		String Var_Service_Start= "cmd.exe /c sc start " + Var_TomcatServiceName;
		
		//verify the service is already running
		
		servstate2=Runtime.getRuntime().exec(Var_Service_Status);
		BufferedReader input2 = new BufferedReader(new InputStreamReader(servstate2.getInputStream()));
		while ((line2 = input2.readLine()) != null) {
			   lineval= line2+lineval;  }
		//Start the service if it not already running
		  try{ if(!lineval.contains("RUNNING")){
			
		     Runtime.getRuntime().exec(Var_Service_Start);
		     System.out.print("Tomcat Service has been started");
		     utilityFunction.waitForChangesToReflect();	
		     
		     // verify the status of service after starting
		     serv_state=Runtime.getRuntime().exec(Var_Service_Status);
		     BufferedReader input_verify = new BufferedReader(new InputStreamReader(serv_state.getInputStream()));
		     String checkstate=null;
		       while ((line2 = input_verify.readLine()) != null) {
		           // comment below statement to hide the service state details
		           System.out.println(line2); //<-- Parse data here.
		            checkstate= line2+ checkstate;     }
			       if  (checkstate.contains("RUNNING")){
			    	  // System.out.println("**************************************");
			           //System.out.print("Tomcat Service is running successfully");
			       assertTrue("TCXX","Verify that Tomcat service is running Successfully", date, checkstate.contains("RUNNING"));    
			       }
			       else {
			    	   // System.out.print("Tomcat Service failed to run successfully");
			    	    assertFalse("TCXX","Verify that Tomcat service failed to run Successfully", date, checkstate.contains("RUNNING"));
			           }
                    input2.close();
                    input_verify.close();
               }else{  	          
		    	 assertTrue("TCXX","Verify that Tomcat service is running Successfully", date, lineval.contains("RUNNING"));      
		    	 //System.out.print("Tomcat Service is already running successfully");
		    	 }
		   }catch (IOException e) {
			     // throw  the exception in case the service is not started due to any reason
			    System.out.println("There has encountered a problem in starting the service");
			    System.out.println(e.toString());
			 }
	 }catch(Exception err){
		err.printStackTrace(); }
	finally  {
		servstate2.exitValue();
		servstate2.destroy();
	  //serv_state.destroy();
	  //serv_state.exitValue();
			    	   
		  }*/
			     
   
 

			       
			
		
	
	
