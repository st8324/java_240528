package day13;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Comparator;

public class ClassSortEx01 {

	public static void main(String[] args) {
		Student [] stds = {
			new Student(1, 1, 1, "홍길동"),
			new Student(2, 1, 1, "고길동"),
			new Student(1, 2, 1, "나길동"),
			new Student(1, 1, 3, "둘리"),
			new Student(1, 1, 1, "고길동")
		};
		
		//Arrays.sort(stds, new Student(0, 0, 0, null));
		Arrays.sort(stds, (o1, o2)->{
			if(o1.grade != o2.grade) {
				return o1.grade - o2.grade;
			}
			if(o1.classNum != o2.classNum) {
				return o1.classNum - o2.classNum;
			}
			if(o1.num != o2.num) {
				return o1.num - o2.num;
			}
			if(!o1.name.equals(o2.name)) {
				return o1.name.compareTo(o2.name);
			}
			return 0;
		});
		System.out.println(Arrays.toString(stds));
	}

}

class Student implements Comparator<Student>{
	int grade, classNum, num;
	String name;
	
	@Override
	public String toString() {
		String format = "{0}학년 {1}반 {2}번 {3}";
		return MessageFormat.format(format, grade, classNum, num, name);
	}

	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.grade != o2.grade) {
			return o1.grade - o2.grade;
		}
		if(o1.classNum != o2.classNum) {
			return o1.classNum - o2.classNum;
		}
		if(o1.num != o2.num) {
			return o1.num - o2.num;
		}
		if(!o1.name.equals(o2.name)) {
			return o1.name.compareTo(o2.name);
		}
		return 0;
	}
}