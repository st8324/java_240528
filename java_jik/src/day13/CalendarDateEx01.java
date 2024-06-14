package day13;

import java.util.Calendar;
import java.util.Date;

public class CalendarDateEx01 {

	public static void main(String[] args) {
		//Calendar => Date
		Calendar cal = Calendar.getInstance();
		//1970년 1월 1일 0시 0분 0초를 기준으로 흐른 밀리초를 날짜로 계산
		Date date = new Date(cal.getTimeInMillis());
		System.out.println(date);
		
		//Date => Calendar
		Date date2 = new Date(0);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		System.out.println(cal2.get(Calendar.YEAR) + "-" + (cal2.get(Calendar.MONTH)+1) + "-"
				+cal2.get(Calendar.DAY_OF_MONTH));
	}

}
