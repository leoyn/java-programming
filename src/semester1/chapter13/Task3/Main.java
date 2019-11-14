package semester1.chapter13.Task3;

public class Main {
    public static void main(String[] args) {
        Lorry lorry1 = new Lorry(3, 3, 3, 2, 3.4);
        lorry1.load();

        System.out.println("Pakete geladen: " + lorry1.getPackages());
    }
}