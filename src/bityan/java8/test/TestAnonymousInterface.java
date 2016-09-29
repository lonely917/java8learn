package bityan.java8.test;

public class TestAnonymousInterface {
	   public static void main(String args[]){
	      TestAnonymousInterface tester = new TestAnonymousInterface();
			
	      //������������
	      MathOperation addition = (int a, int b) -> a + b;
			
	      //û����������
	      MathOperation subtraction = (a, b) -> a - b;
			
	      //���ش����������
	      MathOperation multiplication = (int a, int b) -> { return a * b; };
			
	      //ֻ��һ������ֵ��Ҳ���Բ�������
	      MathOperation division = (int a, int b) -> a / b;
			
	      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
	      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
			
	      //ֻ��һ�������Ӳ������Ŷ�����
	      GreetingService greetService1 = message ->
	      System.out.println("Hello " + message);
			
	      GreetingService greetService2 = (message) ->
	      System.out.println("Hello " + message);
			
	      greetService1.sayMessage("Mahesh");
	      greetService2.sayMessage("Suresh");
	      
	      String pre = "pre";
	      
	      //����ʵ�����������ڲ���ļ�
	      GreetingService gs = new GreetingService() {
			
			@Override
			public void sayMessage(String message) {
				System.out.println("gs:"+message + pre);
//				pre = "dd";  //�˴���ʾ���󣬱���������final�������޸ı���
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
	
	   //����һ��������Ϊ�����Ĳ������˲�����һ���ӿڣ��������һ���ӿڵ�ʵ����
	   private int operate(int a, int b, MathOperation mathOperation){
	      return mathOperation.operation(a, b);
	   }
	}
