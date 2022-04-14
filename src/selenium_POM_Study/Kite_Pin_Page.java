package selenium_POM_Study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kite_Pin_Page {

//	Step 1)--->globallically declare the data members---Declaration
//	@FindBy(AttributeName="Attribute value") private WebElement Datamember;	
	
	@FindBy(id="pin") private WebElement Pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement ContinueButton;
	
	
//  Step 2)--->create a constructor having public access specifier and in that create pagefactory class
	
	public Kite_Pin_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Step 3)--->Create nonstatic methods for this webpage that methods means the elements to take action
	
	public void PinMethod()
	{
		Pin.sendKeys("969696");
	}
	
	public void ContinueButtonMethod()
	{
		ContinueButton.click();
	}
	
	
}
