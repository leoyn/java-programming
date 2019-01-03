package chapter13.Task3;

public class Lorry extends Vehicle {

    private int packages = 0;

    public Lorry(double length, double width, double height, int tires, double speed) {
        super(length, width, height, tires, speed);
    }

    public int getPackages() {
        return packages;
    }
    
    public Lorry load() {
        packages++;
        return this;
    }

    public Lorry unload() {
        if(packages > 0) packages--;
        return this;
    }
}