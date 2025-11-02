package pojo;

public class Subscription {
    private String id;
    private String name;
    private double price;
    private int durationMonths;

    public Subscription() {}

    public Subscription(String id, String name, double price, int durationMonths) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.durationMonths = durationMonths;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getDurationMonths() { return durationMonths; }
    public void setDurationMonths(int durationMonths) { this.durationMonths = durationMonths; }

    @Override
    public String toString() {
        return "Subscription{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", durationMonths=" + durationMonths +
                '}';
    }
}
