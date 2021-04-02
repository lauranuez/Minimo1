import Classes.Order;
import Classes.User;
import Classes.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.List;

public class ProductManagerimpl implements ProductManager{

    private Queue<Order> pendingOrder;
    private List<Product> listProduct;
    private HashMap<String, User > hmUsers = new HashMap<String,User>();


   public ProductManagerimpl () {

       Product product1 = new Product("coca", 2);
       Product product2 = new Product("pan", 1);
       Product product3 = new Product("bocadillo de lomo", 4);
       Product product4 = new Product("patatas", 3);

       listProduct = new ArrayList<>();
       listProduct.add(product1);
       listProduct.add(product2);
       listProduct.add(product3);
       listProduct.add(product4);

       User user = new User("Juan");
       User user2 = new User("Maria");

   }


    @Override
    public List<Product> getProductByPrize() {
        List<Product> p = null;
        for (int i = 0; i < listProduct.size(); i++){
            for (int j = 1; j < listProduct.size(); j++){
                if (listProduct.get(i).getPrice()<listProduct.get(j).getPrice()) {
                    p.remove(i);
                    p.add(i, listProduct.get(i));
                }
            }
        }
        return p;
    }

    @Override
    public List<Order> getOrdersByUser(String userId) {
        return hmUsers.get(userId).getListOrders();
    }


    @Override
    public void newOrder(Order o) {


        List<Product> p = o.getProducts();

        User user = hmUsers.get(o.getUserId());
        user.addOrder(o);
        pendingOrder.add(o);


        for (int i = 0 ; i < p.size(); i++){
            for (int j = 1 ; j < p.size(); j++){
                if (p.get(i).getId() == p.get(j).getId()){
                    p.get(i).addSale();
                    p.remove(j);
                    j --;
                }
            }
        }

    }

    @Override
    public Order processOrder() {
        Order o = pendingOrder.remove();;
        User user = hmUsers.get(o.getUserId());
        user.addOrderDone(o);
        return o;
    }

    @Override
    public List<Product> getProductBySales() {
        List<Product> p = null;
        for (int i = 0; i < listProduct.size(); i++){
            for (int j = 1; j < listProduct.size(); j++){
                if (listProduct.get(i).getSales()>listProduct.get(j).getSales()) {
                    p.remove(i);
                    p.add(i, listProduct.get(i));
                }
            }
        }
        return p;
    }


}
