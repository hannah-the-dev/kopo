package problems;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Receipt1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat k21_format = new DecimalFormat("###,###,###");			// 숫자 포맷 지정
		Calendar k21_cal = Calendar.getInstance();								// 시스템 시간으로 날짜 설정
		SimpleDateFormat k21_sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");	// 날짜 포맷 지정
		int k21_slipNum = 41218;												// 전표 번호 생성
		Scanner sc = new Scanner(System.in);
		int k21_iPrice = sc.nextInt();													// amount after tax	
		int beforeTax = (int) Math.ceil(k21_iPrice/1.1);						// 세전 금액 계산, 올림 금액

		System.out.printf(" 신용 승인\n");										
		System.out.printf("단말기 : 2N68665898	      전표번호 : %06d\n",k21_slipNum); // 전표번호 6자리, 부족하면 0으로 채우기
		System.out.printf("가맹점 : 한양김치찌개\n");		
		String k21_address = "경기 성남시 분당구 황새울로351번길 10, 1층";		// 매장 주소
		System.out.printf("주  소 : %.25s\n", k21_address);						// 매장 주소 25자리까지 까지 출력
		System.out.printf("%.25s\n", k21_address.substring(25));				// 이후 자리 출력
		System.out.printf("대표자 : 유창신\n");								
		System.out.printf("사업자 : 572-53-00558             TEL : 7055695\n");
		System.out.printf("- - - - - - - - - - - - - - - - - - - - - - - -\n");
		
		System.out.printf("금  액             %25s 원\n", k21_format.format(beforeTax));		// 세전 금액 포맷대로 출력
		System.out.printf("부가세             %25s 원\n", k21_format.format(k21_iPrice-beforeTax));	// 세액 계산, 버림금액 출력
		System.out.printf("합  계             %25s 원\n", k21_format.format(k21_iPrice));		// 세후 금액 포맷대로 출력
		System.out.printf("- - - - - - - - - - - - - - - - - - - - - - - -\n");
		String k21_credit = "1234-5678-9010-1112";								// 카드번호
		System.out.printf(" 우리카드\n");
		System.out.printf("카드번호 : %.7s**-****%5s(S) %10s\n", k21_credit, k21_credit.substring(14),"일시불");
		// 카드번호 중간자리 6개 *로 출력 후 나머지 다시 출력, 할부월수 출력
		System.out.printf("거래일시 : %s\n", k21_sdf.format(k21_cal.getTime()));	// 설정된날짜 출력
		System.out.printf("승인번호 : %08d\n", 70404427);							// 승인번호 8자리로 출력
		System.out.printf("거래번호 : %12s\n", "111122223333");						// 거래번호 12자리로 출력
		System.out.printf("매입 : %.12s    가맹 : %d\n", "비씨카드사", 720068568); // 매입 카드사, 가맹점 번호 출력
		System.out.printf("알림 : EDC매출표\n");
		System.out.printf("문의 : TEL) 1544-4700\n");
		System.out.printf("- - - - - - - - - - - - - - - - - - - - - - - -\n");
		System.out.printf("                  * 감사합니다 *               \n");
		System.out.printf("%45s\n", "표준V2.08_20200212");							// 45자 중 오른쪽 정렬로 String 출력
		
		
	}

}
