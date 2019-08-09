package enh.web.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import utilities.HtmlReportUtil;
import utilities.KeywordUtil;

public class CreateSalesorder extends KeywordUtil {
	
	Actions builder = new Actions(getDriver());
	
	//=====Sales Order
	public static By lnk_More = By.xpath("//td[contains(.,'More')]");
	public static By lnk_salesorder = By.name("Sales Order");
	public static By btn_Sales = By.xpath("//img[@alt='Create Sales Order...']");
	public static By txt_subject = By.name("subject");
	public static By txt_customerno = By.id("customerno");
	public static By sl_status = By.name("sostatus");
	public static By txt_billing = By.name("bill_street");
	public static By txt_shipping = By.name("ship_street");
	public static By txt_description = By.xpath("//textarea[@name='description']");
	public static By btn_searchicon = By.xpath("//img[@id='searchIcon1']");
	public static By cb_product = By.xpath("//input[@name='selected_id']");
	public static By btn_save = By.xpath("//input[@class='crmbutton small save']");
	public static By txt_qty = By.id("qty1");
	
	public static By searchOrganizaion = By.xpath("//*[@id=\"frmEditView\"]/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[9]/td[4]/img");
	
	
	//====Purchase Order
	private static By userName=By.name("user_name");
	private static By password=By.name("user_password");
	private static By submit_btn=By.id("submitButton");
	private static By table_link=By.xpath("html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[22]/a");
	private static By order=By.name("Purchase Order");
	private static By order_img=By.xpath("//img[@alt='Create Purchase Order...']");
	private static By subject=By.name("subject");
	private static By frmEditView=By.xpath("//*[@id='frmEditView']/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/img");
	private static By click=By.xpath("//a[@id='1']");
	private static By postatus=By.name("postatus");
	private static By bill_street=By.name("bill_street");
	private static By ship_street=By.name("ship_street");
	private static By description=By.xpath("//textarea[@name='description']");
	private static By searchIcon=By.xpath("//img[@id='searchIcon1']");
	private static By selected_id=By.xpath("//input[@name='selected_id']");
	private static By crmbutton=By.xpath("//input[@class='crmbutton small save']");
	private static By qty1=By.id("qty1");	
	private static By themes=By.xpath("//img[@src='themes/softed/images/Home.PNG']");
	private static By signOut=By.xpath("//a[contains(.,'Sign Out')]");

	
	
	
	public boolean salesorder() throws InterruptedException{
		
		
		String subject = randomString();
		KeywordUtil.hoverElement(By.xpath("html/body/table[2]/tbody/tr/td[2]/table/tbody/tr/td[22]/a"));
		KeywordUtil.hoverElement(lnk_salesorder);
		KeywordUtil.click(lnk_salesorder);
		pause(2000);
		KeywordUtil.click(btn_Sales);
		pause(2000);
		HtmlReportUtil.stepInfo("Clicked on create sales order");
		
		
		KeywordUtil.inputText(txt_subject, subject);
		HtmlReportUtil.stepInfo("Entered subject text: "+ subject);
		KeywordUtil.inputText(txt_customerno, "0984809848");
		HtmlReportUtil.stepInfo("Entered customer No: 0984809848");
		KeywordUtil.selectByVisibleText(sl_status, "Approved");
		HtmlReportUtil.stepInfo("Select visible text: Approved");
		click(searchOrganizaion);
		ArrayList<String> window = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(window.get(1));
		click(By.xpath("//*[@id=\"1\"]"));
		pause(2000);
		getDriver().switchTo().alert().accept();
		getDriver().switchTo().window(window.get(0));
		pause(2000);
		KeywordUtil.inputText(txt_billing, "Lanco hill road manikonda");
		HtmlReportUtil.stepInfo("Entered text: Lanco hill road manikonda");
		KeywordUtil.inputText(txt_shipping, "Hyderabad Telanagana");
		HtmlReportUtil.stepInfo("Entered text: Hyderabad Telanagana");
		KeywordUtil.inputText(txt_description, "Creation of New Sales order");
		HtmlReportUtil.stepInfo("Entered text: Creation of New Sales order");
		KeywordUtil.click(btn_searchicon);
		HtmlReportUtil.stepInfo("Clicked on search icon");
		pause(2000);
		Thread.sleep(2000);
		ArrayList<String> newTab = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(newTab.get(1));
        Thread.sleep(2000); 
		KeywordUtil.click(cb_product);
		HtmlReportUtil.stepInfo("Clicked on product");
		KeywordUtil.click(btn_save);
		HtmlReportUtil.stepInfo("Clicked on save");
		Thread.sleep(2000);
		getDriver().switchTo().window(newTab.get(0));
		//KeywordUtil.click(btn_save);
		pause(2000);
		KeywordUtil.inputText(txt_qty, "5");
		HtmlReportUtil.stepInfo("Entered text: 5");
		pause(5000);
		builder.moveToElement(getDriver().findElement(btn_save)).build().perform();
		KeywordUtil.click(btn_save);
		HtmlReportUtil.stepInfo("Clicked on save");
		pause(5000);
		String salesorderNo = getElementText(By.xpath("//*[starts-with(@id,'tblSalesOrderInformation')]/table/tbody/tr[2]/td[4]"));
		HtmlReportUtil.stepInfo("Sales order No: "+salesorderNo);
		HtmlReportUtil.stepInfo("Sales order Verification is sucessfull");
		getDriver().findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
		pause(3000);
		builder.moveToElement(getDriver().findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
		builder.moveToElement(getDriver().findElement(By.xpath("//a[contains(.,'Sign Out')]"))).build().perform();
		getDriver().findElement(By.xpath("//a[contains(.,'Sign Out')]")).click();
		logStep("User logged out sucessfully");
		return true;
	}
	
public boolean purchaseOrder() throws InterruptedException{
		

	hoverElement(table_link);
	hoverElement(order);
	click(order);
	HtmlReportUtil.stepInfo("Clicked on Purchase Order");
	//click(order);
	click(order_img);
	HtmlReportUtil.stepInfo("clicked on order image ");
	
	String purchaseSubject = randomString();
	inputText(subject, purchaseSubject);//"Dell Machine"
	HtmlReportUtil.stepInfo("Entered purchase subject: "+ purchaseSubject);
	
	getDriver().findElement(By.xpath("//*[@id='frmEditView']/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/img")).click();;
	ArrayList<String> newTab1 = new ArrayList<String>(getDriver().getWindowHandles());
	getDriver().switchTo().window(newTab1.get(1));
    Thread.sleep(5000);
    getDriver().findElement(By.xpath("//a[@id='1']")).click();
    getDriver().switchTo().window(newTab1.get(0));
    getDriver().findElement(By.name("postatus")).sendKeys("Approved");
	Thread.sleep(5000);			
	inputText(bill_street, "Lanco hills");//"Lanco hills"
	HtmlReportUtil.stepInfo("bill_street entered Lanco hills");
	inputText(ship_street, "Hyderabad");//"Hyderabad"
	HtmlReportUtil.stepInfo("ship_street entered");
	inputText(description, "Automation");//"Automation"
	HtmlReportUtil.stepInfo("description entered");
	click(searchIcon);
	HtmlReportUtil.stepInfo("clicked on search icon");
	ArrayList<String> newTab = new ArrayList<String>(getDriver().getWindowHandles());
	getDriver().switchTo().window(newTab.get(1));
	HtmlReportUtil.stepInfo("switchTo new tab");
	click(selected_id);
	HtmlReportUtil.stepInfo("selected_id clicked");
	click(crmbutton);
	HtmlReportUtil.stepInfo("crmbutton clicked");
	getDriver().switchTo().window(newTab.get(0));
	HtmlReportUtil.stepInfo("switchTo parent tab");
	inputText(qty1, "5");//"5"
	HtmlReportUtil.stepInfo("qty entered");
	pause(3000);
	//click(crmbutton);
	builder.moveToElement(getDriver().findElement(crmbutton)).build().perform();
	click(crmbutton);
	HtmlReportUtil.stepInfo("clicked save button");
	String purchaseOrderNo = getElementText(By.xpath("//*[@id='tblPurchaseOrderInformation']/table/tbody/tr/td[4]"));
	HtmlReportUtil.stepInfo("Purchase order no: "+ purchaseOrderNo);
	HtmlReportUtil.stepInfo("Purchase order created sucessfully");
	click(themes);
	builder.moveToElement(getDriver().findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
	builder.moveToElement(getDriver().findElement(By.xpath("//a[contains(.,'Sign Out')]"))).build().perform();
	click(signOut);
	HtmlReportUtil.stepInfo("Clicked on signout");
	HtmlReportUtil.stepInfo("User logged out sucessfully");
		return true;
	}
	
	public static String randomString() {
		
		int random = (int)(Math.random() * 1000 + 1);
		String randomstring = "Dell Machine" + random;
		return randomstring;
		
	}
	
}
