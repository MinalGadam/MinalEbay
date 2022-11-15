package Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProductRepo 
{
static WebElement element;
	
	public static  WebElement SearchBar(WebDriver driver) 
	{
		element=driver.findElement(By.className("gh-tb ui-autocomplete-input"));
		return element;
	}
	public static  WebElement SearchButtonr(WebDriver driver) 
	{
		element=driver.findElement(By.id("gh-btn"));
		return element;
	}
	public static  WebElement SearchByCategory(WebDriver driver) 
	{
		element=driver.findElement(By.id("gh-cat"));
		return element;
	}
	public static  WebElement ShophByCategory(WebDriver driver) 
	{
		element=driver.findElement(By.id("gh-shop-a"));
		return element;
	}
	
}
