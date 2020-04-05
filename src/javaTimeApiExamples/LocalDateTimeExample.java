package javaTimeApiExamples;

import java.time.*;

public class LocalDateTimeExample {

    public static void main(String[] args) {
        //Curren Date
        LocalDateTime today = LocalDateTime.now();
        System.out.println(today);
        //Current Date using LocalDate and LocalTime
        today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(today);
        //Creating LocalDateTime by providing input arguments
        LocalDateTime specificDate = LocalDateTime.of(2000, Month.AUGUST,1,22,20,59,10);
        System.out.println(specificDate);
        //Try creating date by providing invalid inputs
        //LocalDateTime feb29_2014 = LocalDateTime.of(2014, Month.FEBRUARY, 28, 25,1,1);
        //Exception in thread "main" java.time.DateTimeException:
        //Invalid value for HourOfDay (valid values 0 - 23): 25


        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDateTime todayKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(todayKolkata);
        //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
        //LocalDateTime todayIST = LocalDateTime.now(ZoneId.of("IST"));

        //Getting date from the base date i.e 01/01/1970
        LocalDateTime dateFormBase = LocalDateTime.ofEpochSecond(10000,0,ZoneOffset.UTC);
        System.out.println(dateFormBase);


    }
}
