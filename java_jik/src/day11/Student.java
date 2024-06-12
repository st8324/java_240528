package day11;

public class Student {

	//학교명, 이름, 나이, 생일
	private String schoolName;
	protected String name;
	public String birthday;
	int age;
	
	public void print(){
		System.out.println("학교 : " + schoolName);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("생일 : " + birthday);
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
