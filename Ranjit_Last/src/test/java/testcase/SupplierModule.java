package testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import action.Baseclass;
import pages.LoginPage;
import pages.Supplier;
import pages.searchengine;


public class SupplierModule extends Baseclass{
	
	public String homepage;
	
	@Test(priority = 0)
	public void login() throws InterruptedException
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(sheet.sheetIN("Login",0, 1),sheet.sheetIN("Login",1, 1),sheet.sheetIN("Login", 2, 1));
		Thread.sleep(1000);
		homepage = driver.getCurrentUrl();
	}
	@Test(priority =1)
	public void Supplier_Create() throws InterruptedException
	{
		Supplier supplier = new Supplier(driver);
		supplier.Supplier_Module();
		supplier.Supplier_create();
		supplier.Supplier_Name();
		supplier.Supplier_email();
		supplier.Supplier_Address1();
		supplier.Supplier_Address2();
		supplier.Supplier_save();
	}
	@Test(priority = 2)
	public void Supplier_PO()
	{
		searchengine search = new searchengine(driver);
		search.searchbox_supplier_parts("Parts");
		
		
		
	}
	

}
