package RegistrationFunctionality;

import org.testng.annotations.Test;

import Repository.SignupRepo;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Signup 
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
	  XSSFSheet s=w.getSheet("EbaySignupData");
	  
	  int rowSize=s.getLastRowNum();
	  
	  driver.get("https://www.ebay.com/");
	  
	  for(int i=1; i<=rowSize; i++)
	  {
		  String fn=s.getRow(i).getCell(0).getStringCellValue();
		  String ln=s.getRow(i).getCell(1).getStringCellValue();
		  String email=s.getRow(i).getCell(2).getStringCellValue();
		  String pass=s.getRow(i).getCell(3).getStringCellValue();
		  
		  System.out.println(fn+"\t\t"+ln+"\t\t" +email+"\t\t" +pass);
		  
		  try
		  {
			  SignupRepo.ClickOnRegister(driver).click();
			  Thread.sleep(2000);
			  SignupRepo.FirstName(driver).sendKeys(fn);
			  Thread.sleep(2000);
			  SignupRepo.LastName(driver).sendKeys(ln);
			  Thread.sleep(2000);
			  SignupRepo.Email(driver).sendKeys(email);
			  Thread.sleep(2000);
			  SignupRepo.Password(driver).sendKeys(pass);
			  Thread.sleep(2000);
			  SignupRepo.Register(driver).click();
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
