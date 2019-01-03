package chapter13.Task1;

public class Fraction {
    static int fractionCounter = 0;
    public int n = 1;
    public int d = 1;

    public Fraction(int n, int d) {
        this.n = n;
        this.d = d;
        fractionCounter++;
    }

    public Fraction resetFractionCounter() {
        fractionCounter = 0;
        return this;
    }

    public Fraction add(Fraction fraction) {
        n = n * fraction.d + fraction.n * d;
        d = d * fraction.d;
        return this;
    }
} 