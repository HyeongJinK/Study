package newdate;

import java.time.Instant;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
//LocalDate, LocalTime, Instant, Duration, Period
public class NewDate {
	public static void main(String[] args) {
		//Instant();
		//duration ();
		//period();
		chronoUnit();
		/*
		localDatePrint();
		localDateInit();
		localDateAdd();
		localDateMethod ();
		*/
		
		//localTimeInit();
		//localTimeAddAndMinus();
		
		//localDateTimeInit();
//		/zoneld();
	}
	
	static void Instant() {		//����ð�
		Instant instant = Instant.now();	//���� �׶��ġ õ���� �ð�
		System.out.println(instant);
	}
	
	static void duration () {	// LocalDateTime�� ���, �ð��� ����
        Duration oneHours = Duration.ofHours(1);
        System.out.println(oneHours.getSeconds());	//3600

        Duration oneHours2 = Duration.of(1, ChronoUnit.HOURS);
        System.out.println(oneHours2.getSeconds());	//3600

        Duration twoHours = Duration.ofHours(2);
        System.out.println(twoHours.toMinutes());	//120

        
        LocalDateTime oldDate = LocalDateTime.of(2015, Month.JANUARY, 1, 1, 1, 1);
        LocalDateTime newDate = LocalDateTime.of(2017, Month.FEBRUARY, 20, 10, 10, 10);

        System.out.println(oldDate);
        System.out.println(newDate);

        Duration duration = Duration.between(oldDate, newDate);
        
        //��, �ð�, ��, ��, ������
        System.out.println(duration.toDays());	//781
        System.out.println(duration.toHours());	//18753
	}
	
	static void period() {	//LocalDate���� ���
        Period tenDays = Period.ofDays(10);
        System.out.println(tenDays.getDays()); //10

        Period period = Period.of(1, 2, 3);
        System.out.println(period.getYears());   //1
        System.out.println(period.getMonths());  //2
        System.out.println(period.getDays());    //3

        
        LocalDate oldDate = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate newDate = LocalDate.of(2017, Month.FEBRUARY, 10);

        System.out.println(oldDate);
        System.out.println(newDate);

        // check period between dates
        Period period2 = Period.between(oldDate, newDate);

        System.out.println(period2.getYears());		//2
        System.out.println(period2.getMonths());	//1
        System.out.println(period2.getDays());		//9
	}
	
	// �ð� ��
	// �󸶳� ���̰� ���� �� Duration ����� ��������� ��, ��, �ֱ��� �� �����ϴ�.
	static void chronoUnit() {
		LocalDateTime oldDate = LocalDateTime.of(1987, Month.AUGUST, 4, 14, 24, 34);
        LocalDateTime newDate = LocalDateTime.of(2017, Month.FEBRUARY, 9, 10, 11, 12);

        System.out.println(oldDate);
        System.out.println(newDate);

        long years = ChronoUnit.YEARS.between(oldDate, newDate);
        long months = ChronoUnit.MONTHS.between(oldDate, newDate);
        long weeks = ChronoUnit.WEEKS.between(oldDate, newDate);
        long days = ChronoUnit.DAYS.between(oldDate, newDate);
        long hours = ChronoUnit.HOURS.between(oldDate, newDate);
        long minutes = ChronoUnit.MINUTES.between(oldDate, newDate);
        long seconds = ChronoUnit.SECONDS.between(oldDate, newDate);
        long milis = ChronoUnit.MILLIS.between(oldDate, newDate);
        long nano = ChronoUnit.NANOS.between(oldDate, newDate);

        System.out.println(years + " years");
        System.out.println(months + " months");
        System.out.println(weeks + " weeks");
        System.out.println(days + " days");
        System.out.println(hours + " hours");
        System.out.println(minutes + " minutes");
        System.out.println(seconds + " seconds");
        System.out.println(milis + " milis");
        System.out.println(nano + " nano");
        /*
         	1987-08-04T14:24:34
			2017-02-09T10:11:12
			29 years
			354 months
			1540 weeks
			10781 days
			258763 hours
			15525826 minutes
			931549598 seconds
			931549598000 milis
			931549598000000000 nano
         * */
	}
	
	static void localDatePrint() {	//�� �� ������ ������ ��µȴ�.
		Date date = new Date();
		System.out.println(date); // Sun Jan 01 00:00:00 KST 2017
			
		LocalDate localdate = LocalDate.now();
		System.out.println(localdate);	// 2017-01-01
	}
	
	// ���� Date�� �ʱ�ȭ �� ��� �⵵���� 1900���� �������� ���� �⵵�� ���� �� �ְ� ������ -1�� �� ���� �־�� �ߴ�.
	// LocalDate������ �� �� ��������� ��¥�� �ʱ�ȭ �� �� �ִ�.
	static void localDateInit() {	
		Date date = new Date(117, 1, 1);	// ���� 1���� �����Ѵ�.
		System.out.println(date);
		
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		//LocalDate.of(2017, Month.FEBRUARY, 1);
		System.out.println(localdate);
	}
	
	// ������ ��¥ ������ ��� Calendar ��ü�� ����ؾ� �ߴ�.
	// LocalDate������ plus(Days|Months|Weeks|Years)�� �����Ѵ�.
	// ���� �޼��带 ����� ��� ������ �����ϰ� ���ο� ���� �����Ѵ�.
	static void localDateAdd() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 1, 1);
		cal.add(Calendar.DATE, 10);
		System.out.println(cal.getTime()); // Sat Feb 11 10:30:01 KST 2017
		
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		localdate.plusDays(10);
		System.out.println(localdate);	// 2017-02-01, ���� �����͸� �����Ѵ�.
		System.out.println(localdate.plusDays(10));	// 2017-02-11
	}
	
	// ��Ÿ���
	static void localDateMethod () {
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		System.out.println(localdate.getDayOfMonth());	//1
		System.out.println(localdate.getDayOfYear());	//32
	}
	
	static void localTimeInit () {
		LocalTime localtime1 = LocalTime.of(1, 2);
		System.out.println(localtime1);	// 01:02
		
		LocalTime localtime2 = LocalTime.of(1, 2, 3);
		System.out.println(localtime2);	// 01:02:03
		
		LocalTime localtime3 = LocalTime.of(1, 2, 3, 4);
		System.out.println(localtime3);	// 01:02:03.000000004
	}
	
	static void localTimeAddAndMinus () {
		LocalTime localtime1 = LocalTime.of(1, 2);
		System.out.println(localtime1);	// 01:02
		
		System.out.println(localtime1.plusHours(1));	// 02:02
		System.out.println(localtime1.plusMinutes(2));	// 01:04
		System.out.println(localtime1.plusSeconds(3));	// 01:02:03
		System.out.println(localtime1.plusNanos(4));	// 01:02:00.000000004
		
		System.out.println(localtime1.minusMinutes(1));	//01:01
	}
	
	static void localDateTimeInit() {
		LocalDate localdate = LocalDate.of(2017, 2, 1);
		LocalTime localtime = LocalTime.of(1, 2);
		
		LocalDateTime localDateTime = LocalDateTime.of(localdate, localtime);
		System.out.println(localDateTime);	// 2017-02-01T01:02
	}
	
	static void zoneld() {
		ZonedDateTime zoned = ZonedDateTime.of(2017,  1, 1, 1, 1, 0, 0, ZoneId.of("America/New_York"));
		ZonedDateTime zoned2 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/New_York"));
		System.out.println(zoned2);
		//�ٸ� ������ �ð����� �������� ����
		System.out.println(Instant.now().atZone(ZoneId.of("America/New_York")));
	}
}
