package bityan.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TestStream {

	public static void main(String[] args) {
		
		testStream();
		testStreamContrast();
	}
	
	//test stream
	static void testStream()
	{
		//stream and filter
		System.out.println("过滤空字符串:");
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//		strings.add("cc");//这里会报出异常，UnsupportedOperationException，strings是固定长度的，通过asList返回的是一个固定长度arraylist。
		List<String> filtered = strings.stream().filter(s->!s.isEmpty()).collect(Collectors.toList());;
		System.out.println(filtered);
		
		//stream and limit and foreach
		System.out.println("产生10个随机数:");
		Random ran = new Random();
		ran.ints().limit(10).forEach(System.out::println);
		
		//java产生随机数 [0,1)
//		Math.random();
	
		//map distinct sorted
		System.out.println("集合平方映射并且去重并排序:");
		List<Integer> ints = Arrays.asList(3,1,1,2,3,2,1);
		List<Integer> squares = (List<Integer>) ints.stream().map(i->i*i)
														     .distinct()
														     .sorted()
														     .collect(Collectors.toList());
		System.out.println(squares);
		
		
		//并行流使用
		List<Integer> src = Arrays.asList(1,2,3,4,5,6);
		List<Integer> res1= src.stream().filter(i->i>3).collect(Collectors.toList());
		List<Integer> res2= src.parallelStream().filter(i->i>3).collect(Collectors.toList());
		
		System.out.println("大于3的元素："+res1);
		System.out.println("大于3的元素："+res2);
		
		//collector
		System.out.println(strings.stream().collect(Collectors.joining("-")));
		
		//statistics
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		
	}
	
	//streamInJava7AndJava8
	//可以看出java8方法编写代码更为简洁
	static void testStreamContrast()
	{
	      System.out.println("Using Java 7: ");
			
	      // Count empty strings
	      List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
	      System.out.println("List: " +strings);
	      long count = getCountEmptyStringUsingJava7(strings);
			
	      System.out.println("Empty Strings: " + count);
	      count = getCountLength3UsingJava7(strings);
			
	      System.out.println("Strings of length 3: " + count);
			
	      //Eliminate empty string
	      List<String> filtered = deleteEmptyStringsUsingJava7(strings);
	      System.out.println("Filtered List: " + filtered);
			
	      //Eliminate empty string and join using comma.
	      String mergedString = getMergedStringUsingJava7(strings,", ");
	      System.out.println("Merged String: " + mergedString);
	      List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
			
	      //get list of square of distinct numbers
	      List<Integer> squaresList = getSquares(numbers);
	      System.out.println("Squares List: " + squaresList);
	      List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
			
	      System.out.println("List: " +integers);
	      System.out.println("Highest number in List : " + getMax(integers));
	      System.out.println("Lowest number in List : " + getMin(integers));
	      System.out.println("Sum of all numbers : " + getSum(integers));
	      System.out.println("Average of all numbers : " + getAverage(integers));
	      System.out.println("Random Numbers: ");
			
	      //print ten random numbers
	      Random random = new Random();
			
	      for(int i=0; i < 10; i++){
	         System.out.println(random.nextInt());
	      }
			
	      System.out.println("Using Java 8: ");
	      System.out.println("List: " +strings);
			
	      count = strings.stream().filter(string->string.isEmpty()).count();
	      System.out.println("Empty Strings: " + count);
			
	      count = strings.stream().filter(string -> string.length() == 3).count();
	      System.out.println("Strings of length 3: " + count);
			
	      filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
	      System.out.println("Filtered List: " + filtered);
			
	      mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
	      System.out.println("Merged String: " + mergedString);
			
	      squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
	      System.out.println("Squares List: " + squaresList);
	      System.out.println("List: " +integers);
			
	      IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();
			
	      System.out.println("Highest number in List : " + stats.getMax());
	      System.out.println("Lowest number in List : " + stats.getMin());
	      System.out.println("Sum of all numbers : " + stats.getSum());
	      System.out.println("Average of all numbers : " + stats.getAverage());
	      System.out.println("Random Numbers: ");
			
	      random.ints().limit(10).sorted().forEach(System.out::println);
			
	      //parallel processing
	      count = strings.parallelStream().filter(string -> string.isEmpty()).count();
	      System.out.println("Empty Strings: " + count);
	   }
		
	   private static int getCountEmptyStringUsingJava7(List<String> strings){
	      int count = 0;
			
	      for(String string: strings){
			
	         if(string.isEmpty()){
	            count++;
	         }
	      }
	      return count;
	   }
		
	   private static int getCountLength3UsingJava7(List<String> strings){
	      int count = 0;
			
	      for(String string: strings){
			
	         if(string.length() == 3){
	            count++;
	         }
	      }
	      return count;
	   }
		
	   private static List<String> deleteEmptyStringsUsingJava7(List<String> strings){
	      List<String> filteredList = new ArrayList<String>();
			
	      for(String string: strings){
			
	         if(!string.isEmpty()){
	             filteredList.add(string);
	         }
	      }
	      return filteredList;
	   }
		
	   private static String getMergedStringUsingJava7(List<String> strings, String separator){
	      StringBuilder stringBuilder = new StringBuilder();
			
	      for(String string: strings){
			
	         if(!string.isEmpty()){
	            stringBuilder.append(string);
	            stringBuilder.append(separator);
	         }
	      }
	      String mergedString = stringBuilder.toString();
	      return mergedString.substring(0, mergedString.length()-2);
	   }
		
	   private static List<Integer> getSquares(List<Integer> numbers){
	      List<Integer> squaresList = new ArrayList<Integer>();
			
	      for(Integer number: numbers){
	         Integer square = new Integer(number.intValue() * number.intValue());
				
	         if(!squaresList.contains(square)){
	            squaresList.add(square);
	         }
	      }
	      return squaresList;
	   }
		
	   private static int getMax(List<Integer> numbers){
	      int max = numbers.get(0);
			
	      for(int i=1;i < numbers.size();i++){
			
	         Integer number = numbers.get(i);
				
	         if(number.intValue() > max){
	            max = number.intValue();
	         }
	      }
	      return max;
	   }
		
	   private static int getMin(List<Integer> numbers){
	      int min = numbers.get(0);
			
	      for(int i=1;i < numbers.size();i++){
	         Integer number = numbers.get(i);
			
	         if(number.intValue() < min){
	            min = number.intValue();
	         }
	      }
	      return min;
	   }
		
	   private static int getSum(List numbers){
	      int sum = (int)(numbers.get(0));
			
	      for(int i=1;i < numbers.size();i++){
	         sum += (int)numbers.get(i);
	      }
	      return sum;
	   }
		
	   private static int getAverage(List<Integer> numbers){
	      return getSum(numbers) / numbers.size();
	   }
}
