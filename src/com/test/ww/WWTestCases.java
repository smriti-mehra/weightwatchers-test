package com.test.ww;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WWTestCases extends WWTestBase {

	String xpath;

	public WWTestCases() {
	this.resourceFileName ="ww_en_US.properties";
}

	@Test
	public void TestCase1_WebPageTitle()throws Exception{
		//load the url
		driver.get("https://www.weightwatchers.com/us/");
		//Verify load page title
		waitfor(500);
		AssertJUnit.assertEquals("Weight Loss Program, Recipes & Help | Weight Watchers", driver.getTitle());
	}
	
	@Test
	public void TestCase2_MeetingPageTitle()throws Exception{
		//Click on find a meeting
		xpath = getProperty("Find_A_Meeting_Link");
		click(xpath);
		//verify loaded page title
		waitfor(500);
		String url = driver.getCurrentUrl();
		WebElement title = driver.findElement(By.tagName("title"));
		System.out.println(title.getText());
		AssertJUnit.assertEquals("Find A Meeting: Get Schedules & Times Near You | Weight Watchers", driver.getTitle());
		
	}
	
	@Test
	public void TestCase3_LocationSearch()throws Exception{
		//type Search location 10001
		xpath = getProperty("Search_TextBox");
		sendkeys(xpath,"10001");
		//click search
		xpath = getProperty("Search_Button");
		click(xpath);
		//get the first result name & distance
		xpath = getProperty("Search_First_Location_Name");
		String searchname = driver.findElement(By.xpath(xpath)).getText();
		xpath = getProperty("Search_First_Location_Distance");
		String searchdist = driver.findElement(By.xpath(xpath)).getText();
		//verify location name and distance
		xpath = getProperty("Search_First_Location_Name");
		click(xpath);
		waitfor(500);
		xpath = getProperty("Search_page_Location_Text");
		String actualname = driver.findElement(By.xpath(xpath)).getText();
		AssertJUnit.assertEquals(searchname,actualname);
		
	}
	
	@Test
	public void TestCase4_Hours() throws Exception{
		Date now = new Date();
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
		String day = simpleDateformat.format(now);
		
		if(day.equalsIgnoreCase("Monday"))
		{
			xpath = getProperty("Monday_Hours");
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
		}
		else if(day.equalsIgnoreCase("Tuesday")){
			xpath = getProperty("Tuesday_Hours");
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
		}
		else if(day.equalsIgnoreCase("Wednesday")){
			xpath = getProperty("Wednesday_Hours");
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
		}
		else if(day.equalsIgnoreCase("Thursday")){
			xpath = getProperty("Thursday_Hours");
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
		}
		else if(day.equalsIgnoreCase("Friday")){
			xpath = getProperty("Friday_Hours");
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
		}
		else if(day.equalsIgnoreCase("Saturday")){
			xpath = getProperty("Saturday_Hours");
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
		}
		else if(day.equalsIgnoreCase("Sunday")){
			xpath = getProperty("Sunday_Hours");
			System.out.println(driver.findElement(By.xpath(xpath)).getText());
		}
	}
}
