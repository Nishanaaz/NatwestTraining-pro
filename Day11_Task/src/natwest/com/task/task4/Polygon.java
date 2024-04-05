package natwest.com.task.task4;

public class Polygon {

    public void polygon(int n, char ch) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public void polygon(int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print("@ ");
            }
            System.out.println();
        }
    }
}
