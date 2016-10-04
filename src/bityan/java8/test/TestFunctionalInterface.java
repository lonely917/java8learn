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
		
		//���ϴ�����������Ч�����ƣ�����list��capacity��һ��һ����
//		list = Arrays.asList(1,2,4,3);
		
		//�������2������
		System.out.println("�������2�����ݣ�");
		for (Integer integer : list) {
			if(integer > 2)
			{
				System.out.println(integer);
			}
		}
		
		//���С��3������
		System.out.println("���С��3�����ݣ�");
		for (Integer integer : list) {
			if(integer < 3)
			{
				System.out.println(integer);
			}
		}
		
		//���ÿ�����ݵ�ƽ��
		System.out.println("���ÿ�����ݵ�ƽ����");
		for (Integer integer : list) {
				System.out.println(integer*integer);
		}
		
		//ʹ�ú����ӿڽ���ɸѡ
		//�������2������
		System.out.println("�������2�����ݣ�");
		ConditionalPrint(list, n -> n>2);
		
		//���С��3������
		System.out.println("���С��3�����ݣ�");
		ConditionalPrint(list, n-> n<3);
		
		
		//ʹ��Consumer�ӿ���Ϊ����Ĵ�����Ϊ��ֻ��Ϊ��չʾ�߼���ʵ�֣�ʵ��ʹ���и�Ϊ�򵥵ķ�ʽ
		//���ÿ�����ݵ�ƽ��
		System.out.println("���ÿ�����ݵ�ƽ����");
		ConditionalPrintByConsumer(list, n-> System.out.println(n*n));
		
		//collection �ṩ���º�������һ�� consumerʵ��
		System.out.println("���ÿ�����ݵ�ƽ����");
		list.forEach(n-> System.out.println(n*n));
		
		
	}
	
	//����һ���������˷�������һ��ɸѡ�����ӿ�ʵ�֣��������Ǵ��벻ͬ��ɸѡ�߼����ɣ��Բ�ͬɸѡ�����һ���������
	static void ConditionalPrint(List<Integer> l, Predicate<Integer> predict)
	{
		for (Integer integer : l) {
			
			if(predict.test(integer))
			{
				System.out.println(integer);
			}
		}
		
	}
	
	//ͨ��consumer�����ӿ���ʵ��ɸѡ���߱任
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