package ExcelNew.MyFirstXl;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage
{
	static WebDriver driver;
	public static final String path="./data.properties";

	public static String getData(String key) throws Exception
	{
		
		File f = new File(path);
		FileInputStream fis= new FileInputStream(f); 
		Properties p= new Properties();
		p.load(fis);
		return p.getProperty(key);
		
	}
	public String randomNumber(int range) {
		Random r=new Random();
		if(range==5)
		{
			return String.valueOf(r.nextInt(90000)+10000);
			
		}else if(range==10)
		{
			return String.valueOf(r.nextInt(900000000)+100000000);
			
		}
		else return null;
	}
	public void selectOption(WebElement element,int option)
	{
		Select s=new Select(element);
		s.selectByIndex(option);
	}
    

	public static void waitForElement(WebElement element,int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	public static void browserSetup(String browsertype,String url)
	{
		if(browsertype.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\Chrome2.40.exe");
			driver=new ChromeDriver();
		}
		else if (browsertype.equalsIgnoreCase("internetExplorer"))
		{
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
		    driver=new InternetExplorerDriver();
		    
		  
		
		}
		else if (browsertype.equalsIgnoreCase("firefox"))
		{/*
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"C:\\Users\\MARS\\Desktop\\selinium drivers\\geckodriver.exe");
			File pathToBinary = new File("C:\\Users\\MARS\\Downloads\\firefox-46.0.1.win64.sdk\\firefox-sdk\\bin\\firefox.exe");
			FirefoxBinary Fb= new FirefoxBinary(pathToBinary);
			FirefoxProfile fireProfile=new FirefoxProfile();
			FirefoxDriver driverff=new FirefoxDriver(Fb,pathToBinary);
			driver=new FirefoxDriver();
			
			*/
	              
	}
     driver.get(url);
}
}
