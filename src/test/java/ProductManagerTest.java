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

    @Before
    public void init(){

        listProduct.add(product1);
        listProduct.add(product2);
        listProduct.add(product3);
        listProduct.add(product4);
        listProduct.add(product4);

    }

    @After
    public void reset(){

        listProduct = new ArrayList<>();

    }

    @Test
    public void test1(){
        Assert.assertEquals(5,listProduct.size());
        List<Product> orden = pm.getProductByPrize();
        Assert.assertEquals(product2.getName(), orden.get(0).getName());

    }

    @Test
    public void test2(){
        Assert.assertEquals(5,listProduct.size());
        List<Product> orden = pm.getProductBySales();
        Assert.assertEquals(product4.getName(), orden.get(0).getName());

    }
}
