package javaTimeApiExamples;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateParseDormatExample {


    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd:MM:YYYY")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(date.format(DateTimeFormatter.ISO_ORDINAL_DATE));

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));

        Instant timestamp = Instant.now();

        System.out.println(timestamp);

//        LocalDateTime dt = LocalDateTime.parse("27::09::2015 21::56::14");
        LocalDateTime dt2 = LocalDateTime.parse("27::04::2014 21::39::48",
                DateTimeFormatter.ofPattern("d::MM::uuuu HH::mm::ss"));
//        System.out.println(dt);
        System.out.println(dt2);



    }
}
