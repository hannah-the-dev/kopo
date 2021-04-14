import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;

public class WritingFx {
	String textFile = "C:\\Users\\kopo21\\Desktop\\Fx_History.txt";		// declare file path
	public static Map<String, String> toWrite = new LinkedHashMap<String, String>();	//LinkedHashMap to make orders when writing
	static {{
		toWrite.put("Date", "");	toWrite.put("Time", "");	toWrite.put("Currency", "");	toWrite.put("KRW_took", "");	toWrite.put("Exchanged", "");
		toWrite.put("Fx_rate", "");	toWrite.put("USD_bal", "");	toWrite.put("EUR_bal", "");	toWrite.put("JPY_bal", ""); 	toWrite.put("KRW_change", ""); 
		toWrite.put("KRW_1000", "");	toWrite.put("KRW_500", ""); toWrite.put("KRW_100", "");	toWrite.put("KRW_50", "");	toWrite.put("KRW_10", ""); 
		toWrite.put("USD_100", "");	toWrite.put("USD_50", "");	toWrite.put("USD_20", "");	toWrite.put("USD_10", "");	toWrite.put("USD_5", ""); 
		toWrite.put("USD_1", "");	toWrite.put("EUR_500", "");	toWrite.put("EUR_200", "");	toWrite.put("EUR_100", "");	toWrite.put("EUR_50", "");
		toWrite.put("EUR_20", "");	toWrite.put("EUR_10", "");	toWrite.put("JPY_10000", "");	toWrite.put("JPY_5000", "");	toWrite.put("JPY_2000", ""); 
		toWrite.put("JPY_1000", "");
	}};
	
	public BufferedWriter bw = null;								// declare use of BufferedWriter
//	 BufferedWriter with this file setting will be used across the class
	public WritingFx() throws IOException {							
		bw = new BufferedWriter (new FileWriter(textFile, true));	// bufferedWriter to write conversational file
	}

	public void writesAll() throws IOException {
		
		File file = new File("C:\\Users\\kopo21\\Desktop\\Fx_Table.csv");		// declare file path
		CSVWriter writer = new CSVWriter(new FileWriter(file, true));			// openCSV to write final file
		if (file.length() < 10) {
			writer.writeNext(new ArrayList<>(toWrite.keySet()).toArray(new String[toWrite.size()]));
		}
		String[] writeTemp = toWrite.values().toArray(new String[toWrite.size()]);		// collection<object> -> object[] -> String[]
		writer.writeNext(writeTemp);
		writer.close();

		// toWrite map initialization
		for (String x : toWrite.keySet()) {
			toWrite.put(x, "");
		}
	}
	
	public void writesDate(Date date) throws IOException {				// writes date and time in designated format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		bw.write("Date and time: " + sdf.format(date));
		bw.newLine();
		bw.newLine();
		bw.flush();
		toWrite.put("Date", sdf.format(date).substring(0,10));			// puts date and time to the map
		toWrite.put("Time", sdf.format(date).substring(11));
	}

	public void writesWon(int won) throws IOException {				// writes won amount to exchange
		bw.write("Exchanged amount: " + won + " won");
		bw.newLine();
		bw.flush();
		String wonstr = won+"";
		toWrite.put("KRW_took", wonstr);
	}
	
	public void writesChange(int change) throws IOException {		// writes change amount in won
		bw.write("Change: " + change + " " + FCV.CURRENCY.get("KRW"));
		bw.newLine();
		bw.newLine();
		bw.flush();
		toWrite.put("KRW_change", change+"");						// puts return change amount
	}
	
	public void writesSummary(String currency_key, double toCurrency, double fx) throws IOException {
		bw.write("In " + currency_key + ": " + toCurrency + " " + FCV.CURRENCY.get(currency_key));
		bw.newLine();
		bw.write("Fx rate: " + fx); 
		bw.newLine();
		bw.newLine();
		bw.flush();
		toWrite.put("Currency", currency_key);						// puts Fx currency
		toWrite.put("Exchanged", toCurrency+"");					// puts return amount in foreign currency
		toWrite.put("Fx_rate", fx+"");								// puts fx rate applied
	}
	
	public void writesBills(String currency_key, double toCurrency, int change, double fx, 
			Map<String, Integer> changeDesBills, Map<String, Integer> changeWonBills, List<String> bills) throws IOException {
		bw.write("In " + FCV.CURRENCY.get(currency_key) + ": " + toCurrency);
		bw.newLine();
		writesChange(change);
		for (String x: bills) {
			bw.write(x + " " + FCV.CURRENCY.get(currency_key) + ": " + changeDesBills.get(x));
			bw.newLine();
			toWrite.put(currency_key+"_"+x, changeDesBills.get(x)+"");		// puts each foreign bills quantities
		}
		bw.newLine();

		for (String x: FCV.WON_BILLS) {
			bw.write(x + " " + FCV.CURRENCY.get("KRW") + ": " + changeWonBills.get(x));
			bw.newLine();
			toWrite.put("KRW"+"_"+x, changeWonBills.get(x)+"");				// puts each won bills quantities
		}
		bw.write("---------------------------------------------\n");		
		bw.flush();
	}

	void writesBal(String currency_key) throws IOException {
		bw.write(currency_key +" Balance is "+ FCV.BALANCES.get(currency_key) + " " + FCV.CURRENCY.get(currency_key));
		bw.newLine();
		bw.flush();
		toWrite.put("USD_bal", FCV.BALANCES.get("USD")+"");					// puts balances of foreign bills
		toWrite.put("EUR_bal", FCV.BALANCES.get("EUR")+"");
		toWrite.put("JPY_bal", FCV.BALANCES.get("JPY")+"");
	}
	
	void writesErr(String currency_key, double toCurrency, double fx) throws IOException {
		bw.write(currency_key +" balance is not enough.");
		bw.newLine();
		bw.newLine();
		bw.write("---------------------------------------------\n");
		bw.flush();
		writesBal(currency_key);
	}
}