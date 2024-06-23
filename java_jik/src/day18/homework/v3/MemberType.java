package day18.homework.v3;

public enum MemberType {
	INSERT(1), 
	UPDATE(2), 
	DELETE(3),
	EXIT(4);
	
	private final int value;
	
	private MemberType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static MemberType fromValue(int value) {
		for(MemberType tmp : MemberType.values()) {
			if(tmp.getValue() == value) {
				return tmp;
			}
		}
		throw new IllegalArgumentException("회원 기능을 잘못 선택했습니다.");
	}
	
}
