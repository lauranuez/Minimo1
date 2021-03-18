import java.util.HashMap;
import java.util.Queue;

public interface ProductManager {

    public List<Product> getProductByPrize();
    public List<Order> getOrdersByUser(String, idUser);
    public void newOrder(Order o);
    public Order processOrder();
    public List<Product> getProductBySales();

    }
}
