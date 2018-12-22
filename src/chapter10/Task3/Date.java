package chapter10.Task3;

public class Date {

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isBiggerThan(Date date) {        
        return (date.getYear() < year || date.getYear() == year && getDayOfYear() > date.getDayOfYear());
    }

    public int getDayOfYear() {
        int[] monthDays = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int leapYear = isLeapYear() ? 1 : 0;
        return monthDays[month - 1] + day - 1 + leapYear;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
}