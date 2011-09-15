/*
* Class name                                                        Deploy_warfiles 
*
* Version info
*
* Copyright notice
*
* Test Case reference:												Deploy the war file on Qumu  directory.<br>
* What the script does:											    >Navigate to Hudson<br> 
* 																	>Get the path of build files.<br> 															
* 																	>Pass the path to build.xml file<br>						
* 										                            >Download the files and place the file in Qumu/Deploy folder<br>
*																															
* What script(s) should be run before this script:					N/A <br>
* What script(s) should be run after this script:					N/A <br>
*
*   ******************************************************************* <br>
* Before running the test, please ensure that your Selenium Remote Server
* is up and running. Server can be started using the java -jar selenium-server.jar<br>
*/
package com.qa.columbia.scripts.BuildAcceptance_testcasesV6_0;

import java.util.Calendar;
import java.util.Date;
import com.qa.columbia.executor.*;
import com.qa.columbia.functions.v6_0.GetBuildPath;
import com.qa.columbia.functions.v6_0.Utility_Functions;


//import java.io.*;

public class Deploy_warfiles_local_TCID extends TesterAsserter  {
	
	static Date date=Calendar.getInstance().getTime();
	
	public void test_Deploy_warfiles() throws Exception {
    {

    try {
		setUp();
		Utility_Functions utilityFunction = new Utility_Functions(); 
		//Global Variables file
		String globalVariableFile ="Global_variables.xml";
		//Domain name
		String Var_BuildNumber = utilityFunction.GetValue(globalVariableFile, "Var_BuildNumber");
    	String APbuildURL = GetBuildPath.cb_adminportalPath(selenium, Var_BuildNumber);
    	String VPbuildURL = GetBuildPath.cb_viewerportalPath(selenium, Var_BuildNumber);
    	String SPbuildURL = GetBuildPath.cb_serviceportalPath(selenium, Var_BuildNumber);
    	System.out.println(APbuildURL);
    	System.out.println(VPbuildURL);
    	System.out.println(SPbuildURL);
    	utilityFunction.waitForChangesToReflect();
		//String buildURL = "http://10.1.199.64:8080/hudson/job/vcc-all-continuous-600/44/com.mpi$adminportal/artifact/com.mpi/adminportal/5.5-20110617.035119-1554/adminportal.war";
    	Runtime.getRuntime().exec("cmd /c start ant adminportal -DbuildURL="+APbuildURL);
		utilityFunction.waitForChangesToReflect();
    	//Runtime.getRuntime().exec("cmd /c start ant -DbuildURL=http://10.1.199.64:8080/hudson/job/vcc-all-continuous-600/44/com.mpi$adminportal/artifact/com.mpi/adminportal/5.5-20110617.035119-1554/adminportal.war");
    	Runtime.getRuntime().exec("cmd /c start ant viewerportal -DbuildURL="+VPbuildURL);
    	utilityFunction.waitForChangesToReflect();
   	    Runtime.getRuntime().exec("cmd /c start ant serviceportal -DbuildURL="+SPbuildURL);
       	utilityFunction.waitForChangesToReflect();
    	utilityFunction.waitForChangesToReflect();
    	utilityFunction.waitForChangesToReflect();
    	utilityFunction.waitForChangesToReflect();
    	utilityFunction.waitForChangesToReflect();
    	utilityFunction.waitForChangesToReflect();
    	//******************************* deploy the war files on remote machine******************************* \\
        Runtime.getRuntime().exec("cmd /c start ant DeployWarfiles");
    }
    catch(Exception e)
    {
    	System.out.println("Exception");
    	
    }
    }
	}
}
		
		
		
		/*
		
		
		
		runANT = Runtime.getRuntime().exec("E:"+"\\")
		while ((line2 = input2.readLine()) != null) {
			   lineval= line2+lineval;  }
		//Start the service if it not already running
		  try{ if(!lineval.contains("RUNNING")){
		     p2 = Runtime.getRuntime().exec("cmd /c sc start Tomcat5");
		     System.out.print("Tomcat Service has been started");
		     utilityFunction.waitForChangesToReflect();			        
		     // verify the status of service after starting
		     serv_state=Runtime.getRuntime().exec("cmd /c sc query Tomcat5");
		     BufferedReader input_verify = new BufferedReader(new InputStreamReader(serv_state.getInputStream()));
		     String checkstate=null;
		       while ((line2 = input_verify.readLine()) != null) {
		           // comment below statement to hide the servcie state details
		           //System.out.println(line2); //<-- Parse data here.
		            checkstate= line2+ checkstate;     }
			       if  (checkstate.contains("RUNNING")){
			           System.out.print("Tomcat Service is running successfully");}
			       else {
			    	    System.out.print("Tomcat Service is running successfully");
			            serv_state.destroy();
			            serv_state.exitValue();}
               input2.close();}
		     else{  	          
		         System.out.print("Tomcat Service is already running successfully");}
		   }catch (IOException e) {
			     // throw  the exception in case the service is not started due to any reason
			    System.out.println(" There has encountered a problem in starting the service");
			    System.out.println(e.toString());
			    servstate2.exitValue();
			    servstate2.destroy();}
	 }catch(Exception err){
		err.printStackTrace(); }
	finally  {
	  servstate2.destroy();
	  serv_state.destroy();
	  serv_state.exitValue();
	  p2.destroy();
	  p2.exitValue();
			    	   
		  }
*/	
		
	
	
