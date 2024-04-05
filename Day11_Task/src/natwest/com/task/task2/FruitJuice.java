package natwest.com.task.task2;

import java.util.Scanner;

public class FruitJuice {
    int product_code;
    String flavour;
    String pack_type;
    int pack_size;
    float product_price;

    public FruitJuice() {

    }

    public FruitJuice(int product_code, String flavour, String pack_type, int pack_size, float product_price) {
        this.product_code = product_code;
        this.flavour = flavour;
        this.pack_type = pack_type;
        this.pack_size = pack_size;
        this.product_price = product_price;
    }


    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product code:");
        product_code = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter flavour:");
        flavour = scanner.nextLine();
        System.out.println("Enter pack type:");
        pack_type = scanner.nextLine();
        System.out.println("Enter pack size:");
        pack_size = scanner.nextInt();
        System.out.println("Enter product price:");
        product_price = scanner.nextFloat();

    }

    public void discount() {
        float dis = product_price * 10 / 100;
        product_price = product_price - dis;
    }

    public void display() {
        System.out.println("Product code: " + product_code);
        System.out.println("Flavour: " + flavour);
        System.out.println("Pack type: " + pack_type);
        System.out.println("Pack size: " + pack_size + " ml");
        System.out.println("Product price:" + product_price);
    }
}
