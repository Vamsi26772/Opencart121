package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;	
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
		
		// loading config.properties
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		
		
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			// os
			
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				
				System.out.println("no matching os");
				return;
			}
			
			switch(br.toLowerCase()) {
			
			case "chrome": capabilities.setBrowserName("chrome");
			break;
			case "edge": capabilities.setBrowserName("edge");
			break;
			default: System.out.println("no matching browser");
			return;
			}
			
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			switch(br.toLowerCase()) {
			
			case "chrome": driver= new ChromeDriver();
			              break;
			case "edge": driver = new EdgeDriver();
		    default: System.out.println("invalid browser name");
		           return;   // if browser name is invalid then it will exit from the execution , so we are using return
			}
			
		}	
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown() {
		
	}
	
	// generating new email everytime
		public String randomString() {
			
			String random=RandomStringUtils.randomAlphabetic(5);  // randomNumeric() -->to generate numbers 
			return random;
		}
		
		public String captureScreen(String tname) throws IOException{
			
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
			File sourcefile=takesscreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetfilepath= System.getProperty("user.dir")+"\\screenshots\\"+ tname +" _"+timeStamp +".png";
					File targetfile = new File(targetfilepath);
			
			sourcefile.renameTo(targetfile);
			return targetfilepath;
		}

}
