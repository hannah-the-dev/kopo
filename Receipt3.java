package problems;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Receipt3 {		//emart

	public static void main(String[] args) {
		DecimalFormat k21_format = new DecimalFormat("###,###,###"); 			//출력 포맷 지정
		Calendar k21_cal = Calendar.getInstance();								// 현재 시스템 시간 인스턴스 받아오기
		SimpleDateFormat k21_sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	// 날짜 포맷 지정
		String[] item = {
				"매일허쉬초콜릿드링크", "빙그레바나나맛우유", "매일아침에오렌지주스", "서울우유서울우유저지방900ml", "스타벅스더블샷에스프레소&크림(200ml*4캔)",
				"서울우유체다슬라이스치즈(300g2개입)600g", "소와나무체다치즈클래식204g", "필라델피아소프트필라델피아크림치즈플레인200g", "상하치즈더블업모짜렐라슬라이스 240g", "그라나파다노150g",
				"피코크페페론치노홀25g(파우치)", "CJ백설자일로스설탕(하얀) 1kg", "하인즈스위트랠리쉬769ml", "레벤스바움유기농오레가노15g", "르네디종홀그레인머스타드 190g",
				"노브랜드채끝스테이크육포200g", "양송이크림스프 270g", "CJ스팸클래식1,200g(200g*6입)", "농심둥지냉면 비빔냉면 162gx4입", "농심사천짜파게티4입",
				"큐원유러피언와플믹스500g", "(주)복음자리45도과일잼 딸기 350g", "CJ백설퓨어올리브오일 500ml", "샘표연두275ml*2", "CJ투썸요거트파우더320g",
				"삼양핵불닭소스200g", "청정원명란크림파스타소스350g", "꽃게탕면412g(4입)", "오리온오그래놀라바검은콩120g", "하인즈리듀스드케찹369g" 
		};				// 구매 품목 저장 array
		int[] k21_price = {
				1500, 1700, 2500, 1800, 2500,
				7800, 3200, 6300, 4250, 5100,
				3800, 4400, 5000, 4480, 6700,
				6500, 6370, 3400, 7560, 1300,
				3500, 4750, 6830, 9210, 3420,
				4500, 3480, 6400, 3420, 5300
		};				// 구매 단가
		int[] k21_qty = {
				1, 3, 1, 2, 5,
				2, 1, 1, 1, 2,
				3, 1, 1, 3, 4,
				3, 3, 1, 4, 1,
				2, 2, 1, 1, 4,
				5, 1, 3, 1, 1
		};				// 품목당 구매 개수
				boolean[] k21_tax = {
				true, true, true, true, true,
				true, false, true, true, false,
				true, true, false, true, true,
				true, true, true, true, false,
				true, true, false, true, true,
				false, true, true, true, true,
		};				// 구매 품목 부가세 부여 여부
		
		System.out.printf("    	emart   이마트 죽전점 (031)888-1234\n");
		System.out.printf("    	emart   206-86-50913 강희석\n");
		System.out.printf("    	emart   용인 수지구 포은대로 552\n\n");
		System.out.printf("영수증 미지참시 교환/환불 불가\n");
		System.out.printf("정상상품에 한함, 30일 이내(신선7일)\n");
		System.out.printf("※일부 브랜드매장 제외(매장 고지물참조)\n");
		System.out.printf("교환/환불 구매점에서 가능(결제카드 지참)\n\n");
		
		System.out.printf("[구매]%.16s             POS:%s\n", k21_sdf.format(k21_cal.getTime()), "0011-9861");
		// 구매 시간은 초단위까지 표시, 포스 번호 표시
		System.out.printf("------------------------------------------------\n");
		System.out.printf("  %-8s %15s %4s %6s\n", "상 품 명", "단 가", "수량", "금 액");
		System.out.printf("------------------------------------------------\n");
		
		int k21_dutyFree = 0;			// 면세 품목 합계 저장용
		int k21_duty = 0;				// 과세 품목 합계 저장용
		int k21_counter = 0;			// 총 수량 계산용
		
		for (int k21_i = 0; k21_i < item.length; k21_i++) {		// 품목 개수만큼 반복
			if (k21_tax[k21_i] == false) { 						// 해당 품목 면세품목일 경우
				System.out.printf("* ");						// * 출력
				k21_dutyFree += k21_qty[k21_i] * k21_price[k21_i];	// dutyFree에 합산
			}
			else {												// 면세 품목이 아닐 경우
				System.out.printf("  ") ;						// 공란 출력
				k21_duty += k21_qty[k21_i] * k21_price[k21_i];	// duty에 합산
			}
			System.out.printf("%-10.10s	%8s %4d %10s\n", item[k21_i], k21_format.format(k21_price[k21_i]), 
					k21_qty[k21_i], k21_format.format(k21_qty[k21_i] * k21_price[k21_i]));
			// 품목 10자리까지 채워서 표시, 단가, 수량, 금액 순서대로 반복문으로 한줄씩 불러옴
			// 숫자 포맷 적용시 String으로 인식함 주의
			k21_counter += k21_qty[k21_i]; 			// 품목별 수량 합산
				
			if (k21_i % 5 == 4 && k21_i != item.length-1)		// 5줄 출력 후 구분자 인쇄
				System.out.printf("------------------------------------------------\n");
		}
		
		int k21_beforeTax = (int) Math.ceil(k21_duty/1.1);		// 과세액 계산 올림 처리
		
		System.out.printf("\n %28s %13s\n", "총 품목 수량 ", k21_format.format(k21_counter));		// 총 품목 수량
		System.out.printf("	 %20s %14s\n", "(*)면 세  물 품", k21_format.format(k21_dutyFree));		// 면세 총액
		System.out.printf("	 %20s %14s\n",    "과 세  물 품", k21_format.format(k21_beforeTax));	// 과세 총액
		System.out.printf("	  %20s %14s\n", "부   가   세", k21_format.format(k21_duty - k21_beforeTax));	// 세액
		System.out.printf("	   %20s %14s\n", "합        계", k21_format.format(k21_duty+k21_dutyFree));		// 합계(=과세+면세+부가세)
		System.out.printf("%-20s %21s\n", "결 제 대 상 금 액", k21_format.format(k21_duty+k21_dutyFree));	// 결제대상금액 = 합계액
		System.out.printf("------------------------------------------------\n");
		String k21_credit = "1234567890101112";											// 카드 번호
		System.out.printf("%.11s%20.6s**%s/%s\n", "0021 KEB 하나카드", k21_credit, k21_credit.substring(8,12),"12345678");		//카드 번호 가리기, 카드 이름 잘림
		System.out.printf("카드결제(IC) 		%11s / %4s\n", "일시불",  k21_format.format(k21_duty+k21_dutyFree));			// 카드 결제 정보, 금액
		System.out.printf("------------------------------------------------\n");
		System.out.printf("              [신세계포인트 적립]\n");
		System.out.printf("%.1s*%s 고객님의 포인트 현황입니다.\n", "안설란","안설란".substring(2));					// 이름의 중간자만 가리고 싶을 때 사용
		System.out.printf("금회발생포인트 %15.4s**%s %11s\n", "935000955","935000955".substring(5), 164);			// 중간자만 가리고 싶을 때 사용 방법
		System.out.printf("누계(가용)포인트 %17s( %11s)\n", k21_format.format(3400+164), k21_format.format(3400));	// 가용 포인트 + 금회 발생 포인트 = 누계 포인트
		System.out.printf("*신세계포인트 유효기간은 2년입니다.\n");
		System.out.printf("------------------------------------------------\n");
		System.out.printf("       구매금액기준 무료주차시간 자동 부여\n");
		System.out.printf("차량번호 : %32.3s****\n", "12가1234");													// 차량 번호 가리기
		System.out.printf("입차시간 : %37s\n", k21_sdf.format(k21_cal.getTime()));									// 입차시간: 입차시간 확인 로직 불분명, 인스턴스 시간 전체 출력
		System.out.printf("------------------------------------------------\n");
		System.out.printf("캐셔:%s %.1s00 %31d\n", "011202", "최수지", 1150);							// 캐셔 번호, 이름 일부 인쇄
	
	}
}