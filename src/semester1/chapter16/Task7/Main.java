package semester1.chapter16.Task7;

public class Main {
    public static void main(String[] args) {
        towersOfHanoi(6);
    }

    public static void towersOfHanoi(int height) {
        Tower[] towers = { new Tower(height, true), new Tower(height), new Tower(height) };
        move(towers, 0, 1, height);
    }

    private static void move(Tower[] towers, int origin, int destination, int height) {
        if(height > 0) {
            int freeTower = 3 - (origin + destination);
            move(towers, origin, freeTower, height - 1);
            int number = towers[origin].pop();
            towers[destination].push(number);
            System.out.println("(" + (origin + 1) + ") --- " + number + " --> (" + (destination + 1) + ")");
            move(towers, freeTower, destination, height - 1);
        }
    }
}