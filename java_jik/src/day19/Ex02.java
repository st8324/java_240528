package day19;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/* 주민번호를 입력받아 입력받은 주민번호의 생일을 출력하는 코드를 작성하세요.
		 * 000101-3012141
		 * => 2000-01-01
		 * 000101-2012141
		 * => 1900-01-01
		 * */
		//1. Scanner 생성
		Scanner scan = new Scanner(System.in);
		//2. 주민번호 입력
		System.out.print("주민번호 입력 : ");
		String num = scan.next();
		//3. 주민번호 형식이 맞는지 확인
		boolean res = checkNum(num);
		//3-1. 주민번호 형식에 맞지 않으면 안내문구 출력 후 종료
		if(!res) {
			System.out.println("주민번호 형식에 맞지 않습니다.");
			return;
		}
		//4. 성별번호를 이용해서 19또는 20을 계산
		//4-1. 성별 번호를 가져옴
		char ch = num.charAt(7);
		String year="";
		//4-2. 성별 번호가 1또는2이면 19를 3또는 4이면 20을 변수에 저장
		switch(ch) {
		case '1','2': year = "19"; break;
		case '3','4': year = "20"; break;
		}
		//5. 4번에서 구한 숫자를 이용하여 생일을 출력
		//5-1. year이 빈문자열이면 안내문구 출력 후 종료
		if(year.length() == 0) {
			System.out.println("잘못된 주민번호입니다.");
			return;
		}
		//5-2. 아니면 num를 년,월,일부분만 잘라서 앞에 year을 이어 붙임
		num = year + num.substring(0, 6);
		
		//5-3. yyyyMMdd 형태의 문자을열 yyyy-MM-dd로 바꾸는 메소드를 통해 변환하여 저장
		String result;
		try {
			result = convert2(num);
		} catch (ParseException e) {
			System.out.println("잘못된 주민번호입니다.");
			return;
		}
		
		//5-4. 변환된 문자열을 출력
		System.out.println(result);
	}

	private static String convert1(String num) {
		//num에서 yyyy, MM, dd을 문자열로 추출
		String year = num.substring(0,4);
		String month = num.substring(4, 6);
		String day = num.substring(6);
		
		//추출한 년,월,일을 -와 함께 이어 붙여서 반환
		return year + "-" + month + "-" + day;
	}

	private static String convert2(String num) throws ParseException {
		//yyyyMMdd 문자열을 날짜 객체로 변환
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
		Date date = format1.parse(num);
		//변환된 날짜 객체를 yyyy-MM-dd형태로 변환
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		return format2.format(date);
	}

	private static boolean checkNum(String num) {
		return true;
	}

}
