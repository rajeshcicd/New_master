package git_cicd;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class windows {
	
public	WebDriver driver;
	
	@BeforeTest
	
	public void open()
	{
		
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		
		
		
	}
	
	
//	@Test
	
	public void windows() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//a[text()='Open Seperate Multiple Windows']")).click();
		
		driver.findElement(By.xpath("//button[text()='click ']")).click();
		
		String parent=driver.getWindowHandle();
		
		String parent_title=driver.getTitle();
		
		System.out.println("parent session id" +parent);
		
		Set<String>windows=driver.getWindowHandles();
		
		System.out.println("list of windows "+windows);
		
		for(String child:windows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				
				String child_title=driver.getTitle();
				
				if(!parent_title.equals(child_title))
				{
					driver.close();
				}
				
				
			}
			
			
		}
		
		
	}
	
	@Test
	
	public void seperate_windows() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
		
		driver.findElement(By.xpath("//button[text()='click']")).click();
		
		String parent=driver.getWindowHandle();
		
		String parent_url=driver.getCurrentUrl();
		
		System.out.println("parent_url "+parent_url);
		
		Set<String>windows=driver.getWindowHandles();
		
		for(String child:windows)
		{
			String child_url=driver.getCurrentUrl();
			
			System.out.println("child_url "+child_url);
			
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
				
				driver.close();
				
			}
		}
	
		
	}
	
	public void take_sc() throws WebDriverException, IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(""));
		
		
		
		
	
	}
	

	@FindBy(xpath="")
	private static WebElement clicktest;
	
	
	public String clcik()
	{
		clicktest.getText();
		
		return clicktest.getText();
		
		
	}

}
