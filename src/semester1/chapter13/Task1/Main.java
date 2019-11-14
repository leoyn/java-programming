package semester1.chapter13.Task1;

public class Main {
    public static void main(String[] args) {
        ReducedFraction rf = new ReducedFraction(96, 36);

        rf.add(new Fraction(3, 36));

        System.out.println(rf.n + "/" + rf.d);
    }
}