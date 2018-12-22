package chapter10.Task3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Difference: " + dayDifference(new Date(2018, 10, 22), new Date(2000, 11, 12)) + " days");
    }

    public static int dayDifference(Date date1, Date date2) {

        if(date2.isBiggerThan(date1)) {
            Date tempDate = date1;
            date1 = date2;
            date2 = tempDate;
        }

        int days = 0;

        for(int year = date2.getYear(); year < date1.getYear(); year++) {
            days += (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 366 : 365; 
        }

        days += date1.getDayOfYear();
        days -= date2.getDayOfYear();

        return days;
    }
}