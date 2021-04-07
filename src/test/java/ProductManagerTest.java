import Classes.Order;
import Classes.Product;
import Classes.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductManagerTest {

    ProductManager pm = new ProductManagerimpl();

    private Product product1 = new Product("coca", 2);
    private Product product2 = new Product("pan", 1);
    private Product product3 = new Product("bocadillo de lomo", 4);
    private Product product4 = new Product("patatas", 3);
    private List<Product> listProduct = new ArrayList<>();
    private User user = new User("Juan");
    private User user2 = new User("Maria");
    private Order o1 = new Order("Maria");
    private Order o2 = new Order("Juan");
    private Order o3 = new Order("Juan");

    @Before
    public void init(){

        listProduct.add(product1);
        listProduct.add(product2);
        listProduct.add(product3);
        listProduct.add(product4);

        o1.addProduct("coca");
        o1.addProduct("coca");
        o1.addProduct("pan");

        pm.newOrder(o1);

        o2.addProduct("coca");
        o2.addProduct("bocadillo de lomo");
        o2.addProduct("pan");

        pm.newOrder(o2);

        o3.addProduct("coca");
        o3.addProduct("coca");
        o3.addProduct("patatas");

        pm.newOrder(o3);



    }
    @After
    public void reset(){
        listProduct = new ArrayList<>();
    }
    @Test
    public void test1(){
        List<Product> orden = pm.getProductByPrize();
        Assert.assertEquals(product2.getName(), orden.get(0).getName());
    }
    @Test
    public void test2(){
        List<Product> orden = pm.getProductBySales();
        Assert.assertEquals(product1.getName(), orden.get(0).getName());
    }
    @Test
    public void test3() {
        Order o4 = pm.processOrder();
        Assert.assertEquals(o1.getId(), o4.getId());
    }
    @Test
    public void test4(){
        pm.processOrder();
        pm.processOrder();
        pm.processOrder();
        List<Product> orden = pm.getProductBySales();
        Assert.assertEquals(product2.getName(),orden.get(1).getName());
    }
    @Test
    public void test5(){
        pm.processOrder();
        Order o5 = pm.processOrder();
        pm.processOrder();
        List<Order> order = pm.getOrdersByUser("Juan");
        Assert.assertEquals(order.get(0).getId(),o5.getId());
        Assert.assertEquals(2,order.size());
    }
}
