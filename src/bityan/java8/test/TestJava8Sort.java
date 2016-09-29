package bityan.java8.test;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class TestJava8Sort {
   public static void main(String args[]){
      List<String> names1 = new ArrayList<String>();
      names1.add("java1");
      names1.add("java2");
      names1.add("java8");
		
      List<String> names2 = new ArrayList<String>();
      names2.add("LiLei ");
      names2.add("HanMeimei ");
      names2.add("Wenburg ");
		
      TestJava8Sort tester = new TestJava8Sort();
      System.out.println("Sort using Java 7 syntax: ");
	
      //ʹ��java7���﷨��������comparator
      tester.sortUsingJava7(names1);
      System.out.println(names1);
      System.out.println("Sort using Java 8 syntax: ");
	
      //ʹ��java8�﷨������lamda���ʽ��������ڲ���
      tester.sortUsingJava8(names2);
      System.out.println(names2);
   }
	
   private void sortUsingJava7(List<String> names){
      //java 7
      Collections.sort(names, new Comparator<String>() {

		@Override
		public int compare(String s1, String s2) {
			return s1.compareTo(s2);
		}
	});
   }
	
   private void sortUsingJava8(List<String> names){
      //java 8
      Collections.sort(names, (s1,s2)->s1.compareTo(s2));
   }
}
