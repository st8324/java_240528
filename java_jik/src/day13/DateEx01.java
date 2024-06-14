package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();

		System.out.println(date);
		//날짜 => 문자열
		/* yyyy : 년, MM : 월, dd : 일, hh : 시(오후2시 -> 2시), 
		 * HH : 시(오후2시 -> 14시), mm : 분, ss : 초
		 * */
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr1 = format1.format(date);
		System.out.println(dateStr1);
		
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd KK:mm:ss");
		String dateStr2 = format2.format(date);
		System.out.println(dateStr2);
		
		SimpleDateFormat format3 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String dateStr3 = format3.format(date);
		System.out.println(dateStr3);
		
		//문자열 => 날짜
		//포맷이 안맞는 경우 예외가 발생할 수 있다
		String dateStr4 = "2024-06-14 09:22";
		SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date4 = format4.parse(dateStr4);
		System.out.println(date4);
	}

}
