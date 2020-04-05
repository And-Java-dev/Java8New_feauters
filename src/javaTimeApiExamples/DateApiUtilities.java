package javaTimeApiExamples;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class DateApiUtilities {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today.getYear() + " is Leap year " + today.isLeapYear());
        System.out.println("today is before 01/01/2015" + today.isBefore(LocalDate.of(2015,1,1)));
        System.out.println("today is after 03/04/2020" + today.isAfter(LocalDate.of(2020,4,01)));
        System.out.println(today.atTime(LocalTime.now()));
        System.out.println(today.plusDays(10));
        System.out.println(today.plusWeeks(9));
        System.out.println(today.plusMonths(3));
        System.out.println(today.minusMonths(10));
        System.out.println(today.minusDays(200));
        System.out.println(today.minusYears(10));
        System.out.println("first day of this month = " + today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("last day of this year  = " + lastDayOfYear);

        Period period = today.until(lastDayOfYear);
        System.out.println(period);
        System.out.println("Months remaining in the year= " + period.getMonths());
    }
}
