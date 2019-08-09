package enh.web.tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.CustomListeners;
import listeners.ExecutionStartEndListner;
import enh.web.pages.CRMlogin;
import enh.web.pages.CreateSalesorder;
import enh.web.pages.HomePage;
import utilities.GlobalUtil;
import utilities.HtmlReportUtil;
import utilities.KeywordUtil;

@Listeners({CustomListeners.class,ExecutionStartEndListner.class})
public class CRM_TC_090 extends KeywordUtil{
	String stepInfo="";
	int retryCount=getIntValue("retryCount");
	static int retryingNumber=1;

	@Test(
			testName="CRM_TC_090",
			groups={"Sales Suite"}, 
			description="Create sales order"
			)
	public void test() throws Throwable {
		try{
			setTestCaseID(getClass().getSimpleName());
			//======================BASIC SETTING FOR TEST==========================================================
			if(retryingNumber==1)
				initTest();						
			//.........Script Start...........................
			WebDriver dr=KeywordUtil.getDriver();
			
			stepInfo="Open home page";
			logStep(stepInfo);
			HomePage.openHomePage();
			System.out.println("driver = " +KeywordUtil.getDriver());
			dr.findElement(By.name("user_name")).sendKeys("admin");
			dr.findElement(By.name("user_password")).sendKeys("password");
			dr.findElement(By.id("submitButton")).click();
			logStep("User logged into Application");
			Thread.sleep(3000);
			Actions builder = new Actions(dr);			
			builder.moveToElement(dr.findElement(By.xpath("html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[22]/a"))).build().perform();
			builder.moveToElement(dr.findElement(By.name("Sales Order"))).build().perform();
			dr.findElement(By.name("Sales Order")).click();
			logStep("Creating Sales Order");
			Thread.sleep(3000);
			dr.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
			dr.findElement(By.name("subject")).sendKeys("Dell Machine");
			dr.findElement(By.id("customerno")).sendKeys("0984521254");
			dr.findElement(By.name("sostatus")).sendKeys("Approved");
			dr.findElement(By.xpath("//*[@id='frmEditView']/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[9]/td[4]/img")).click();;
			ArrayList<String> newTab1 = new ArrayList<String>(dr.getWindowHandles());
            dr.switchTo().window(newTab1.get(1));
			dr.findElement(By.xpath("//a[@id='1']")).click();
			dr.switchTo().alert().accept();
			Thread.sleep(2000);
			dr.switchTo().window(newTab1.get(0));
			dr.findElement(By.name("bill_street")).sendKeys("Lanco hills");
			dr.findElement(By.name("ship_street")).sendKeys("Hyderabad");
			dr.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Automation");
			dr.findElement(By.xpath("//img[@id='searchIcon1']")).click();
			Thread.sleep(2000);
			ArrayList<String> newTab = new ArrayList<String>(dr.getWindowHandles());
            dr.switchTo().window(newTab.get(1));
            Thread.sleep(2000); 
			dr.findElement(By.xpath("//input[@name='selected_id']")).click();			
			dr.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			Thread.sleep(2000);
			dr.switchTo().window(newTab.get(0));
			dr.findElement(By.id("qty1")).sendKeys("5");
			dr.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			Thread.sleep(2000);
			dr.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
			Thread.sleep(3000);
			logStep("Sales order Verification is sucessfull");
			builder.moveToElement(dr.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
			builder.moveToElement(dr.findElement(By.xpath("//a[contains(.,'Sign Out')]"))).build().perform();
			dr.findElement(By.xpath("//a[contains(.,'Sign Out')]")).click();
			logStep("User logged out sucessfully");
							
			//.........Script Start...........................
		}
		catch (Exception e){
			   if(retryCount>0)
			   {
				   String imagePath = takeScreenshot(getDriver(), getTestCaseID()+"_"+ retryingNumber);

				   logStepFail(stepInfo+" - "+KeywordUtil.lastAction);
				   logStepError(e.getMessage());
				   HtmlReportUtil.attachScreenshot(imagePath,false);
			    
				   GlobalUtil.getTestResult().setScreenshotref(imagePath);
			    
				   HtmlReportUtil.stepInfo("Trying to Rerun" + " "+getTestCaseID() +" for " + retryingNumber + " time");
				   retryCount--;
				   retryingNumber++;
				   utilities.LogUtil.infoLog(getClass(), "****************Waiting for " + getIntValue("retryDelayTime") +" Secs before retrying.***********");
				   delay(getIntValue("retryDelayTime"));
			    //Rerun same test
				   test();
			   }
			   else{
				   String imagePath = takeScreenshot(getDriver(), getTestCaseID());
				   logStepFail(stepInfo+" - "+KeywordUtil.lastAction);
				   logStepError(e.getMessage());
				   HtmlReportUtil.attachScreenshot(imagePath,false);
			    
				   GlobalUtil.getTestResult().setScreenshotref(imagePath);
				   GlobalUtil.setTestException(e);
				   throw e;
			   }
		  }
}//End Test
	
	
	
}
