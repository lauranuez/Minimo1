import Classes.Order;
import Classes.User;
import Classes.Product;

import java.util.*;

public class ProductManagerimpl implements ProductManager{
    private Queue<Order> pendingOrder = new LinkedList<>();
    private List<Product> listProduct;
    private HashMap<String, User > hmUsers = new HashMap<String,User>();
    private int cont = 0;

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
       hmUsers.put("Juan", user);
       hmUsers.put("Maria", user2);
   }

    @Override
    public List<Product> getProductByPrize() {
        List<Product> p = listProduct;
        int cont = 0;
        Product product = new Product(" ",0);
        for (int i = 0; i < p.size()-1; i++){
            for (int j = i+1; j <p.size(); j++){
                if (p.get(i).getPrice()>p.get(j).getPrice()) {
                    product = p.get(i);
                    p.set(i,p.get(j));
                    p.set(j, product);
                }
            }
        }
        return p;
    }
    @Override
    public List<Order> getOrdersByUser(String userId) {
        return hmUsers.get(userId).getListOrdersDone();
    }
    @Override
    public void newOrder(Order o) {
        User user = hmUsers.get(o.getUserName());
        user.addOrder(o);
        pendingOrder.add(o);

        o.setId(cont);
        cont++;
    }
    @Override
    public Order processOrder() {
        Order o = pendingOrder.remove();
        User user = hmUsers.get(o.getUserName());
        user.addOrderDone(o);

        List<String> p = o.getProductNames();
        for (int i = 0 ; i < p.size(); i++){
            for (int j = 0 ; j < listProduct.size(); j++){
                if (p.get(i) == listProduct.get(j).getName())
                    listProduct.get(i).addSale();
            }
        }

        return o;
    }
    @Override
    public List<Product> getProductBySales() {
        List<Product> p = listProduct;
        int cont = 0;
        Product product = new Product(" ",0);
        for (int i = 0; i < p.size()-1; i++){
            for (int j = i+1; j <p.size(); j++){
                if (p.get(i).getSales()<p.get(j).getSales()) {
                    product = p.get(i);
                    p.set(i,p.get(j));
                    p.set(j, product);
                }
            }
        }
        return p;
    }
}
