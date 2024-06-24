package day18.homework.v1;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
//Collections.sort()를 사용하기 위해 Comparable 인터페이스를 구현
//객체로 저장하기 위해 Serializable 인터페이스 구현
public class Schedule implements Comparable<Schedule>, Serializable{
	private static final long serialVersionUID = 1L;
	private String date;//날짜
	private String toDo;//할일
	private String detail;//상세
	
	@Override
	public String toString() {
		return "" + date + " " + toDo + " : " + detail + "";
	}
	
	@Override
	public int compareTo(Schedule o) {
		return date.compareTo(o.date);
	}
	
}
