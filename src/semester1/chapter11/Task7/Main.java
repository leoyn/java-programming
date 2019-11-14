package semester1.chapter11.Task7;

public class Main {
    public static void main(String[] args) {
        Time time = new Time(6, 34);
        System.out.println("Minuten: " + time.getMinutes());
        System.out.println("Minuten: " + time.add(new Time(2, 2)).getMinutes());
        System.out.println("Minuten: " + time.difference(new Time(2, 2)));
    }
}