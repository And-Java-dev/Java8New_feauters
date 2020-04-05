package javaTimeApiExamples;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;

public class LocalDateExample {



    public static void main(String[] args) {
        //LocalDate
        LocalDate today = LocalDate.now();
        System.out.println("Current day " + today);
        //Creating LocalDate by providing input arguments
        LocalDate fistDay_2014 = LocalDate.of(2014, Month.JANUARY,1);
        System.out.println(fistDay_2014);
        //Try creating date by providing invalid inputs
        //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
        //Exception in thread "main" java.time.DateTimeException:
        //Invalid date 'February 29' as '2014' is not a leap year

        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(todayKolkata);
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

        //Getting date from the base date i.e 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println(dateFromBase);

        LocalDate hundredDay2004 = LocalDate.ofYearDay(2004,100);
        System.out.println(hundredDay2004);
    }


}
