package day11;

public class CopyEx01 {

	public static void main(String[] args) {
		//얕은 복사 예제
		C [] list1 = new C[5];
		
		for(int i = 0; i<list1.length; i++) {
			list1[i] = new C(2*i);
		}
		C [] list2 = new C[5];
		System.arraycopy(list1, 0, list2, 0, list1.length);
		
		print(list1);
		print(list2);
		
		list1[0].num = 100;
		
		print(list1);
		print(list2);
		
		//깊은 복사 예제
		C [] list3 = new C[5];
		
		for(int i = 0; i<list3.length; i++) {
			list3[i] = new C(2*i);
		}
		C [] list4 = new C[5];
		
		for(int i = 0; i<list3.length; i++) {
			list4[i] = new C(list3[i]);
		}
		System.out.println("--------------");
		print(list3);
		print(list4);
		
		list3[0].num = 100;
		
		print(list3);
		print(list4);
		
	}
	public static void print(C[] list) {
		for(C tmp : list) {
			tmp.print();
		}
		System.out.println();
	}
}

class C{
	public int num;
	
	public C(int num) {
		this.num = num;
	}
	public void print() {
		System.out.print(num+ " ");
	}
	public C(C c) {
		this.num = c.num;
	}
}