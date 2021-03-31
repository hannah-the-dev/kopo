import java.util.HashMap;
import java.util.Map;

public class FCV {		//FxConstantValues 
	//currency and rates 
	public static final  Map<String, Double> RATES = new HashMap<String, Double>(); 
	static {{
		RATES.put("USD", 1134.30);
		RATES.put("EUR", 1333.09); 
		RATES.put("JPY", 10.30);
	}};
	//currency and words
	public static final  Map<String, String> CURRENCY = new HashMap<String, String>(); 
	static {{
		CURRENCY.put("USD", "dollars");
		CURRENCY.put("EUR", "euros"); 
		CURRENCY.put("JPY", "yen");
		CURRENCY.put("KRW", "won");
	}};
	
	public final static int MENU_USD = 1;			
	public final static int MENU_EUR = 2;
	public final static int MENU_JPY = 3;
	public final static int MIN_KOR = 10;			// min KRW unit can be return 
	
	public final static String[] WON_BILLS = {"1000", "500", "100", "50", "10"};
	public final static String[] USD_BILLS = {"100", "50", "20", "10", "5", "1"};
	public final static String[] EUR_BILLS = {"500", "200", "100", "50", "20", "10"};
	public final static String[] JPY_BILLS = {"10000", "5000", "2000", "1000"};
}
