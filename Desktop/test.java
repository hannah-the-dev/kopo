public class test {

	public static void main(String[] ar) throws InterruptedException{
		System.out.println("MainThread End");
		System.out.println("ABC");
		System.out.println("ABC");
		System.out.print("\033[F\r");
		System.out.println("EDF");
	}
	
}