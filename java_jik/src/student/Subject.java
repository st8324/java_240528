package student;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject implements Serializable {

	private static final long serialVersionUID = -2872421688647654540L;
	//과목명, 학년, 학기, 중간, 기말, 수행평가
	private String name;
	private int grade;
	private int semester;
	private int midterm;
	private int finals;
	private int performance;
	
	//한 학생에게 같은 과목명, 학년, 학기 성적이 여러개 있을 수 없기 때문에
	//equals를 과목명, 학년, 학기를 이용하여 오버라이딩

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return grade == other.grade && Objects.equals(name, other.name) && semester == other.semester;
	}
	@Override
	public int hashCode() {
		return Objects.hash(grade, name, semester);
	}
	public void update(int midterm, int finals, int performace) {
		this.midterm = midterm;
		this.finals = finals;
		this.performance = performace;
	}
	@Override
	public String toString() {
		return "과목 : " + name + "\n" + grade + "학년 " + semester + "학기\n중간 : " + midterm
				+ "\n기말 : " + finals + "\n수행 : " + performance + "\n총점 : " + getTotal();
	}
	private double getTotal() {
		return midterm * 0.4 + finals * 0.5 + performance * 0.1;
	}
	
}
