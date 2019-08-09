package enh.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.KeywordUtil;

public class CRMlogin {

	
	public static By txtUserName = By.name("user_name");
	public static By txtPassword = By.name("user_password");
	public static By btnLog = By.id("submitButton");
	
	
public boolean login() throws Exception{
		
	Thread.sleep(3000);	
	KeywordUtil.inputText(txtUserName, "admin");
	KeywordUtil.inputText(txtPassword, "password");
	KeywordUtil.click(btnLog);
	Thread.sleep(3000);
	return true;
	
	
	
	
}
	
}
