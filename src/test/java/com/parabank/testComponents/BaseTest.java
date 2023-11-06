package com.parabank.testComponents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {

	protected WebDriver driver;
	private static String browser;
	private static String url;

	public void setup() throws IOException {

		if (browser == null && url == null) {
			String jsonContent = new String(Files.readAllBytes(Paths
					.get(System.getProperty("user.dir") + "//src//test//java//com//parabank//resources//Data1.json")));
			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String, String>> data = objectMapper.readValue(jsonContent,
					new TypeReference<List<Map<String, String>>>() {
					});
			HashMap<String, String> hm = (HashMap<String, String>) data.get(0);
			browser = hm.get("browser");
			url = hm.get("url");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

 		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}

	@BeforeMethod(alwaysRun = true)
	public void launchApplication(ITestContext context) throws IOException {
		setup();
		context.setAttribute("driver", driver);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
