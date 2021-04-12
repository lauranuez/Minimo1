import Classes.Order;
import Classes.User;
import Classes.Product;

import java.util.*;

public class ProductManagerimpl implements ProductManager{

    private Queue<Order> pendingOrder = new LinkedList<>();
    private List<Product> listProduct = new ArrayList<>();
    private HashMap<String, User > hmUsers = new HashMap<String,User>();
    private int cont = 0;

    private static ProductManager instance;

   private ProductManagerimpl () {}

   public void addProduct(Product p){
       listProduct.add(p);
   }

   public void addUser(User user){
       hmUsers.put(user.getId(),user);
   }

   public User getUser(String name){
       return hmUsers.get(name);
   }

   public Product getProduct(String name){
       return null;
   }

   public void clear(){

       listProduct.clear();
       hmUsers.clear();
       pendingOrder.clear();

   }

    public static ProductManager getInstance() {
        if (instance==null) instance = new ProductManagerimpl();
        return instance;
    }

    public List<Product> getListProduct(){return listProduct;}

    @Override
    public List<Product> getProductByPrize() {
        List<Product> p = listProduct;
        /*
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
*/
        Collections.sort(p, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
               // return (int)(o2.getPrice()-o1.getPrice());
                return Float.compare(o1.getPrice(),o2.getPrice());
            }
        });

        return p;
    }
    @Override
    public List<Order> getOrdersByUser(String userId) {
        return hmUsers.get(userId).getListOrdersDone();
    }
    @Override
    public void newOrder(Order o) {
        User user = hmUsers.get(o.getUserName());
        if (user == null)
            System.out.println("usuari " + o.getUserName() + " no existeix");
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
                    listProduct.get(j).addSale();
            }
        }

        return o;
    }
    @Override
    public List<Product> getProductBySales() {
        List<Product> p = listProduct;

        /*
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

         */
        Collections.sort(p, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getSales()-o1.getSales();
            }
        });

        return p;
    }
}
