package dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;

public class DataAPI {

    public static  void main(String... args) {

        //create date without zone
        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow);
        LocalDate localDate2 = dateNow.minusDays(5);

        System.out.println(dateNow.isAfter(localDate2));
        System.out.println(LocalDate.of(2015, 12, 15));

        System.out.println(LocalTime.of(1, 1,1,1));

        //create date + time without zone
        LocalDateTime dateTimeNow = LocalDateTime.now();
        System.out.println(dateTimeNow);

        //create date + time with zone information
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        //operations with dates
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
        LocalDateTime newDateTime = dateTime.plusHours(30);
        System.out.println(newDateTime);

        //Duration
        Duration durationBetween = Duration.between(dateTime, newDateTime);
        System.out.println("Duration "+ durationBetween);

        //Period
        LocalDate first = LocalDate.now();
        LocalDate second = first.minusYears(3).minusDays(5);
        Period periodBetween = Period.between(second, first);
        System.out.println("Period " + periodBetween);
    }
}
