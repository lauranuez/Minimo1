package Classes;

import java.util.List;

public class Order {


    private List<String> productNames;
    private int id = 0;
    private String userName;


    public Order (String user)
    {
        this.id ++;
        this.userName = user;
    }

    public void addProduct(String productName){

        productNames.add(productName);
    }

    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> names) {
        this.productNames = names;
    }


    public String getUserName() {
        return userName;
    }

}
