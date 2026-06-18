package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter=0;
	int retrylimit=2;  //count of how many times we want to re-execute
	public boolean retry(ITestResult result) {   //for fetching the result
		
		if(counter<retrylimit) {
			counter++;
			return true;  //re-execute 
		}
		return false;   //stops execution
	}

}
