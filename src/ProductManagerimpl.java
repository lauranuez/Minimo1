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
        List<Product> p = null;
        for (int i = 0; i < listProduct.size(); i++){
            for (int j = 0; j < listProduct.size(); j++){
                if (listProduct.get(i).getPrice()<listProduct.get(j).getPrice()) {
                    p.remove(i);
                    p.add(i, listProduct.get(i));
                }
            }
        }
        return p;
    }



    @Override
    public List<Order> getOrdersByUser(int userId) {
        List<Order> userOrders = null;
        for (int i = 0; i < listOrder.size(); i++){
            if (listOrder.get(i).getUserId() == userId)
                userOrders.add(i,listOrder.get(i));
        }
    }

    @Override
    public newOrder(List<Product> p, User user) {
        Order order = new Order(p, user);

    }

    @Override
    public Order processOrder() {
        return null;
    }

    @Override
    public List<Product> getProductBySales() {
        List<Product> p = null;
        for (int i = 0; i < listProduct.size(); i++){
            for (int j = 0; j < listProduct.size(); j++){
                if (listProduct.get(i).getSales()>listProduct.get(j).getSales()) {
                    p.remove(i);
                    p.add(i, listProduct.get(i));
                }
            }
        }
        return p;
    }
}
