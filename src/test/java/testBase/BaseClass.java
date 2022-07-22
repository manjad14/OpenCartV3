package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
 public WebDriver driver;
 public Logger logger;
 public ResourceBundle rb;
	
	@BeforeClass(groups= {"regression", "master", "sanity"})
	@Parameters({"Browser"})
	public void setUp(String br)
	{
		
		logger=LogManager.getLogger(this.getClass());
		rb=ResourceBundle.getBundle("config");
		
		if (br.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(br.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterClass(groups= {"regression", "master","sanity"})
	public void tearDown()
	{
		driver.close();
	}
	
	public String randomString()
	{
		String random_String=RandomStringUtils.randomAlphabetic(5);
		return random_String;
	}
	
	public int randomInt()
	{
		String random_Int=RandomStringUtils.randomNumeric(10);
		return (Integer.parseInt(random_Int));
	}
	
	public void captureScreen(WebDriver driver, String shotName) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+shotName+".png");
		FileUtils.copyFile(source, target);	
	}
	
}
