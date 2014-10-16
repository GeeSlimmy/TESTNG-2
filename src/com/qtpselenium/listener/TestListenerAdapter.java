package com.qtpselenium.listener;

import java.util.List;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.qtpselenium.util.ErrorUtil;

public class TestListenerAdapter implements IInvokedMethodListener {
	
	public void afterInvocation(IInvokedMethod method, ITestResult result){
	  Reporter.setCurrentTestResult(result);
	//System.out.println("************* TestListenerAdapter *****************");
	
	if (method.isTestMethod()){
		List<Throwable> verificationFailures = ErrorUtil.getVerificationFailures();
				// if there are verification failures..
				if (verificationFailures.size() !=0){
					// set the test to failed
					result.setStatus(ITestResult.FAILURE);
					
					// if there is an assertion failure
					if (result.getThrowable() != null){
						verificationFailures.add(result.getThrowable());
					}
					
					int size = verificationFailures.size();
					// if there's only one failure just set that
					if (size == 1) {
						result.setThrowable(verificationFailures.get(0));
					}else {
						
					}
					
					StringBuffer failureMessage = new StringBuffer("Multiple failure (").append(size).append("):nn");
							for(int i = 0; i < size-1; i++){
								failureMessage.append("Failure").append(i+1).append(" of ").append(size).append(":n");
								
							}
							}
				}
	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		
	}

}
