	 package com.qa.columbia.executor;

import java.util.Calendar;
import java.util.Date;
	
/**
 * This class is the base executor class for scripts in the package "com.qa.columbia.scripts".
 * 
 */

public class TesterRunner {
	public static Calendar calendar = null;
	public static Date date = null;
	public static int cntFail = 0;
	public static int cntSuccess = 0;

  protected TesterRunner() {
  }

  /**	 
   * Static block which contai	ns the header of the HTML report which would be generated after the test or batch run
   */
  static{
				
	  // 	Variable for the start date 
	  calendar = Calendar.getInstance();
	  date = calendar.getTime();
	  
	  // 	Header for the success file
	  TesterLogger.getLoggerObject().logSuccess("<title>V6.0_patch 38_MSSQL2008_Patch Level Testcases Execution Report</title>") ;
	  TesterLogger.getLoggerObject().logSuccess("<head><u><h1 align='center'>Columbia Automation Test Suite Report</h1></u></head>");
	  TesterLogger.getLoggerObject().logSuccess("<table border='0' width='100%' height='47'>");
	  TesterLogger.getLoggerObject().logSuccess("<tr>");
	  TesterLogger.getLoggerObject().logSuccess("</tr>");
	  TesterLogger.getLoggerObject().logSuccess("<BR>");
	  TesterLogger.getLoggerObject().logSuccess("<tr>");
	  TesterLogger.getLoggerObject().logSuccess("<td width='25%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Garamond'>Test Script Name</font></b></td>");
	  TesterLogger.getLoggerObject().logSuccess("<td width='35%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Garamond'>Test Case Description</font></b></td>");
	  TesterLogger.getLoggerObject().logSuccess("<td width='10%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Garamond'>Result</font></b></td>");
	  TesterLogger.getLoggerObject().logSuccess("<td width='15%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Garamond'>Start Time</font></b></td>");
	  TesterLogger.getLoggerObject().logSuccess("<td width='15%' bgcolor='#CCCCFF' align='center'><b><font color='#000000' face='Garamond'>End Time</font></b></td>");
	  TesterLogger.getLoggerObject().logSuccess("</tr>");
	  TesterLogger.getLoggerObject().logSuccess("</table>");
	
	}

  /**
   * This method calls the test suite in the T	esterSuite class
   *
   */
  public static void runTest(){
	  
	  int ranMethods = 0;
	  TesterUtilities utils= new TesterUtilities();
	  
	  //	Get the time before execution starts
	  long start = System.currentTimeMillis();
	
	  //	Execute test suite
	  ranMethods = TesterSuite.runTestSuite();
	  
	  //	Log for the success file
	  TesterLogger.getLoggerObject().logSuccess("<font color='#330066' face='Garamond'><BR> Start Time:'"+date+"'. </font><BR>");
	  TesterLogger.getLoggerObject().logSuccess("<font color='#330066' face='Garamond'>Elapsed Time for running the entire test suite = " + (utils.getElapsedTimeString(System.currentTimeMillis() - start))+"</font><BR>");
	  TesterLogger.getLoggerObject().logSuccess("<font color='#0000FF' face='Garamond'>Total number of tester scripts launched = '" + ranMethods+"'. </font><BR>");
	  TesterLogger.getLoggerObject().logSuccess("<font color='#00C000' face='Garamond'>Total number of test cases passed = '" + cntSuccess+"'. </font><BR>");
	  TesterLogger.getLoggerObject().logSuccess("<font color='#FF0000' face='Garamond'>Total number of test cases failed = '" + cntFail+"'. </font><BR>");
	  TesterLogger.getLoggerObject().logSuccess("<font color='#330066' face='Garamond'> End Time:'"+Calendar.getInstance().getTime()+"'. </font><BR>");
	  TesterLogger.getLoggerObject().logSuccess("<font color='#330066' face='Garamond'> Selenium Test Suite Ended. </font><BR>");
	  TesterLogger.getLoggerObject().logSuccess("<font color='#330066' face='Garamond'><b2>Note:</b2> Please check the fail log file to see in case there are any failures. This is in case there are failures other than the assertions used.(like failures due to application, timeout etc.'. </font><BR>");
	  TesterLogger.getLoggerObject().logSuccess("===========================================================================================================" );
  }

  /**
   * Main method which will executes the scripts 
   */
  public static void main(String args[]) {
  	 //	Call runtest which executes the test suite
	runTest();	 
	 
	
	 
  }



}
