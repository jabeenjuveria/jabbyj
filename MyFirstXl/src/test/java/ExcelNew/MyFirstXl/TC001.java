package ExcelNew.MyFirstXl;

import org.testng.annotations.Test;

import ExcelNew.MyFirstXl.UIactions.LoginPageUI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TC001 extends BasePage{
    LoginPageUI page;
  @BeforeMethod
  @Parameters("browser")
  public void startProcess() throws Exception {
	  browserSetup("chrome",getData("url"));
	  
  }

  
  
  @Test
  public void customerRegistration() throws Exception {
	  page=new LoginPageUI(driver);
	  page.customerRegistration();
	  
	  
  }
  
  @AfterMethod
  public void endProcess() {
  }

}
