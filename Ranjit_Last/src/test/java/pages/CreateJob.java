package pages;

import org.openqa.selenium.WebDriver;

import action.Wrapper;

public class CreateJob extends Wrapper {
	
	public CreateJob(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	public void addjob() throws InterruptedException
	{
		click("//a[@id='newJob']");
		Thread.sleep(1000);
	}
	public void JobDescription(String a) throws InterruptedException
	{
		searchengine search = new searchengine(driver);
		search.searchbox_jobDescription(a);
		Thread.sleep(3000);
	}
	public void createjob()
	{
		click("//span[text()='Add job']");
	}
	public void jobdetail()
	{
		click("(//a[text()='Details'])[2]");
	}
	public void edit_job() throws InterruptedException
	{
		click("(//a[text()='Edit'])[1]");
		Thread.sleep(1000);
	}
	public void complete_job() throws InterruptedException
	{
		click("//input[@formcontrolname='completed']");
		Thread.sleep(3000);
		click("(//span[text()='Save'])[2]");
	}
	public void Add_new_diaryEvent()
	{
		click("//span[text()='Add new diary event']");
	}
	/*k*/
	public void JobCost()
	{
		click("//span[text()='Costs']");
	}
	public void JobCostPO()
	{
		click("(//a[@class=\"btn btn-primary btn-small ng-scope\"])[3]");//Click PO
	}
	public void PO_item_unitprice( String amount)
	{
		dclick("(//td[@class=\"overflow_handsontable\"])[3]");
		clear("(//textarea[@class=\"handsontableInput\"])[4]");
		type("(//textarea[@class=\"handsontableInput\"])[4]", amount);
		typeenter("(//textarea[@class=\"handsontableInput\"])[4]");		
	}
	public void PO_item_unitprice_value()
	{
		dclick("(//td[@class=\"overflow_handsontable\"])[2]");
		clear("(//textarea[@class=\"handsontableInput\"])[4]");
		type("(//textarea[@class=\"handsontableInput\"])[4]", "500");
		typeenter("(//textarea[@class=\"handsontableInput\"])[4]");		
	}
	public void PO_item_saleprice( String amount)
	{
		dclick("//td[@class=\"overflow_handsontable current highlight\"]");
		clear("//*[@id=\"job_item_new_purchase_order\"]/div[6]/textarea");
		type("//*[@id=\"job_item_new_purchase_order\"]/div[6]/textarea", amount);
		typeenter("//*[@id=\"job_item_new_purchase_order\"]/div[6]/textarea");		
	}
	public void PO_part_unitprice_eidt( String amount)
	{
		dclick("//*[@id=\"part_edit_purchase_order\"]/div[1]/div/div/div/table/tbody/tr/td[4]");
		clear("//textarea[@class=\"handsontableInput\"]");
		type("//textarea[@class=\"handsontableInput\"]", amount);
		typeenter("//textarea[@class=\"handsontableInput\"]");		
	}
	public void PO_part_itemprice_eidt( String amount)
	{
		dclick("(//td[@class=\"overflow_handsontable\"])[2]");
		clear("(//textarea[@class=\"handsontableInput\"])[2]");
		type("(//textarea[@class=\"handsontableInput\"])[2]", amount);
		typeenter("(//textarea[@class=\"handsontableInput\"])[2]");		
	}
	public void Add_PO_button()
	{
		click("(//span[@class=\"ng-scope\"])[15]");
	}
	public void view_po()
	{
		click("(//a[@class=\"ng-scope\"])[27]");
	}
	public void edit_po()
	{
		click("(//span[@class=\"ng-scope\"])[26]");
	}
	public void save_po()
	{
		click("//span[@ng-hide=\"saving\"]");
	}
	public void invoice_withlineitem() throws InterruptedException
	{
		click("(//span[@class=\"ng-scope\"])[16]");//click invoice tab
		click("//a[@class=\"btn btn-primary btn-small ng-scope\"]");// click add invoice
		click("(//span[@class=\"help-block\"])[1]");//copy from job
		selectdropdownindex("//select[@class=\"full-width-select ng-untouched ng-pristine ng-invalid\"]", 1);//invoice category
		click("//a[@class=\"without-margin\"]");// lineitem
		click("(//input[@type=\"checkbox\"])[4]");//click part checkbox
		//isenabled("//button[@class=\"btn btn-primary loading_btn save_btn\"]");//save and add line items
		Thread.sleep(3000);
		click("(//input[@type=\"checkbox\"])[5]");//click labour checkbox
		Thread.sleep(3000);
		click("(//a[@class=\"btn btn-primary\"])[1]");//save invoice
	}
	public void save_invocie()
	{
		click("//button[@class=\"btn btn-primary loading_btn save_btn\"]");// save button
	}
	public void assert_parttotal()
	{
		String part_total = gettext("(//span[@class=\"ng-binding\"])[16]");//part total
		part_total = part_total.replace("£", "");
		String Expectedparttotal= "300.00";
		Assertion(part_total, Expectedparttotal,"Wrong part total");
	}
	public void assert_itemtotal()
	{
		String item_total = gettext("(//span[@class=\"ng-binding\"])[23]");//item total
		item_total = item_total.replace("£", "");
		String Expecteditemtotal= "100.00";
		Assertion(item_total, Expecteditemtotal,"Wrong item total");
	}
	public void assert_subtotal()
	{
		String sub_total = gettext("(//span[@class=\"ng-binding\"])[24]");//sub total
		sub_total = sub_total.replace("£", "");
		String Expectedsubtotal= "400.00";
		Assertion(sub_total, Expectedsubtotal,"Wrong sub total");
	}
	public void assert_VAT()
	{
		String VAT = gettext("(//span[@class=\"ng-binding\"])[25]");//VAT
		VAT = VAT.replace("£", "");
		String ExpectedVATpart= "80.00";
		Assertion(VAT,ExpectedVATpart,"Wrong VAT value");
	}
	public void assert_grandtotal()
	{
		String Grandtotal = gettext("(//span[@class=\"ng-binding\"])[26]");//Grand total
		Grandtotal = Grandtotal.replace("£", "");
		String ExpectedGrandtotal= "480.00";
		Assertion(Grandtotal,ExpectedGrandtotal,"Wrong Grandtotal value");
	}
	public void assert_partedittoal()
	{
	String part_total = gettext("(//span[@class=\"ng-binding\"])[16]");//part total
	part_total = part_total.replace("£", "");
	String Expectedparttotal= "600.00";
	Assertion(part_total, Expectedparttotal,"Wrong part total");
	}
	public void assert_item_edittotal()
	{
	String item_total = gettext("(//span[@class=\"ng-binding\"])[23]");//item total
	item_total = item_total.replace("£", "");
	String Expecteditemtotal= "200.00";
	Assertion(item_total, Expecteditemtotal,"Wrong item total");
	}
	public void assert_subedittotal()
	{
	String sub_total = gettext("(//span[@class=\"ng-binding\"])[24]");//sub total
	sub_total = sub_total.replace("£", "");
	String Expectedsubtotal= "800.00";
	Assertion(sub_total, Expectedsubtotal,"Wrong sub total");
	}
	public void assert_editvat()
	{
	String VAT = gettext("(//span[@class=\"ng-binding\"])[25]");//VAT
	VAT = VAT.replace("£", "");
	String ExpectedVATpart= "120.00";
	Assertion(VAT,ExpectedVATpart,"Wrong VAT value");
	}
	public void assert_editgrand()
	{
	String Grandtotal = gettext("(//span[@class=\"ng-binding\"])[26]");//Grand total
	Grandtotal = Grandtotal.replace("£", "");
	String ExpectedGrandtotal= "920.00";
	Assertion(Grandtotal,ExpectedGrandtotal,"Wrong Grandtotal value");
	}
	public void assert_invoicetotal()
	{
	String Total_in = gettext("(//div[@class=\"total-value\"])[1]");
	Total_in = Total_in.replace("£", "");
	String Expectedintotal= "800.00";
	Assertion(Total_in, Expectedintotal,"Wrong invoice total");
	}
	public void assert_invoicevattotal()
	{
	String Total_vat = gettext("(//div[@class=\"total-value\"])[2]");
	Total_vat = Total_vat.replace("£", "");
	String Expectedvattotal= "160.00";
	Assertion(Total_vat, Expectedvattotal,"Wrong vat total");
	}
	public void assert_invoicegrand()
	{
	String Total_grand = gettext("(//div[@class=\"total-value\"])[3]");
	Total_grand = Total_grand.replace("£", "");
	String Expectedgrandtotal= "960.00";
	Assertion(Total_grand, Expectedgrandtotal,"Wrong grand total");
	}
	public void assert_finalinvoicetotal()
	{
	String Finalvalue = gettext("(//div[@class=\"total-value\"])[3]");
	Finalvalue = Finalvalue.replace("£", "");
	String ExpectedFinalvalue= "960.00";
	Assertion(Finalvalue, ExpectedFinalvalue,"Wrong Final total");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

