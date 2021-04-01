import Classes.Order;
import Classes.Product;
import Classes.User;

import java.util.ArrayList;
import java.util.List;

public class ElCliente {

    public static void main(String[] args){

        ProductManager pm = new ProductManagerimpl();

        User user = new User("Juan");
        User user2 = new User("Maria");

        Product product1 = new Product("coca", 2);
        Product product2 = new Product("pan", 1);
        Product product3 = new Product("bocadillo de lomo", 4);
        Product product4 = new Product("patatas", 3);

        List<Product> list1 = new ArrayList<>();
        List<Product> list2 = new ArrayList<>();
        list1.add(product1);
        list1.add(product2);
        list2.add(product3);
        list2.add(product4);


        Order order = new Order(list1,user);
        Order order2 = new Order(list2,user2);

        List<Product> list3 = pm.getProductByPrize();
        System.out.println(list3);
        List<Product> list4 = pm.getProductBySales();
        System.out.println(list4);

        Order firstDone = pm.processOrder();
        System.out.println(firstDone);

        Order order3 = new Order(list1,user);
        pm.newOrder(order3);

        List<Order> listOrdersJuan = pm.getOrdersByUser("Juan");
        System.out.println(listOrdersJuan);


    }
}
