package com.kh.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
 * java.time 패키지
 * - Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공(JDK 1.8)
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 클래스 포함
 * - 날짜와 시간에 대한 다양한 메서드 제공
 * */

public class B_Time {

	/*
	 * LocalDateTime - 날짜와 시간 정보 모두 저장
	 */
	public void method1() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("today : " + now);

		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2025, 6, 30, 12, 8, 10);
		System.out.println("when : " + when);

		// ZonedDateTime : LocalDateTime + 시간대
		System.out.println("ZonedDateTime : " + ZonedDateTime.now());

		// 년, 월, 일, 요일, 시, 분, 초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonthValue() + "월"); // 숫자
//		System.out.println(now.getMonth() + "월"); // 영어 
		System.out.println(now.getDayOfMonth() + "일"); // 달 단위
//		System.out.println(now.getDayOfYear() + "일"); // 년 단위 (2025년 1월 1일부터 181일)
		System.out.println(now.getDayOfWeek());
		System.out.println(now.getHour() + "시");
		System.out.println(now.getMinute() + "분");
		System.out.println(now.getSecond() + "초");

		// 날짜 조작
		// plus 시간 추가
		LocalDateTime plusDay = now.plusDays(1).plusMonths(2).plusYears(1);
		System.out.println("plus : " + plusDay);
		// minus 시간 감소
		LocalDateTime minusDay = now.minusYears(1).minusMonths(1).minusDays(5);
		System.out.println("minus : " + minusDay);
		// 시간 직접 변경
		LocalDateTime withDay = now.withYear(2026).withMonth(8).withDayOfMonth(15);
		System.out.println("with : " + withDay); // 2026-08-15T12:23:10.016694500

		System.out.println("isAfter : " + now.isAfter(withDay)); // 오늘이 해당 날짜(withDay)보다 이후인가? false
		System.out.println("isBefore : " + now.isBefore(withDay)); // 오늘이 해당 날짜(withDay)보다 이전인가? true

		// LocalDate : 날짜 정보 저장
		LocalDate localDate = LocalDate.now();
		System.out.println("LocalDate : " + localDate);
		localDate = LocalDate.of(2025, 12, 16);
		System.out.println("LocalDate 2 : " + localDate);

		// LocalTime : 시간 정보 저장
		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime : " + localTime);
		localTime = LocalTime.of(17, 49, 59);
		System.out.println("LocalTime 2 : " + localTime);
	}

	/*
	 * Period Duration - 날짜와 시간 간격을 표현하기 위한 클래스 - Period : 날짜 간의 차이 - Duration : 시간의
	 * 차이
	 */
	public void method2() {
//		날짜 차이
		LocalDate date1 = LocalDate.of(2025, 1, 1);
		LocalDate date2 = LocalDate.of(2026, 12, 31);

		Period pe = Period.between(date1, date2);
		System.out.println("pe : " + pe); // P1Y11M30D
		// get~ 사용
		System.out.println("year : " + pe.getYears()); // 1
		System.out.println("month : " + pe.getMonths()); // 11
		System.out.println("day : " + pe.getDays()); // 30
		// 또는 ChronoUnit 사용
		System.out.println("year : " + pe.get(ChronoUnit.YEARS)); // 1
		System.out.println("month : " + pe.get(ChronoUnit.MONTHS)); // 11
		System.out.println("day : " + pe.get(ChronoUnit.DAYS)); // 30
//		날짜 차이
		LocalTime time1 = LocalTime.of(1, 2, 3);
		LocalTime time2 = LocalTime.of(11, 59, 59);

		Duration du = Duration.between(time1, time2);
		System.out.println(du);

		System.out.println("hour : " + du.toHours());
		System.out.println("minute : " + du.toMinutes());
		System.out.println("second : " + du.getSeconds());

		// 문자열을 LocalDate 객체로 파싱!
		LocalDate date = LocalDate.parse("2025-12-16");
		System.out.println(date); // 2025-12-16

        //DateTimeFormatter
		// 날짜와 시간을 포맷팅(Fomatting)된 문자열로 변환하는 메서드를 제공하는 클래스
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime today = LocalDateTime.now();
		String format = today.format(dtf);
		System.out.println(format); // 2025-06-30 12:43:31
		
		

	}
	/*
	 * D-Day 계산기 : 년 월 일(각각 입력)을 입력하여 디데이 계산
	 * ChronoUnit.DAYS.between(날짜, 날짜)
	 * 또는 날짜.until(날짜, chronoUnit.DAYS)
	 * */
	
	public void method3() {
		Scanner sc =  new Scanner(System.in);
		// 년, 월, 일 입력
		System.out.print("년 : ");
		int year = Integer.parseInt(sc.nextLine());
		System.out.print("월 : ");
		int month = Integer.parseInt(sc.nextLine());
		System.out.print("일 : ");
		int day = Integer.parseInt(sc.nextLine());
		// 입력한 날짜 변수 설정
		LocalDate date = LocalDate.of(year, month, day);
		// 오늘 날짜 변수 설정
		LocalDate now = LocalDate.now();
		// 디데이
		long dDay = ChronoUnit.DAYS.between(date, now);
		if(dDay == 0) {
			System.out.println("D-DAY");
		} else if(dDay < 0 ) {
			System.out.println("D" + dDay); 
		} else {
			System.out.println("D+"+ dDay);
		}
		// 또는 
		dDay = date.until(now, ChronoUnit.DAYS);
		if(dDay == 0) {
			System.out.println("D-DAY");
		} else if(dDay < 0 ) {
			System.out.println("D" + dDay); 
		} else {
			System.out.println("D+"+ dDay);
		}
	}

	public static void main(String[] args) {
		B_Time b = new B_Time();
//		b.method1();
//		b.method2();
		b.method3();
	}

}
