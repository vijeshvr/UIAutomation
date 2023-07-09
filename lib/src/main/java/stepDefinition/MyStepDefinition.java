package stepDefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class MyStepDefinition {
	
	public static WebDriver driver;
	
	public static String CustomerID;
	public static String AccountNumber;
	
	

	
	@Given("User is in Managers page")
	public static void user_is_in_managers_page() {
	   
	    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\geckodriver.exe");

		 
//	  Set the path to the ad blocker extension XPI file
        String adBlockerExtensionPath = "C:\\Users\\Vijesh V R\\eclipse-workspace\\DemoBDDCucumber\\lib\\src\\main\\resources\\driver\\uBlock0_1.50.1b6.firefox.signed.xpi";

        FirefoxProfile profile = new FirefoxProfile();
        
        profile.setPreference("extensions.enabledAddons", "ublock-origin@raymondhill.net:" + adBlockerExtensionPath);
        profile.setPreference("extensions.autoDisableScopes", 0);
        profile.setPreference("extensions.startupFingerprint", "");
        
        // Create FirefoxOptions and add the ad blocker extension
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
	    
		 driver= new FirefoxDriver();
		 
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		 
	
		 driver.get("https://demo.guru99.com/V4/index.php");
		 
		 WebElement uid =driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));
		 uid.click();
		 uid.clear();
		 uid.sendKeys("mngr513520");
		 
		 WebElement pass =driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
		 pass.click();
		 pass.clear();
		 pass.sendKeys("AdUnudA");
		 
		 WebElement login =driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
		 login.click();
			       
		 
		 System.out.println("Step 1 done");
		 
	}
	@Then("User Clicks the New Customer button")
	public static void user_clicks_the_new_customer_button() {
		 WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a"));

	        element1.click();
	        
	        System.out.println("Step 2 done");


	}
	@When("User is in new Customer Entry Page")
	public static void user_is_in_new_customer_entry_page() {
	    String ExpTitle1="Guru99 Bank New Customer Entry Page";
	    
	    String ActTitle1=driver.getTitle();
	    
	    Assert.assertEquals(ExpTitle1, ActTitle1);
	    
        System.out.println("User sucessfully landed in New Customer Entry Page");
	    
		System.out.println("Step 3 done");

	}
    @ParameterType(".*")
    public String dynamicParameter(String value) {
        return value;
    }

    @Then("User enters {dynamicParameter}, {dynamicParameter}, {dynamicParameter}, {dynamicParameter}, {dynamicParameter}, {dynamicParameter}, {dynamicParameter}, {dynamicParameter}, {dynamicParameter}")

	public void user_enter(String Name, String Gender, String Address, String City, String State, String PIN, String MobileNumber, String Email, String Password) {
		WebElement CName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input"));
		CName.sendKeys(Name);
		
		WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a"));

		String Cgender = Gender;

        if (Cgender.equals("Male")) {
           
            WebElement Male = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));

	        Male.click();
        }else {
        	WebElement Female = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));

	        Female.click();
        };
        
        WebElement dateInput = driver.findElement(By.id("dob"));
        
       
        
        JavascriptExecutor js=(JavascriptExecutor)driver; 
        js.executeScript("arguments[0].type = arguments[1]", dateInput, "text"); 
        driver.findElement(By.id("dob")).sendKeys("12/12/1999");
        
        
        WebElement address = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea"));

       
        address.clear();
        address.sendKeys(Address);
        
        WebElement city = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"));

       
        city.clear();
        city.sendKeys(City);
        
        WebElement state = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input"));

      
        state.clear();
        state.sendKeys(State);
        
        WebElement pin = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input"));

       
        pin.clear();
        pin.sendKeys(PIN);
        
        WebElement phone = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input"));

      
        phone.clear();
        phone.sendKeys(MobileNumber);
        
        WebElement email = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input"));

       
        email.clear();
        email.sendKeys(Email);
        
        WebElement password = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input"));


        password.clear();
        password.sendKeys(Password);
        
        System.out.println("Customer details entered sucessfully");
	}
	
	@Then("User Clicks submit button")
	public static void user_clicks_submit_button() {
	   WebElement submit1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]"));
	   submit1.click();
	   System.out.println("User details submitted sucessfully");
	   
	}
	@Then("User lands on Sucessful Customer Registration page")
	public static void user_lands_on_sucessful_customer_registration_page() {
	    WebElement UsrAddedMsg = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p"));
	    
	    if(UsrAddedMsg.getText().equalsIgnoreCase("Customer Registered Successfully!!!")) {
	    	
	    	System.out.println("Customer Registered");
	    	CustomerID =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
	    	System.out.println(CustomerID);
	    }else {
	    	System.out.println("User not Added");
	    }
	    
	    driver.quit();
	}
	@Then("User clicks on edit Customer buttton")
	public static void user_clicks_on_edit_customer_buttton() {
		WebElement EditCus =driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a"));
		EditCus.click();
		
	    }

	@When("User is in Edit Customer Page")
	public static void user_is_in_edit_customer_page() throws Exception {
		String ExTitle = "Guru99 Bank Edit Customer Page";
		String AcTitle=driver.getTitle();
		if (ExTitle.equalsIgnoreCase(AcTitle)) {
        System.out.println("User is in "+ AcTitle);
		} else {
    	throw new Exception("Result is negative. Stopping execution.");
		}
	}

	@When("User enters Customer id and click submit")
	public void user_enters_customer_id_and_click_submit() {
		WebElement EditCusId =driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input"));
		EditCusId.sendKeys(CustomerID);
		WebElement submit2 = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]"));
		   submit2.click();
	}

	@Then("User edit the Phone number and Click submit button")
	public void user_edit_the_phone_number_and_click_submit_button() {
		WebElement Editphone = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input"));

      
        Editphone.clear();
        Editphone.sendKeys("9999999999");
        
        WebElement submit3 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input[1]"));
		   submit3.click();
	}

	@Then("User get a Changes made sucessfully message")
	public void user_get_a_changes_made_sucessfully_message() {
		
		
		
		Alert alert1 = driver.switchTo().alert();
		
		 String alertText1 = alert1.getText();
		 
	        System.out.println("Alert Text: " + alertText1);
	        
	        alert1.accept();
	        
	        driver.switchTo().defaultContent();
	        
	        driver.quit();
	        
	        String ExpAlertMsg = "Changes made to Customer records";
	        
	        Assert.assertEquals(ExpAlertMsg, alertText1);
	        
	        
	   
	}
	
	@Then("User clicks on new account buttton")
	public void user_clicks_on_new_account_buttton() {
		WebElement NewAcc =driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[5]/a"));
		NewAcc.click();
	}
	@When("User is in add new account page")
	public void user_is_in_add_new_account_page() throws Exception {
		String ExTitle2 = "Guru99 bank add new account";
		String AcTitle2=driver.getTitle();
		if (ExTitle2.equalsIgnoreCase(AcTitle2)) {
        System.out.println("User is in "+ AcTitle2);
		} else {
    	throw new Exception("Result is negative. Stopping execution.");
		}	
	}
	
	
	@Then("User enters customer id, account type and click submit button")
	public void user_enters_customer_id_account_type_and_click_submit_button() {
		WebElement EditCus =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input"));
		EditCus.clear();
		EditCus.sendKeys(CustomerID);
		
		WebElement InitialAmount =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input"));
		InitialAmount.clear();
//		InitialAmount.sendKeys("5000");
		
		WebElement Submit3 =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
		Submit3.click();
		
	}
	@Then("User get Please fill all fields message")
	public void user_get_please_fill_all_fields_message() {
		Alert alert2 = driver.switchTo().alert();
		
		 String alertText2 = alert2.getText();
		 
	        System.out.println("Alert Text: " + alertText2);
	        
	        alert2.accept();
	        driver.switchTo().defaultContent();
	        
	        driver.quit();
	        
	        String ExpAlertMsg = "Please fill all fields";
	        
	        Assert.assertEquals(ExpAlertMsg, alertText2);
	        
	}
	
	@Then("User enters customer id, account type and initial amount and click submit button")
	public void user_enters_customer_id_account_type_and_initial_amount_and_click_submit_button() {
		WebElement EditCus =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input"));
		EditCus.clear();
		EditCus.sendKeys(CustomerID);
		
		WebElement InitialAmount =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input"));
		InitialAmount.clear();
		InitialAmount.sendKeys("5000");
		
		WebElement Submit3 =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
		Submit3.click();
	}
	@Then("User get Account Generated Successfully!!! text")
	public void user_get_account_generated_successfully_text() {
		 WebElement AccCreatedMsg = driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[1]/td/p"));
		    
		    if(AccCreatedMsg.getText().equalsIgnoreCase("Account Generated Successfully!!!")) {
		    	
		    	System.out.println("Account Created");
		    	AccountNumber =driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]")).getText();
		    	System.out.println(AccountNumber);
		    }else {
		    	System.out.println("Account Not Created");
		    }
		    
		    driver.quit();
		    
		    System.out.println(CustomerID);
	}
	
	@Then("User clicks on Delete Customer buttton")
	public void user_clicks_on_delete_customer_buttton() {
		WebElement DelCus =driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[4]/a"));
		DelCus.click();
	}
	@When("User is in delete Customer page")
	public void user_is_in_delete_customer_page() throws Exception {
		String ExTitle3 = "Guru99 Bank Delete Customer Page";
		String AcTitle3=driver.getTitle();
		if (ExTitle3.equalsIgnoreCase(AcTitle3)) {
        System.out.println("User is in "+ AcTitle3);
		} else {
    	throw new Exception("Result is negative. Stopping execution.");
		}
	}
	@Then("User Enters the customer id and clicks submit")
	public void user_enters_the_customer_id_and_clicks_submit() {
		WebElement DelCusId =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input"));
		DelCusId.sendKeys(CustomerID);
		WebElement submit3 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input[1]"));
		   submit3.click();
	}
	@Then("User gets an alert meassage on customer deletion confirmation")
	public void user_an_alert_meassage_on_customer_deletion_confirmation() {
		Alert alert3 = driver.switchTo().alert();
		
		 String alertText3 = alert3.getText();
		 
	        System.out.println("User get a Alert Text: " + alertText3);
	        
	        alert3.accept();
	        driver.switchTo().defaultContent();
	        
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	@Then("User gets a alert message saying Customer could not be deleted!!. First delete all accounts of this customer then delete the customer")
	public void user_gets_a_alert_message_saying_customer_could_not_be_deleted_first_delete_all_accounts_of_this_customer_then_delete_the_customer() {
		Alert alert4 = driver.switchTo().alert();
		
		 String alertText4 = alert4.getText();
		 
	        System.out.println("User get a Alert Text: " + alertText4);
	        
	        alert4.accept();
	        driver.switchTo().defaultContent();
	        driver.quit();
	        
	}
	
}
