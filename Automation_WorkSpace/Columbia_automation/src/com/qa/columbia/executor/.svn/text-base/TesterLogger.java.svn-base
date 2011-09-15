package com.qa.columbia.executor;

import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;
import java.util.*;

/**
 * This class is used for logging purpose. Not for use by end users as such.
 *
 */
public class TesterLogger{
    
  private final static Logger _m_successLogger = Logger.getLogger("logger.success");
  private final static Logger _m_failLogger = Logger.getLogger("logger.fail");
  private final static Logger _m_debugLogger = Logger.getLogger("logger.debug");
  private static int _m_failedCnt;
   
  private final static String _m_LogPrefix = "";
  private static TesterLogger _m_loggerInstance = null;


  private TesterLogger() {

	  
	  DOMConfigurator.configure(TesterConstants.LOG4J_CONFIG_FILE_NAME);
	  _m_failedCnt = 0;
  }

  public static TesterLogger getLoggerObject() {
    if (_m_loggerInstance == null) {
      _m_loggerInstance = new TesterLogger();
    }
    return _m_loggerInstance;

  }

  public void logDebug(String msg) {
    _m_debugLogger.debug(_m_LogPrefix + msg);
  }

  public void logFail(String msg) {
	  _m_failLogger.error(_m_LogPrefix + msg);
	  _m_failedCnt++;
  }

  public void logSuccess(String msg) {
	  _m_successLogger.info(_m_LogPrefix + msg);
  }
  
  
  public int getFailedCount() {
	  return _m_failedCnt;
  } 
  
  public String getFailedLogFileName() {
	  Appender appnd = null;
	  FileAppender fileAppend = null;
	  Enumeration appenders = _m_failLogger.getAllAppenders();
	  while (appenders.hasMoreElements()) {
		  appnd = (Appender) (appenders.nextElement());
		  if (appnd.getClass() == org.apache.log4j.FileAppender.class) {
			  fileAppend = (FileAppender) appnd;
			  break;
		  }
	  }
	  
	  
	  if (fileAppend != null) {
	  	  return fileAppend.getFile();
	  } else {
		  return "<File Name Not Found>";
	  }	  
  }
}
