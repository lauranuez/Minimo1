package Classes;

public class Order {

    private  Product[] products;
    private int id;
    private User user;


    public Order (Product[] p, User user)
    {
        this.products = p;
        this.user = user;
    }

}
