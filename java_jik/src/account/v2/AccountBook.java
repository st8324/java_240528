package account.v2;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class AccountBook implements Serializable{

	private static final long serialVersionUID = 3440525402416053767L;

	private List<Item> list = new ArrayList<Item>();
	public static List<String> incomeCategoryList = Arrays.asList("월급", "용돈", "부수입");
	public static List<String> expensesCategoryList = Arrays.asList("교통비", "식비", "취미", "기타");
	private List<String> typeList = Arrays.asList("수입", "지출");
	
	/**
	 * item의 필드들이 유효한 값들로 되어 있는지 확인하는 메소드
	 * @param item 필드들이 유효한지 체클할 내역
	 * @return 유효 여부
	 */
	public boolean checkItem(Item item) {
		//타입이 수입 또는 지출이 맞는 맞는지 확인
		if(!typeList.contains(item.getType())) {
			return false;
		}
		//카테고리가 수입/지출에 맞는 카테고리인지 확인
		List<String> tmpList 
			= item.getType().equals("수입")?incomeCategoryList : expensesCategoryList;
		if(!tmpList.contains(item.getCategory())) {
			return false;
		}
		//금액이 맞는 확인(음수만 아니면 됨)
		if(item.getAmount() < 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * 내역 추가 메소드
	 * @param item 추가할 내역
	 * @return 내역 추가 여부
	 * */
	public boolean insert(Item item) {
		if(!checkItem(item)) {
			return false;
		}
		list.add(item);
		return true;
	}
	
	//내역 수정 메소드
	public boolean update(Item oldItem, Item newItem) {
		try {
			if(!checkItem(newItem)) {
				return false;
			}
			oldItem.update(newItem);
			return true;
		}catch(ArrayIndexOutOfBoundsException e) {
			//잘못된 번지인 경우 수정할 수가 없어서 수정 실패를 리턴
			return false;
		}
	}
	
	//내역 삭제 메소드
	public boolean delete(Item oldItem) {
		
		return list.remove(oldItem);
		
	}
	
	//내역 출력 메소드
	public void search(Predicate<Item> p) {
		search(list, p);
	}

	public List<Item> selectList(String date) throws ParseException {
		Item item = new Item(date, "", "", 0, "");
		return list.stream()
					.filter(i->i.equals(item))
					.collect(Collectors.toList());
	}

	public void search(List<Item> list, Predicate<Item> p) {
		for(int i = 0; i<list.size(); i++) {
			if(p.test(list.get(i))) {
				System.out.println(i+1+". " + list.get(i));
			}
		}
	}
	
}
