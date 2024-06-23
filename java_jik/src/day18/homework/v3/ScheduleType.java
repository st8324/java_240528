package day18.homework.v3;

public enum ScheduleType {
	INSERT(1),
	UPDATE(2),
	DELETE(3),
	SEARCH(4),
	EXIT(5);
	
	private final int value;
	
	private ScheduleType(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static ScheduleType fromValue(int value) {
		for(ScheduleType tmp : ScheduleType.values()) {
			if(tmp.getValue() == value) {
				return tmp;
			}
		}
		throw new IllegalArgumentException("일정 기능을 잘못 선택했습니다.");
	}
}
