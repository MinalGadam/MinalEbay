package SearchFeature;

import org.testng.annotations.Test;

import Repository.SearchProductRepo;

import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class SearchFunctionality 
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
	  XSSFSheet s=w.getSheet("SearchProduct");
	  
	  int rowSize=s.getLastRowNum();
	  System.out.println("No. of Products"+ rowSize);
	  
	  for(int i=1; i<rowSize; i++)
	  {
		  String Products=s.getRow(i).getCell(0).getStringCellValue();
		  System.out.println("Products:"+Products);
		  
		  try
		  {
		  driver.get("https://www.ebay.com/n/all-categories");
		  Thread.sleep(2000);
		  Actions ac=new Actions(driver);
		  
		  ac.moveToElement(SearchProductRepo.SearchBar(driver)).build().perform();
		  SearchProductRepo.SearchBar(driver).sendKeys(Products);
		  SearchProductRepo.SearchButtonr(driver).click();
		  System.out.println("Valid Data");
		  System.out.println("");
		  
		  }
	 catch(Exception e) 
		  {
		 System.out.println("Invalid Data");
		 System.out.println("");
		  }
		  SearchProductRepo.SearchBar(driver).clear();
  }
  }

  
  @AfterTest
  public void afterTest() 
  {
	  driver.close();
}

}

