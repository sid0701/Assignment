package com.parabank.testComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parabank.utilities.Screenshots;
import com.parabank.utilities.TestNGReporter;


public class Listener implements ITestListener {

	ExtentTest test;
	ExtentReports er = TestNGReporter.getReporterObject();
	ThreadLocal<ExtentTest> tl = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		test = er.createTest(result.getMethod().getMethodName());
		tl.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tl.get().log(Status.PASS, "Test Case Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		tl.get().fail(result.getThrowable());

		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");

		String screenshotPath = null;
		try {
			screenshotPath = Screenshots.getScreenshot(driver, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tl.get().addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		er.flush();
	}

}
