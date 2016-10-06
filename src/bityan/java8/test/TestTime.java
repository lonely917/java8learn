package bityan.java8.test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class TestTime {

	public static void main(String[] args) {

		new TestTime().testLocalDateTime();
		new TestTime().testDateTimeFormatter();
		new TestTime().testZonedDateTime();
		new TestTime().testChronoUnit();
	}

	public void testLocalDateTime() {

		// Local... java8�µ�ʱ���� local�Զ�����ʱ��
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);

		LocalTime time1 = currentTime.toLocalTime();
		System.out.println("time1: " + time1);
		
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);

		//immutable and thread-safe enum  since1.8  
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();

		System.out.println("Month: " + month + "\nday: " + day + "\nseconds: "
				+ seconds);

		//����withȥ�޸Ķ�Ӧά��
		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);

		// ����ָ�����ڿ���ʹ��Monthö��Ҳ����ָ��1~12
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
//		LocalDate date3 = LocalDate.of(2014, 12, 12);
		System.out.println("date3: " + date3);

		// ����ָ��ʱ��
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);
		
		//����ָ��ʱ������
		LocalDateTime datetime = LocalDateTime.of(2014, 12, 12, 22, 15);
		System.out.println("datetime: " + datetime);

		//�����ַ���ʱ�� ���Ƶ�LocalTime��LocalDateTime
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);
		
		//��ȡmonthvalue��monthö��ֵ�Լ����ڼ�
		System.out.println(currentTime.getMonthValue());
		System.out.println(currentTime.getMonth());
		System.out.println(currentTime.getDayOfWeek());
		
		
	}
	
	//java8�ṩ���̰߳�ȫ��formatter
	public void testDateTimeFormatter()
	{
	  LocalDate date = LocalDate.now();
	  
	  //ʹ���Զ����ģʽ����ȻҲ�кܶ�Ԥ���ģʽ
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy*MM*dd");
//	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy*M*d");
	  String text = date.format(formatter);
	  LocalDate parsedDate = LocalDate.parse(text, formatter);
	  System.out.println("date:"+date+"\ntext:"+text+"\nparsedate:"+parsedDate);
	}
	
	//ʱ��ʱ��
   public void testZonedDateTime()
   {
		
      //��ȡָ��ʱ��ָ������ʱ�䣬ʹ�õ�Ԥ��ģʽ����
      ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
      System.out.println("date1: " + date1);
	
      //��ȡʱ����־
      ZoneId id = ZoneId.of("Europe/Paris");
      System.out.println("ZoneId: " + id);
	
      //�õ���ǰϵͳʱ��
      ZoneId currentZone = ZoneId.systemDefault();
      System.out.println("CurrentZone: " + currentZone);
      
      //��ȡָ��ʱ����ǰʱ��
      ZonedDateTime parisDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
      System.out.println("parisDateTime: "+parisDateTime);
      System.out.println("currentDateTime: "+ZonedDateTime.now());
      
   }
   
   //�µ�ʱ�䵥λ,ʱ���������ڼ��
   public void testChronoUnit()
   {
	  //��ǰʱ��
	  LocalDateTime today = LocalDateTime.now();
	  System.out.println("Current date: " + today);
		
	  //��һ��
	  LocalDateTime nextWeek = today.plus(1, ChronoUnit.WEEKS);
	  System.out.println("Next week: " + nextWeek);
		
	  //��һ��
	  LocalDateTime nextMonth = today.plus(1, ChronoUnit.MONTHS);
	  System.out.println("Next month: " + nextMonth);
		
	  //��һ��
	  LocalDateTime nextYear = today.plus(1, ChronoUnit.YEARS);
	  System.out.println("Next year: " + nextYear);
		
	  //��ȥ10��
	  LocalDateTime lastDecade = today.minus(1, ChronoUnit.DECADES);
	  System.out.println("Date ten years before : " + lastDecade);	   	
	  
	  //period  date ���
	  System.out.println("period :" + Period.between(today.toLocalDate(), lastDecade.toLocalDate()));
	  
	  //duration time ���
	  System.out.println("duration :" + Duration.between(today.toLocalTime(), lastDecade.toLocalTime()));
	  
	  //�����ֵ
	  LocalDate one = LocalDate.now();
	  LocalDate two = LocalDate.parse("2007-12-03");
	  System.out.println("interval:"+Period.between(one, two));
	  
   }
   
  //testBackwardCompatibility
   void testBackWard()
   {
	   
   }
   
}
