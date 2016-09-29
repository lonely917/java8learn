package bityan.java8.test;

import java.util.ArrayList;
import java.util.List;

public class TestMethodRef {

	public static void main(String[] args) {
		List<String> datas = new ArrayList<String>();
		datas.add("beijing");
		datas.add("shanghai");
		datas.add("guangzhou");
		
		//�������
		for (String data : datas) {
			System.out.println(data);
		}
		
		//�������÷����������
		datas.forEach(System.out::println);
	}

}
/**

default void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);
    for (T t : this) {
        action.accept(t);
    }

*/