package step_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class step_class {
     WebDriver driver;
     @Given("^Open google finance website$")
     public void open_google_finance_website() throws Throwable {
   
    	 System.setProperty("webDriver.chrome.driver", "\"C:\\chormeDriver\\chrome-win64\\chrome.exe\"");
		 ChromeOptions naz= new ChromeOptions();
		 naz.addArguments("--remote-allow-origins=*");
		 
		 driver= new ChromeDriver();
		 driver.get("https://www.google.com/finance/");
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }



	@Then("^Enter Google in serch field$")
	public void enter_Google_in_serch_field() throws Throwable {
	    
		WebElement search= driver.findElement(By.xpath("/html/body/c-wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]"));
		search.sendKeys("Google");
		WebElement search2= driver.findElement(By.xpath("/html/body/c-wiz[2]/div/div[3]/div[3]/div/div/div/div[1]/input[2]"));
		search2.sendKeys(Keys.ENTER);
	}

	@Then("^Print previous close result$")
	public void print_previous_close_result() throws Throwable {
	String rslt = driver.findElement(By.xpath("/html/body/c-wiz[3]/div/div[4]/div/main/div[2]/div[2]/div/div[1]/div[2]/div")).getText();
	 System.out.println("previous close result is" + rslt);
	 Thread.sleep(3000);
	}

	@Then("^Print all links count$")
	public void print_all_links_count() throws Throwable {
	    
		List<WebElement> alllink = driver.findElements(By.tagName("a"));
		System.out.println("Total links in this page" + alllink.size());
		for(int i=0; i<alllink.size(); i ++) {
			System.out.println(alllink.get(i).getAttribute("href"));
		}
		  
		   driver.close();
		  
	}
	


	
}
