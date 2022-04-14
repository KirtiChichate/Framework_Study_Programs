package selenium_POM_Study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Kite_Test_Class {

	public static void main(String[] args) throws InterruptedException {

System.setProperty("webdriver.chrome.driver", "C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\VELOCITY NOTES\\Automation Notes\\SELENIUM Software\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("https://kite.zerodha.com/");
		Thread.sleep(500);
		driver.manage().window().maximize();
		Thread.sleep(500);

		
		//1---call methods from login class creat the class obj and pass argument as driver
		Kite_Login_Page LoginClass= new Kite_Login_Page(driver);
		
		LoginClass.UserIdMethod();
		LoginClass.PasswordMethod();
		LoginClass.LoginButtonMethod();
		
		
		//2---call methods from login class creat the class obj and pass argument as driver
		Kite_Pin_Page PinClass= new Kite_Pin_Page(driver);
		
		PinClass.PinMethod();
		PinClass.ContinueButtonMethod();
		
		
		//3---call methods from login class creat the class obj and pass argument as driver
		Kite_Home_Page HomeClass= new Kite_Home_Page(driver);
		
		HomeClass.UserIdHomeMethod();
		HomeClass.LogOutOptionMethod();
		
		Thread.sleep(500);
		driver.close();
		
		
		
		
	}

}
