package ExcelNew.MyFirstXl;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Mylaunch {
	static WebDriver driver;
  
  @BeforeMethod
  public void setup() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.facebook.com");
            
     }
  @Test
  public void test() throws Exception {
	  excelAPI eapi=new excelAPI("C:\\Users\\MARS\\Desktop\\Mylaunch.xlsx");
	  int log=eapi.getRowcount("Login");

	  for(int i=1;i<log;i++)
      {
    	  driver.findElement(By.id("email")).clear();
    	  Thread.sleep(2000);
    	  driver.findElement(By.id("email")).sendKeys(eapi.getCellData("Login", "username", i));
    	  driver.findElement(By.id("pass")).clear();
    	  driver.findElement(By.id("pass")).sendKeys(eapi.getCellData("Login", "password",i));
    	  Thread.sleep(3000);
    	  
    	  //driver.findElement(By.xpath("//input[@id='u_0_8']")).click();
      }
  }
  
  @AfterMethod
  public void afterMethod() {
  }

}
