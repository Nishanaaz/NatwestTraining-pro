package natwest.com.task.task1;

public class Wrestler {

    private int id;
    private String name;
    private int weight;
    private int height;
    private int age;

    public Wrestler(int id, String name, int weight, int height, int age) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Wrestler{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
