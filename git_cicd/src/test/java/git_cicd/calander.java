package git_cicd;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calander {
	
	

	public WebDriver driver;
	
	
	@BeforeTest()
	public void open_browser()
	{
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		
		driver.navigate().to("http://www.leafground.com/pages/Calendar.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		
		
		
	}
	
	@Test
	public void date()
	
	{
		
		driver.findElement(By.id("datepicker")).click();
		
		driver.findElement(By.xpath("//a[text()='10']")).click();
		
		
		
	}
	


}
