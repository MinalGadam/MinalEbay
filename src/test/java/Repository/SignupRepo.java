package Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupRepo 
{
static WebElement element;
public static  WebElement ClickOnRegister(WebDriver driver) 
{
	element=driver.findElement(By.linkText("register"));
	return element;
}


public static  WebElement FirstName(WebDriver driver) 
	{
		element=driver.findElement(By.id("firstname"));
		return element;
	}

public static  WebElement LastName(WebDriver driver) 
{
	element=driver.findElement(By.id("lastname"));
	return element;
}
public static  WebElement Email(WebDriver driver) 
{
	element=driver.findElement(By.id("Email"));
	return element;
}
public static  WebElement Password(WebDriver driver) 
{
	element=driver.findElement(By.id("password"));
	return element;
}
public static  WebElement Register(WebDriver driver) 
{
	element=driver.findElement(By.xpath("//*[@id=\"EMAIL_REG_FORM_SUBMIT\"]"));
	return element;
}

}
