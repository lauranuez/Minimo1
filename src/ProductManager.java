public interface ProductManager {

    public List<Product> getProductByPrize();
    public void newOrder(Order o);
    public Order processOrder();
    public List<Order> getOrdersByUser(String, idUser);
    getProductBySales();

    }
}
