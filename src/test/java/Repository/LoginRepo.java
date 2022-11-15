package Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginRepo 
{
	static WebElement element;
	
	public static  WebElement ClickOnSignIn(WebDriver driver) 
	{
		element=driver.findElement(By.linkText("Sign in"));
		return element;
	}
	
	
	public static  WebElement UserName(WebDriver driver) 
	{
		element=driver.findElement(By.id("userid"));
		return element;
	}
	
	public static  WebElement Continue(WebDriver driver) 
	{
		element=driver.findElement(By.id("signin-continue-btn"));
		return element;
	}
	
	public static  WebElement Pass(WebDriver driver) 
	{
		element=driver.findElement(By.id("pass"));
		return element;
	}
	
	public static  WebElement SignInButton(WebDriver driver) 
	{
		element=driver.findElement(By.id("sgnBt"));
		return element;
	}
	
	
	public static  WebElement ClickOnAccountDropdown(WebDriver driver) 
	{
		Select ClickOnAccountDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"gh-ug\"]")));
		return element;
	}
	public static  WebElement ClickOnLogOut(WebDriver driver) 
	{
		element=driver.findElement(By.linkText("Sign out"));
		return element;
	}
}