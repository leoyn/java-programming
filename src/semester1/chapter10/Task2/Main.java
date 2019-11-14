package semester1.chapter10.Task2;

public class Main {

    public static Rectangle intersection(Rectangle r1, Rectangle r2) {
        int x1 = r1.x;
        int y1 = r1.y;

        if(x1 < r2.x) x1 = r2.x;
        if(y1 < r2.y) y1 = r2.y;

        int x2 = r1.x + r1.width;
        int y2 = r1.y + r1.height;

        if(x2 > r2.x + r2.width) x2 = r2.x + r2.width;
        if(y2 > r2.y + r2.height) y2 = r2.y + r2.height;

        if(x2 > x1 && y2 > y1) {
            int width = x2 - x1;
            int height = y2 - y1;

            return new Rectangle(x1, y1, width, height);
        } else return null;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, -3, 8, 8);
        Rectangle r2 = new Rectangle(0, 0, 10, 10);

        Rectangle intersectionArea = intersection(r1, r2);

        if(intersectionArea != null) System.out.println("(" + intersectionArea.x + "," + intersectionArea.y + ") w:" + intersectionArea.width + " h:" + intersectionArea.height);
        else System.out.println("No intersection");
    }
}