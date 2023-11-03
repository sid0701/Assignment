package com.parabank.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	public static String getScreenshot(WebDriver driver, String testCaseName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "//Results//Screenshots//" + testCaseName + ".png";
		File dest = new File(screenshotPath);
		FileUtils.copyFile(src, dest);
		return screenshotPath;

	}
	
}
