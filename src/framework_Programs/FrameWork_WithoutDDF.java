package framework_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameWork_WithoutDDF {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\VELOCITY NOTES\\Automation Notes\\SELENIUM Software\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		driver.findElement(By.id("userid")).sendKeys("HD5857");  //send only single username
		
		driver.findElement(By.id("password")).sendKeys("Ajinkya@123");  //send only single password
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();  //clicking on login button
		Thread.sleep(1000);
		
		driver.findElement(By.id("pin")).sendKeys("969696");    //send pin only for single 
		driver.findElement(By.xpath("//button[@type='submit']")).click();  //click on continue button
		Thread.sleep(1000);
		
	    WebElement UserName = driver.findElement(By.className("user-id")); // after login check that username is as per the actual username
         String ActualUsername = UserName.getText();
         String ExpectedUsername = "HD5857";
         
         if(ExpectedUsername.equals(ActualUsername))
         {
        	 System.out.println("Username is correct its matching, this test case is passed");
         }
         
         else
         {
        	 System.out.println("Username is incorrect not matching, this test case is failed");
         }
         
         //now if this test case is passed then we have to logout for that 1st we need to click on that username then choose option logout
         UserName.click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("//a[@target='_self']")).click();
         Thread.sleep(1000);
         
         driver.close();

	}

}
