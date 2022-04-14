package framework_Programs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framework_withDDF {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	
		FileInputStream ObjFile= new FileInputStream("C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\Automation Excel sheet\\IntroExcel.xlsx");  

		Sheet Getsheet = WorkbookFactory.create(ObjFile).getSheet("DDF Data");
		
		String Username = Getsheet.getRow(1).getCell(0).getStringCellValue();
		String Password = Getsheet.getRow(1).getCell(1).getStringCellValue();
		String pin = Getsheet.getRow(1).getCell(2).getStringCellValue();
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\VELOCITY NOTES\\Automation Notes\\SELENIUM Software\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		driver.findElement(By.id("userid")).sendKeys(Username);  //send only single username
		
		driver.findElement(By.id("password")).sendKeys(Password);  //send only single password
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();  //clicking on login button
		Thread.sleep(1000);
		
		//here we need to add single slas' in excel to convert its return type from double to string but it shows as it is value 
		
		driver.findElement(By.id("pin")).sendKeys(pin);    //send pin only for single 
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
