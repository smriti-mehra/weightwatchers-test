package com.test.ww;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * @author smehra
 *
 */
public class WWTestBase {
	WebDriver driver;
	public String baseUrl = "";
	protected String resourceFileName;
	
	File scrFile = new File("");
	public String browser;
	static FileInputStream in;
	public String url, folder;
	String source;
	DateFormat dateFormat = new SimpleDateFormat("yyMMdd-hhmm");
	String today =  dateFormat.format(new Date(0));
	
	@BeforeClass
	@Parameters({"browser-name","url-name"})
	public void setup(String browser, String url)throws Exception{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\dchawla\\workspace\\ENSO_Test\\lib\\geckodriver.exe");
		if(browser.equalsIgnoreCase("FF")){
			System.out.println("Firefox Browser is used");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}//driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("IE")){
			System.out.println("IE Browser is used");
			System.setProperty("webdriver.ie.driver", "browsers\\IEDriverServer.exe");
			DesiredCapabilities capabilities =DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver = new InternetExplorerDriver(capabilities);
		}
		else{
			System.out.println("Chrome Browser is used");
			System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("test-type");
		    capabilities.setCapability("chrome.binary","<<your chrome path>>");
		    capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		    driver = new ChromeDriver(capabilities);
			//System.setProperty("webdriver.chrome.driver", "browsers\\chromedriver.exe");
			//driver = new ChromeDriver();
		}
		driver.get(baseUrl+url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Creating a screenshot Directory for current run");
		String working = System.getProperty("user.dir");
		url = working+File.separator+"Screenshots"+File.separator;
		//url ="C:\\Users\\smriti.mehra\\workspace\\SalesforceTestNG\\Screenshots\\";
		
		folder = url + "FailureScreenShots"+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime());
        File dir = new File(folder);
        dir.mkdir();
		
	}
	public String getProperty(String property){
		
	       String xpath;
	       String working = System.getProperty("user.dir");  
	       File file = new File(working+File.separator+"Resources"+File.separator+resourceFileName);
	       //File file = new File("C:"+File.separator+"Users"+File.separator+"smriti.mehra"+File.separator+"workspace"+File.separator+"ConnectTestNGProject"+File.separator+"Resources"+File.separator+resourceFileName);
	       Properties properties = new Properties();
	       FileInputStream in;
		     try {
	           in = new FileInputStream(file);
	           try {
	                 properties.load(in);
		           } catch (IOException e) {
	                 e.printStackTrace();
		           }
		     } catch (FileNotFoundException e) {
		    	 System.out.println("Unable to locate the file path specified. Please check the file path.");
		     }
		     xpath = properties.getProperty(property);
		     //System.out.println("XPATH is :"+xpath);
		     if(xpath == null)
		       {
		    	 System.out.println("XPATH not found for: " + property);
		    	 //throw new Exception("problem getting xpath for property: " + property);
		       }
		     return xpath;
		}
	
	//wait action for a few seconds
 	public void waitfor(int number) throws Exception
 	{
 		Thread.sleep(number);
 	}
 	//click action is performed
 	public void click(String xpath)
 	{
 		driver.findElement(By.xpath(xpath)).click();
 	}
 	//user input action will be performed
 	public void sendkeys(String xpath, String input)
 	{
 		driver.findElement(By.xpath(xpath)).sendKeys(input);
 	}
 	


}

