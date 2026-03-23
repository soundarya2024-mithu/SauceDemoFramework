package com.automation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.base.BaseTest;
import com.automation.utilities.Screenshot;
import com.relevantcodes.extentreports.LogStatus;

public class Listeners extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		test=report.startTest(result.getName().toUpperCase());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS ");
		report.endTest(test);
		report.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Screenshot.captureScreenshot();
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" FAIL ");
		test.log(LogStatus.FAIL, test.addScreenCapture(Screenshot.path));
		report.endTest(test);
		report.flush();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}


}
