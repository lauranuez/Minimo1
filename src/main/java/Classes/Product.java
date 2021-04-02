package Classes;

public class Product {

    private int id = 0;
    private String name;
    private float price;
    private int sales = 0;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        this.id ++;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public void addSale() {
        this.sales++;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public int getSales() {
        return sales;
    }

    public String getName() {
        return name;
    }





}
