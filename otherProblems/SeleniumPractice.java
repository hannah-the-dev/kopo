package otherProblems;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeleniumPractice seltest= new SeleniumPractice();
		seltest.crawl();
	}
	//web driver
	private WebDriver driver;
	
	// property
	public static final String WEB_DRIVER_ID = "webdriver.chrome.dirver";
	public static final String WEB_DRIVER_PATH = "C:/Users/kopo21/Downloads/Selenium/chromedriver.exe";
	
	//url to crawl
	private String base_url;
	
	public SeleniumPractice() {
		super();
		
		//system property setup
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		//driver setup
		driver = new ChromeDriver();
		base_url = "https://www.naver.com";
	}
	public void crawl() {
		try {
			driver.get(base_url);
			System.out.println(driver.getPageSource());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}
