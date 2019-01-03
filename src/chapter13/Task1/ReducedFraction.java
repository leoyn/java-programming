package chapter13.Task1;

public class ReducedFraction extends Fraction {

    ReducedFraction(int n, int d) {
        super(n, d);
        reduce();
    }

    public Fraction add(Fraction fraction) {
        super.add(fraction);
        reduce();
        return this;
    } 

    private void reduce() {
        int y = d;
        int r = n;

        if(y < r) {
            y = n;
            r = d;
        }

        while(r > 0) {
            int previousR = r;
            r = y % r;
            y = previousR;
        }

        d /= y;
        n /= y;
    }
}