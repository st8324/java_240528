package day18.homework.v2;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
//Collections.sort()를 사용하기 위해 Comparable 인터페이스를 구현
//객체로 저장하기 위해 Serializable 인터페이스 구현
public class Schedule implements Comparable<Schedule>, Serializable{
	private static final long serialVersionUID = 1L;
	private Date date;//날짜
	private String toDo;//할일
	private String detail;//상세
	
	//date를 문자열로 반환
	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return format.format(date);
	}
	//문자열로 된 날짜를 날짜 객체로 변환하여 저장
	public void setDate(String str) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		date = format.parse(str);
	}
	
	@Override
	public String toString() {
		return "" + getDateStr() + " " + toDo + " : " + detail + "";
	}
	/* @AllArgsContructor를 안 쓰고 추가한 이유는 날짜 문자열을 Date 객체 문자열로 바꾸는
	 * 작업을 setDate()를 이용하기 위해서
	 * */
	public Schedule(String date, String toDo, String detail) throws ParseException {
		setDate(date);
		this.toDo = toDo;
		this.detail = detail;
	}
	@Override
	public int compareTo(Schedule o) {
		return date.compareTo(o.date);
	}
	
	
	
}
