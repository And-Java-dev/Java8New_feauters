package javaTimeApiExamples;

import java.time.Duration;
import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        //current time
        Instant  timestamp = Instant.now();
        System.out.println(timestamp);
        //Instant from timestamp
        Instant specificTime  = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println(specificTime);
        //Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);
    }
}
