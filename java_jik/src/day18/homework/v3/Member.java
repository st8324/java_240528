package day18.homework.v3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor //id,name을 이용한 생성자 추가. list는 제외
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Schedule> list = new ArrayList<Schedule>();
	@NonNull
	private String id;
	@NonNull
	private String name;
	
	//List에서 indexOf, contains, remove 등을 이용하기 위해 오버라이딩
	//아이디만 같으면 같은 객체로 판별
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
