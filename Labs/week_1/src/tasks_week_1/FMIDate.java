package tasks_week_1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FMIDate {
    private int year;
    private int month;
    private int day;

    public FMIDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear() {
        return LocalDate.of(year, month, day).isLeapYear();
    }

    public int getCentury() {
        int century = year / 100;
        if (year % 100 != 0) {
            century++;
        }
        return century;
    }

    public long getDaysDifference(FMIDate other) {
        LocalDate date1 = LocalDate.of(year, month, day);
        LocalDate date2 = LocalDate.of(other.year, other.month, other.day);
        return Math.abs(ChronoUnit.DAYS.between(date1, date2)) + 1;
    }

    public void printInfo() {
        System.out.print(String.format("%04d %02d %02d - %d century.", year, month, day, getCentury()));
        if (isLeapYear()) {
            System.out.print(" It is a LEAP year");
        }
        System.out.println();
    }
}
