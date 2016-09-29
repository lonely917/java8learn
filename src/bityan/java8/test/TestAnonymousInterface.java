package bityan.java8.test;

public class TestAnonymousInterface {
	   public static void main(String args[]){
	      TestAnonymousInterface tester = new TestAnonymousInterface();
			
	      //带有类型声明
	      MathOperation addition = (int a, int b) -> a + b;
			
	      //没有类型声明
	      MathOperation subtraction = (a, b) -> a - b;
			
	      //返回代码带有括号
	      MathOperation multiplication = (int a, int b) -> { return a * b; };
			
	      //只有一个返回值，也可以不加括号
	      MathOperation division = (int a, int b) -> a / b;
			
	      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
	      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
			
	      //只有一个参数加不加括号都可以
	      GreetingService greetService1 = message ->
	      System.out.println("Hello " + message);
			
	      GreetingService greetService2 = (message) ->
	      System.out.println("Hello " + message);
			
	      greetService1.sayMessage("Mahesh");
	      greetService2.sayMessage("Suresh");
	      
	      String pre = "pre";
	      
	      //上述实际上是匿名内部类的简化
	      GreetingService gs = new GreetingService() {
			
			@Override
			public void sayMessage(String message) {
				System.out.println("gs:"+message + pre);
//				pre = "dd";  //此处提示错误，变量必须是final，不能修改变量
			}
		  };
		  gs.sayMessage("haha");
	   }
		
	   interface MathOperation {
	      int operation(int a, int b);
	   }
		
	   interface GreetingService {
	      void sayMessage(String message);
	   }
	
	   //传入一个操作作为函数的参数，此操作是一个接口，传入的是一个接口的实现类
	   private int operate(int a, int b, MathOperation mathOperation){
	      return mathOperation.operation(a, b);
	   }
	}
