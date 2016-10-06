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

		// Local... java8新的时间类 local自动处理时区
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

		//利用with去修改对应维度
		LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
		System.out.println("date2: " + date2);

		// 构造指定日期可以使用Month枚举也可以指定1~12
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
//		LocalDate date3 = LocalDate.of(2014, 12, 12);
		System.out.println("date3: " + date3);

		// 构造指定时间
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);
		
		//构造指定时间日期
		LocalDateTime datetime = LocalDateTime.of(2014, 12, 12, 22, 15);
		System.out.println("datetime: " + datetime);

		//解析字符串时间 类似的LocalTime和LocalDateTime
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);
		
		//获取monthvalue和month枚举值以及星期几
		System.out.println(currentTime.getMonthValue());
		System.out.println(currentTime.getMonth());
		System.out.println(currentTime.getDayOfWeek());
		
		
	}
	
	//java8提供的线程安全的formatter
	public void testDateTimeFormatter()
	{
	  LocalDate date = LocalDate.now();
	  
	  //使用自定义的模式，当然也有很多预设的模式
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy*MM*dd");
//	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy*M*d");
	  String text = date.format(formatter);
	  LocalDate parsedDate = LocalDate.parse(text, formatter);
	  System.out.println("date:"+date+"\ntext:"+text+"\nparsedate:"+parsedDate);
	}
	
	//时区时间
   public void testZonedDateTime()
   {
		
      //获取指定时区指定日期时间，使用的预定模式解析
      ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
      System.out.println("date1: " + date1);
	
      //获取时区标志
      ZoneId id = ZoneId.of("Europe/Paris");
      System.out.println("ZoneId: " + id);
	
      //得到当前系统时区
      ZoneId currentZone = ZoneId.systemDefault();
      System.out.println("CurrentZone: " + currentZone);
      
      //获取指定时区当前时间
      ZonedDateTime parisDateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
      System.out.println("parisDateTime: "+parisDateTime);
      System.out.println("currentDateTime: "+ZonedDateTime.now());
      
   }
   
   //新的时间单位,时间间隔，日期间隔
   public void testChronoUnit()
   {
	  //当前时间
	  LocalDateTime today = LocalDateTime.now();
	  System.out.println("Current date: " + today);
		
	  //加一周
	  LocalDateTime nextWeek = today.plus(1, ChronoUnit.WEEKS);
	  System.out.println("Next week: " + nextWeek);
		
	  //加一月
	  LocalDateTime nextMonth = today.plus(1, ChronoUnit.MONTHS);
	  System.out.println("Next month: " + nextMonth);
		
	  //加一年
	  LocalDateTime nextYear = today.plus(1, ChronoUnit.YEARS);
	  System.out.println("Next year: " + nextYear);
		
	  //减去10年
	  LocalDateTime lastDecade = today.minus(1, ChronoUnit.DECADES);
	  System.out.println("Date ten years before : " + lastDecade);	   	
	  
	  //period  date 间隔
	  System.out.println("period :" + Period.between(today.toLocalDate(), lastDecade.toLocalDate()));
	  
	  //duration time 间隔
	  System.out.println("duration :" + Duration.between(today.toLocalTime(), lastDecade.toLocalTime()));
	  
	  //计算差值
	  LocalDate one = LocalDate.now();
	  LocalDate two = LocalDate.parse("2007-12-03");
	  System.out.println("interval:"+Period.between(one, two));
	  
   }
   
  //testBackwardCompatibility
   void testBackWard()
   {
	   
   }
   
}
