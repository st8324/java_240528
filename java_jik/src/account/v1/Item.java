package account.v1;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item implements Serializable, Comparable<Item> {
	
	private static final long serialVersionUID = 3338039793241865107L;
	
	private String date;
	private String type;
	private String category;
	private int amount;
	private String contents;
	
	//날짜순으로 정렬을 위해
	@Override
	public int compareTo(Item o) {
		return date.compareTo(o.date);
	}
	//내역 검색할 때 사용하기 위해 날짜를 기준으로 같다 여부를 판별
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(date, other.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}
	@Override
	public String toString() {
		return "" + date + " | " + type + " | " + category + " | " + amount + " | "
				+ contents + "";
	}
	
	
	

}
