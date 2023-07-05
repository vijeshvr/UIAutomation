package stepDefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;

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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class MyStepDefinition {
	
	public WebDriver driver;
	
	public void invokeBrowser() {
	
//	System.setProperty("webdriver.edge.driver", "C:\\Users\\Vijesh V R\\eclipse-workspace\\DemoBDDCucumber\\lib\\src\\main\\resources\\driver\\msedgedriver.exe");
//	WebDriver driver = new EdgeDriver();
		
//		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\IEDriverServer.exe");
//		 driver= new InternetExplorerDriver();
//		 driver.manage().window().maximize();
//
//		 
//	
//	driver.get("https://demo.guru99.com/V4/manager/Managerhomepage.php");
	}

	
	@Given("User is in Managers page")
	public void user_is_in_managers_page() {
	    invokeBrowser();
	    System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\resources\\driver\\geckodriver.exe");
//		 driver= new InternetExplorerDriver();
		 
	 // Set the path to the ad blocker extension XPI file
        String adBlockerExtensionPath = "C:\\Users\\Vijesh V R\\eclipse-workspace\\DemoBDDCucumber\\lib\\src\\main\\resources\\driver\\uBlock0_1.50.1b6.firefox.signed.xpi";

//        File adBlockerExtension = new File(adBlockerExtensionPath);
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
		 uid.sendKeys("mngr507818");
		 
		 WebElement pass =driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));
		 pass.click();
		 pass.clear();
		 pass.sendKeys("arYgUtU");
		 
		 WebElement login =driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));
		 login.click();
		 
			        
//	        WebElement addv = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/div/svg/path[1]"));
//
//	        // Click on the element
//	        addv.click();
//	        
//	        try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		 
		 System.out.println("Step 1 done");
		 
		 
//		 
//		 System.out.println("Hii");
//		 driver.quit();
	}
	@Then("User Clicks the New Customer button")
	public void user_clicks_the_new_customer_button() {
		 WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a"));

	        // Click on the element
	        element1.click();
	        
	        System.out.println("Step 2 done");


	}
	@When("User is in new Customer Entry Page")
	public void user_is_in_new_customer_entry_page() {
	    String ExpTitle1="Guru99 Bank New Customer Entry Page";
	    
	    String ActTitle1=driver.getTitle();
	    
	    Assert.assertEquals(ExpTitle1, ActTitle1);
	    
        System.out.println("User sucessfully landed in New Customer Entry Page");
	    
		System.out.println("Step 3 done");

	}
	@Then("User enters all the Customer details")
	public void user_enters_all_the_customer_details() {
		WebElement CName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input"));
		CName.sendKeys("name");
		
		WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a"));

		String Cgender = "Male";

        if (Cgender.equals("Male")) {
           
            WebElement Male = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));

	        // Click on the element
	        Male.click();
        }else {
        	WebElement Female = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));

	        // Click on the element
	        Female.click();
        };
        
        WebElement dateInput = driver.findElement(By.id("dob"));
        
       
//        try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        dateInput.sendKeys("12/12/2018");
        
        
        JavascriptExecutor js=(JavascriptExecutor)driver; 
        js.executeScript("arguments[0].type = arguments[1]", dateInput, "text"); 
        driver.findElement(By.id("dob")).sendKeys("12/12/1999");
        
//        JavascriptExecutor js2 = (JavascriptExecutor) driver;
//        js2.executeScript("arguments[0].value = arguments[1]", dateInput,"23-03-2000");

        
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].onkeyup()", dateInput);

        
        
        
        WebElement address = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea"));

        // Click on the element
        address.clear();
        address.sendKeys("iykyk");
        
        WebElement city = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input"));

        // Click on the element
        city.clear();
        city.sendKeys("Chennai");
        
        WebElement state = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input"));

        // Click on the element
        state.clear();
        state.sendKeys("TN");
        
        WebElement pin = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input"));

        // Click on the element
        pin.clear();
        pin.sendKeys("123456");
        
        WebElement phone = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input"));

        // Click on the element
        phone.clear();
        phone.sendKeys("1234567891");
        
        WebElement email = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input"));

        // Click on the element
        email.clear();
        email.sendKeys("hjdh@hjs.com");
        
        WebElement password = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input"));

        // Click on the element
        password.clear();
        password.sendKeys("Test12345");
        
        System.out.println("Customer details entered sucessfully");
        
	}
	@Then("User Clicks submit button")
	public void user_clicks_submit_button() {
	   WebElement submit = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]"));
	   submit.click();
	   System.out.println("User details submitted sucessfully");
	   
	}
	@Then("User lands on Sucessful Customer Registration page")
	public void user_lands_on_sucessful_customer_registration_page() {
	    WebElement UsrAddedMsg = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[1]/td/p"));
	    
	    if(UsrAddedMsg.getText().equalsIgnoreCase("Customer Registered Successfully!!!")) {
	    	
	    	System.out.println("Customer Registered");
	    	String CustomerID =driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
	    	System.out.println(CustomerID);
	    }else {
	    	System.out.println("User not Added");
	    }
	}
	@Then("User clicks on edit Customer buttton")
	public void user_clicks_on_edit_customer_buttton() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User is in Edit Customer Page")
	public void user_is_in_edit_customer_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enters Customer id and click submit")
	public void user_enters_customer_id_and_click_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User edit the Phone number and Click submit button")
	public void user_edit_the_phone_number_and_click_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User get a Changes made sucessfully message")
	public void user_get_a_changes_made_sucessfully_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
}
