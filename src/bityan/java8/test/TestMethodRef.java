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
		
		//查看源码可以知道传入的是一个consumer类型的参数，一个函数接口，我们自定义一个
		System.out.print("data equals Beijing:");
		datas.forEach(s->
						{
							if(s.equalsIgnoreCase("Beijing"))
								{
								 System.out.println(s);
								}
						});
	}

}
/**

default void forEach(Consumer<? super T> action) {
    Objects.requireNonNull(action);
    for (T t : this) {
        action.accept(t);
    }

*/