import Classes.Order;
import Classes.Product;
import Classes.User;

import java.util.HashMap;
import java.util.Queue;
import java.util.List;

public class ProductManagerimpl implements ProductManager{

    private Queue<Order> pendingOrder;
    private List<Product> listProduct;
    private List<Order> listOrder;
    private HashMap<User, List<Order> > hmUsers;


    public ProductManagerimpl (){

    }

    @Override
    public List<Product> getProductByPrize() {
        return null;
    }

    @Override
    public List<Order> getOrdersByUser() {
        return null;
    }

    @Override
    public void newOrder(Order o) {

    }

    @Override
    public Order processOrder() {
        return null;
    }

    @Override
    public List<Product> getProductBySales() {
        return null;
    }
}
