package chapter11.Task3;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D add(Vector2D vector) {
        this.x += vector.x;
        this.y += vector.y;
        return this;
    }

    public Vector2D subtract(Vector2D vector) {
        this.x -= vector.x;
        this.y -= vector.y;
        return this;
    }

    public Vector2D multiply(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    public Vector2D multiply(Vector2D vector) {
        this.x *= vector.x;
        this.y *= vector.y;
        return this;
    }
}