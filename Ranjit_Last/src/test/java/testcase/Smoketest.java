package testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import action.Baseclass;
import pages.CreateJob;
import pages.Customer;
import pages.Diary;
import pages.Estimate;
import pages.Invoice;
import pages.LoginPage;
import pages.NotesandCommunication;

public class Smoketest extends Baseclass {
	
	public String homepage;
	public String jobURL;
	public String WA;
   
	
	
	@Test(priority = 0)
	public void login() throws InterruptedException
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(sheet.sheetIN("Login",0, 1),sheet.sheetIN("Login",1, 1),sheet.sheetIN("Login", 2, 1));
		Thread.sleep(15000);
		homepage = driver.getCurrentUrl();
	}
	@Test(priority = 1)
	public void Add_Customer() throws InterruptedException
	{
		Customer customer = new Customer(driver);
		customer.Customer_create();
		customer.Customer_title();
		customer.Customer_Name();
		customer.Customer_SurName();
		customer.Customer_Mobile();
		customer.Customer_email();
		customer.Customer_AddressLine1();
		customer.Customer_Save();
		Thread.sleep(20000);
		customerpage = driver.getCurrentUrl();
	}
	@Test(priority = 2)
	public void Add_job_Prefinal() throws InterruptedException
	{
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("PreFinal");
		job.createjob();
	}
	@Test(priority = 3)
	public void Add_job_Final_Complete() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(6000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("AutoFinal");
		job.createjob();
		Thread.sleep(6000);
		job.edit_job();
		Thread.sleep(3000);
		job.complete_job();
	}
	@Test(priority = 5)
	public void Addjob_NoRules() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("No Rules");
		job.createjob();
		Thread.sleep(3000);
		Invoice invoice = new Invoice(driver);
		invoice.InvoiceTab();
		invoice.addinvoice();
		invoice.Final_invoice();
		invoice.invoice_description();
		invoice.invoice_UserGroup();
		invoice.invoice_Category();
		invoice.sub_total("500");
		invoice.save_invoice();
	}
	@Test(priority = 6)
	public void Addjob_NoRules_Adddtional() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("No Rules");
		job.createjob();
		Thread.sleep(3000);
		Invoice invoice = new Invoice(driver);
		invoice.InvoiceTab();
		invoice.addinvoice();
		invoice.Additional_invoice();
		invoice.invoice_UserGroup();
		invoice.invoice_Category();
		invoice.Invoice_Breakdown_Full_breakdown_by_category();
		invoice.invoice_description();
		invoice.Full_Breakdown_ByCategory_Labour_Description("Labour");
		invoice.unitprice_FullBreakdown_ByCategory_Labour("300");
		invoice.Full_Breakdown_ByCategory_Parts_Description("Price one");
		invoice.save_invoice();
	}
	@Test(priority = 7)
	public void Estimate_Accept() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(5000);
		Estimate estimate = new Estimate(driver);
		estimate.Estimate_AddNew();
		estimate.choose_description();
		estimate.Estimate_Notes();
		estimate.Estimate_CustomerReference();
		estimate.Estimate_user_group();
		estimate.Estimate_AddEstimate();
		Thread.sleep(3000);
		estimate.Estimate_Price_tab();
		Thread.sleep(3000);
		estimate.Estimate_Price_NoBreakdown();
		Thread.sleep(3000);
		estimate.Estimate_Price_NoBreakdown_PartsTotal();
		Thread.sleep(3000);
		estimate.Estimate_InvoiceSchedule();
		Thread.sleep(3000);
		estimate.Estimate_InvoiceSchedule_Deposite();
		Thread.sleep(3000);
		estimate.Estimate_InvoiceSchedule_Completion();
		Thread.sleep(3000);
		estimate.Estimate_InvoiceSchedule_Retention();
		Thread.sleep(3000);
		estimate.Estimate_SendtoCustomer();
		estimate.Estimate_Accept();
	}
	@Test(priority = 8)
	public void Estimate_Reject() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(5000);
		Estimate estimate = new Estimate(driver);
		estimate.Estimate_AddNew();
		estimate.choose_description();
		estimate.Estimate_Notes();
		estimate.Estimate_CustomerReference();
		estimate.Estimate_user_group();
		estimate.Estimate_AddEstimate();
		estimate.Estimate_Price_tab();
		estimate.Estimate_Price_NoBreakdown();
		estimate.Estimate_Price_NoBreakdown_PartsTotal();
		estimate.Estimate_InvoiceSchedule();
		estimate.Estimate_InvoiceSchedule_Deposite();
		estimate.Estimate_InvoiceSchedule_Completion();
		estimate.Estimate_InvoiceSchedule_Retention();
		estimate.Estimate_SendtoCustomer();
		estimate.Estimate_Reject();
	}
	@Test(priority = 9)
	public void Addjob_NoRules_DiaryEvent() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("No Rules");
		job.createjob();
		Thread.sleep(4000);
		job.Add_new_diaryEvent();
		Diary diary = new Diary(driver);
		diary.Diary_Daily();
		diary.Diary_Today();
		diary.Diary_EventFromJob();
	}
	@Test(priority = 10)
	public void Addpayment_job() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("No Rules");
		job.createjob();
		Thread.sleep(4000);
		Invoice invoice = new Invoice(driver);
		invoice.InvoiceTab();
		invoice.addinvoice();
		invoice.Pre_Final_invoice();
		invoice.Invoice_Breakdown_Full_breakdown();
		invoice.invoice_description();
		invoice.Full_Breakdown_des("Price one");
		invoice.invoice_UserGroup();
		invoice.invoice_Category();
		invoice.save_invoice();
		NotesandCommunication communication = new NotesandCommunication(driver);
		communication.emailinvoice();
		communication.printinvoice();
		invoice.invoice_AddnewPayment();
		invoice.invoice_payment_AddDescription();
		invoice.invoice_payment_method();
		invoice.invoice_payment_nominalcode();
		invoice.invoice_payment_amount();
		invoice.invoice_paymeny_save();
	}
	@Test(priority = 11)
	public void Workaddress_Add() throws InterruptedException
	{
		driver.get(customerpage);
		Thread.sleep(5000);
		Customer customer = new Customer(driver);
		customer.workaddress_tab();
		customer.workaddress_addnewWorkaddress();
		customer.Workaddress_create();
		Thread.sleep(6000);
		WA = driver.getCurrentUrl();
		
	}
	@Test(priority = 12)
	public void WA_Add_job_Prefinal() throws InterruptedException
	{
		driver.get(WA);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("PreFinal");
		job.createjob();
	}
	@Test(priority = 13)
	public void WA_Addpayment_job() throws InterruptedException
	{
		driver.get(WA);
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("No Rules");
		job.createjob();
		Thread.sleep(4000);
		Invoice invoice = new Invoice(driver);
		invoice.InvoiceTab();
		invoice.addinvoice();
		invoice.Pre_Final_invoice();
		invoice.Invoice_Breakdown_Full_breakdown();
		invoice.invoice_description();
		invoice.Full_Breakdown_des("Price one");
		invoice.invoice_UserGroup();
		invoice.invoice_Category();
		invoice.save_invoice();
		NotesandCommunication communication = new NotesandCommunication(driver);
		communication.emailinvoice();
		communication.printinvoice();
		invoice.invoice_AddnewPayment();
		invoice.invoice_payment_AddDescription();
		invoice.invoice_payment_method();
		invoice.invoice_payment_nominalcode();
		invoice.invoice_payment_amount();
		invoice.invoice_paymeny_save();
	}
	@Test(priority = 14)
	public void WA_Estimate_Accept() throws InterruptedException
	{
		driver.get(WA);
		Thread.sleep(5000);
		Estimate estimate = new Estimate(driver);
		estimate.Estimate_AddNew();
		estimate.choose_description();
		estimate.Estimate_Notes();
		estimate.Estimate_CustomerReference();
		estimate.Estimate_user_group();
		estimate.Estimate_AddEstimate();
		Thread.sleep(3000);
		estimate.Estimate_Price_tab();
		Thread.sleep(3000);
		estimate.Estimate_Price_NoBreakdown();
		estimate.Estimate_Price_NoBreakdown_PartsTotal();
		estimate.Estimate_InvoiceSchedule();
		estimate.Estimate_InvoiceSchedule_Deposite();
		estimate.Estimate_InvoiceSchedule_Completion();
		estimate.Estimate_InvoiceSchedule_Retention();
		estimate.Estimate_SendtoCustomer();
		estimate.Estimate_Accept();
		Thread.sleep(6000);
	}
	

}
