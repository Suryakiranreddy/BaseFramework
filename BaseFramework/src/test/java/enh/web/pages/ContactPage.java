package enh.web.pages;

import org.openqa.selenium.By;

import utilities.KeywordUtil;
import utilities.LogUtil;

public class ContactPage  {
	public static By btncontact = By.xpath("//*[contains(text(), 'Contacts')]");
	public static By btncreatecontact = By.xpath("//img[@alt='Create Contact...']");
	public static By txtfirstname = By.name("firstname");
	public static By txtlastname = By.name("lastname");
	public static By txtorganisationname = By.name("account_name");
	public static By txtTitle = By.id("title");
	public static By ddLeadsource = By.name("leadsource");
	public static By txtdepartment = By.id("department");
	public static By txtemail = By.id("email");
	public static By txtassistant = By.id("assistant");
	public static By txtassistantphone = By.id("assistantphone");
	public static By  cbemail = By.name("emailoptout");
	public static By  cbnotify = By.name("notify_owner");
	public static By  txtphone = By.name("phone");
	
	

	
	public static void createcontact() throws Exception {
		LogUtil.infoLog("Create Contact", "Create Contact");
	
		
		
		
		
		
}
}