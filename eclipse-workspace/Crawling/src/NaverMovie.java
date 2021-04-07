import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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

public class NaverMovie extends java.lang.Object {

	WebDriver driver;
	WebElement element;
	
	public static final String WEB_DRRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRRIVER_PATH = "C:/Users/kopo21/Downloads/Selenium/chromedriver_win32/chromedriver.exe";
	public static final String FILE_PATH = "C:/Users/kopo21/Desktop/movieRanking.csv";
	public final String[] TITLE = "ID,Title,User Scores,Specialist Socres,Genre,Nation,Year,Date,Director,Stared,Rate_Ko,Rate_USA".split(",");
	
	private static Map<String, String> LISTINGS = new LinkedHashMap<String, String>(); 	// save movie id and title
	
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
	
	public void getTitle() throws IOException {	

		File file = new File("C:/Users/kopo21/Desktop/movieRanking.csv");
		if (!file.exists()) {
				file.createNewFile();
		}
		writeTitle(TITLE);
	}
	
//	public Map<String, String> getIDs(int n) throws IOException {
	public void getIDs(int times) throws IOException {
		
		for(int p = 1; p < times+1; p++) { 		// repeats n times p == page # (1~20)
			try {
				//get page
				System.out.println(rank_url+p);
				driver.get(rank_url+p);
					
				Thread.sleep(3000);
	
				//finds id and title
				for (int i = 1; i < 56; i++) {			// rank from 1 to 2000 (50 per page), 5 separators
					try {
//						String pageID = "";
//						String title = "";
						element = driver.findElement(By.xpath("//*[@id=\"old_content\"]/table/tbody/tr["+(i)+"]/td[2]/div/a"));
						String title = element.getText();
	//					System.out.println(i+" "+name);
						String pageID = element.getAttribute("href").split("code=")[1];
						System.out.println(pageID);
						LISTINGS.put(pageID, title);			//saving page code and title
					} catch (NoSuchElementException e) {
					} 
				}
			} catch (Exception e) {
				e.printStackTrace();
				p--;			// if error, try the same page again;
				continue;
			} finally {
	//			System.out.println(listings.toString());
			}
		}
		getInfo(LISTINGS);
		driver.close();
		System.out.println("Driver closed");
	}

	public void getInfo(Map<String, String> listings) throws IOException {
		String[] tempList = {};
		String tempListStr = "";
			
		for (String id: listings.keySet()) {
			String netscore = "";
			String spcscore = "";
			String genre = "";
			String nation = "";
//			String running = "";
			String year = "";
			String date = "";
			String director = "";
			String actors = "";
			String ratingK = "";
			String ratingU = "";
			int counter = 0;
			try {
				Document page = Jsoup.connect(start_url+id).get();
				// star-rated section
//				Elements stars = page.select("#container span > span");	
				netscore = page.select("div.netizen_score > div > div > em").text();
				spcscore = page.select("div.special_score > div > div > em").text();
				if (netscore.equals("0.00") || spcscore.equals("0.00")) continue;
				
				// film information section
				Elements info = page.select("#content > div.article > div.mv_info_area > div.mv_info > dl");
				Elements basic = info.select("dd:nth-child(2) > p > span");
//				genre = StringUtils.substringBetween(Xsoup.compile("//*[@id=\"content\"]/div[1]/div[2]/div[1]/dl/dd[1]/p/span[1]/a")
//						.evaluate(page).get(), ">", "</a");
//				System.out.println(genre);
//				genre = StringUtils.substringBetween(basic.select(".*genre").get(0).text(), "=", ">");
				System.out.print(listings.get(id) + "\t");
				genre = basic.outerHtml().contains("?genre") ? basic.select("a[href*=?genre]").get(0).text() : "";
				nation = basic.outerHtml().contains("?nation") ? basic.select("a[href*=?nation]").get(0).text() : "";
//				running = Integer.parseInt(basic.get(3).text());
//				running = StringUtils.substringBetween(basic.outerHtml(), "N=a:ifo.nation", "분 </span>").replace(" --> </span>\n<span>", "");
//				System.out.println("run: "+ running);
				year = basic.outerHtml().contains("?open") ? basic.select("a[href*=?open]").get(0).text() : "";
				date = basic.outerHtml().contains("?open") ? basic.select("a[href*=?open]").get(1).text() : "";
//				System.out.println("open: "+year + date);
				
				director = (info.text().contains("감독") && info.text().contains("출연")) ? 
						StringUtils.substringBetween(info.text(), "감독", "출연") : StringUtils.substringBetween(info.text(), "감독", "등급");
				System.out.printf("director: "+director+ "\t");
				actors = (info.text().contains("출연") && info.text().contains("등급")) ? 
						StringUtils.substringBetween(info.text(), "출연", "등급").replace("더보기","") : "";
				System.out.printf("actors" + actors + "\t");
				ratingK = info.outerHtml().contains("?grade=1001") ? info.select("a[href*=?grade=1001]").get(0).text() : "";
				System.out.printf("ratingK:" + ratingK + "\t");
				ratingU = info.outerHtml().contains("?grade=1011") ? info.select("a[href*=?grade=1011]").get(0).text() : "";
				System.out.println("ratingU: "+ratingU);
				
				tempListStr = id+"#"+listings.get(id)+"#"+netscore+"#"+spcscore+"#"+genre+"#"+nation+"#"+year+"#"+date+"#"+director+"#"+actors+"#"+ratingK+"#"+ratingU;
				tempList = tempListStr.split("#");
				
				writeCSV(tempList);
				
				counter++;
				if (counter % 100 == 0)
				Thread.sleep(1000*60*5);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
		}
	}
	void writeTitle(String[] title) throws IOException {
		CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH, true), "EUC-KR"));
		writer.writeNext(title);
		writer.close();
	}
	
	void writeCSV(String[] tempList) throws IOException {
		CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH, true), "EUC-KR"));
		writer.writeNext(tempList);
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		NaverMovie movie = new NaverMovie();
		movie.getTitle();			// makes file and write title
		movie.getIDs(40);			// take ID and film title per page total 40 pages
//		driver.close();
	}
}
