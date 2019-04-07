package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties or = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	@BeforeSuite()
	public void abc()
	{
		System.out.println("abc");
		 if(driver==null)
		   {
			   try {
				fis = new FileInputStream("C:\\Users\\HP\\eclipse\\java-oxygen\\eclipse\\DDMaven\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				config.load(fis);
				log.debug("config loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   System.out.println("config loaded");
		   
		 
		 try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Or.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				or.load(fis);
				log.debug("or loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   System.out.println("or loaded");
			   System.out.println(config.getProperty("browser"));

		   		if(config.getProperty("browser").equals("chrome"))
		   		{
		   			System.out.println("initilaze browser");
		   			System.getProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		   			driver=new ChromeDriver();
		   			log.debug("chrome browser open");
		   			System.out.println("chrome browser open");
		   		}
		   }
	}
	@AfterSuite
	public void after()
	{
		System.out.println("browser  quit");
	}
	
	
}
