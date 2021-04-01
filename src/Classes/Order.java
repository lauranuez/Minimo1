package Classes;

import java.util.List;

public class Order {

    private List<Product> products;
    private int id = 0;
    private int userId;


    public Order (List<Product> p, User user)
    {
        this.products = p;
        this.id ++;
        this.userId = user.getId();

        for (int i = 0 ; i < p.size(); i++){
            for (int j = 1 ; j < p.size(); j++){
                if (p.get(i).getId() == p.get(j).getId()){
                   p.get(i).setSales();
                   p.remove(j);
                   j --;
                }
            }
        }

    }



    public int getUserId() {
        return userId;
    }

}
