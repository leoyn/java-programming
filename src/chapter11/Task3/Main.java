package chapter11.Task3;

public class Main {
    public static void main(String[] args) {
        Vector2D vec1 = new Vector2D(1, 2);
        Vector2D vec2 = new Vector2D(3, -1);

        vec1.multiply(vec2).add(vec2);

        System.out.println("(" + vec1.x + "," + vec1.y + ")");
    }
}