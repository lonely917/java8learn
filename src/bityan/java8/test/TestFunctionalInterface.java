package bityan.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestFunctionalInterface {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(3);
		
		//以上代码和下面代码效果相似，除了list的capacity不一定一样。
//		list = Arrays.asList(1,2,4,3);
		
		//输出大于2的数据
		System.out.println("输出大于2的数据：");
		for (Integer integer : list) {
			if(integer > 2)
			{
				System.out.println(integer);
			}
		}
		
		//输出小于3的数据
		System.out.println("输出小于3的数据：");
		for (Integer integer : list) {
			if(integer < 3)
			{
				System.out.println(integer);
			}
		}
		
		//输出每个数据的平方
		System.out.println("输出每个数据的平方：");
		for (Integer integer : list) {
				System.out.println(integer*integer);
		}
		
		//使用函数接口进行筛选
		//输出大于2的数据
		System.out.println("输出大于2的数据：");
		ConditionalPrint(list, n -> n>2);
		
		//输出小于3的数据
		System.out.println("输出小于3的数据：");
		ConditionalPrint(list, n-> n<3);
		
		
		//使用Consumer接口作为传入的处理行为，只是为了展示逻辑和实现，实际使用有更为简单的方式
		//输出每个数据的平方
		System.out.println("输出每个数据的平方：");
		ConditionalPrintByConsumer(list, n-> System.out.println(n*n));
		
		//collection 提供如下函数传入一个 consumer实现
		System.out.println("输出每个数据的平方：");
		list.forEach(n-> System.out.println(n*n));
		
		
	}
	
	//定义一个方法，此方法接收一个筛选函数接口实现，这样我们传入不同的筛选逻辑即可，对不同筛选问题的一个抽象归纳
	static void ConditionalPrint(List<Integer> l, Predicate<Integer> predict)
	{
		for (Integer integer : l) {
			
			if(predict.test(integer))
			{
				System.out.println(integer);
			}
		}
		
	}
	
	//通过consumer函数接口来实现筛选或者变换
	static void ConditionalPrintByConsumer(List<Integer> l, Consumer<Integer> consumer)
	{
		for (Integer integer : l) {
			consumer.accept(integer);
		}
		
	}

}

/**
 * Returns a fixed-size list backed by the specified array. 
 * (Changes to the returned list "write through" to the array.) 
 * This method acts as bridge between array-based and collection-based APIs, 
 * in combination with Collection.toArray. 
 * The returned list is serializable and implements RandomAccess. 
 * This method also provides a convenient way to create a fixed-size list 
 * initialized to contain several elements: 
 * List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
 */