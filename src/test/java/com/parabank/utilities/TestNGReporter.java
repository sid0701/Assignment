package com.parabank.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNGReporter {

	public static ExtentReports getReporterObject() {
		ExtentSparkReporter esp = new ExtentSparkReporter(System.getProperty("user.dir")+ "//Results//index.html");
		ExtentReports er = new ExtentReports();
		er.attachReporter(esp);
		return er;
	}

	
}
