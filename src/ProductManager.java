import java.util.List;

import Classes.User;
import Classes.Product;
import Classes.Order;


public interface ProductManager {

    public List<Product> getProductByPrize();
    public List<Order> getOrdersByUser(int userId);
    public Order newOrder(List<Product> p, User user);
    public Order processOrder();
    public List<Product> getProductBySales();

    }
}
