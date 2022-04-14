package selenium_POM_And_DDF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Kite_TestDDF_Using_ChromeOption {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\VELOCITY NOTES\\Automation Notes\\SELENIUM Software\\chromedriver.exe");
		
//here insted of launch browser u can have option i.e headless to create that 

        ChromeOptions obj= new ChromeOptions();
        obj.addArguments("Headless");
        WebDriver driver= new ChromeDriver(obj);   //due to this we r not seeing the browser but the action can be taken in backdata and we got the output in console 
//Here some are the addarguments
/*  Below are the list of available and most commonly used arguments for ChromeOptions class

start-maximized: Opens Chrome in maximize mode
incognito: Opens Chrome in incognito mode
headless: Opens Chrome in headless mode
disable-extensions: Disables existing extensions on Chrome browser
disable-popup-blocking: Disables pop-ups displayed on Chrome browser
make-default-browser: Makes Chrome default browser
version: Prints chrome browser version
disable-infobars: Prevents Chrome from displaying the notification ‘Chrome is being controlled by automated software

      
		*/
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		
//Take the data from excel sheet so for that follow the steps to get excel sheet data
		
		FileInputStream ObjFile= new FileInputStream("C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\Automation Excel sheet\\IntroExcel.xlsx");  

		Sheet Getsheet = WorkbookFactory.create(ObjFile).getSheet("DDF Data");

	//Approch--1	Approch--1        Approch--1  we can use this approach or approach 2
		
		String UsernameDDF = Getsheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordDDF = Getsheet.getRow(1).getCell(1).getStringCellValue();
		String pinDDF = Getsheet.getRow(1).getCell(2).getStringCellValue();
		
		
	//now call the methods by creating object of DDf class 1
		Kite_Login_DDFPage DDFobj= new Kite_Login_DDFPage(driver);
		DDFobj.EnterUsername(UsernameDDF);
		DDFobj.EnterPassword(PasswordDDF);
		DDFobj.ClickingLoginButton();
		
		Thread.sleep(1000);
		//now call the methods by creating object of DDf class 2
		Kite_Pin_DDFPage DDFobj2= new Kite_Pin_DDFPage(driver);
		DDFobj2.EnterPin(pinDDF);
		DDFobj2.ClickingContinueButton();
		
		Thread.sleep(1000);
		//now call the methods by creating object of DDf class 3
		Kite_Home_DDFPage DDFobj3= new Kite_Home_DDFPage(driver);
		DDFobj3.ValidateUsername(UsernameDDF);
		DDFobj3.ClickingLogout();            
		
		
		driver.close();

	}

}
