package problems;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Receipt2 {		//daiso

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat k21_format = new DecimalFormat("###,###,###");
		Calendar k21_cal1 = Calendar.getInstance();
		SimpleDateFormat k21_sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat k21_sdf1 = new SimpleDateFormat("MM월dd일");
		k21_cal1.add(Calendar.DATE, 14);
		
		String k21_item1 = "퓨어메딕 비말차단용마스크(최고급형)";
		String k21_itemCode1 = "1031615";
		int k21_itemPrice1 = 3000;
		int k21_itemQty1 = 1;

		String k21_item2 = "슬라이드식명찰(가로형)       ";
		String k21_itemCode2 = "11008152";
		int k21_itemPrice2 = 1000;
		int k21_itemQty2 = 2;
		
		String k21_item3 = "매직흡착 인테리어후크(알루미늄타입)";
		String k21_itemCode3 = "1020800";
		int k21_itemPrice3 = 1000;
		int k21_itemQty3 = 1;
		
		System.out.printf("%25s\n", "\"국민가게, 다이소\"");
		System.out.printf("%.45s\n", "(주)아성다이소_분당서현점");
		System.out.printf("%.45s\n", "전화:031-702-6016");
		System.out.printf("%.45s\n", "본사:서울 강남구 남부순환로 2748 (도곡동)");
		System.out.printf("%.45s\n", "대표:박정부, 신호섭 213-81-52063");
		
		String k21_address = "경기도 성남시 분당구 분당로53번길 11 (서현동)";
		System.out.printf("매장:%.26s\n", k21_address);
		System.out.printf("%.25s\n", k21_address.substring(26));
		
		System.out.printf("================================================\n");
		System.out.printf("         소비자중심경영(CCM) 인증기업           \n");
		System.out.printf("       ISO 9001 품질경영시스템 인증기업         \n");
		System.out.printf("================================================\n");
		System.out.printf("         교환//환불 14일(%s)이내,          \n", k21_sdf1.format(k21_cal1.getTime()));
		System.out.printf("(전자)영수증, 결제카드 지참 후 구입매장에서 가능\n");
		System.out.printf("      포장/가격 택 훼손시 교환/환불 불가        \n");
		System.out.printf("        체크카드 취소 시 최대 7일 소요          \n");
		System.out.printf("================================================\n");
		Calendar k21_cal = Calendar.getInstance();
		System.out.printf("[POS %s] %34s\n", "1058231", k21_sdf.format(k21_cal.getTime()));
		System.out.printf("================================================\n");
		int k21_itemAmount1 = k21_itemPrice1 * k21_itemQty1;
		int k21_itemAmount2 = k21_itemPrice2 * k21_itemQty2;
		int k21_itemAmount3 = k21_itemPrice3 * k21_itemQty3;
		
		System.out.printf("%.14s %8s %3d %8s\n", k21_item1, k21_format.format(k21_itemPrice1), 
				k21_itemQty1, k21_format.format(k21_itemAmount1));
		System.out.printf("[%s]\n", k21_itemCode1);
		System.out.printf("%.16s %8s %3d %8s\n", k21_item2, k21_format.format(k21_itemPrice2), 
				k21_itemQty2, k21_format.format(k21_itemAmount2));
		System.out.printf("[%s]\n", k21_itemCode2);
		System.out.printf("%.14s %8s %3d %8s\n", k21_item3, k21_format.format(k21_itemPrice3), 
				k21_itemQty3, k21_format.format(k21_itemAmount3));
		System.out.printf("[%s]\n", k21_itemCode3);
		
		int k21_amountSum = k21_itemAmount1+k21_itemAmount2+k21_itemAmount3;
		int k21_beforeTax = (int) Math.ceil(k21_amountSum/1.1);
		System.out.printf("%16s %27s\n", "과세합계", k21_format.format(k21_beforeTax));
		System.out.printf("%17s %27s\n", "부가세", k21_format.format(k21_amountSum-k21_beforeTax));
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%s %39s\n", "판매합계", k21_format.format(k21_amountSum));
		System.out.printf("================================================\n");
		String k21_credit = "1234567890101112";
		System.out.printf("%s %39s\n", "신용카드", k21_format.format(k21_amountSum));
		System.out.printf("------------------------------------------------\n");
		System.out.printf("%s %29.6s**********\n", "우리카드", k21_credit);
		String k21_approval = "승인금액 " + k21_format.format(k21_amountSum);
		System.out.printf("승인번호 %s(0) %23s\n", "77982843", k21_approval);
		System.out.printf("================================================\n");
		System.out.printf("%27s 분당서현점\n", k21_sdf.format(k21_cal.getTime()));
		System.out.printf("상품 및 기타 문의 : 1522-4400\n");
		System.out.printf("멤버십 및 샵다이소 관련 문의 : 1599-2211\n");
		System.out.printf("              2112820610158231\n");
		System.out.printf("------------------------------------------------\n");
		System.out.printf(" \u25C8 다이소 멤버십 앱 또는 홈페이에 접속하셔서\n"
				+ "   회원가입 후 다양한 혜택을 누려보세요! \u25C8\n");
	}
}