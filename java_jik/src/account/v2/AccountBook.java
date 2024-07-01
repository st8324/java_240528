package account.v2;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class AccountBook implements Serializable{

	private static final long serialVersionUID = 3440525402416053767L;

	private List<Item> list = new ArrayList<Item>();
	private List<String> incomeCategoryList = Arrays.asList("월급", "용돈", "부수입");
	private List<String> expensesCategoryList = Arrays.asList("교통비", "식비", "취미", "기타");
	private List<String> typeList = Arrays.asList("수입", "지출");
	/**
	 * 내역 추가 메소드
	 * @throws ParseException 
	 * */
	public void insert(Item item) throws ParseException {
		
		//타입이 수입 또는 지출이 맞는 맞는지 확인
		if(!typeList.contains(item.getType())) {
			throw new ParseException("타입을 잘못 입력했습니다.", 0);
		}
		//카테고리가 수입/지출에 맞는 카테고리인지 확인
		List<String> tmpList 
			= item.getType().equals("수입")?incomeCategoryList : expensesCategoryList;
		if(!tmpList.contains(item.getCategory())) {
			throw new ParseException("분류를 잘못 입력했습니다.", 0);
		}
		//금액이 맞는 확인(음수만 아니면 됨)
		if(item.getAmount() < 0) {
			throw new ParseException("금액을 잘못 입력했습니다.", 0);
		}
		list.add(item);
	}
	
	//내역 수정 메소드
	public void update() {
		
	}
	
	//내역 삭제 메소드
	public void delete() {
		
	}
	
	//내역 출력 메소드
	public void search() {
		
	}
	
}
