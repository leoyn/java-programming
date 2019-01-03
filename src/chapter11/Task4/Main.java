package chapter11.Task4;

public class Main {
    public static void main(String[] args) {
        ComplexNumber num = new ComplexNumber(3.2, 1.75);

        num.add(new ComplexNumber(1, 3)).multiply(new ComplexNumber(3, 4));

        System.out.println(num.r + " + " + num.i + "i");
    }
}