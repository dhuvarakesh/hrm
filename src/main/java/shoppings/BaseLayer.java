package shoppings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class BaseLayer {
	public WebDriver driver;
	Excelpage obj= new Excelpage ("D:\\Book2.xlsx");

@BeforeMethod
public void setup()
{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\dhuvarakesh\\Downloads\\chromedriver_32\\chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.className("login")).click();
	}

@AfterMethod
public void tearDown() 
{
	driver.quit();
	}

@DataProvider(name ="Credentials1")
public Object[][] getExcelData() 
{
	int rows= obj.getRowCount("type");
	int column= obj.getColumnCount("type");
	int actRows=rows-1;
	Object[][] data= new Object[actRows][column];
	for(int i=0;i<actRows;i++) {
	for(int j=0; j<column;j++) {
	data[i][j]=obj.getCellData("input", j, i+2);
	}
}
	return data;
	}
}
