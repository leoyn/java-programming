package semester1.chapter13.Task3;

public class Vehicle {
    public double length;
    public double width;
    public double height;
    public int direction;
    public int tires;
    public double speed;

    public Vehicle(double length, double width, double height, int tires, double speed) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.tires = tires;
        this.speed = speed;
    }

    public Vehicle setSpeed(double speed) {
        this.speed = speed;
        return this;
    }

    public Vehicle setDirection(int direction) {
        this.direction = direction >= 0 && direction < 360 ? direction : 0;
        return this;
    }
}