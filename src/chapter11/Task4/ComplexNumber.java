package chapter11.Task4;

public class ComplexNumber {
    public double r;
    public double i;

    public ComplexNumber(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public ComplexNumber add(ComplexNumber number) {
        r += number.r;
        i += number.i;
        return this;
    }

    public ComplexNumber subtract(ComplexNumber number) {
        r -= number.r;
        i -= number.i;
        return this;
    }

    public ComplexNumber multiply(ComplexNumber number) {
        r = r * number.r - i * number.i;
        i = r * number.i + i * number.r;
        return this;
    }

    public ComplexNumber divide(ComplexNumber number) {
        r = (r * number.r + i * number.i) / (number.r * number.r + number.i * number.i);
        i = (i * number.r - r * number.i) / (number.r * number.r + number.i * number.i);
        return this;
    }
}