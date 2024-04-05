package natwest.com.task.task4;

public class PolygonMain {
        public static void main(String[] args) {
            Polygon poly = new Polygon();
            System.out.println("Square:");
            poly.polygon(2, 'O');
            System.out.println();

            System.out.println("Rectangle:");
            poly.polygon(2, 5);
        }
}
