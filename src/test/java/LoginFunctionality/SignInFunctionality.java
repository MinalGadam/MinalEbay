package LoginFunctionality;

import org.testng.annotations.Test;

import Repository.LoginRepo;
import Repository.SignupRepo;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SignInFunctionality 
{
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Onkar Gadam\\Documents\\Automation Testing\\Browser Extension\\chromedriver.exe");
		   driver= new ChromeDriver();
		   driver.manage().window().maximize();
		
	  }

  @Test
  public void f() throws Exception 
  {
	  FileInputStream file=new FileInputStream("C:\\Users\\Onkar Gadam\\Documents\\Automation Testing\\POI\\EbaySigupData.xlsx");
	  XSSFWorkbook w= new XSSFWorkbook(file);
	  XSSFSheet s=w.getSheet("SignIn");
	  
	  int rowSize=s.getLastRowNum();
	  
	  driver.get("https://www.ebay.com/");
	  
	  for(int i=1; i<rowSize; i++)
	  {
		  String Username=s.getRow(i).getCell(0).getStringCellValue();
		 String Pass=s.getRow(i).getCell(1).getStringCellValue();
		  System.out.println(Username +"\t\t"+Pass);
		  
		  try
		  {
			  LoginRepo.ClickOnSignIn(driver).click();
			  Thread.sleep(2000);
			  LoginRepo.UserName(driver).sendKeys(Username);
			  Thread.sleep(2000);
			  LoginRepo.Continue(driver).click();
			  LoginRepo.Pass(driver).sendKeys(Pass);
			  Thread.sleep(2000);
			  LoginRepo.SignInButton(driver).click();
			  driver.findElement(By.id("checkbox")).click();
			  LoginRepo.ClickOnAccountDropdown(driver).click();
			  System.out.println("Valid Data");
			  
			  
			  
		  }
	  
	  
		  catch (Exception e)
		  {
			  System.out.println("Invalid Data");
		  }
		  }
  }
  
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}

