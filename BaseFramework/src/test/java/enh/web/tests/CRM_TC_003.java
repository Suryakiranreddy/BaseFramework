package enh.web.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import enh.web.pages.HomePage;
import listeners.CustomListeners;
import listeners.ExecutionStartEndListner;
import utilities.GlobalUtil;
import utilities.HtmlReportUtil;
import utilities.KeywordUtil;

@Listeners({CustomListeners.class,ExecutionStartEndListner.class})
public class CRM_TC_003 extends KeywordUtil{
	String stepInfo="";
	int retryCount=getIntValue("retryCount");
	static int retryingNumber=1;

	@Test(
			testName="CRM_TC_003",
			groups={"Smoke"}, 
			description="Home Page UI And Links Sanity Check"
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
			Thread.sleep(3000);
			logStep("User logged into Application");	
			
			String actualText = dr.findElement(By.xpath("//a[contains(.,'Calendar')]")).getText();
			String expectedText = "Calendar";
			Assert.assertTrue(actualText.contains(expectedText));
			logStep("Calender Menu is displayed sucessfully");
	
			String actualText1 = dr.findElement(By.xpath("//a[contains(.,'Leads')]")).getText();
			String expectedText1 = "Leads";
			Assert.assertTrue(actualText1.contains(expectedText1));
			logStep("Leads Menu is displayed sucessfully");
			
			String actualText2 = dr.findElement(By.xpath("//a[contains(.,'Organizations')]")).getText();
			String expectedText2 = "Organizations";
			Assert.assertTrue(actualText2.contains(expectedText2));
			logStep("Organizations Menu is displayed sucessfully");
			
			String actualText3 = dr.findElement(By.xpath("//a[contains(.,'Contacts')]")).getText();
			String expectedText3 = "Contacts";
			Assert.assertTrue(actualText3.contains(expectedText3));
			logStep("Contacts Menu is displayed sucessfully");
						
			String actualText4 = dr.findElement(By.xpath("//a[contains(.,'Dashboard')]")).getText();
			String expectedText4 = "Dashboard";
			Assert.assertTrue(actualText4.contains(expectedText4));
			logStep("Dashboard Menu is displayed sucessfully");
			
			Actions builder = new Actions(dr);
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
