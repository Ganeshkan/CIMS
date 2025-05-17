package Base.cims;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public  TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"F:\\Projects_Documents\\CIMS\\ORCBDS\\ORCBDS\\ORCBDS_Functional TestScript\\src\\main\\java\\config\\cims\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Launch-Web browser
	public static void intialization() {
		String browsername = prop.getProperty("browser"); //browsername = chrome
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
		}else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browsername.equals("edge")){
			WebDriverManager.edgedriver().setup();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(util.cims.TestUtil.PageLoadTimeOut));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(util.cims.TestUtil.ImplicitWait));	
		driver.get(prop.getProperty("url"));
		
		
	}

	//******************** READ XL FILE CODE  ********************************
	public String[][] Testxlfile() throws IOException {
		File Testxldata=new File("E:\\GK\\CIMS_Automation\\src\\main\\java\\cims\\config\\config.properties");
		FileInputStream txl=new FileInputStream(Testxldata);
		XSSFWorkbook Workbook = new XSSFWorkbook(txl);
		XSSFSheet sheet =Workbook.getSheet("AddUser");
		int noOfrows=sheet.getPhysicalNumberOfRows();
		int noOfcolumns=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[noOfrows-1][noOfcolumns];
		for (int i=0; i<noOfrows-1; i++) {
			for (int j=0; j<noOfcolumns; j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));	
			}
			System.out.println();
		}
		Workbook.close();
		txl.close();
		return data;
	}
	
	
	
	public static void SelectDateFromDatePickerUsingParameters(String Documentdate,String YearXpath,
			String MonthXpath,String DateXpath) throws ParseException, InterruptedException
	{
		WebElement PIDateYearSelect=driver.findElement(By.xpath("(//div[contains(@class,'mat-calendar-content')])"));  /////to select  year from  dropdown
		List<WebElement> PIcolumns = PIDateYearSelect.findElements(By.tagName("td"));
	    String Getyear= new String(String.valueOf(GetYear(Documentdate)));
         for (WebElement year: PIcolumns) {
			String dateyear = year.getText();
			if(dateyear.equals(Getyear))
			{
				year.click();
				break;
			}
		}
		TimeUnit.SECONDS.sleep(3);
		WebElement PIDateMonthSelect=driver.findElement(By.xpath("(//tbody[contains(@class,'mat-calendar-body')])"));/////to select  moonth from  dropdown
		List<WebElement> PIMonthcolumns = PIDateMonthSelect.findElements(By.tagName("td"));
		String GetMonth= new String(String.valueOf(GetMonth(Documentdate)));
		for (WebElement Month: PIMonthcolumns) {
			String Date = Month.getText();
			if(Date.equals(GetMonth))
			{
				Month.click();
				break;
			}
		}
		TimeUnit.SECONDS.sleep(3);
		WebElement PISelectDate=driver.findElement(By.xpath("(//tbody[contains(@class,'mat-calendar-body')])"));/////to select  date from  dropdown
		List<WebElement> PIDatecolumns = PISelectDate.findElements(By.tagName("td"));
		String getdate= new String(String.valueOf(GetDateFromPassedDate(Documentdate)));
		for (WebElement Docdate: PIDatecolumns)
		{
			String Date = Docdate.getText();
			//System.out.println(Date);
			if(Date.equals(getdate))
			{
				Docdate.click();
				break;
			}
		}
	}
	
	
	
	
	
private static char[] GetDateFromPassedDate(String documentdate) {
		// TODO Auto-generated method stub
		return null;
	}

private static char[] GetMonth(String documentdate) {
		// TODO Auto-generated method stub
		return null;
	}

private static char[] GetYear(String documentdate) {
		// TODO Auto-generated method stub
		return null;
	}

public void writeExcel(String sheetname, String cellvalue, int row, int col) throws IOException {
		
		String excelpath="D:\\Automation Testing Reports\\Testing Report.xlsx";
		File file=new File(excelpath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetname);
		sheet.getRow(row).createCell(col).setCellValue(cellvalue);
		FileOutputStream fos=new FileOutputStream(new File(excelpath));
		wb.write(fos);
		wb.close();
	}
 public String Alphabetic_Values() {
	 int length = 10;
	 boolean useLetters = true;
	 boolean useNumbers = false;
	 String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	 return generatedString;
 }
	public  String Numeric_values() {
		int length = 10;
		boolean useLetters = false;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}
	public String AlphaNumeric_values(){
		int length = 10;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}
	
	public String Description_values() {
		int length = 100;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}
	public String Firstname() {
		String[] firstname= {"Wade", "Dave","Seth","Ivan","Riley","Gilbert","Jorge","Dan","Brian","Roberto","Ramon","Miles","Liam","Nathaniel","Ethan","Lewis","Milton"};
		Random random=new Random();
		return firstname[random.nextInt(firstname.length)];
	}
	public String Lastname() {
		String[] lastname= {"Mark","Ron","Craig","Philip","Jimmy","Arthur","Jaime","Perry","Harold","Jerry","Shawn","Walter","Sebastian","Stefan","Robin","Clarence","Sandy","Ernest","Samuel"};
		Random random=new Random();
		System.out.println(lastname[random.nextInt(lastname.length)]);
		return lastname[random.nextInt(lastname.length)];
	}
	
	public String BusinessName() {
		String[] businessname= {"Spa Paragon","GameDay Catering","Exploration Kids","Yoga Professor","Darwin Travel.","Party Plex.","Pizza Factor.","Acorn Crafts"};
		Random random=new Random();
		return businessname[random.nextInt(businessname.length)];
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
