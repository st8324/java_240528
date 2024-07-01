package account.v2;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
public class Item implements Serializable, Comparable<Item> {
	
	private static final long serialVersionUID = 3338039793241865107L;
	
	private Date date;
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
		return "" + getDate() + " | " + type + " | " + category + " | " + amount + " | "
				+ contents + "";
	}

	public void setDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.date = format.parse(date);
	}
	
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	public Item(String date, String type, String category, int amount, String contents) throws ParseException {
		setDate(date);
		this.type = type;
		this.category = category;
		this.amount = amount;
		this.contents = contents;
	}
	public void update(Item item) {
		this.date = item.date;
		this.type = item.type;
		this.category = item.category;
		this.amount = item.amount;
		this.contents = item.contents;
	}
}



