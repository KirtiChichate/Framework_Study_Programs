package selenium_POM_Study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kite_Login_Page {
	
//	Step 1)--->globallically declare the data members---Declaration
//	@FindBy(AttributeName="Attribute value") private WebElement Datamember;
	
	@FindBy(id="userid") private WebElement UserId;
	@FindBy(id="password") private WebElement Password;
	@FindBy(xpath="//button[@type='submit']") private WebElement LoginButton;
	
	
//  Step 2)--->create a constructor having public access specifier and in that create pagefactory class
	
	public Kite_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
//Step 3)--->Create nonstatic methods for this webpage that methods means the elements to take action
	
	public void UserIdMethod()
	{
		UserId.sendKeys("HD5857");
	}
	
	public void PasswordMethod()
	{
		Password.sendKeys("Ajinkya@123");
	}
	
	public void LoginButtonMethod()
	{
		LoginButton.click();
	}


}
