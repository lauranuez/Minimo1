import java.util.List;

import Classes.User;
import Classes.Product;
import Classes.Order;


public interface ProductManager {

    public List<Product> getProductByPrize();
    public List<Order> getOrdersByUser(String userId);
    public void newOrder(Order o);
    public Order processOrder();
    public List<Product> getProductBySales();
    public void clear();
    public User getUser(String userId);
    public Product getProduct(String productName);
    public void addProduct(Product p);
    public void addUser(User user);


}
