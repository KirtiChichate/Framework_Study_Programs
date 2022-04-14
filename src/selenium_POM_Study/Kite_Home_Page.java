package selenium_POM_Study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kite_Home_Page {

//	Step 1)--->globallically declare the data members---Declaration
//	@FindBy(AttributeName="Attribute value") private WebElement Datamember;	
	
	@FindBy(xpath="//span[@class='user-id']") private WebElement UserIdHome;
	@FindBy(xpath="//a[@target='_self']") private WebElement LogoutOption;
	
	
//  Step 2)--->create a constructor having public access specifier and in that create pagefactory class
	
	public Kite_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Step 3)--->Create nonstatic methods for this webpage that methods means the elements to take action
	
	public void UserIdHomeMethod()
	{
		String ActualUserId = UserIdHome.getText();
		String ExpectedUserId = "HD5857";
		
		if(ExpectedUserId.equals(ActualUserId))
		{
			System.out.println("UserId is matching so test case is passed");
		}
		else
		{
			System.out.println("UserId is not matching so test case is failed");
		}
		
	}	
		
	
	public void LogOutOptionMethod() throws InterruptedException
		{
		    UserIdHome.click();
		    Thread.sleep(500);
		    LogoutOption.click();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
