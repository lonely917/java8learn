package bityan.java8.test;

import java.util.ArrayList;
import java.util.List;

public class TestMethodRef {

	public static void main(String[] args) {
		List<String> datas = new ArrayList<String>();
		datas.add("beijing");
		datas.add("shanghai");
		datas.add("guangzhou");
		
		//输出数据
		for (String data : datas) {
			System.out.println(data);
		}
		
		//函数引用方法输出数据
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