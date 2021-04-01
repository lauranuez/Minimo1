package Classes;

import java.util.List;

public class Order {


    private List<Product> products;
    private int id = 0;
    private String userId;


    public Order (List <Product> p, User user)
    {
        this.products = p;
        this.id ++;
        this.userId = user.getId();

    }
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public String getUserId() {
        return userId;
    }

}
