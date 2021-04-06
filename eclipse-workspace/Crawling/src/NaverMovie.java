import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVWriter;

//APACHE common math => statistics

public class NaverMovie {

	private WebDriver driver;
	private WebElement element;
	
	public static final String WEB_DRRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRRIVER_PATH = "C:/Users/kopo21/Downloads/Selenium/chromedriver_win32/chromedriver.exe";
	public static final String FILE_PATH = "C:\\Users\\kopo21\\Desktop\\movieRanking.csv";
	private static Map<String, String> listings = new LinkedHashMap<String, String>(); 	// save movie id and title
	
	private String rank_url;
	private String start_url;
	
	public NaverMovie() {
		super();
		//driver property setup
		System.setProperty(WEB_DRRIVER_ID, WEB_DRRIVER_PATH);
		
		//driver setup
		driver = new ChromeDriver();	//start url
		rank_url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt&date=20210404&page=";
		start_url = "https://movie.naver.com/movie/bi/mi/basic.nhn?code=";
	}
	
	public void getIDs() {
		String pageID = "";
		String title = "";
		
		for(int p = 1; p < 2; p++) { 		// p == page # (1~20)
			try {
				//get page
				driver.get(rank_url+p);
	//				System.out.println(driver.getPageSource());
	//				driver.getPageSource();
				
	//				WebDriverWait wait = new WebDriverWait(driver, 5);
	//				
	//				wait.until();
					
				Thread.sleep(3000);
	
				//finds id and title
				for (int i = 1; i < 56; i++) {			// rank from 1 to 2000 (50 per page), 5 separators
					try {
						element = driver.findElement(By.xpath("//*[@id=\"old_content\"]/table/tbody/tr["+(i)+"]/td[2]/div/a"));
						title = element.getText();
	//					System.out.println(i+" "+name);
						pageID = element.getAttribute("href").split("code=")[1];
						System.out.println(pageID);
						listings.put(pageID, title);			//saving page code and title
					} catch (NoSuchElementException e) {
						
					} 
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				p--;			// if error, try the same page again;
				continue;
			} finally {
	//			System.out.println(listings.toString());
				driver.close();
			}
		}
	}
	
	public void getInfo(Map<String, String> listings) throws IOException {
		String[] tempList = {};
		String tempListStr = "";
		
		String users = "";
		String writers = "";
		String netizens = "";
		String genre = "";
		String nation = "";
		String running = "";
		String year = "";
		String date = "";
		String director = "";
		String actors = "";
		String ratingK = "";
		String ratingU = "";
		

//		File file = new File("C:/Users/kopo21/Desktop/movieRanking.csv");
//		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//		String NEWLINE = System.lineSeparator();
//		bw.newLine();
		CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH, true));
		String[] title = "ID,Title,Payer Score,Prof. Socre,User Socre,Genre,Nation,Running time,Year,Date,Director,Stared,Rate_Ko,Rate_USA".split(",");
		writer.writeNext("ID,Title,Payer Score,Prof. Socre,User Socre,Genre,Nation,Running time,Year,Date,Director,Stared,Rate_Ko,Rate_USA".split(","));
//		writeTitle(title);
		
		for (String id: listings.keySet()) {
			try {
				Document page = Jsoup.connect(start_url+id).get();
				// star-rated section
				Elements stars = page.select("#container span > span");	
				for (int i = 0; i < 3; i++) {
					String tempStr;
					String tempNum;
					if (stars.get(i).attr("style") == "") tempNum = "0.0";
					else {
						tempStr = stars.get(i).attr("style").substring(6, stars.get(i).attr("style").length()-1);
						tempNum = Math.round((Double.parseDouble(tempStr) * 100))/1000.0 + "";
					}
					switch(i) {
					case 0: users = tempNum; break; 
					case 1: writers = tempNum; break; 
					case 2: netizens = tempNum; break; 
					}
				}
				
				// film information section
				Elements info = page.select("#content > div.article > div.mv_info_area > div.mv_info > dl");
				Elements basic = info.select("dd:nth-child(2) > p > span");
				genre = basic.first().text();
				nation = basic.get(1).text();
//				running = Integer.parseInt(basic.get(3).text());
				running = basic.get(2).text();
				year = basic.select("a").first().text();
				date = basic.select("a").get(2).text();
				director = info.select("dd:nth-child(4) > p > a").text();
				actors = info.select("dd:nth-child(6) > a").text();
				ratingK = info.select("dd:nth-child(8) > p > a:nth-child(1)").text();
				ratingU = info.select("dd:nth-child(8) > p > a:nth-child(2)").text();
				
				tempListStr = id+","+listings.get(id)+","+users+","+writers+","+netizens+","+genre+","+nation+","+running+","+year+","+date+","+director+","+actors+","+ratingK+","+ratingU;
				tempList = tempListStr.split(",");
				writer.writeNext(tempList);
//				writeCSV(tempList);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
		}
		writer.close();
	}
	void writeTitle(String[] tempList) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH));
		writer.writeNext("ID,Title,Payer Score,Prof. Socre,User Socre,Genre,Nation,Running time,Year,Date,Director,Stared,Rate_Ko,Rate_USA".split(","));
		writer.close();
	}
	
	void writeCSV(String[] tempList) throws IOException {
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		NaverMovie movie = new NaverMovie();
		movie.getIDs();
	}
}
